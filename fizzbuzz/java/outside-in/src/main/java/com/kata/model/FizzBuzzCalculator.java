package com.kata.model;

public class FizzBuzzCalculator {
    public String calculate(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        }
        return String.valueOf(number);
    }
}
