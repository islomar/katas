package com.kata;


import com.google.common.collect.ImmutableSortedMap;

import com.kata.rules.FizzBuzzRule;
import com.kata.rules.FizzBuzzRulePriorityComparator;

import java.util.List;
import java.util.Map;

public class FizzBuzzCalculator {

    private final List<FizzBuzzRule> fizzBuzzRules;


    public FizzBuzzCalculator(List<FizzBuzzRule> fizzBuzzRules) {
        this.fizzBuzzRules = fizzBuzzRules;
    }


    public String calculate(int input) {

        return fizzBuzzRules.stream().
            sorted(new FizzBuzzRulePriorityComparator()).
            filter(rule -> rule.shouldBeApplied(input)).
            findFirst().
            map(rule -> rule.convert(input)).
            orElse(String.valueOf(input));
    }
}
