package com.kata.app;

import com.kata.actions.GenerateFizzBuzz;
import com.kata.infrastructure.Console;
import com.kata.model.FizzBuzzCalculator;

import java.util.stream.IntStream;

public class FizzBuzzLauncher {

    public static void main(String[] args) {
        GenerateFizzBuzz generateFizzBuzz = new GenerateFizzBuzz(new Console(), new FizzBuzzCalculator());
        FizzBuzzApp fizzBuzzApp = new FizzBuzzApp(generateFizzBuzz);

        fizzBuzzApp.run(IntStream.range(1, 101));
    }
}
