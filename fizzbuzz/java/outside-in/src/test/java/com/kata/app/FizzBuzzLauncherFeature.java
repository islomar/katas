package com.kata.app;

import com.kata.infrastructure.Console;
import com.kata.model.FizzBuzzCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.stream.IntStream;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class FizzBuzzLauncherFeature {

    @Mock
    private Console console;
    @Mock
    private FizzBuzzCalculator fizzBuzzCalculator;


    @BeforeEach
    public void setUp() {
        initMocks(this);
    }

    @DisplayName("The app should print all the FizzBuzz results from 1 to 100")
    @Test
    void xxx() {
        FizzBuzzLauncher fizzBuzzLauncher = new FizzBuzzLauncher(this.console);
        IntStream intRange = IntStream.range(1, 100);

        fizzBuzzLauncher.run(intRange);

        checkPrintHasBeenCalledNtimes(100);
        //intRange.forEach(number -> checkPrintHasBeenCalled(number));
    }

    private void checkPrintHasBeenCalledNtimes(int numberOfPrints) {
        verify(this.console, times(numberOfPrints)).print(anyString());
    }

}
