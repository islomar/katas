package com.katas.cards;


import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Card {

    private final CardValueType cardValue;
    private final CardSuitType cardSuit;

    public Card(CardValueType cardValue, CardSuitType cardSuit) {

        this.cardValue = cardValue;
        this.cardSuit = cardSuit;
    }

    public CardValueType getCardValue() {
        return this.cardValue;
    }

    public CardSuitType getCardSuit() {
        return this.cardSuit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Card that = (Card) o;

        return Objects.equal(this.cardValue, that.cardValue) &&
               Objects.equal(this.cardSuit, that.cardSuit);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cardValue, cardSuit);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("cardValue", cardValue)
            .add("cardSuit", cardSuit)
            .toString();
    }
}
