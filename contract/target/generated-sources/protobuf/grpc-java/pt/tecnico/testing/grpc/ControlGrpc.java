package pt.tecnico.testing.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.0)",
    comments = "Source: Testing.proto")
public final class ControlGrpc {

  private ControlGrpc() {}

  public static final String SERVICE_NAME = "pt.tecnico.testing.grpc.Control";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<pt.tecnico.testing.grpc.Testing.PingRequest,
      pt.tecnico.testing.grpc.Testing.PingResponse> getCtrlPingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CtrlPing",
      requestType = pt.tecnico.testing.grpc.Testing.PingRequest.class,
      responseType = pt.tecnico.testing.grpc.Testing.PingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.tecnico.testing.grpc.Testing.PingRequest,
      pt.tecnico.testing.grpc.Testing.PingResponse> getCtrlPingMethod() {
    io.grpc.MethodDescriptor<pt.tecnico.testing.grpc.Testing.PingRequest, pt.tecnico.testing.grpc.Testing.PingResponse> getCtrlPingMethod;
    if ((getCtrlPingMethod = ControlGrpc.getCtrlPingMethod) == null) {
      synchronized (ControlGrpc.class) {
        if ((getCtrlPingMethod = ControlGrpc.getCtrlPingMethod) == null) {
          ControlGrpc.getCtrlPingMethod = getCtrlPingMethod =
              io.grpc.MethodDescriptor.<pt.tecnico.testing.grpc.Testing.PingRequest, pt.tecnico.testing.grpc.Testing.PingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CtrlPing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.testing.grpc.Testing.PingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.testing.grpc.Testing.PingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ControlMethodDescriptorSupplier("CtrlPing"))
              .build();
        }
      }
    }
    return getCtrlPingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ControlStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControlStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControlStub>() {
        @java.lang.Override
        public ControlStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControlStub(channel, callOptions);
        }
      };
    return ControlStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControlBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControlBlockingStub>() {
        @java.lang.Override
        public ControlBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControlBlockingStub(channel, callOptions);
        }
      };
    return ControlBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControlFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControlFutureStub>() {
        @java.lang.Override
        public ControlFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControlFutureStub(channel, callOptions);
        }
      };
    return ControlFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ControlImplBase implements io.grpc.BindableService {

    /**
     */
    public void ctrlPing(pt.tecnico.testing.grpc.Testing.PingRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.testing.grpc.Testing.PingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCtrlPingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCtrlPingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                pt.tecnico.testing.grpc.Testing.PingRequest,
                pt.tecnico.testing.grpc.Testing.PingResponse>(
                  this, METHODID_CTRL_PING)))
          .build();
    }
  }

  /**
   */
  public static final class ControlStub extends io.grpc.stub.AbstractAsyncStub<ControlStub> {
    private ControlStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControlStub(channel, callOptions);
    }

    /**
     */
    public void ctrlPing(pt.tecnico.testing.grpc.Testing.PingRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.testing.grpc.Testing.PingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCtrlPingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ControlBlockingStub extends io.grpc.stub.AbstractBlockingStub<ControlBlockingStub> {
    private ControlBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControlBlockingStub(channel, callOptions);
    }

    /**
     */
    public pt.tecnico.testing.grpc.Testing.PingResponse ctrlPing(pt.tecnico.testing.grpc.Testing.PingRequest request) {
      return blockingUnaryCall(
          getChannel(), getCtrlPingMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ControlFutureStub extends io.grpc.stub.AbstractFutureStub<ControlFutureStub> {
    private ControlFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControlFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.tecnico.testing.grpc.Testing.PingResponse> ctrlPing(
        pt.tecnico.testing.grpc.Testing.PingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCtrlPingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CTRL_PING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CTRL_PING:
          serviceImpl.ctrlPing((pt.tecnico.testing.grpc.Testing.PingRequest) request,
              (io.grpc.stub.StreamObserver<pt.tecnico.testing.grpc.Testing.PingResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pt.tecnico.testing.grpc.Testing.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Control");
    }
  }

  private static final class ControlFileDescriptorSupplier
      extends ControlBaseDescriptorSupplier {
    ControlFileDescriptorSupplier() {}
  }

  private static final class ControlMethodDescriptorSupplier
      extends ControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ControlMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ControlFileDescriptorSupplier())
              .addMethod(getCtrlPingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
