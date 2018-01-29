package com.kata.actions;

import com.kata.Console;

public class GenerateFizzBuzz {

    private final Console console;

    public GenerateFizzBuzz(Console console) {

        this.console = console;
    }

    public void execute(int number) {
        if (number == 3) {
            this.console.print("Fizz");
        }
        this.console.print(String.valueOf(number));
    }
}
