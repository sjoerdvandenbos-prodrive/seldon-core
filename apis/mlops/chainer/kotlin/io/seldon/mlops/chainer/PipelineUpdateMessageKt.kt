//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: chainer.proto

package io.seldon.mlops.chainer;

@kotlin.jvm.JvmSynthetic
public inline fun pipelineUpdateMessage(block: io.seldon.mlops.chainer.PipelineUpdateMessageKt.Dsl.() -> kotlin.Unit): io.seldon.mlops.chainer.ChainerOuterClass.PipelineUpdateMessage =
  io.seldon.mlops.chainer.PipelineUpdateMessageKt.Dsl._create(io.seldon.mlops.chainer.ChainerOuterClass.PipelineUpdateMessage.newBuilder()).apply { block() }._build()
public object PipelineUpdateMessageKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: io.seldon.mlops.chainer.ChainerOuterClass.PipelineUpdateMessage.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: io.seldon.mlops.chainer.ChainerOuterClass.PipelineUpdateMessage.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): io.seldon.mlops.chainer.ChainerOuterClass.PipelineUpdateMessage = _builder.build()

    /**
     * <code>.seldon.mlops.chainer.PipelineUpdateMessage.PipelineOperation op = 1;</code>
     */
    public var op: io.seldon.mlops.chainer.ChainerOuterClass.PipelineUpdateMessage.PipelineOperation
      @JvmName("getOp")
      get() = _builder.getOp()
      @JvmName("setOp")
      set(value) {
        _builder.setOp(value)
      }
    /**
     * <code>.seldon.mlops.chainer.PipelineUpdateMessage.PipelineOperation op = 1;</code>
     */
    public fun clearOp() {
      _builder.clearOp()
    }

    /**
     * <code>string pipeline = 2;</code>
     */
    public var pipeline: kotlin.String
      @JvmName("getPipeline")
      get() = _builder.getPipeline()
      @JvmName("setPipeline")
      set(value) {
        _builder.setPipeline(value)
      }
    /**
     * <code>string pipeline = 2;</code>
     */
    public fun clearPipeline() {
      _builder.clearPipeline()
    }

    /**
     * <code>uint32 version = 3;</code>
     */
    public var version: kotlin.Int
      @JvmName("getVersion")
      get() = _builder.getVersion()
      @JvmName("setVersion")
      set(value) {
        _builder.setVersion(value)
      }
    /**
     * <code>uint32 version = 3;</code>
     */
    public fun clearVersion() {
      _builder.clearVersion()
    }

    /**
     * <code>string uid = 4;</code>
     */
    public var uid: kotlin.String
      @JvmName("getUid")
      get() = _builder.getUid()
      @JvmName("setUid")
      set(value) {
        _builder.setUid(value)
      }
    /**
     * <code>string uid = 4;</code>
     */
    public fun clearUid() {
      _builder.clearUid()
    }

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class UpdatesProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <code>repeated .seldon.mlops.chainer.PipelineStepUpdate updates = 5;</code>
     */
     public val updates: com.google.protobuf.kotlin.DslList<io.seldon.mlops.chainer.ChainerOuterClass.PipelineStepUpdate, UpdatesProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getUpdatesList()
      )
    /**
     * <code>repeated .seldon.mlops.chainer.PipelineStepUpdate updates = 5;</code>
     * @param value The updates to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addUpdates")
    public fun com.google.protobuf.kotlin.DslList<io.seldon.mlops.chainer.ChainerOuterClass.PipelineStepUpdate, UpdatesProxy>.add(value: io.seldon.mlops.chainer.ChainerOuterClass.PipelineStepUpdate) {
      _builder.addUpdates(value)
    }/**
     * <code>repeated .seldon.mlops.chainer.PipelineStepUpdate updates = 5;</code>
     * @param value The updates to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignUpdates")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<io.seldon.mlops.chainer.ChainerOuterClass.PipelineStepUpdate, UpdatesProxy>.plusAssign(value: io.seldon.mlops.chainer.ChainerOuterClass.PipelineStepUpdate) {
      add(value)
    }/**
     * <code>repeated .seldon.mlops.chainer.PipelineStepUpdate updates = 5;</code>
     * @param values The updates to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllUpdates")
    public fun com.google.protobuf.kotlin.DslList<io.seldon.mlops.chainer.ChainerOuterClass.PipelineStepUpdate, UpdatesProxy>.addAll(values: kotlin.collections.Iterable<io.seldon.mlops.chainer.ChainerOuterClass.PipelineStepUpdate>) {
      _builder.addAllUpdates(values)
    }/**
     * <code>repeated .seldon.mlops.chainer.PipelineStepUpdate updates = 5;</code>
     * @param values The updates to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllUpdates")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<io.seldon.mlops.chainer.ChainerOuterClass.PipelineStepUpdate, UpdatesProxy>.plusAssign(values: kotlin.collections.Iterable<io.seldon.mlops.chainer.ChainerOuterClass.PipelineStepUpdate>) {
      addAll(values)
    }/**
     * <code>repeated .seldon.mlops.chainer.PipelineStepUpdate updates = 5;</code>
     * @param index The index to set the value at.
     * @param value The updates to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setUpdates")
    public operator fun com.google.protobuf.kotlin.DslList<io.seldon.mlops.chainer.ChainerOuterClass.PipelineStepUpdate, UpdatesProxy>.set(index: kotlin.Int, value: io.seldon.mlops.chainer.ChainerOuterClass.PipelineStepUpdate) {
      _builder.setUpdates(index, value)
    }/**
     * <code>repeated .seldon.mlops.chainer.PipelineStepUpdate updates = 5;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearUpdates")
    public fun com.google.protobuf.kotlin.DslList<io.seldon.mlops.chainer.ChainerOuterClass.PipelineStepUpdate, UpdatesProxy>.clear() {
      _builder.clearUpdates()
    }}
}
@kotlin.jvm.JvmSynthetic
public inline fun io.seldon.mlops.chainer.ChainerOuterClass.PipelineUpdateMessage.copy(block: io.seldon.mlops.chainer.PipelineUpdateMessageKt.Dsl.() -> kotlin.Unit): io.seldon.mlops.chainer.ChainerOuterClass.PipelineUpdateMessage =
  io.seldon.mlops.chainer.PipelineUpdateMessageKt.Dsl._create(this.toBuilder()).apply { block() }._build()
