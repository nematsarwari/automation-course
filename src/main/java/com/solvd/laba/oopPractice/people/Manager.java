package com.solvd.laba.oopPractice.people;

import com.solvd.laba.oopPractice.Exception.InvalidPersonException;
import com.solvd.laba.oopPractice.abstracts.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDate;
import java.util.Objects;


public class Manager extends Person {
    private static final Logger LOGGER = LogManager.getLogger(Manager.class);
    private LocalDate hiredDate;
    private int batch;
    public static int countManager;

    public Manager(String firstName, String lastName, long phoneNumber,LocalDate hiredDate, int batch) throws InvalidPersonException {
        super(firstName, lastName, phoneNumber);
        this.hiredDate = hiredDate;
        this.batch = batch;
        countManager++;
        LOGGER.info("This manager created: " + firstName + " " + lastName);
    }

    public LocalDate getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(LocalDate hiredDate) {
        this.hiredDate = hiredDate;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return batch == manager.batch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), batch);
    }

    @Override
    public String toString() {
        return "Manager{name=" + firstName + ", lastName=" + lastName + ", hiredDate=" + hiredDate +
                ", batch=" + batch +
                '}';
    }

    @Override
    public void printDocument() {
        LOGGER.info("FirstName = " + getFirstName());
        LOGGER.info("LastName = " + getLastName());
        LOGGER.info("PhoneNumber = " + getPhoneNumber());
        LOGGER.info("HiredDate = " + getHiredDate());
        LOGGER.info("Batch = " + getBatch());
    }

    @Override
    public void showID() {
        LOGGER.info("Title: Manager");
        LOGGER.info("LastName: " + getLastName());
        LOGGER.info("PhoneNumber: " + getPhoneNumber());
        LOGGER.info("HiredDate: " + getHiredDate());
        LOGGER.info("Batch: " + getBatch());
    }
}
