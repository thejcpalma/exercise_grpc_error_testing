package pt.tecnico.testing.client;

import pt.tecnico.testing.grpc.Testing.*;


public class TestingClientApp {
	
	public static void main(String[] args) {
		System.out.println(TestingClientApp.class.getSimpleName());
		
		// receive and print arguments
		System.out.printf("Received %d arguments%n", args.length);
		for (int i = 0; i < args.length; i++) {
			System.out.printf("arg[%d] = %s%n", i, args[i]);
		}

		final String host = args[0];
		final int port = Integer.parseInt(args[1]);
		final String target = host + ":" + port;
		
		ServerFrontend frontend = new ServerFrontend(target);

	    PingRequest request = PingRequest.newBuilder().setRequest("friend").build();
	    PingResponse response = frontend.ctrlPing(request);
	    System.out.println(response);


		
	}
}