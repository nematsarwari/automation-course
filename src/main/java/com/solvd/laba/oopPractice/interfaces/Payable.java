package com.solvd.laba.oopPractice.interfaces;

import com.solvd.laba.oopPractice.Exception.UnsuccessfulPayment;

public interface Payable {
    void makePayment(long cardNumber, long price) throws UnsuccessfulPayment;
    void receivePayment();
}
