package com.solvd.laba.oopPractice.enums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum DayOfWeek {

    MONDAY("Monday", 1) {
        @Override
        public void plans() {
            System.out.println("Monday: Start of the workweek. Plan your goals for the week.");
        }
    },
    TUESDAY("Tuesday", 2) {
        @Override
        public void plans() {
            System.out.println("Tuesday: Team meetings and collaborative work day.");
        }
    },
    WEDNESDAY("Wednesday", 3) {
        @Override
        public void plans() {
            System.out.println("Wednesday: Midweek checkpoint. Review and adjust your plans.");
        }
    },
    THURSDAY("Thursday", 4) {
        @Override
        public void plans() {
            System.out.println("Thursday: Project updates and client meetings.");
        }
    },
    FRIDAY("Friday", 5) {
        @Override
        public void plans() {
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

    public String getDay() {
        return day;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void plans() {

    }

    // Static block
    static {
        LOGGER.info("Initializing DayOfWeek enum");
    }
}

