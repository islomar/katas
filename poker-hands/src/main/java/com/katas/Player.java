package com.katas;


import com.katas.hands.PokerHand;

public class Player {

    private final String playerName;
    private final PokerHand pokerHand;


    public Player(final String playerName, PokerHand pokerHand) {

        this.playerName = playerName;
        this.pokerHand = pokerHand;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public PokerHand getPokerHand() {
        return this.pokerHand;
    }
}
