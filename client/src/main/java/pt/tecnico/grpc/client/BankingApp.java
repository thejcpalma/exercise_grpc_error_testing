package pt.tecnico.grpc.client;

import java.util.Scanner;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import pt.tecnico.grpc.BankingServiceGrpc;

import pt.tecnico.grpc.Banking.RegisterRequest;
import pt.tecnico.grpc.Banking.RegisterResponse;
import pt.tecnico.grpc.Banking.ConsultRequest;
import pt.tecnico.grpc.Banking.ConsultResponse;
import pt.tecnico.grpc.Banking.Result;

/** Client application main code. */
public class BankingApp {


	private static final String EXIT_CMD = "exit";
	private static final String REGISTER_CMD = "register";
	private static final String CONSULT_CMD = "consult";

	public static void main(String[] args) {
		System.out.println(BankingApp.class.getSimpleName());

		// receive and print arguments
		System.out.printf("Received %d arguments%n", args.length);
		for (int i = 0; i < args.length; i++) {
			System.out.printf("arg[%d] = %s%n", i, args[i]);
		}

		// check arguments
		if (args.length < 2) {
			System.out.println("Argument(s) missing!");
			System.out.printf("Usage: java %s host port%n", BankingApp.class.getName());
			return;
		}

		final String host = args[0];
		final int port = Integer.parseInt(args[1]);

		final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		// Create a blocking stub.

		final BankingServiceGrpc.BankingServiceBlockingStub stub = BankingServiceGrpc.newBlockingStub(channel);
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.printf("> Type the operation you wish to perform (`exit` to quit)%n> ");


			String line = scanner.nextLine();

			// exit
			if (EXIT_CMD.equals(line)) {
				scanner.close();
				System.exit(0);
				break;
			}

			switch (line) {
				case REGISTER_CMD:
					System.out.printf("> Type username you want to register%n> ");
					String client = scanner.nextLine();
					System.out.printf("> What is this user's initial balance%n> ");
					String balance = scanner.nextLine();
					stub.register(RegisterRequest.newBuilder().setClient(client).setBalance(Integer.parseInt(balance)).build());
					System.out.println("\n\n");
					break;

				case CONSULT_CMD:
					System.out.printf("> Get balance of user: %n> ");
					client = scanner.nextLine();
					ConsultResponse responseConsult = stub.consult(ConsultRequest.newBuilder().setClient(client).build());

					if (!responseConsult.getResult().equals(Result.SUCCESS)) {
						System.out.println("Couldn't consult the balance of user: " + client + "\n\n");
						break;
					}

					System.out.println("> User: " + client + " has " + responseConsult.getBalance() + " EUR\n\n");
					break;
			}
		}
	}
}