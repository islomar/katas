package com.kata;

public class FizzBuzz {

    private final Console console;

    public FizzBuzz(Console console) {

        this.console = console;
    }

    public void calculate(int number) {
        if (number == 3) {
            this.console.print("Fizz");
        }
        this.console.print(String.valueOf(number));
    }
}
