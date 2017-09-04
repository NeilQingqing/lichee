// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RequestMsg.proto

package study.java.foundation.proto;

public final class RequestMsgProtoBuf {
  private RequestMsgProtoBuf() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface RequestMsgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:RequestMsg)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string cmd = 1;</code>
     */
    java.lang.String getCmd();
    /**
     * <code>string cmd = 1;</code>
     */
    com.google.protobuf.ByteString
        getCmdBytes();

    /**
     * <code>bytes param = 2;</code>
     */
    com.google.protobuf.ByteString getParam();
  }
  /**
   * Protobuf type {@code RequestMsg}
   */
  public  static final class RequestMsg extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:RequestMsg)
      RequestMsgOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use RequestMsg.newBuilder() to construct.
    private RequestMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private RequestMsg() {
      cmd_ = "";
      param_ = com.google.protobuf.ByteString.EMPTY;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    @SuppressWarnings("unused")
	private RequestMsg(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              cmd_ = s;
              break;
            }
            case 18: {

              param_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return study.java.foundation.proto.RequestMsgProtoBuf.internal_static_RequestMsg_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return study.java.foundation.proto.RequestMsgProtoBuf.internal_static_RequestMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg.class, study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg.Builder.class);
    }

    public static final int CMD_FIELD_NUMBER = 1;
    private volatile java.lang.Object cmd_;
    /**
     * <code>string cmd = 1;</code>
     */
    public java.lang.String getCmd() {
      java.lang.Object ref = cmd_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        cmd_ = s;
        return s;
      }
    }
    /**
     * <code>string cmd = 1;</code>
     */
    public com.google.protobuf.ByteString
        getCmdBytes() {
      java.lang.Object ref = cmd_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        cmd_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PARAM_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString param_;
    /**
     * <code>bytes param = 2;</code>
     */
    public com.google.protobuf.ByteString getParam() {
      return param_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getCmdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, cmd_);
      }
      if (!param_.isEmpty()) {
        output.writeBytes(2, param_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getCmdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, cmd_);
      }
      if (!param_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, param_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg)) {
        return super.equals(obj);
      }
      study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg other = (study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg) obj;

      boolean result = true;
      result = result && getCmd()
          .equals(other.getCmd());
      result = result && getParam()
          .equals(other.getParam());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @SuppressWarnings("unchecked")
	@java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + CMD_FIELD_NUMBER;
      hash = (53 * hash) + getCmd().hashCode();
      hash = (37 * hash) + PARAM_FIELD_NUMBER;
      hash = (53 * hash) + getParam().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code RequestMsg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:RequestMsg)
        study.java.foundation.proto.RequestMsgProtoBuf.RequestMsgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return study.java.foundation.proto.RequestMsgProtoBuf.internal_static_RequestMsg_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return study.java.foundation.proto.RequestMsgProtoBuf.internal_static_RequestMsg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg.class, study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg.Builder.class);
      }

      // Construct using study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        cmd_ = "";

        param_ = com.google.protobuf.ByteString.EMPTY;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return study.java.foundation.proto.RequestMsgProtoBuf.internal_static_RequestMsg_descriptor;
      }

      public study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg getDefaultInstanceForType() {
        return study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg.getDefaultInstance();
      }

      public study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg build() {
        study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg buildPartial() {
        study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg result = new study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg(this);
        result.cmd_ = cmd_;
        result.param_ = param_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg) {
          return mergeFrom((study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg other) {
        if (other == study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg.getDefaultInstance()) return this;
        if (!other.getCmd().isEmpty()) {
          cmd_ = other.cmd_;
          onChanged();
        }
        if (other.getParam() != com.google.protobuf.ByteString.EMPTY) {
          setParam(other.getParam());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object cmd_ = "";
      /**
       * <code>string cmd = 1;</code>
       */
      public java.lang.String getCmd() {
        java.lang.Object ref = cmd_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          cmd_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string cmd = 1;</code>
       */
      public com.google.protobuf.ByteString
          getCmdBytes() {
        java.lang.Object ref = cmd_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          cmd_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string cmd = 1;</code>
       */
      public Builder setCmd(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        cmd_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string cmd = 1;</code>
       */
      public Builder clearCmd() {
        
        cmd_ = getDefaultInstance().getCmd();
        onChanged();
        return this;
      }
      /**
       * <code>string cmd = 1;</code>
       */
      public Builder setCmdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        cmd_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString param_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes param = 2;</code>
       */
      public com.google.protobuf.ByteString getParam() {
        return param_;
      }
      /**
       * <code>bytes param = 2;</code>
       */
      public Builder setParam(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        param_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes param = 2;</code>
       */
      public Builder clearParam() {
        
        param_ = getDefaultInstance().getParam();
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:RequestMsg)
    }

    // @@protoc_insertion_point(class_scope:RequestMsg)
    private static final study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg();
    }

    public static study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<RequestMsg>
        PARSER = new com.google.protobuf.AbstractParser<RequestMsg>() {
      public RequestMsg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new RequestMsg(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<RequestMsg> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<RequestMsg> getParserForType() {
      return PARSER;
    }

    public study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RequestMsg_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RequestMsg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020RequestMsg.proto\"(\n\nRequestMsg\022\013\n\003cmd\030" +
      "\001 \001(\t\022\r\n\005param\030\002 \001(\014B1\n\033study.java.found" +
      "ation.protoB\022RequestMsgProtoBufb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_RequestMsg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_RequestMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RequestMsg_descriptor,
        new java.lang.String[] { "Cmd", "Param", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
