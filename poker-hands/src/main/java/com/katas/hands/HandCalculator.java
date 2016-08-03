package com.katas.hands;

import com.katas.Player;
import com.katas.cards.Card;
import com.katas.cards.CardComparatorByValue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HandCalculator {

    public TopUserHand calculateTopHand(PokerHand pokerHand) {
        return Arrays.asList(HandType.values()).
            stream().
            sorted(new HandTypeComparatorByPriority()).
            filter(handType -> handType.getHandRule().isPokerHandMatchingTheRule(pokerHand)).
            findFirst().
            map(handType -> new TopUserHand(handType, handType.getHandRule().getMaxCardValue(pokerHand))).
            get();
    }

    public List<Card> sortPokerHandCardsByValue(PokerHand pokerHand) {
        return pokerHand.getCards().
            stream().
            sorted(new CardComparatorByValue()).
            collect(Collectors.toList());
    }

    public Optional<Player> getPlayerWithHighestCard(Player player1, Player player2) {
        List<Card> sortedCardsForPlayer1 = player1.getPokerHand().getCardsSortedByValue();
        List<Card> sortedCardsForPlayer2 = player2.getPokerHand().getCardsSortedByValue();

        for (int i = 0; i < sortedCardsForPlayer1.size(); i++) {
            if (sortedCardsForPlayer1.get(0).getCardValue().getValue() >
                sortedCardsForPlayer2.get(0).getCardValue().getValue()) {
                return Optional.of(player1);
            }
        }

        return Optional.empty();
    }

}
