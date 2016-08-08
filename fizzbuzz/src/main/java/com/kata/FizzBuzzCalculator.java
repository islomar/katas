package com.kata;


import com.google.common.collect.ImmutableSortedMap;

import com.kata.rules.DivisibleRule;
import com.kata.rules.FizzBuzzRule;
import com.kata.rules.FizzBuzzRulePriorityComparator;
import com.kata.rules.RulePriorityEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FizzBuzzCalculator {

    private final Function<Integer, String> defaultConverter;
    private final List<FizzBuzzRule> fizzBuzzRules;

    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";
    private static final String WIZZ = "wizz";
    private static final String FIZZBUZZ = "fizzbuzz";

    public FizzBuzzCalculator() {
        this.fizzBuzzRules = this.generateRules();
        this.defaultConverter = (input) -> String.valueOf(input);
    }


    public String calculate(int input) {

        return fizzBuzzRules.stream().
            sorted(new FizzBuzzRulePriorityComparator()).
            filter(rule -> rule.shouldBeApplied(input)).
            findFirst().
            map(rule -> rule.convert(input)).
            orElse(defaultConverter.apply(input));
    }

    public List<FizzBuzzRule> generateRules() {

        List<FizzBuzzRule> rules = new ArrayList<>();
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
