package com.solvd.laba.oopPractice.enums;

public enum EmployeeStatus {
    Available("Available"),
    Unavailable("Unavailable"),
    OnBreak("On Break");

    private final String status;

    EmployeeStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
