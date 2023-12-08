package com.solvd.laba.oopPractice.threadPractice;

import java.util.concurrent.CompletableFuture;

public class ThreadMain {
    public static void main(String[] args) {
        // Get an instance of the connection pool
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        // Create a CompletableFuture array to store results
        CompletableFuture<Connection>[] futures = new CompletableFuture[7];

        // Simulate multiple threads trying to get and release connections
        for (int i = 0; i < 7; i++) {
            futures[i] = connectionPool.getConnection()
                    .thenApplyAsync(connection -> {
                        // Perform some operations with the connection
                        connection.executeQuery("SELECT * FROM TABLE");

                        // Release the connection back to the pool
                        connectionPool.releaseConnection(connection);

                        return connection;
                    })
                    .exceptionally(throwable -> {
                        System.err.println("Error: " + throwable.getMessage());
                        return null;
                    });
        }

        // Wait for all CompletableFuture instances to complete
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures);

        // Join the CompletableFuture to wait for all threads to finish
        allOf.join();
    }
}
