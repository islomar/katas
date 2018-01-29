package com.kata.app;

import com.kata.actions.GenerateFizzBuzz;
import com.kata.infrastructure.Console;
import com.kata.model.FizzBuzzCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.function.Supplier;
import java.util.stream.IntStream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class FizzBuzzLauncherApplicationShould {

    private final static int MAX_NUMBER = 100;

    private Supplier<IntStream> intRangeSupplier;
    @Mock
    private Console console;
    @Mock
    private FizzBuzzCalculator fizzBuzzCalculator;
    private GenerateFizzBuzz generateFizzBuzz;


    @BeforeEach
    public void setUp() {
        initMocks(this);
        this.generateFizzBuzz = new GenerateFizzBuzz(this.console, this.fizzBuzzCalculator);
        this.intRangeSupplier = () -> IntStream.range(1, MAX_NUMBER + 1);
    }

    @DisplayName("The app should print all the FizzBuzz results from 1 to 100")
    @Test
    void print_the_fizzbuzz_result_for_all_the_first_100_numbers() {
        FizzBuzzLauncherApplication fizzBuzzLauncherApplication = new FizzBuzzLauncherApplication(this.generateFizzBuzz);

        fizzBuzzLauncherApplication.run(this.intRangeSupplier.get());

        verifyPrintHasBeenCalledNtimes(MAX_NUMBER);
    }

    @DisplayName("The app should calculate all the FizzBuzz results from 1 to 100")
    @Test
    void calculate_the_fizzbuzz_result_for_all_the_first_100_numbers() {
        FizzBuzzLauncherApplication fizzBuzzLauncherApplication = new FizzBuzzLauncherApplication(this.generateFizzBuzz);

        fizzBuzzLauncherApplication.run(this.intRangeSupplier.get());

        verifyFizzBuzzIsCalculatedNtimes();
    }

    private void verifyFizzBuzzIsCalculatedNtimes() {
        this.intRangeSupplier.get().forEach(number -> verify(this.fizzBuzzCalculator, times(1)).calculate(number));
    }

    private void verifyPrintHasBeenCalledNtimes(int numberOfPrints) {
        verify(this.console, times(numberOfPrints)).print(any());
    }

}
