package com.solvd.laba.oopPractice.stationSystem;

import com.solvd.laba.oopPractice.Exception.InvalidTrainLineException;
import com.solvd.laba.oopPractice.abstracts.Equipment;
import com.solvd.laba.oopPractice.interfaces.Maintainable;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Driver;
import java.time.LocalDate;
import java.util.Objects;

public class TrainLine extends Equipment implements Maintainable {
    private static final Logger LOGGER = LogManager.getLogger(Driver.class);
    private int lineNumber;
    public TrainLine(String name, LocalDate establishedDate , int lineNumber)throws InvalidTrainLineException {
        super(name, establishedDate);
        if (name == null || StringUtils.isEmpty(name) || lineNumber == 0) {
            throw new InvalidTrainLineException("Invalid " + this.getClass().getSimpleName() + ": TrainName and LineNumber.");
        }
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TrainLine trainLine = (TrainLine) o;
        return lineNumber == trainLine.lineNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lineNumber);
    }

    @Override
    public String toString() {
        return "TrainLine{" +
                "lineNumber=" + lineNumber +
                ", name='" + name + '\'' +
                ", establishedDate=" + establishedDate +
                '}';
    }

    public void maintenanceDate(LocalDate date) {
        LOGGER.info("The maintain date is:"+date);
    }

    @Override
    public void maintenanceReason(String reason) {
        LOGGER.info("the reason:"+reason);
    }
}
