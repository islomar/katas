package com.katas.cards;

import com.katas.cards.Card;
import com.katas.cards.CardFactory;
import com.katas.cards.CardSuitType;
import com.katas.cards.CardValueType;
import com.katas.hands.HandType;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@Test
public class CardFactoryShould {

    @DataProvider
    public Object[][] CreateCardProvider() {
        return new Object[][]{
            {"2H", CardValueType.TWO, CardSuitType.HEARTS},
            {"AS", CardValueType.ACE, CardSuitType.SPADES},
            {"JD", CardValueType.JACK, CardSuitType.DIAMONDS},
            };
    }

    @Test(dataProvider = "CreateCardProvider")
    public void create_a_card_object_from_string(final String stringCard, CardValueType cardValueType, CardSuitType cardSuitType) {

        Object card = CardFactory.createCard(stringCard);

        assertThat(card, is(instanceOf(Card.class)));
        assertThat(((Card)card).getCardValue(), is(cardValueType));
        assertThat(((Card)card).getCardSuit(), is(cardSuitType));
    }
}
