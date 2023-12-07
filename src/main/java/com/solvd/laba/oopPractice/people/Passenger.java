package com.solvd.laba.oopPractice.people;

import com.solvd.laba.oopPractice.Exception.InvalidPersonException;
import com.solvd.laba.oopPractice.FileUtils;
import com.solvd.laba.oopPractice.Ticket;
import com.solvd.laba.oopPractice.abstracts.Person;
import com.solvd.laba.oopPractice.enums.RideExperience;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class Passenger extends Person {
    private static final Logger LOGGER = LogManager.getLogger(Passenger.class);
    private LocalDate ticketDate;
    private Ticket ticket;
    private FileUtils fileUtils;
    private RideExperience rideExperience;


    public Passenger(String firstName, String lastName, long phoneNumber, LocalDate ticketDate) throws InvalidPersonException {
        super(firstName, lastName, phoneNumber);
        this.ticketDate = ticketDate;
        LOGGER.info("This passenger created: " + firstName + " " + lastName);
    }

    public LocalDate getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(LocalDate ticketDate) {
        this.ticketDate = ticketDate;
    }

    public void assignTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(ticketDate, passenger.ticketDate) && Objects.equals(ticket, passenger.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ticketDate, ticket);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "ticketDate=" + ticketDate +
                ", ticket=" + ticket +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
    String path = "src\\test\\java\\passengerDocuments\\"+getFirstName()+"Documents.txt";
    @Override
    public void writeDocument() {
        fileUtils = new FileUtils();
        fileUtils.writeToFile(path,
                "FirstName: " + getFirstName()+
                        "\nLastName: " + getLastName()+
                        "\nPhoneNumber: " + getPhoneNumber());
        LOGGER.info("document successfully written!");
    }

    @Override
    public void printDocument() {
        List<String> lines = fileUtils.readFromFile(path);

        // Runnable lambda and forEach
        Runnable printLinesRunnable = () -> {
            lines.forEach(System.out::println);
        };

        // Execute the Runnable
        printLinesRunnable.run();
    }
    public RideExperience feedBack(int op){
        return RideExperience.getByOption(op);
    }
}
