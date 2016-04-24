package com.kata.rules;

import java.util.function.Predicate;

public abstract class FizzBuzzRule {

    protected final Predicate<Integer> condition;
    protected final int priority;
    protected final String result;

    public FizzBuzzRule(Predicate<Integer> condition, String result, int priority) {

        this.condition = condition;
        this.result = result;
        this.priority = priority;
    }

    public abstract boolean shouldBeApplied(Integer input);
    public abstract String convert(Integer input);

    public int getPriority() {
        return this.priority;
    }
}
