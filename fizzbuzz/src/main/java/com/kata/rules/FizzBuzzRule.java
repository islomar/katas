package com.kata.rules;

import java.util.function.Function;
import java.util.function.Predicate;

public abstract class FizzBuzzRule {

    protected final Predicate<Integer> condition;
    protected final int priority;
    protected final Function<Integer, String> converter;

    public FizzBuzzRule(Predicate<Integer> condition, Function<Integer, String> converter, int priority) {

        this.condition = condition;
        this.converter = converter;
        this.priority = priority;
    }

    public abstract boolean shouldBeApplied(Integer input);

    public int getPriority() {
        return this.priority;
    }

    public String convert(Integer input) {
        return this.converter.apply(input);
    }
}
