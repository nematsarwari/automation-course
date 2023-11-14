package com.solvd.laba.HW2345.interfaces;

import com.solvd.laba.HW2345.Exception.UnsuccessfulPayment;

public interface Payable {
    void makePayment(long cardNumber, long price) throws UnsuccessfulPayment;
    void receivePayment();
}
