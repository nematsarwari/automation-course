package com.solvd.laba.oopPractice.interfaces;

import com.solvd.laba.oopPractice.Exception.UnsuccessfulPaymentException;

public interface Payable {
    void makePayment(long cardNumber, long price) throws UnsuccessfulPaymentException;
    void receivePayment();
}
