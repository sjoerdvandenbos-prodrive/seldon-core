//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: chainer.proto

package io.seldon.mlops.chainer;

@kotlin.jvm.JvmSynthetic
public inline fun pipelineSubscriptionRequest(block: io.seldon.mlops.chainer.PipelineSubscriptionRequestKt.Dsl.() -> kotlin.Unit): io.seldon.mlops.chainer.ChainerOuterClass.PipelineSubscriptionRequest =
  io.seldon.mlops.chainer.PipelineSubscriptionRequestKt.Dsl._create(io.seldon.mlops.chainer.ChainerOuterClass.PipelineSubscriptionRequest.newBuilder()).apply { block() }._build()
public object PipelineSubscriptionRequestKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: io.seldon.mlops.chainer.ChainerOuterClass.PipelineSubscriptionRequest.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: io.seldon.mlops.chainer.ChainerOuterClass.PipelineSubscriptionRequest.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): io.seldon.mlops.chainer.ChainerOuterClass.PipelineSubscriptionRequest = _builder.build()

    /**
     * <code>string name = 1;</code>
     */
    public var name: kotlin.String
      @JvmName("getName")
      get() = _builder.getName()
      @JvmName("setName")
      set(value) {
        _builder.setName(value)
      }
    /**
     * <code>string name = 1;</code>
     */
    public fun clearName() {
      _builder.clearName()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun io.seldon.mlops.chainer.ChainerOuterClass.PipelineSubscriptionRequest.copy(block: io.seldon.mlops.chainer.PipelineSubscriptionRequestKt.Dsl.() -> kotlin.Unit): io.seldon.mlops.chainer.ChainerOuterClass.PipelineSubscriptionRequest =
  io.seldon.mlops.chainer.PipelineSubscriptionRequestKt.Dsl._create(this.toBuilder()).apply { block() }._build()
