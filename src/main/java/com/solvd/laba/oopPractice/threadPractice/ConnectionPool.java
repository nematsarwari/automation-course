package com.solvd.laba.oopPractice.threadPractice;

import java.util.concurrent.*;

public class ConnectionPool {
    private BlockingQueue<Connection> pool;

    private ConnectionPool() {
        // Lazy initialization of the pool
        pool = new ArrayBlockingQueue<>(5);
        initializeConnections();
    }

    private void initializeConnections() {
        for (int i = 0; i < 5; i++) {
            // Creating and adding mocked connections to the pool
            Connection connection = new Connection("Connection-" + i);
            pool.offer(connection);
        }
    }

    public static ConnectionPool getInstance() {
        return ConnectionPoolHolder.INSTANCE;
    }

    private static class ConnectionPoolHolder {
        private static final ConnectionPool INSTANCE = new ConnectionPool();
    }

    public CompletableFuture<Connection> getConnection() {
        // Use CompletableFuture.supplyAsync to perform the operation asynchronously
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Retrieve a connection from the pool, waiting if necessary until one becomes available
                Connection connection = pool.poll(5, TimeUnit.SECONDS);
                if (connection != null) {
                    return connection;
                } else {
                    throw new TimeoutException("Timed out waiting for a connection");
                }
            } catch (InterruptedException | TimeoutException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void releaseConnection(Connection connection) {
        // Release the connection back to the pool
        if (connection != null) {
            connection.release();
            pool.offer(connection);
        }
    }
}