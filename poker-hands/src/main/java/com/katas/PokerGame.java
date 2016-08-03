package com.katas;

import com.katas.cards.Card;
import com.katas.hands.HandCalculator;
import com.katas.hands.HandType;
import com.katas.hands.TopUserHand;
import com.katas.infrastructure.OutputMessageFormatter;
import com.katas.infrastructure.OutputWriter;

import java.util.List;

public class PokerGame {

    private final HandCalculator handCalculator;
    private final Player whitePlayer;
    private final Player blackPlayer;
    private final OutputMessageFormatter outputMessageFormatter;
    private final OutputWriter outputWriter;

    public PokerGame(HandCalculator handCalculator, OutputMessageFormatter outputMessageFormatter, OutputWriter outputWriter, Player whitePlayer, Player blackPlayer) {

        this.handCalculator = handCalculator;
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.outputMessageFormatter = outputMessageFormatter;
        this.outputWriter = outputWriter;
    }

    public void showDown() {

        String resultMessage;

        TopUserHand topHandForWhitePlayer = this.handCalculator.calculateTopHand(whitePlayer.getPokerHand());
        TopUserHand topHandForBlackPlayer = this.handCalculator.calculateTopHand(blackPlayer.getPokerHand());

        if (topHandForWhitePlayer.getHandType().getPriority() == topHandForBlackPlayer.getHandType().getPriority()) {

            int whitePlayerMaxValue = topHandForWhitePlayer.getMaxCardValue().getValue();
            int blackPlayerMaxValue = topHandForBlackPlayer.getMaxCardValue().getValue();
            if (whitePlayerMaxValue > blackPlayerMaxValue) {
                System.out.println("HELLOOOO");
                resultMessage = this.outputMessageFormatter.createResultMessage(whitePlayer, topHandForWhitePlayer);
            } else if (whitePlayerMaxValue < blackPlayerMaxValue) {
                resultMessage = this.outputMessageFormatter.createResultMessage(blackPlayer, topHandForBlackPlayer);
            } else if (topHandForBlackPlayer.getHandType() == HandType.HIGH_CARD) {
                //TODO: calculate again the highest card
                List<Card> sortedWhitePlayerCards = this.handCalculator.sortPokerHandCardsByValue(whitePlayer.getPokerHand());
                List<Card> sortedBlackPlayerCards = this.handCalculator.sortPokerHandCardsByValue(blackPlayer.getPokerHand());

                resultMessage = this.outputMessageFormatter.createResultMessage(blackPlayer, topHandForBlackPlayer);
            } else {
                resultMessage = "Tie.";
            }
        } else if ((topHandForWhitePlayer.getHandType().getPriority() > topHandForBlackPlayer.getHandType().getPriority())) {
            resultMessage = this.outputMessageFormatter.createResultMessage(whitePlayer, topHandForWhitePlayer);
        } else {
            resultMessage = this.outputMessageFormatter.createResultMessage(blackPlayer, topHandForBlackPlayer);
        }

        this.outputWriter.write(resultMessage);
    }

    private void xx() {

    }
}
