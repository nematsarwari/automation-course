package com.solvd.laba.oopPractice.interfaces;
@FunctionalInterface
public interface PaymentLogger {
    void logPaymentStatus(int payCounter, double price);
}
