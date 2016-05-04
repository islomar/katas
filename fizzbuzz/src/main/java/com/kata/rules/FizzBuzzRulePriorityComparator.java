package com.kata.rules;

import java.util.Comparator;


public class FizzBuzzRulePriorityComparator implements Comparator<FizzBuzzRule> {

    @Override
    public int compare(FizzBuzzRule rule1, FizzBuzzRule rule2) {
        return (rule1.getPriority() > rule2.getPriority()) ? 1 : -1;
    }

}
