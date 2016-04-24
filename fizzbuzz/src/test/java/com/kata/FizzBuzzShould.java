package com.kata;

import com.kata.rules.DivisibleRule;
import com.kata.rules.FizzBuzzRule;
import com.kata.rules.IntegerToStringConverterRule;
import com.kata.rules.RulePriorityEnum;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
public class FizzBuzzShould {

    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";
    public static final String WIZZ = "wizz";
    public static final String FIZZBUZZ = "fizzbuzz";
    private FizzBuzzCalculator fizzBuzzCalculator;
    private List<FizzBuzzRule> rules = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        rules = generateRules();
        Function<Integer, String> defaultConverter = (input) -> String.valueOf(input);
        fizzBuzzCalculator = new FizzBuzzCalculator(rules, defaultConverter);
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
        assertThat(fizzBuzzCalculator.calculate(15), is(FIZZBUZZ));
    }

    public void return_fizzbuzz_when_it_receives_a_number_divisible_by_fifteen() {
        assertThat(fizzBuzzCalculator.calculate(45), is(FIZZBUZZ));
    }

    public void return_wizz_when_it_receives_a_number_divisible_by_seven() {
        assertThat(fizzBuzzCalculator.calculate(14), is(WIZZ));
    }

    public List<FizzBuzzRule> generateRules() {

        rules.add(createDivisibleByThreeRule());
        rules.add(createDivisibleByFiveRule());
        rules.add(createDivisibleBySevenRule());
        rules.add(createDivisibleByFifteenRule());
        return rules;
    }

    private FizzBuzzRule createDivisibleByThreeRule() {
        Predicate<Integer> isDivisibleByThree = input -> input % 3 == 0;
        Function<Integer, String> fizzConverter = input -> FIZZ;
        return new DivisibleRule(isDivisibleByThree, fizzConverter, RulePriorityEnum.LOW);
    }

    private FizzBuzzRule createDivisibleByFiveRule() {
        Predicate<Integer> isDivisibleByFive = input -> input % 5 == 0;
        Function<Integer, String> buzzConverter = input -> BUZZ;
        return new DivisibleRule(isDivisibleByFive, buzzConverter, RulePriorityEnum.LOW);
    }

    private FizzBuzzRule createDivisibleBySevenRule() {
        Predicate<Integer> isDivisibleBySeven = input -> input % 7 == 0;
        Function<Integer, String> wizzConverter = input -> WIZZ;
        return new DivisibleRule(isDivisibleBySeven, wizzConverter, RulePriorityEnum.HIGH);
    }

    private FizzBuzzRule createDivisibleByFifteenRule() {
        Predicate<Integer> isDivisibleByFifteen = input -> input % 15 == 0;
        Function<Integer, String> fizzbuzzConverter = input -> FIZZBUZZ;
        return new DivisibleRule(isDivisibleByFifteen, fizzbuzzConverter, RulePriorityEnum.HIGH);
    }
}
