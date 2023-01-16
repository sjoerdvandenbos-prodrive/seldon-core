package password

import (
	"context"
	"fmt"
	. "github.com/onsi/gomega"
	"github.com/seldonio/seldon-core/components/tls/v2/pkg/tls"
	"github.com/sirupsen/logrus"
	v1 "k8s.io/api/core/v1"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/client-go/kubernetes/fake"
	"os"
	"testing"
	"time"
)

func TestWatchSecretPassword(t *testing.T) {
	g := NewGomegaWithT(t)
	password, err := os.ReadFile("testdata/p1/password")
	g.Expect(err).To(BeNil())
	secName := "password"
	sec := v1.Secret{
		ObjectMeta: metav1.ObjectMeta{Name: secName, Namespace: "default"},
		Data: map[string][]byte{
			"password": password,
		},
	}
	prefix := tls.EnvSecurityPrefixKafkaClient
	suffix := "suffix"
	tmpFolder := t.TempDir()
	t.Setenv(fmt.Sprintf("%s%s", tls.EnvSecurityPrefixKafkaClient, envSecretSuffix), sec.Name)
	t.Setenv(fmt.Sprintf("%s%s", prefix, suffix), fmt.Sprintf("%s/password", tmpFolder))
	t.Setenv("POD_NAMESPACE", sec.Namespace)
	clientset := fake.NewSimpleClientset(&sec)
	ps, err := NewPasswordSecretHandler(secName, clientset, "default", prefix, suffix, logrus.New())
	g.Expect(err).To(BeNil())
	err = ps.GetPasswordAndWatch()
	g.Expect(err).To(BeNil())
	passwordLoaded := ps.GetPassword()
	g.Expect(passwordLoaded).To(Equal(string(password)))
	password = []byte("newpassword")
	sec2 := v1.Secret{
		ObjectMeta: metav1.ObjectMeta{Name: secName, Namespace: "default"},
		Data: map[string][]byte{
			"password": password,
		},
	}
	_, err = clientset.CoreV1().Secrets(sec.Namespace).Update(context.Background(), &sec2, metav1.UpdateOptions{})
	g.Expect(err).To(BeNil())
	time.Sleep(time.Millisecond * 500)
	passwordLoaded = ps.GetPassword()
	g.Expect(passwordLoaded).To(Equal(string(password)))
	ps.Stop()
}