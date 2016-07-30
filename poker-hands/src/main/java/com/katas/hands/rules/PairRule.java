package com.katas.hands.rules;

import com.katas.hands.PokerHand;
import com.katas.cards.Card;
import com.katas.cards.CardComparatorByValue;
import com.katas.cards.CardValueType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PairRule extends HandRule {

    private static final int NUMBER_OF_CARDS_EQUAL = 2;

    final static Function<PokerHand, List<Card>> RULE_EXTRACTOR = creatematchingRuleCardsExtractor();

    public PairRule(final int priority) {
        super(RULE_EXTRACTOR, priority);
    }

    public boolean isPokerHandMatchingTheRule(PokerHand pokerHand) {
        Map<CardValueType, Integer> numberOfSameCardValues = new HashMap<>();
        pokerHand.getCards().stream().forEach(card -> numberOfSameCardValues.compute(card.getCardValue(), (k, v) -> (v==null)? 1: v+1));
        return numberOfSameCardValues.entrySet().stream().anyMatch(cardValueTypeIntegerEntry -> cardValueTypeIntegerEntry.getValue()==NUMBER_OF_CARDS_EQUAL);
    }

    private static Function<PokerHand, List<Card>> creatematchingRuleCardsExtractor() {
        return pokerHand -> pokerHand.getCards().stream().sorted(new CardComparatorByValue()).collect(Collectors.toList()).subList(0, 1);
    }
}
