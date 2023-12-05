package com.solvd.laba.oopPractice.interfaces;

@FunctionalInterface
interface Validator<T> {
    boolean validate(T actualPrice, T expectedPrice);
}
