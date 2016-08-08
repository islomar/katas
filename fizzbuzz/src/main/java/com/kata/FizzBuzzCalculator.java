package com.kata;


import com.kata.rules.DivisibleRule;
import com.kata.rules.FizzBuzzRule;
import com.kata.rules.FizzBuzzRulePriorityComparator;
import com.kata.rules.RulePriorityEnum;

import java.util.ArrayList;
import java.util.List;
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

    private List<FizzBuzzRule> generateRules() {

        List<FizzBuzzRule> rules = new ArrayList<>();
        rules.add(createDivisibleByThreeRule());
        rules.add(createDivisibleByFiveRule());
        rules.add(createDivisibleBySevenRule());
        rules.add(createDivisibleByFifteenRule());
        return rules;
    }


    private FizzBuzzRule createDivisibleByThreeRule() {
        return this.createDivisibleByNumberRule(3, FIZZ, RulePriorityEnum.LOW);
    }

    private FizzBuzzRule createDivisibleByFiveRule() {
        return this.createDivisibleByNumberRule(5, BUZZ, RulePriorityEnum.LOW);
    }

    private FizzBuzzRule createDivisibleBySevenRule() {
        return this.createDivisibleByNumberRule(7, WIZZ, RulePriorityEnum.HIGH);
    }

    private FizzBuzzRule createDivisibleByFifteenRule() {
        return this.createDivisibleByNumberRule(15, FIZZBUZZ, RulePriorityEnum.HIGH);
    }

    private FizzBuzzRule createDivisibleByNumberRule(int number, String output, RulePriorityEnum rulePriority) {
        Predicate<Integer> isDivisibleBy = input -> input % number == 0;
        Function<Integer, String> fizzbuzzConverter = input -> output;
        return new DivisibleRule(isDivisibleBy, fizzbuzzConverter, rulePriority);
    }
}
