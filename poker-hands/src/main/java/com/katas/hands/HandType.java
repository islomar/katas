package com.katas.hands;

import com.katas.hands.rules.FlushRule;
import com.katas.hands.rules.HandRule;
import com.katas.hands.rules.HighCardRule;
import com.katas.hands.rules.NotYetImplementedRule;
import com.katas.hands.rules.PairRule;

public enum HandType {
    HIGH_CARD(1, new HighCardRule(1)),
    PAIR(2, new PairRule(2)),
    TWO_PAIRS(3, new NotYetImplementedRule(3)),
    THREE_OF_A_KIND(4, new NotYetImplementedRule(4)),
    STRAIGHT(5, new NotYetImplementedRule(5)),
    FLUSH(6, new FlushRule(6)),
    FULL_HOUSE(7, new NotYetImplementedRule(7)),
    FOUR_OF_A_KIND(8, new NotYetImplementedRule(8)),
    STRAIGHT_FLUSH(9, new NotYetImplementedRule(9));

    private int priority;
    private final HandRule handRule;

    HandType(int priority, HandRule handRule) {
        this.priority = priority;
        this.handRule = handRule;
    }

    public int getPriority() {
        return this.priority;
    }

    HandRule getHandRule() {
        return this.handRule;
    }
}
