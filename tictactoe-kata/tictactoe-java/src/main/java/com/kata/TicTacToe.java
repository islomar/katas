package com.kata;

public class TicTacToe {

  private Player currentPlayer;
  private GameStatus gameStatus;

  public void startGame() {
    currentPlayer = new Player("X");
  }

  public Player currentPlayer() {
    return currentPlayer;
  }

  public void nextTurn() {
    if (currentPlayer.equals(new Player("X"))){
      currentPlayer = new Player("O");
      return;
    }
    currentPlayer = new Player("X");
  }

  public void move(Position position) {
    gameStatus = new GameStatus();
  }

  public GameStatus currentStatus() {
    return new GameStatus();
  }
}
