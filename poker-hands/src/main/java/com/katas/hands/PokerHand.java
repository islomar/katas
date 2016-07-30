package com.katas.hands;

import com.katas.cards.Card;
import com.katas.cards.CardFactory;

import java.util.Arrays;
import java.util.List;

public class PokerHand {

    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;

    public PokerHand(Card card1, Card card2, Card card3, Card card4, Card card5) {
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
        this.card4 = card4;
        this.card5 = card5;
    }

    public PokerHand(String card1, String card2, String card3, String card4, String card5) {
        this.card1 = CardFactory.createCard(card1);
        this.card2 = CardFactory.createCard(card2);
        this.card3 = CardFactory.createCard(card3);
        this.card4 = CardFactory.createCard(card4);
        this.card5 = CardFactory.createCard(card5);
    }

    public List<Card> getCards() {
        return Arrays.asList(this.card1, this.card2, this.card3, this.card4, this.card5);
    }
}
