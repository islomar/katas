package com.kata.model;

public class FizzBuzzCalculator {
    public String calculate(int number) {
        if (isDivisibleBy3(number) && isDivisibleBy5(number)) {
            return "FizzBuzz";
        }
        if (isDivisibleBy3(number)) {
            return "Fizz";
        }
        if (isDivisibleBy5(number)) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

    private boolean isDivisibleBy3(int number) {
        return isNumberDivisibleBy(number, 3);
    }

    private boolean isDivisibleBy5(int number) {
        return isNumberDivisibleBy(number, 5);
    }

    private boolean isNumberDivisibleBy(int number, int i) {
        return number % i == 0;
    }
}
