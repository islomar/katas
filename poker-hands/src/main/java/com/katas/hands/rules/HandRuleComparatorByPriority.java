package com.katas.hands.rules;

import java.util.Comparator;

public class HandRuleComparatorByPriority implements Comparator<HandRule> {

    @Override
    public int compare(HandRule handRule1, HandRule handRule2) {
        return (handRule2.getPriority() > handRule1.getPriority()) ? 1 : -1;
    }

}
