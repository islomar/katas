package com.katas.hands;

import java.util.Arrays;

public class HandCalculator {

    public HandType calculateHand(PokerHand pokerHand) {
        return Arrays.asList(HandType.values()).
            stream().
            sorted(new HandTypeComparatorByPriority()).
            filter(handType -> handType.getHandRule().isPokerHandMatchingTheRule(pokerHand)).
            findFirst().
            get();
    }


    public TopUserHand calculateTopHand(PokerHand pokerHand) {
        return Arrays.asList(HandType.values()).
            stream().
            sorted(new HandTypeComparatorByPriority()).
            filter(handType -> handType.getHandRule().isPokerHandMatchingTheRule(pokerHand)).
            findFirst().
            map(handType -> new TopUserHand(handType, handType.getHandRule().getMaxCardValue(pokerHand))).
            get();
    }

}
