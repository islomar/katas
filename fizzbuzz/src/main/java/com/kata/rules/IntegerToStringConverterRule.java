package com.kata.rules;

import java.util.function.Predicate;

public class IntegerToStringConverterRule extends FizzBuzzRule {

    public IntegerToStringConverterRule(Integer input, Predicate<Integer> condition, String result, int priority) {
        super(condition, result, priority);
    }

    @Override
    public boolean shouldBeApplied(Integer input) {
        return false;
    }

    @Override
    public String convert(Integer input) {
        return String.valueOf(input);
    }
}
