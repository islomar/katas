package com.katas.hands;

import java.util.Comparator;

public class HandTypeComparatorByPriority implements Comparator<HandType> {

    @Override
    public int compare(HandType handType1, HandType handType2) {
        return (handType2.getPriority() > handType1.getPriority()) ? 1 : -1;
    }

}
