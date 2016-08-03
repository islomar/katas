package com.katas.cards;

import com.katas.cards.Card;
import com.katas.cards.CardSuitType;
import com.katas.cards.CardValueType;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

@Test
public class CardShould {

    @DataProvider
    public Object[][] CardProvider() {
        return new Object[][]{
            {CardValueType.TWO, CardSuitType.HEARTS},
            {CardValueType.ACE, CardSuitType.SPADES}
        };
    }

    @Test(dataProvider = "CardProvider")
    public void be_able_to_return_its_value(final CardValueType cardValue, final CardSuitType cardSuit) {
        Card card = new Card(cardValue, cardSuit);

        CardValueType recoveredCardValue = card.getCardValue();

        assertThat(recoveredCardValue, is(cardValue));
    }

    @Test(dataProvider = "CardProvider")
    public void be_able_to_return_its_suit(final CardValueType cardValue, final CardSuitType cardSuit) {
        Card card = new Card(cardValue, cardSuit);

        CardSuitType recoveredCardSuit = card.getCardSuit();

        assertThat(recoveredCardSuit, is(cardSuit));
    }

    public void be_equal_to_another_one_when_both_value_and_suit_match() {
        Card card1 = new Card(CardValueType.THREE, CardSuitType.CLUBS);
        Card card2 = new Card(CardValueType.THREE, CardSuitType.CLUBS);

        assertThat(card1, is(card2));
    }

    public void be_different_to_another_if_their_values_are_different() {
        Card card1 = new Card(CardValueType.THREE, CardSuitType.CLUBS);
        Card card2 = new Card(CardValueType.THREE, CardSuitType.DIAMONDS);

        assertThat(card1, is(not(card2)));
    }

    public void be_different_to_another_if_their_suits_are_different() {
        Card card1 = new Card(CardValueType.THREE, CardSuitType.CLUBS);
        Card card2 = new Card(CardValueType.FOUR, CardSuitType.CLUBS);

        assertThat(card1, is(not(card2)));
    }

    public void return_a_simplified_symbol_for_itself() {
        Card card = new Card(CardValueType.THREE, CardSuitType.CLUBS);

        String cardSymbol = card.toSymbol();

        assertThat(cardSymbol, is("3C"));
    }

}
