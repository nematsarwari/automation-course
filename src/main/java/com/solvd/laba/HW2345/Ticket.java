package com.solvd.laba.HW2345;

import com.solvd.laba.HW2345.Exception.UnsuccessfulPayment;
import com.solvd.laba.HW2345.interfaces.Payable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Driver;
import java.util.Objects;

public class Ticket implements Payable {
    private static final Logger LOGGER = LogManager.getLogger(Driver.class);

    private String ticketHolderName;
    private String ticketHolderLastname;
    private double price = 30.0;
    private static int ticketNumber;
    private int l;

    public Ticket(String ticketHolderName, String ticketHolderLastname){
        this.ticketHolderName = ticketHolderName;
        this.ticketHolderLastname = ticketHolderLastname;
        ticketNumber++;
    }

    public String getTicketHolderName() {
        return ticketHolderName;
    }

    public void setTicketHolderName(String ticketHolderName) {
        this.ticketHolderName = ticketHolderName;
    }

    public String getTicketHolderLastname() {
        return ticketHolderLastname;
    }

    public void setTicketHolderLastname(String ticketHolderLastname) {
        this.ticketHolderLastname = ticketHolderLastname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int getTicketNumber() {
        return ticketNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Double.compare(ticket.price, price) == 0 && ticketNumber == ticket.ticketNumber && Objects.equals(ticketHolderName, ticket.ticketHolderName) && Objects.equals(ticketHolderLastname, ticket.ticketHolderLastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketHolderName, ticketHolderLastname, price, ticketNumber);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketHolderName='" + ticketHolderName + '\'' +
                ", ticketHolderLastname='" + ticketHolderLastname + '\'' +
                ", price=" + price +
                ", ticketNumber=" + ticketNumber +
                '}';
    }

    @Override
    public void makePayment(long cardNumber, long price) throws UnsuccessfulPayment {
        if (price == this.price){
            LOGGER.info("you make the payment successfully");
            l++;
        }else {
            throw new UnsuccessfulPayment("Please pay full amount");
        }
    }

    @Override
    public void receivePayment() {
        if (l > 0){
            LOGGER.info("You already paid "+price+"$");
        }else {
            LOGGER.info("Payment did not placed yet!");
        }
    }

}
