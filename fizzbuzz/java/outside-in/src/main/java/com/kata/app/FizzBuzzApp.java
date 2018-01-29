package com.kata.app;

import com.kata.actions.GenerateFizzBuzz;
import com.kata.infrastructure.Console;
import com.kata.model.FizzBuzzCalculator;

import java.util.stream.IntStream;

public class FizzBuzzApp {
    private final GenerateFizzBuzz generateFizzBuzz;

    public FizzBuzzApp(GenerateFizzBuzz generateFizzBuzz) {

        this.generateFizzBuzz = generateFizzBuzz;
    }

    public void run(IntStream range) {
        range.forEach(number -> this.generateFizzBuzz.execute(number));
    }
}
