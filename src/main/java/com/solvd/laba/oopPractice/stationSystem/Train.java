package com.solvd.laba.oopPractice.stationSystem;

import com.solvd.laba.oopPractice.Exception.InvalidTrainException;
import com.solvd.laba.oopPractice.MaxCapacity;
import com.solvd.laba.oopPractice.abstracts.Equipment;
import com.solvd.laba.oopPractice.interfaces.Maintainable;
import com.solvd.laba.oopPractice.interfaces.Transportable;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDate;
import java.util.Objects;

public class Train extends Equipment implements Transportable, Maintainable {
    private static final Logger LOGGER = LogManager.getLogger(Train.class);
    private int capacity;
    public static int trainCount;
    public static MaxCapacity maxCapacity;
    public Train(String name,LocalDate establishedDate , int capacity)throws InvalidTrainException {
        super(name, establishedDate);
        if (name == null || StringUtils.isEmpty(name) || capacity == 0) {
            throw new InvalidTrainException("Invalid " + this.getClass().getSimpleName() + ": TrainName and Capacity.");
        }
        this.capacity = capacity;
        trainCount++;
        LOGGER.info("This train created: " + name);

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

    public static int getMaxCapacity() {
        return maxCapacity.MAX_PASSENGERS;
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
