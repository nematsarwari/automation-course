package com.solvd.laba.oopPractice.stationSystem;

import com.solvd.laba.oopPractice.Exception.InvalidTrainException;
import com.solvd.laba.oopPractice.abstracts.Equipment;
import com.solvd.laba.oopPractice.interfaces.Maintainable;
import com.solvd.laba.oopPractice.interfaces.Transportable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Driver;
import java.time.LocalDate;
import java.util.Objects;

public class Train extends Equipment implements Transportable, Maintainable {
    private static final Logger LOGGER = LogManager.getLogger(Driver.class);
    private int capacity;
    public static int trainCount;
    public Train(String name,LocalDate establishedDate , int capacity)throws InvalidTrainException {
        super(name, establishedDate);
        if (name == null || name.isEmpty() || capacity == 0) {
            throw new InvalidTrainException("Invalid " + this.getClass().getSimpleName() + ": TrainName and Capacity.");
        }
        this.name = name;
        this.capacity = capacity;
        trainCount++;
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
        if (!super.equals(o)) return false;
        Train train = (Train) o;
        return capacity == train.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity);
    }

    @Override
    public String toString() {
        return "Train{" +
                "capacity=" + capacity +
                ", name='" + name + '\'' +
                ", establishedDate=" + establishedDate +
                '}';
    }

    @Override
    public void currentStation(String location){
        LOGGER.info("Train "+getName()+" currently at this ("+location+") location");
    }

    @Override
    public void move(String fromLocation, String toLocation) {
        LOGGER.info("Train "+getName()+" is moving from "+fromLocation+" to "+toLocation);
    }
    public void maintenanceDate(LocalDate date) {
        LOGGER.info("The maintain date is:"+date);
    }

    @Override
    public void maintenanceReason(String reason) {
        LOGGER.info("the reason:"+reason);
    }
}
