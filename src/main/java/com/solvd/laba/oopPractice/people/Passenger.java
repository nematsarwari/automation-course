package com.solvd.laba.oopPractice.people;

import com.solvd.laba.oopPractice.Exception.InvalidPersonException;
import com.solvd.laba.oopPractice.abstracts.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDate;
import java.util.Objects;


public class Passenger extends Person {
    private static final Logger LOGGER = LogManager.getLogger(Passenger.class);
    private LocalDate ticketDate;
    public boolean hasValidTicket;
    public Passenger(String firstName, String lastName, long phoneNumber,LocalDate ticketDate, boolean hasValidTicket) throws InvalidPersonException {
        super(firstName, lastName, phoneNumber);
        this.ticketDate = ticketDate;
        this.hasValidTicket = hasValidTicket;
        LOGGER.info("This passenger created: " + firstName + " " + lastName);
    }

    public LocalDate getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(LocalDate ticketDate) {
        this.ticketDate = ticketDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(ticketDate, passenger.ticketDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ticketDate);
    }

    @Override
    public String toString() {
        return "Passenger{name=" + firstName + ", lastName=" + lastName + ", ticketDate=" + ticketDate +
                '}';
    }

    @Override
    public void printDocument() {
        LOGGER.info("FirstName = " + getFirstName());
        LOGGER.info("LastName = " + getLastName());
        LOGGER.info("PhoneNumber = " + getPhoneNumber());
        LOGGER.info("ticketDate = " + getTicketDate());
    }

    @Override
    public void showID() {
        LOGGER.info("Title: Passenger");
        LOGGER.info("LastName: " + getLastName());
        LOGGER.info("PhoneNumber: " + getPhoneNumber());
        LOGGER.info("ticketDate: " + getTicketDate());
    }

    public boolean hasValidTicket() {
        return hasValidTicket;
    }
}
