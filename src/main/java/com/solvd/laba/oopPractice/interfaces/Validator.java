package com.solvd.laba.oopPractice.interfaces;

@FunctionalInterface
public interface Validator<T> {
    boolean validate(T actualPrice, T expectedPrice);
}
