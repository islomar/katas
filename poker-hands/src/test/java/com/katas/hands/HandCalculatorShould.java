package com.katas.hands;


import com.katas.cards.CardFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HandCalculatorShould {

    private HandCalculator handCalculator;

    @BeforeMethod
    public void setUp() {
        this.handCalculator = new HandCalculator();
    }

    @DataProvider
    public Object[][] CalculateHandProvider() {
        return new Object[][]{
            {"2H", "3D", "5S", "9C", "KD", HandType.HIGH_CARD },
            {"2S", "3H", "AS", "QS", "3S", HandType.PAIR },
            };
    }

    @Test(dataProvider = "CalculateHandProvider")
    public void calculate_hand(final String card1, final String card2, final String card3, final String card4, final String card5, HandType expectedHandType) {
        PokerHand pokerHand = new PokerHand(CardFactory.createCard(card1),
                                            CardFactory.createCard(card2),
                                            CardFactory.createCard(card3),
                                            CardFactory.createCard(card4),
                                            CardFactory.createCard(card5));

        HandType handType = handCalculator.calculateHand(pokerHand);

        assertThat(handType, is(expectedHandType));
    }

}
