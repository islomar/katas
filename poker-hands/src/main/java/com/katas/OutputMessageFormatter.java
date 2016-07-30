package com.katas;

import com.katas.hands.TopUserHand;

public class OutputMessageFormatter {

    public String createResultMessage(Player player, TopUserHand topUserHand) {
        return player.getPlayerName() + " wins. - with high card: " + topUserHand.getMaxCardValue().getDescription();
    }

}
