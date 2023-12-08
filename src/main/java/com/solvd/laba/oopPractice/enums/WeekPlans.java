package com.solvd.laba.oopPractice.enums;
public enum WeekPlans {
        MONDAY("Planning and Goal Setting"),
        TUESDAY("Collaboration and Communication"),
        WEDNESDAY("Skill Development and Training"),
        THURSDAY("Focus and Productivity"),
        FRIDAY("Reflection and Team Building");

        private final String plan;

        WeekPlans(String plan) {
            this.plan = plan;
        }

        public String getPlan() {
            return plan;
        }

    // Method to return all plans for the week
    public static String getAllPlans() {
        StringBuilder allPlans = new StringBuilder("Weekly Plans:\n");

        for (WeekPlans day : WeekPlans.values()) {
            allPlans.append(day.name()).append(": ").append(day.getPlan()).append("\n");
        }

        return allPlans.toString();
    }

    // Method to return the plan for a specific day
    public static String getPlanForDay(String day) {
        try {
            WeekPlans selectedDay = WeekPlans.valueOf(day.toUpperCase());
            return selectedDay.getPlan();
        } catch (IllegalArgumentException e) {
            return "Invalid day. Please provide a valid day of the week.";
        }
    }
}
