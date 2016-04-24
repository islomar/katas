package com.kata;

import com.kata.rules.DivisibleRule;
import com.kata.rules.FizzBuzzRule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
public class FizzBuzzShould {

    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";
    private FizzBuzzCalculator fizzBuzzCalculator;
    private List<FizzBuzzRule> rules = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        rules.add(new DivisibleRule());
        fizzBuzzCalculator = new FizzBuzzCalculator(rules);
    }

    public void return_one_when_it_receives_one() {
        assertThat(fizzBuzzCalculator.calculate(1), is("1"));
    }

    public void return_two_when_it_receives_two() {
        assertThat(fizzBuzzCalculator.calculate(2), is("2"));
    }

    public void return_fizz_when_it_receives_a_number_three() {
        assertThat(fizzBuzzCalculator.calculate(3), is(FIZZ));
    }

    public void return_buzz_when_it_receives_a_number_five() {
        assertThat(fizzBuzzCalculator.calculate(5), is(BUZZ));
    }

    public void return_fizz_when_it_receives_a_number_divisible_by_three() {
        assertThat(fizzBuzzCalculator.calculate(12), is(FIZZ));
    }

    public void return_buzz_when_it_receives_a_number_divisible_by_five() {
        assertThat(fizzBuzzCalculator.calculate(10), is(BUZZ));
    }

    public void return_fizzbuzz_when_it_receives_a_number_fifteen() {
        assertThat(fizzBuzzCalculator.calculate(15), is("fizzbuzz"));
    }

    public void return_fizzbuzz_when_it_receives_a_number_divisible_by_fifteen() {
        assertThat(fizzBuzzCalculator.calculate(45), is("fizzbuzz"));
    }

    public void return_wizz_when_it_receives_a_number_divisible_by_seven() {
        assertThat(fizzBuzzCalculator.calculate(14), is("wizz"));
    }
}
