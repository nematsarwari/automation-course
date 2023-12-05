package com.solvd.laba.oopPractice.enums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum RideExperience {
    TERRIBLE("Terrible"),
    POOR("Poor" ),
    AVERAGE("Average"),
    GOOD("Good"),
    EXCELLENT("Excellent");
    private static final Logger LOGGER = LogManager.getLogger(RideExperience.class);
    private final String name;
    RideExperience(String rating) {
        this.name = rating;
    }


    public static RideExperience  getByOption(int option) {
        switch (option) {
            case 1:
                return TERRIBLE;

            case 2:
                return POOR;

            case 3:
                return AVERAGE;

            case 4:
                return GOOD;

            case 5:
                return EXCELLENT;

            default:
                return RideExperience.valueOf("Please choose one of the option: " + option);
        }
    }

    public String getName() {
        return name;
    }

}
