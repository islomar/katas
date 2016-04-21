package com.kata;


import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class FizzBuzzCalculator {

    private static final Map<Integer, String> rules;

    static {
        rules = ImmutableMap.<Integer, String>builder()
            .put(15, "fizzbuzz")
            .put(3, "fizz")
            .put(5, "buzz")
            .put(7, "wizz")
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
