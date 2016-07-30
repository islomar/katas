package com.katas;

import com.katas.hands.HandCalculator;
import com.katas.hands.PokerHand;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
public class PokerGamesFeature {

    public void calculate_who_wins() {
        PokerHand whitePlayerPokerHand = new PokerHand("2C", "3H", "4S", "8C", "AH");
        PokerHand blackPlayerPokerHand = new PokerHand("2H", "3D", "5S", "9C", "KD");
        Player whitePlayer = new Player("White", whitePlayerPokerHand);
        Player blackPlayer = new Player("Black", blackPlayerPokerHand);
        PokerGame pokerGame = new PokerGame(new HandCalculator(), whitePlayer, blackPlayer);

        String result = pokerGame.showDown();

        assertThat(result, is("White wins. - with high card: Ace"));
    }

}
