package com.solvd.laba.oopPractice.threadPractice;

public class Connection {
    private String connectionId;

    public Connection(String connectionId) {
        this.connectionId = connectionId;
    }

    public void executeQuery(String query) {
        System.out.println("Executing query '" + query + "' on connection " + connectionId);
    }

    // Mocked method to release the connection back to the pool
    public void release() {
        System.out.println("Connection " + connectionId + " released back to the pool");
    }
}
