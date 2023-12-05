package com.solvd.laba.oopPractice;

import com.solvd.laba.oopPractice.Exception.UnsuccessfulPaymentException;
import com.solvd.laba.oopPractice.interfaces.Payable;
import com.solvd.laba.oopPractice.interfaces.PaymentLogger;
import com.solvd.laba.oopPractice.interfaces.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Ticket implements Payable {
    private static final Logger LOGGER = LogManager.getLogger(Ticket.class);

    private int ticketNumber;
    private double price = 20.0;
    private int payCounter;
    public Ticket(int ticketNumber){
        this.ticketNumber = ticketNumber;
        LOGGER.info("ticket created");
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPayCounter() {
        return payCounter;
    }

    public void setPayCounter(int payCounter) {
        this.payCounter = payCounter;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber=" + ticketNumber +
                '}';
    }

    @Override
    public void makePayment(long cardNumber, long price) throws UnsuccessfulPaymentException {

        Validator<Double> validator = (actual, expected) -> actual.equals(expected);

        if (validator.validate(this.price, (double) price)) {
            System.out.println("You made the payment successfully");
            payCounter++;
        } else {
            throw new UnsuccessfulPaymentException("Please pay the full amount");
        }
        if (price == this.price){
            LOGGER.info("you make the payment successfully");
            payCounter++;
        }else {
            throw new UnsuccessfulPaymentException("Please pay full amount");
        }
    }

    @Override
    public void receivePayment() {
        // using
        PaymentLogger paymentLogger = (counter, amount) -> {
            if (counter > 0) {
                LOGGER.info("You already paid " + amount + "$");
            } else {
                LOGGER.info("Payment did not placed yet!");
            }
        };

        paymentLogger.logPaymentStatus(payCounter, price);
    }

}
