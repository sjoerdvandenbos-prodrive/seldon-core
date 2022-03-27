package gateway

import (
	"context"
	"fmt"
	"io"
	"math"
	"time"

	grpc_retry "github.com/grpc-ecosystem/go-grpc-middleware/retry"
	"github.com/seldonio/seldon-core/scheduler/apis/mlops/scheduler"
	"github.com/sirupsen/logrus"
	"google.golang.org/grpc"
)

type KafkaSchedulerClient struct {
	logger       logrus.FieldLogger
	conn         *grpc.ClientConn
	callOptions  []grpc.CallOption
	kafkaManager *KafkaManager
}

func NewKafkaSchedulerClient(logger logrus.FieldLogger, kafkaManager *KafkaManager) *KafkaSchedulerClient {
	opts := []grpc.CallOption{
		grpc.MaxCallSendMsgSize(math.MaxInt32),
		grpc.MaxCallRecvMsgSize(math.MaxInt32),
	}

	return &KafkaSchedulerClient{
		logger:       logger.WithField("source", "KafkaSchedulerClient"),
		callOptions:  opts,
		kafkaManager: kafkaManager,
	}
}

func (kc *KafkaSchedulerClient) ConnectToScheduler(host string, port int) error {
	retryOpts := []grpc_retry.CallOption{
		grpc_retry.WithBackoff(grpc_retry.BackoffExponential(100 * time.Millisecond)),
	}
	opts := []grpc.DialOption{
		grpc.WithInsecure(),
		grpc.WithStreamInterceptor(grpc_retry.StreamClientInterceptor(retryOpts...)),
		grpc.WithUnaryInterceptor(grpc_retry.UnaryClientInterceptor(retryOpts...)),
	}
	conn, err := grpc.Dial(fmt.Sprintf("%s:%d", host, port), opts...)
	if err != nil {
		return err
	}
	kc.conn = conn
	kc.logger.Info("Connected to scheduler")
	return nil
}

func (kc *KafkaSchedulerClient) SubscribeModelEvents(ctx context.Context) error {
	logger := kc.logger.WithField("func", "SubscribeModelEvents")
	grcpClient := scheduler.NewSchedulerClient(kc.conn)

	stream, err := grcpClient.SubscribeModelStatus(ctx, &scheduler.ModelSubscriptionRequest{SubscriberName: "seldon stream"}, grpc_retry.WithMax(100))
	if err != nil {
		return err
	}
	for {
		event, err := stream.Recv()
		if err != nil {
			if err == io.EOF {
				break
			}
			logger.Error(err, "event recv failed")
			return err
		}
		// The expected contract is just the latest version will be sent to us
		if len(event.Versions) != 1 {
			logger.Info("Expected a single model version", "numVersions", len(event.Versions), "name", event.GetModelName())
			continue
		}
		latestVersionStatus := event.Versions[0]

		logger.Infof("Received event name %s version %d state %s", event.ModelName, latestVersionStatus.Version, latestVersionStatus.State.State.String())

		switch latestVersionStatus.State.State {
		case scheduler.ModelStatus_ModelAvailable:
			logger.Infof("Adding model %s", event.ModelName)
			err := kc.kafkaManager.AddModel(event.ModelName, latestVersionStatus.ModelDefn.GetStreamSpec())
			if err != nil {
				kc.logger.WithError(err).Errorf("Failed to add model %s", event.ModelName)
			}
		default:
			logger.Infof("Removing model %s", event.ModelName)
			kc.kafkaManager.RemoveModel(event.ModelName)
		}

	}
	return nil
}