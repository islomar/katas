package com.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.*;

public class FizzBuzzShould {

    @Mock Console console = new Console();

    @BeforeEach
    public void setUp() {
        initMocks(this);
    }

    @DisplayName("print 1 if number is 1")
    @Test
    void print_1_if_number_is_1() {
        FizzBuzz fizzBuzz = new FizzBuzz(console);

        fizzBuzz.calculate(1);

        verify(console).print("1");
    }

    @DisplayName("print 2 if number is 2")
    @Test
    void print_2_if_number_is_2() {
        FizzBuzz fizzBuzz = new FizzBuzz(console);

        fizzBuzz.calculate(2);

        verify(console).print("2");
    }

    @DisplayName("print Fizz if number is divisible by 3 (e.g. for number 3)")
    @Test
    void print_Fizz_if_number_is_3() {
        FizzBuzz fizzBuzz = new FizzBuzz(console);

        fizzBuzz.calculate(3);

        verify(console).print("Fizz");
    }
}