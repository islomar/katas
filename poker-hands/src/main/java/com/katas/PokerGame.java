package com.katas;

import com.katas.hands.HandCalculator;
import com.katas.hands.HandType;
import com.katas.hands.TopUserHand;

import java.util.Arrays;
import java.util.List;

public class PokerGame {

    private final HandCalculator handCalculator;
    private final Player whitePlayer;
    private final Player blackPlayer;
    private final OutputMessageFormatter outputMessageFormatter;

    public PokerGame(HandCalculator handCalculator, OutputMessageFormatter outputMessageFormatter, Player whitePlayer, Player blackPlayer) {

        this.handCalculator = handCalculator;
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.outputMessageFormatter = outputMessageFormatter;
    }

    public String showDown() {

        TopUserHand topHandForWhitePlayer = this.handCalculator.calculateTopHand(whitePlayer.getPokerHand());
        TopUserHand topHandForBlackPlayer = this.handCalculator.calculateTopHand(blackPlayer.getPokerHand());

        if (topHandForWhitePlayer.getHandType().getPriority() == topHandForBlackPlayer.getHandType().getPriority()) {

            int whitePlayerMaxValue = topHandForWhitePlayer.getMaxCardValue().getValue();
            int blackPlayerMaxValue = topHandForBlackPlayer.getMaxCardValue().getValue();
            if (whitePlayerMaxValue > blackPlayerMaxValue) {
                return this.outputMessageFormatter.createResultMessage(whitePlayer, topHandForWhitePlayer);
            } else if (whitePlayerMaxValue < blackPlayerMaxValue) {
                return this.outputMessageFormatter.createResultMessage(blackPlayer, topHandForBlackPlayer);
            }
            return "Tie.";
        } else if ((topHandForWhitePlayer.getHandType().getPriority() > topHandForBlackPlayer.getHandType().getPriority())) {
            return this.outputMessageFormatter.createResultMessage(whitePlayer, topHandForWhitePlayer);
        }
        return null;
    }
}
