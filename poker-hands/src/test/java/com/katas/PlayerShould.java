package com.katas;

import com.katas.cards.CardFactory;
import com.katas.hands.PokerHand;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.MockitoAnnotations.initMocks;

@Test
public class PlayerShould {

    public void be_initialized_with_a_name() {
        Player player = new Player("White", null);

        assertThat(player.getPlayerName(), is("White"));
    }

    public void be_initialized_with_a_poker_hand() {
        Player player = new Player("White", new PokerHand("2H", "3D", "5S", "9C", "KD"));

        assertThat(player.getPokerHand().getCards(), containsInAnyOrder(CardFactory.createCard("2H"),
                                                                        CardFactory.createCard("3D"),
                                                                        CardFactory.createCard("5S"),
                                                                        CardFactory.createCard("9C"),
                                                                        CardFactory.createCard("KD")
        ));
    }
}
