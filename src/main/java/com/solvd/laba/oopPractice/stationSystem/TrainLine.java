package com.solvd.laba.oopPractice.stationSystem;

import com.solvd.laba.oopPractice.Exception.InvalidTrainLineException;
import com.solvd.laba.oopPractice.abstracts.Maintain;
import com.solvd.laba.oopPractice.interfaces.Available;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Driver;
import java.time.LocalDate;
import java.util.Objects;

public class TrainLine extends Maintain implements Available {
    private static final Logger LOGGER = LogManager.getLogger(Driver.class);
    private String lineName;
    private int lineNumber;
    public TrainLine(String lineName, int lineNumber)throws InvalidTrainLineException {
        if (lineName == null || lineName.isEmpty() || lineNumber == 0) {
            throw new InvalidTrainLineException("Invalid " + this.getClass().getSimpleName() + ": TrainName and LineNumber.");
        }
        this.lineName = lineName;
        this.lineNumber = lineNumber;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
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
        TrainLine trainLine = (TrainLine) o;
        return lineNumber == trainLine.lineNumber && Objects.equals(lineName, trainLine.lineName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineName, lineNumber);
    }

    @Override
    public String toString() {
        return "TrainLine{" +
                "lineName='" + lineName + '\'' +
                ", lineNumber=" + lineNumber +
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
