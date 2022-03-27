//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: v2_dataplane.proto

package io.seldon.mlops.inference.v2;

@kotlin.jvm.JvmSynthetic
public inline fun serverReadyResponse(block: io.seldon.mlops.inference.v2.ServerReadyResponseKt.Dsl.() -> kotlin.Unit): io.seldon.mlops.inference.v2.V2Dataplane.ServerReadyResponse =
  io.seldon.mlops.inference.v2.ServerReadyResponseKt.Dsl._create(io.seldon.mlops.inference.v2.V2Dataplane.ServerReadyResponse.newBuilder()).apply { block() }._build()
public object ServerReadyResponseKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: io.seldon.mlops.inference.v2.V2Dataplane.ServerReadyResponse.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: io.seldon.mlops.inference.v2.V2Dataplane.ServerReadyResponse.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): io.seldon.mlops.inference.v2.V2Dataplane.ServerReadyResponse = _builder.build()

    /**
     * <pre>
     * True if the inference server is ready, false if not ready.
     * </pre>
     *
     * <code>bool ready = 1;</code>
     */
    public var ready: kotlin.Boolean
      @JvmName("getReady")
      get() = _builder.getReady()
      @JvmName("setReady")
      set(value) {
        _builder.setReady(value)
      }
    /**
     * <pre>
     * True if the inference server is ready, false if not ready.
     * </pre>
     *
     * <code>bool ready = 1;</code>
     */
    public fun clearReady() {
      _builder.clearReady()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun io.seldon.mlops.inference.v2.V2Dataplane.ServerReadyResponse.copy(block: io.seldon.mlops.inference.v2.ServerReadyResponseKt.Dsl.() -> kotlin.Unit): io.seldon.mlops.inference.v2.V2Dataplane.ServerReadyResponse =
  io.seldon.mlops.inference.v2.ServerReadyResponseKt.Dsl._create(this.toBuilder()).apply { block() }._build()
