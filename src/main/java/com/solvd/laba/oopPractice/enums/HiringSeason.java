package com.solvd.laba.oopPractice.enums;

import java.util.Arrays;

public enum HiringSeason {
    SPRING("Spring", "March", "April", "May"),
    SUMMER("Summer", "June", "July", "August"),
    FALL("Fall", "September", "October", "November"),
    WINTER("Winter", "December", "January", "February");

    private final String[] months;

    HiringSeason(String... months) {
        this.months = months;
    }

    public String[] getMonths() {
        return months;
    }

    public static HiringSeason getSeasonByMonth(String month) {
        for (HiringSeason season : HiringSeason.values()) {
            if (Arrays.asList(season.getMonths()).contains(month)) {
                return season;
            }
        }
        throw new IllegalArgumentException("No season found for the month: " + month);
    }

    public static void main(String[] args) {
        // Example of using the HiringSeason enum with months
        String inputMonth = "July";

        try {
            HiringSeason seasonForMonth = HiringSeason.getSeasonByMonth(inputMonth);
            System.out.println("Hiring season for " + inputMonth + ": " + seasonForMonth);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
