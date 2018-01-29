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

    GenerateFizzBuzz generateFizzBuzz;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        this.fizzBuzzCalculator = new FizzBuzzCalculator();
        this.generateFizzBuzz = new GenerateFizzBuzz(console, fizzBuzzCalculator);
    }

    @DisplayName("print 1 if number is 1")
    @Test
    void print_1_if_number_is_1() {
        generateFizzBuzz.execute(1);

        verify(console).print("1");
    }

    @DisplayName("print 2 if number is 2")
    @Test
    void print_2_if_number_is_2() {
        generateFizzBuzz.execute(2);

        verify(console).print("2");
    }

    @DisplayName("print Fizz if number is divisible by 3 (e.g. for number 3)")
    @Test
    void print_Fizz_if_number_is_3() {
        generateFizzBuzz.execute(3);

        verify(console).print("Fizz");
    }

    @DisplayName("print Fizz if number is divisible by 3 (e.g. for number 6)")
    @Test
    void print_Fizz_if_number_is_6() {
        generateFizzBuzz.execute(6);

        verify(console).print("Fizz");
    }

    @DisplayName("print Buzz if number is divisible by 5 (e.g. for number 5)")
    @Test
    void print_Buzz_if_number_is_5() {
        generateFizzBuzz.execute(5);

        verify(console).print("Buzz");
    }

    @DisplayName("print Buzz if number is divisible by 5 (e.g. for number 10)")
    @Test
    void print_Buzz_if_number_is_10() {
        generateFizzBuzz.execute(10);

        verify(console).print("Buzz");
    }

    @DisplayName("print FizzBuzz if number is divisible by 3 and 5 (e.g. for number 15)")
    @Test
    void print_FizzBuzz_if_number_is_15() {
        generateFizzBuzz.execute(15);

        verify(console).print("FizzBuzz");
    }

    @DisplayName("print FizzBuzz if number is divisible by 3 and 5 (e.g. for number 30)")
    @Test
    void print_FizzBuzz_if_number_is_30() {
        generateFizzBuzz.execute(30);

        verify(console).print("FizzBuzz");
    }
}