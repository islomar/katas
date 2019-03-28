package com.kata;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
public class TicTacToeShould {

    private TicTacToe ticTacToe;

    @BeforeMethod
    public void setUp() {
        ticTacToe = new TicTacToe();
    }

    public void start_game_with_player_X() {
        ticTacToe.startGame();

        assertThat(ticTacToe.currentPlayer(), is(new Player("X")));
    }

    public void alternate_player_X_to_player_O() {
        ticTacToe.startGame();

        ticTacToe.nextTurn();

        assertThat(ticTacToe.currentPlayer(), is(new Player("O")));
    }

    public void alternate_player_O_to_player_X() {
        ticTacToe.startGame();

        ticTacToe.nextTurn();
        ticTacToe.nextTurn();

        assertThat(ticTacToe.currentPlayer(), is(new Player("X")));
    }

    public void put_token_on_empty_position() {
        ticTacToe.startGame();

        ticTacToe.move(new Position(1, 1));

        assertThat(ticTacToe.currentStatus(), is(new GameStatus()));
    }

    @Ignore
    //Pending to fix the assertion
    public void not_allow_putting_token_on_occupied_position() {
        ticTacToe.startGame();

        ticTacToe.move(new Position(1, 1));
        ticTacToe.nextTurn();
        ticTacToe.move(new Position(1, 1));

        assertThat(ticTacToe.currentStatus(), is(new GameStatus()));
    }
}