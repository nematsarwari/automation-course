package com.solvd.laba.oopPractice.people;

import com.solvd.laba.oopPractice.Exception.InvalidPersonException;
import com.solvd.laba.oopPractice.abstracts.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Driver;
import java.time.LocalDate;
import java.util.Objects;


public class Security extends Person {
    private static final Logger LOGGER = LogManager.getLogger(Driver.class);
    private LocalDate hiredDate;
    private int batch;
    public static int countSecurity;
    public Security(String firstName, String lastName, long phoneNumber, LocalDate hiredDate, int batch) throws InvalidPersonException {
        super(firstName, lastName, phoneNumber);
        this.hiredDate = hiredDate;
        this.batch = batch;
        countSecurity++;
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
        Security security = (Security) o;
        return batch == security.batch && Objects.equals(hiredDate, security.hiredDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hiredDate, batch);
    }

    @Override
    public String toString() {
        return "Security{name=" + firstName + ", lastName=" + lastName + ", hiredDate=" + hiredDate +
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
        LOGGER.info("Title: Driver");
        LOGGER.info("LastName: " + getLastName());
        LOGGER.info("PhoneNumber: " + getPhoneNumber());
        LOGGER.info("HiredDate: " + getHiredDate());
        LOGGER.info("Batch: " + getBatch());
    }
}
