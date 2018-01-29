package com.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

        fizzBuzz.calculate("1");

        verify(console).print("1");
    }
}