package com.solvd.laba.oopPractice.interfaces;

import com.solvd.laba.oopPractice.Exception.UnsuccessfulPaymentRuntime;

public interface Payable {
    void makePayment(long cardNumber, long price) throws UnsuccessfulPaymentRuntime;
    void receivePayment();
}
