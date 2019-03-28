package com.kata;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
public class TicTacToeShould {

    public void start_game_with_player_X() {

        final TicTacToe ticTacToe = new TicTacToe();

        ticTacToe.startGame();

        assertThat(ticTacToe.currentPlayer(), is(new Player("X")));
    }
}