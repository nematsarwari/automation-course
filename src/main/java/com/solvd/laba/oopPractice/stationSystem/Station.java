package com.solvd.laba.oopPractice.stationSystem;

import com.solvd.laba.oopPractice.Exception.InvalidStationException;
import com.solvd.laba.oopPractice.abstracts.Equipment;
import com.solvd.laba.oopPractice.interfaces.Maintainable;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDate;
import java.util.Objects;

public class Station extends Equipment implements Maintainable {
    private static final Logger LOGGER = LogManager.getLogger(Station.class);

    private String location;
    public Station(String name, String location, LocalDate establishedDate)throws InvalidStationException {
        super(name, establishedDate);
        if(name == null || StringUtils.isEmpty(name) || location == null || StringUtils.isEmpty(location)){
            throw new InvalidStationException("Invalid " + getClass().getName() +": stationName and location");
        }
        this.location = location;
        LOGGER.info("This station created: " + name);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Station station = (Station) o;
        return Objects.equals(location, station.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), location);
    }

    @Override
    public String toString() {
        return "Station{" +
                "location='" + location + '\'' +
                ", name='" + name + '\'' +
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
}
