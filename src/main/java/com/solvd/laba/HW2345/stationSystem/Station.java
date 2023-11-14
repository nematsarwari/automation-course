package com.solvd.laba.HW2345.stationSystem;

import com.solvd.laba.HW2345.Exception.InvalidStationException;
import com.solvd.laba.HW2345.abstracts.Maintain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Driver;
import java.time.LocalDate;
import java.util.Objects;

public class Station extends Maintain {
    private static final Logger LOGGER = LogManager.getLogger(Driver.class);

    private String stationName;
    private String location;
    private LocalDate establishedDate;
    public Station(String stationName, String location, LocalDate establishedDate)throws InvalidStationException {
        if(stationName == null || stationName.isEmpty() || location == null || location.isEmpty()){
            throw new InvalidStationException("Invalid " + getClass().getName() +": stationName and location");
        }
        this.stationName = stationName;
        this.location = location;
        this.establishedDate = establishedDate;

    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(LocalDate establishedDate) {
        this.establishedDate = establishedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(stationName, station.stationName) && Objects.equals(location, station.location) && Objects.equals(establishedDate, station.establishedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationName, location, establishedDate);
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationName='" + stationName + '\'' +
                ", location='" + location + '\'' +
                ", establishedDate=" + establishedDate +
                '}';
    }

    @Override
    public void maintenanceDate(LocalDate date) {
        LOGGER.info("The maintain date is:"+date);
    }

    @Override
    public void maintenanceReason(String reason) {
        LOGGER.info("the reason:"+reason);
    }

    @Override
    public void dailyCostForCompany() {
        LOGGER.info("Daily cast: "+500+"$");
    }
}
