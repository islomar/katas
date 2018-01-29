package com.kata;

public class FizzBuzz {

    private final Console console;

    public FizzBuzz(Console console) {

        this.console = console;
    }

    public void calculate(String number) {
        this.console.print(number);
    }
}
