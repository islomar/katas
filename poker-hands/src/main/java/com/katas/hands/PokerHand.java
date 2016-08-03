package com.katas.hands;

import com.katas.cards.Card;
import com.katas.cards.CardComparatorByValue;
import com.katas.cards.CardFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PokerHand {

    private List<Card> cardList = new ArrayList<>();

    public PokerHand(Card card1, Card card2, Card card3, Card card4, Card card5) {
        this.cardList.add(card1);
        this.cardList.add(card2);
        this.cardList.add(card3);
        this.cardList.add(card4);
        this.cardList.add(card5);
    }

    public PokerHand(String card1, String card2, String card3, String card4, String card5) {
        this.cardList.add(CardFactory.createCard(card1));
        this.cardList.add(CardFactory.createCard(card2));
        this.cardList.add(CardFactory.createCard(card3));
        this.cardList.add(CardFactory.createCard(card4));
        this.cardList.add(CardFactory.createCard(card5));
    }

    public PokerHand(List<String> cardList) {
        this.cardList = cardList.stream().map(cardString -> CardFactory.createCard(cardString)).collect(Collectors.toList());
    }

    public List<Card> getCards() {
        return this.cardList;
    }

    public List<Card> getCardsSortedByValue() {
        return this.getCards().stream().sorted(new CardComparatorByValue()).collect(Collectors.toList());
    }

    public Optional<Card> getCardWithHighestValue() {
        if (this.getCards().isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(this.getCardsSortedByValue().get(0));
    }
}
