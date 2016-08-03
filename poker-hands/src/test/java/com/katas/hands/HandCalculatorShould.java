package com.katas.hands;


import com.katas.cards.Card;
import com.katas.cards.CardFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.testng.Assert.assertEquals;

public class HandCalculatorShould {

    private HandCalculator handCalculator;

    @BeforeMethod
    public void setUp() {
        this.handCalculator = new HandCalculator();
    }

    @DataProvider
    public Object[][] CalculateTopHandProvider() {
        return new Object[][]{
            {"2H", "3D", "5S", "9C", "KD", HandType.HIGH_CARD},
            {"2S", "3H", "AS", "QS", "3S", HandType.PAIR},
            };
    }

    @DataProvider
    public Object[][] SortCardsByValueProvider() {
        return new Object[][]{
            {"5S", "KD", "2H", "9C", "3D", Arrays.asList("KD", "9C", "5S", "3D", "2H")},
            {"2S", "3H", "AS", "QS", "4S", Arrays.asList("AS", "QS", "4S", "3H", "2S")},
            };
    }

    @Test(dataProvider = "CalculateTopHandProvider")
    public void calculate_hand(final String card1, final String card2, final String card3, final String card4, final String card5,
                               HandType expectedHandType) {
        PokerHand pokerHand = new PokerHand(CardFactory.createCard(card1),
                                            CardFactory.createCard(card2),
                                            CardFactory.createCard(card3),
                                            CardFactory.createCard(card4),
                                            CardFactory.createCard(card5));

        TopUserHand topUserHand = handCalculator.calculateTopHand(pokerHand);

        assertThat(topUserHand.getHandType(), is(expectedHandType));
    }

    @Test(dataProvider = "SortCardsByValueProvider")
    public void sort_cards_by_value(final String card1, final String card2, final String card3, final String card4, final String card5,
                                    List<String> expectedSortedListOfCardsByValue) {
        PokerHand pokerHand = new PokerHand(CardFactory.createCard(card1),
                                            CardFactory.createCard(card2),
                                            CardFactory.createCard(card3),
                                            CardFactory.createCard(card4),
                                            CardFactory.createCard(card5));

        List<Card> sortedCards = handCalculator.sortPokerHandCardsByValue(pokerHand);

        List<Card> expectedSortedListOfCardsByValue2 = expectedSortedListOfCardsByValue.stream().
            map(s -> CardFactory.createCard(s)).
            collect(Collectors.toList());
        assertThat(sortedCards, is(expectedSortedListOfCardsByValue2));
    }

}
