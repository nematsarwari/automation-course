package com.solvd.laba.oopPractice.enums;

public enum PassengerFeedback {
    EXCELLENT("Excellent"),
    GOOD("Good"),
    AVERAGE("Average"),
    POOR("Poor"),
    UNSATISFACTORY("Unsatisfactory");

    private final String feedback;

    PassengerFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback;
    }
}
