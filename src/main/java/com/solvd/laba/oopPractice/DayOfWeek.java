package com.solvd.laba.oopPractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum DayOfWeek {

    MONDAY("Monday", 1) {
        @Override
        void plans() {
            System.out.println("Monday: Start of the workweek. Plan your goals for the week.");
        }
    },
    TUESDAY("Tuesday", 2) {
        @Override
        void plans() {
            System.out.println("Tuesday: Team meetings and collaborative work day.");
        }
    },
    WEDNESDAY("Wednesday", 3) {
        @Override
        void plans() {
            System.out.println("Wednesday: Midweek checkpoint. Review and adjust your plans.");
        }
    },
    THURSDAY("Thursday", 4) {
        @Override
        void plans() {
            System.out.println("Thursday: Project updates and client meetings.");
        }
    },
    FRIDAY("Friday", 5) {
        @Override
        void plans() {
            System.out.println("Friday: Focus on completing tasks and planning for the weekend.");
        }
    };
    private static final Logger LOGGER = LogManager.getLogger(DayOfWeek.class);

    private final String day;
    private final int dayNumber;

    DayOfWeek(String day, int dayNumber) {
        this.day = day;
        this.dayNumber = dayNumber;
    }

    String getDay() {
        return day;
    }

    int getDayNumber() {
        return dayNumber;
    }

     abstract void plans();

    // Static block
    static {
        LOGGER.info("Initializing DayOfWeek enum");
    }
}

