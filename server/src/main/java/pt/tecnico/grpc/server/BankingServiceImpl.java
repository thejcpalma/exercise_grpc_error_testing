package pt.tecnico.grpc.server;

import pt.tecnico.grpc.Banking.*;
import pt.tecnico.grpc.BankingServiceGrpc;

import io.grpc.stub.StreamObserver;

import static io.grpc.Status.INVALID_ARGUMENT;

public class BankingServiceImpl extends BankingServiceGrpc.BankingServiceImplBase {
	private Bank bank = new Bank();

	@Override
	public void register(RegisterRequest request, StreamObserver<RegisterResponse> responseObserver) {

		if (bank.isClient(request.getClient()) == true) {
    		responseObserver.onError(INVALID_ARGUMENT.withDescription("User already exists!").asRuntimeException());
		}		

		bank.register(request.getClient(), request.getBalance());

		responseObserver.onNext(RegisterResponse.getDefaultInstance());
		responseObserver.onCompleted();
	}

	@Override
	public void consult(ConsultRequest request, StreamObserver<ConsultResponse> responseObserver) {

		if (bank.isClient(request.getClient()) == false) {
    		responseObserver.onError(INVALID_ARGUMENT.withDescription("Input has to be a valid user").asRuntimeException());
		}

		int balance = bank.consult(request.getClient());

		ConsultResponse response = ConsultResponse.newBuilder().setBalance(balance).build();

		// Send a single response through the stream.
		responseObserver.onNext(response);
		// Notify the client that the operation has been completed.
		responseObserver.onCompleted();
	}
     

	@Override
	public void zero(ZeroRequest request, StreamObserver responseObserver) {

		if (bank.isClient(request.getClient()) == false) {
    		responseObserver.onError(INVALID_ARGUMENT.withDescription("Input has to be a valid user").asRuntimeException());
		}

		bank.zero(request.getClient());

		ZeroResponse response = ZeroResponse.newBuilder().setSuccess("Account Zeroed!").build();

		// Send a single response through the stream.
		responseObserver.onNext(response);
		// Notify the client that the operation has been completed.
		responseObserver.onCompleted();
	}
     
}
