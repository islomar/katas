package com.katas.hands.rules;

import com.katas.cards.Card;
import com.katas.cards.CardComparatorByValue;
import com.katas.hands.PokerHand;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HighCardRule extends HandRule {

    final static Function<PokerHand, List<Card>> RULE_EXTRACTOR = creatematchingRuleCardsExtractor();

    public HighCardRule(final int priority) {
        super(RULE_EXTRACTOR, priority);
    }

    public boolean isPokerHandMatchingTheRule(PokerHand pokerHand) {
        return true;
    }

    private static Function<PokerHand, List<Card>> creatematchingRuleCardsExtractor() {
        return pokerHand -> pokerHand.getCards().stream().sorted(new CardComparatorByValue()).collect(Collectors.toList()).subList(0, 1);
    }
}
