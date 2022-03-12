package pt.tecnico.grpc.server;

import pt.tecnico.grpc.Banking.RegisterResponse;
import pt.tecnico.grpc.Banking.ConsultResponse;
import pt.tecnico.grpc.Banking.Result;

import java.util.concurrent.ConcurrentHashMap;

public class Bank {
    ConcurrentHashMap<String, Integer> clients = new ConcurrentHashMap<>();

    boolean isClient(String client) {
        return clients.containsKey(client);
    }

    public void register(String client, Integer balance) {
        clients.put(client, balance);
        System.out.println(clients);
    }

    public ConsultResponse getBalance(String client) {
        Integer balance = clients.get(client);
        System.out.println(balance);

        if (balance == null) {
            return ConsultResponse.newBuilder().setResult(Result.FAILED).build();
        }

        return ConsultResponse.newBuilder().setBalance(balance).setResult(Result.SUCCESS).build();
    }
}
