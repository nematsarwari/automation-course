package com.solvd.laba.oopPractice.stationSystem;

import com.solvd.laba.oopPractice.Exception.InvalidTrainException;
import com.solvd.laba.oopPractice.abstracts.Maintain;
import com.solvd.laba.oopPractice.interfaces.Available;
import com.solvd.laba.oopPractice.interfaces.Transportable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Driver;
import java.time.LocalDate;
import java.util.Objects;

public class Train extends Maintain implements Transportable, Available {
    private static final Logger LOGGER = LogManager.getLogger(Driver.class);
    private String trainNumber;
    private int capacity;
    public static int trainCount;
    public Train(String trainNumber, int capacity)throws InvalidTrainException {
        if (trainNumber == null || trainNumber.isEmpty() || capacity == 0) {
            throw new InvalidTrainException("Invalid " + this.getClass().getSimpleName() + ": TrainName and Capacity.");
        }
        this.trainNumber = trainNumber;
        this.capacity = capacity;
        trainCount++;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return capacity == train.capacity && Objects.equals(trainNumber, train.trainNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainNumber, capacity);
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainNumber='" + trainNumber + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public void currentStation(String location){
        LOGGER.info("Train "+getTrainNumber()+" currently at this ("+location+") location");
    }

    @Override
    public void move(String fromLocation, String toLocation) {
        LOGGER.info("Train "+getTrainNumber()+" is moving from "+fromLocation+" to "+toLocation);
    }
    public void maintenanceDate(LocalDate date) {
        LOGGER.info("The maintain date is:"+date);
    }

    @Override
    public void maintenanceReason(String reason) {
        LOGGER.info("the reason:"+reason);
    }
}
