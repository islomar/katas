package com.katas.hands.rules;

import com.katas.cards.Card;
import com.katas.cards.CardComparatorByValue;
import com.katas.cards.CardSuitType;
import com.katas.hands.PokerHand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FlushRule extends HandRule {

    final static Function<PokerHand, List<Card>> RULE_EXTRACTOR = creatematchingRuleCardsExtractor();

    public FlushRule(final int priority) {
        super(RULE_EXTRACTOR, priority);
    }

    public boolean isPokerHandMatchingTheRule(PokerHand pokerHand) {
        return this.haveAllCardsTheSameSuit(pokerHand);
    }

    private boolean haveAllCardsTheSameSuit(PokerHand pokerHand) {
        Map<CardSuitType, Integer> numberOfCardsWithSameSuit = new HashMap<>();
        CardSuitType firstCardSuit = pokerHand.getCards().get(0).getCardSuit();
        return pokerHand.getCards().stream().allMatch(card -> card.getCardSuit() == firstCardSuit);
    }

    private static Function<PokerHand, List<Card>> creatematchingRuleCardsExtractor() {
        return pokerHand -> pokerHand.getCards().stream().sorted(new CardComparatorByValue()).collect(Collectors.toList()).subList(0, 1);
    }
}
