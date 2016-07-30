package com.katas.hands.rules;


import com.katas.cards.Card;
import com.katas.hands.PokerHand;
import com.katas.cards.CardComparatorByValue;
import com.katas.cards.CardValueType;

import java.util.List;
import java.util.function.Function;

public abstract class HandRule {

    private final int priority;

    protected final Function<PokerHand, List<Card>> matchingRuleCardsExtractor;

    public HandRule(final Function<PokerHand, List<Card>> matchingRuleCardsExtractor, final int priority) {

        this.matchingRuleCardsExtractor = matchingRuleCardsExtractor;
        this.priority = priority;
    }

    public abstract boolean isPokerHandMatchingTheRule(PokerHand pokerHand);

    public List<Card> getCardsMatchingThisRule(PokerHand pokerHand) {
        return this.matchingRuleCardsExtractor.apply(pokerHand);
    }

    public CardValueType getMaxCardValue(PokerHand pokerHand) {
        List<Card> cardsMatchingThisRule = this.getCardsMatchingThisRule(pokerHand);
        return cardsMatchingThisRule.stream().sorted(new CardComparatorByValue()).findFirst().map(card -> card.getCardValue()).get();
    }

    public int getPriority() {
        return this.priority;
    }

}
