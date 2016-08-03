package com.katas;

import com.katas.hands.HandCalculator;
import com.katas.hands.PokerHand;
import com.katas.infrastructure.Console;
import com.katas.infrastructure.OutputMessageFormatter;
import com.katas.infrastructure.OutputWriter;

import org.mockito.Mockito;
import org.mockito.Spy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.MockitoAnnotations.initMocks;

@Test
public class PokerGamesFeature {

    private OutputWriter outputWriterSpy;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
        OutputWriter outputWriter = new Console();
        this.outputWriterSpy = Mockito.spy(outputWriter);
    }

    public void calculate_who_wins_when_both_players_have_high_card_ace() {
        Player whitePlayer = new Player("White", new PokerHand("2C", "3H", "4S", "8C", "AH"));
        Player blackPlayer = new Player("Black", new PokerHand("2H", "3D", "5S", "9C", "KD"));
        PokerGame pokerGame = new PokerGame(new HandCalculator(), new OutputMessageFormatter(), this.outputWriterSpy, whitePlayer, blackPlayer);

        pokerGame.showDown();

        Mockito.verify(this.outputWriterSpy).write("White wins. - with high card: Ace");
    }

    public void calculate_who_wins_when_white_player_has_flush() {
        Player whitePlayer = new Player("White", new PokerHand("2S", "8S", "AS", "QS",  "3S"));
        Player blackPlayer = new Player("Black", new PokerHand("2H", "3D", "5S", "9C", "KD"));
        PokerGame pokerGame = new PokerGame(new HandCalculator(), new OutputMessageFormatter(), this.outputWriterSpy, whitePlayer, blackPlayer);

        pokerGame.showDown();

        Mockito.verify(this.outputWriterSpy).write("White wins. - with flush");
    }

    public void when_both_players_have_same_high_card_then_the_second_highest_card_wins() {
        Player whitePlayer = new Player("White", new PokerHand("2C", "3H", "4S", "8C", "AH"));
        Player blackPlayer = new Player("Black", new PokerHand("2H", "3D", "5S", "9C", "AD"));
        PokerGame pokerGame = new PokerGame(new HandCalculator(), new OutputMessageFormatter(), this.outputWriterSpy, whitePlayer, blackPlayer);

        pokerGame.showDown();

        Mockito.verify(this.outputWriterSpy).write("Black wins. - with high card: 9");
    }

    public void calculate_who_wins_when_there_is_tie() {
        Player whitePlayer = new Player("White", new PokerHand("2D", "3H", "5C", "9S", "KH"));
        Player blackPlayer = new Player("Black", new PokerHand("2H", "3D", "5S", "9C", "KD"));
        PokerGame pokerGame = new PokerGame(new HandCalculator(), new OutputMessageFormatter(), this.outputWriterSpy, whitePlayer, blackPlayer);

        pokerGame.showDown();

        Mockito.verify(this.outputWriterSpy).write("Tie.");
    }

}
