package com.katas;

import com.katas.hands.HandCalculator;
import com.katas.hands.PokerHand;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
public class PokerGamesFeature {

    public void calculate_who_wins_when_both_players_have_high_card_value() {
        PokerHand whitePlayerPokerHand = new PokerHand("2C", "3H", "4S", "8C", "AH");
        PokerHand blackPlayerPokerHand = new PokerHand("2H", "3D", "5S", "9C", "KD");
        Player whitePlayer = new Player("White", whitePlayerPokerHand);
        Player blackPlayer = new Player("Black", blackPlayerPokerHand);
        PokerGame pokerGame = new PokerGame(new HandCalculator(), new OutputMessageFormatter(), whitePlayer, blackPlayer);

        String result = pokerGame.showDown();

        assertThat(result, is("White wins. - with high card: Ace"));
    }

    public void calculate_who_wins_when_there_is_tie() {
        PokerHand whitePlayerPokerHand = new PokerHand("2D", "3H", "5C", "9S", "KH");
        PokerHand blackPlayerPokerHand = new PokerHand("2H", "3D", "5S", "9C", "KD");
        Player whitePlayer = new Player("White", whitePlayerPokerHand);
        Player blackPlayer = new Player("Black", blackPlayerPokerHand);
        PokerGame pokerGame = new PokerGame(new HandCalculator(), new OutputMessageFormatter(), whitePlayer, blackPlayer);

        String result = pokerGame.showDown();

        assertThat(result, is("Tie."));
    }

    public void calculate_who_wins_when_white_player_has_flush() {
        PokerHand whitePlayerPokerHand = new PokerHand("2S", "8S", "AS", "QS",  "3S");
        PokerHand blackPlayerPokerHand = new PokerHand("2H", "3D", "5S", "9C", "KD");
        Player whitePlayer = new Player("White", whitePlayerPokerHand);
        Player blackPlayer = new Player("Black", blackPlayerPokerHand);
        PokerGame pokerGame = new PokerGame(new HandCalculator(), new OutputMessageFormatter(), whitePlayer, blackPlayer);

        String result = pokerGame.showDown();

        assertThat(result, is("White wins. - with flush"));
    }

}
