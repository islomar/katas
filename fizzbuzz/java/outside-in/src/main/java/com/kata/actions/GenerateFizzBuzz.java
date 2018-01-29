package com.kata.actions;

import com.kata.infrastructure.Console;
import com.kata.model.FizzBuzzCalculator;

public class GenerateFizzBuzz {

    private final Console console;
    private final FizzBuzzCalculator fizzBuzzCalculator;

    public GenerateFizzBuzz(Console console, FizzBuzzCalculator fizzBuzzCalculator) {

        this.console = console;
        this.fizzBuzzCalculator = fizzBuzzCalculator;
    }

    public void execute(int number) {
        String result = this.fizzBuzzCalculator.calculate(number);
        this.console.print(result);
    }
}
