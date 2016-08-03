package com.katas.infrastructure;

import com.katas.Player;
import com.katas.hands.TopUserHand;

public class OutputMessageFormatter {

    public String createResultMessage(Player player, TopUserHand topUserHand) {
        String description;

        switch (topUserHand.getHandType()) {
            case HIGH_CARD:
                description = "high card: " + topUserHand.getMaxCardValue().getDescription();
                break;
            case FLUSH:
                description = "flush";
                break;
            default:
                description = "MEEEEC";
                break;
        }
        return player.getPlayerName() + " wins. - with " + description;
    }

}
