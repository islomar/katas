package com.kata;


import com.google.common.collect.ImmutableSortedMap;

import java.util.List;
import java.util.Map;

public class FizzBuzzCalculator {

    private final Map<Integer, String> rules;

    public static class Builder {
        private final Map<Integer, String> rules;

        public Builder(List<FizzBuzzRule> fizzBuzzRules) {
            this.rules = ImmutableSortedMap.<Integer, String>reverseOrder()
                .put(3, "fizz")
                .put(5, "buzz")
                .put(7, "wizz")
                .put(15, "fizzbuzz")
                .build();
        }

        public FizzBuzzCalculator build() {
            return new FizzBuzzCalculator(this);
        }
    }

    private FizzBuzzCalculator(Builder builder) {
        this.rules = ImmutableSortedMap.<Integer, String>reverseOrder()
            .put(3, "fizz")
            .put(5, "buzz")
            .put(7, "wizz")
            .put(15, "fizzbuzz")
            .build();
    }


    public String calculate(int number) {

        return rules.entrySet().stream().
            filter(rule -> isNumberDivisibleByDivisor(number, rule.getKey())).
            findFirst().
            map(rule -> rule.getValue()).
            orElse(String.valueOf(number));
    }

    private boolean isNumberDivisibleByDivisor(int number, Integer divisor) {
        return number % divisor == 0;
    }

}
