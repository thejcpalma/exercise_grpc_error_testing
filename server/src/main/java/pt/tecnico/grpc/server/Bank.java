package pt.tecnico.grpc.server;

import pt.tecnico.grpc.Banking.RegisterResponse;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class Bank {
    private static final Logger LOGGER = Logger.getLogger(Bank.class.getName());
    ConcurrentHashMap<String, Integer> clients = new ConcurrentHashMap<>();

    public boolean isClient(String client) {
        return (clients.get(client) != null);
    }

    public void register(String client, Integer balance) {
        clients.put(client, balance);
        LOGGER.info("User: " + client + " has been instantiated with balance: " + balance);
    }

    public int consult(String client) {
        int balance = clients.get(client);
        LOGGER.info("User: " + client + "'s balance has been consulted!");
        return balance;
    }

    public void zero(String client) {
        clients.put(client, 0);
        LOGGER.info("User: " + client + "'s balance has been zeroed!");
    }
}
