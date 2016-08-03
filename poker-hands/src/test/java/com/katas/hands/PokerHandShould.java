package com.katas.hands;

import com.katas.cards.Card;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
public class PokerHandShould {

    @DataProvider
    public Object[][] GetCardWithHighestValueProvider() {
        return new Object[][]{
            {Arrays.asList("KD", "9C", "5S", "3D", "2H"), "KD"},
            {Arrays.asList("AS", "QS", "4S", "3H", "2S"), "AS"},
            };
    }

    @Test(dataProvider = "GetCardWithHighestValueProvider")
    public void get_card_with_highest_value(List<String> cardList, String expectedHighestCard) {
        PokerHand pokerHand = new PokerHand(cardList);

        Optional<Card> cardWithHighestValue = pokerHand.getCardWithHighestValue();

        assertThat(cardWithHighestValue.get().toSymbol(), is(expectedHighestCard));
    }

}
