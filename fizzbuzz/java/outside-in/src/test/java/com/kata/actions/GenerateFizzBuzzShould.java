package com.kata.actions;

import com.kata.infrastructure.Console;
import com.kata.model.FizzBuzzCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.*;

public class GenerateFizzBuzzShould {

    @Mock
    Console console = new Console();

    FizzBuzzCalculator fizzBuzzCalculator;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        this.fizzBuzzCalculator = new FizzBuzzCalculator();
    }

    @DisplayName("print 1 if number is 1")
    @Test
    void print_1_if_number_is_1() {
        GenerateFizzBuzz generateFizzBuzz = new GenerateFizzBuzz(console, fizzBuzzCalculator);

        generateFizzBuzz.execute(1);

        verify(console).print("1");
    }

    @DisplayName("print 2 if number is 2")
    @Test
    void print_2_if_number_is_2() {
        GenerateFizzBuzz generateFizzBuzz = new GenerateFizzBuzz(console, fizzBuzzCalculator);

        generateFizzBuzz.execute(2);

        verify(console).print("2");
    }

    @DisplayName("print Fizz if number is divisible by 3 (e.g. for number 3)")
    @Test
    void print_Fizz_if_number_is_3() {
        GenerateFizzBuzz generateFizzBuzz = new GenerateFizzBuzz(console, fizzBuzzCalculator);

        generateFizzBuzz.execute(3);

        verify(console).print("Fizz");
    }
}