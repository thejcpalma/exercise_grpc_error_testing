package pt.tecnico.testing;

import io.grpc.stub.StreamObserver;

import pt.tecnico.testing.grpc.ControlGrpc.*;
import pt.tecnico.testing.grpc.Testing.*;

public class TestingServerImpl extends ControlImplBase {

	@Override
	public void ctrlPing(PingRequest request, 
		    StreamObserver<PingResponse> responseObserver) {

		    String input = request.getRequest();
		    String output = "Hello " + input + "!";
		    PingResponse response = PingResponse.newBuilder()
		    		.setResponse(output).build();
		    responseObserver.onNext(response);
		    responseObserver.onCompleted();
		}
}