package com.katas.cards;

import java.util.HashMap;
import java.util.Map;

public enum CardSuitType {
    CLUBS("C"),
    DIAMONDS("D"),
    HEARTS("H"),
    SPADES("S");

    private static final Map<String, CardSuitType> lookup = new HashMap();
    static {
        for(CardSuitType suitType : CardSuitType.values())
            lookup.put(suitType.getSymbol(), suitType);
    }

    private String symbol;

    CardSuitType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public static CardSuitType fromSymbol(String symbol) {
        return lookup.get(symbol);
    }
}
