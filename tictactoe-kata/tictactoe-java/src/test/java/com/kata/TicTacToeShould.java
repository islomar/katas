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

    public void alternate_player_X_to_player_O() {
        final TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.startGame();

        ticTacToe.nextTurn();

        assertThat(ticTacToe.currentPlayer(), is(new Player("O")));
    }

    public void alternate_player_O_to_player_X() {
        final TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.startGame();

        ticTacToe.nextTurn();
        ticTacToe.nextTurn();

        assertThat(ticTacToe.currentPlayer(), is(new Player("X")));
    }
}