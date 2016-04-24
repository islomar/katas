package com.kata.rules;

import java.util.function.Predicate;

public class DivisibleRule extends FizzBuzzRule {

    public DivisibleRule(Predicate<Integer> condition, String result, int priority) {
        super(condition, result, priority);
    }

    @Override
    public boolean shouldBeApplied(Integer input) {
        return this.condition.test(input);
    }

    @Override
    public String convert(Integer input) {
        return this.result;
    }
}
