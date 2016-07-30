package com.katas.cards;

import com.katas.cards.Card;

import java.io.Serializable;
import java.util.Comparator;

public class CardComparatorByValue implements Comparator<Card>, Serializable {

    @Override
    public int compare(Card card1, Card card2) {
        return (card2.getCardValue().getValue() > card1.getCardValue().getValue()) ? 1 : -1;
    }
}
