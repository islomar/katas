package com.kata;


import com.google.common.collect.ImmutableSortedMap;

import com.kata.rules.FizzBuzzRule;
import com.kata.rules.FizzBuzzRulePriorityComparator;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FizzBuzzCalculator {

    private final List<FizzBuzzRule> fizzBuzzRules;
    private final Function<Integer, String> defaultConverter;


    public FizzBuzzCalculator(List<FizzBuzzRule> fizzBuzzRules, Function<Integer, String> defaultConverter) {
        this.fizzBuzzRules = fizzBuzzRules;
        this.defaultConverter = defaultConverter;
    }


    public String calculate(int input) {

        return fizzBuzzRules.stream().
            sorted(new FizzBuzzRulePriorityComparator()).
            filter(rule -> rule.shouldBeApplied(input)).
            findFirst().
            map(rule -> rule.convert(input)).
            orElse(defaultConverter.apply(input));
    }
}
