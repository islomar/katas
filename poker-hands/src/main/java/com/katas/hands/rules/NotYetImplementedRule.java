package com.katas.hands.rules;

import com.katas.hands.PokerHand;

public class NotYetImplementedRule extends HandRule {

    public NotYetImplementedRule(int priority) {
        super(null, priority);
    }

    @Override
    public boolean isPokerHandMatchingTheRule(PokerHand pokerHand) {
        return false;
    }
}
