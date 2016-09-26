package com.kata.rules;

import java.util.function.Function;
import java.util.function.Predicate;

public class DivisibleRule extends FizzBuzzRule {

    public DivisibleRule(Predicate<Integer> condition, Function<Integer, String> converter, RulePriorityEnum priority) {
        super(condition, converter, priority);
    }

    @Override
    public boolean shouldBeApplied(Integer input) {
        return this.condition.test(input);
    }

}
