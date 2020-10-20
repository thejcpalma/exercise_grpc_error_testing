package pt.tecnico.testing.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import pt.tecnico.testing.grpc.ControlGrpc;
import pt.tecnico.testing.grpc.Testing.*;


public class ServerFrontend {
	
    private ManagedChannel channel;
    private ControlGrpc.ControlBlockingStub stub;
    private String target;
    
    public ServerFrontend (String t) {
    	this.target = t;

    }
    	
   
   
        
    public PingResponse ctrlPing(PingRequest) {
    	
    	PingResponse response;
    	
		// Channel is the abstraction to connect to a service endpoint.
		// Let us use plaintext communication because we do not have certificates.
		this.channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();

		// It is up to the client to determine whether to block the call.
		// Here we create a blocking stub, but an async stub, or an async stub with
		// Future are also available.
		this.stub = ControlGrpc.newBlockingStub(channel);

    	
    	return(response);
    }
}