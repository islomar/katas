package com.katas.hands;

import com.google.common.base.MoreObjects;

import com.katas.cards.CardValueType;

public class TopUserHand {

    private final HandType handType;
    private final CardValueType maxCardValue;

    public TopUserHand(HandType handType, CardValueType maxCardValue) {
        this.handType = handType;
        this.maxCardValue = maxCardValue;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("handType", handType.toString())
            .add("maxCardValue", maxCardValue)
            .toString();
    }

    public HandType getHandType() {
        return this.handType;
    }

    public CardValueType getMaxCardValue() {
        return this.maxCardValue;
    }
}
