package com.katas.hands.rules;


import com.katas.hands.PokerHand;
import com.katas.cards.Card;
import com.katas.cards.CardFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.testng.Assert.assertTrue;

@Test
public class HighCardRuleShould {

    @DataProvider
    public Object[][] HighCardRuleProvider() {
        return new Object[][]{
            {new PokerHand("2H", "3D", "5S", "9C", "KD"), "KD" },
            { new PokerHand("2H", "3D", "AS", "9C", "KD"), "AS" }
        };
    }

    private HighCardRule highCardRule;

    @BeforeMethod
    public void setUp() {
        int priority = 1;
        this.highCardRule = new HighCardRule(priority);
    }

    public void return_isPokerHandMatchingTheRule_is_always_true() {
        PokerHand pokerHand = new PokerHand("2H", "3D", "5S", "9C", "KD");

        boolean isPokerHandMatchingTheRule = this.highCardRule.isPokerHandMatchingTheRule(pokerHand);

        assertTrue(isPokerHandMatchingTheRule);
    }

    @Test(dataProvider = "HighCardRuleProvider")
    public void return_the_card_from_a_hand_which_is_matching_this_rule(PokerHand pokerHand, String expectedHighestCard) {

        List<Card> cardsMatchingThisRule = this.highCardRule.getCardsMatchingThisRule(pokerHand);

        assertThat(cardsMatchingThisRule, hasSize(1));
        assertThat(cardsMatchingThisRule, contains(CardFactory.createCard(expectedHighestCard)));
    }

}
