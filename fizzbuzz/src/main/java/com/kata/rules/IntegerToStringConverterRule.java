package com.kata.rules;

import java.util.function.Function;
import java.util.function.Predicate;

public class IntegerToStringConverterRule extends FizzBuzzRule {

    public IntegerToStringConverterRule(Integer input, Predicate<Integer> condition, Function<Integer, String> converter, int priority) {
        super(condition, converter, priority);
    }

    @Override
    public boolean shouldBeApplied(Integer input) {
        return false;
    }

}
