package com.kata;

import com.kata.rules.DivisibleRule;
import com.kata.rules.FizzBuzzRule;
import com.kata.rules.IntegerToStringConverterRule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
        Predicate<Integer> divisibleByThree = input -> input % 3 == 0;
        Predicate<Integer> divisibleByFive = input -> input % 5 == 0;
        Predicate<Integer> divisibleBySeven = input -> input % 7 == 0;
        Predicate<Integer> divisibleByFifteen = input -> input % 15 == 0;
        rules.add(new DivisibleRule(divisibleByThree, "fizz", 2));
        rules.add(new DivisibleRule(divisibleByFive, "buzz", 2));
        rules.add(new DivisibleRule(divisibleBySeven, "wizz", 2));
        rules.add(new DivisibleRule(divisibleByFifteen, "fizzbuzz", 1));
        //rules.add(new IntegerToStringConverterRule());
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
