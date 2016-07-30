package com.katas.cards;

import java.util.HashMap;
import java.util.Map;

public enum CardValueType {
    TWO("2", "2", 2),
    THREE("3", "3", 3),
    FOUR("4", "4", 4),
    FIVE("5", "5", 5),
    SIX("6", "6", 6),
    SEVEN("7", "7", 7),
    EIGTH("8", "8", 8),
    NINE("9", "9", 9),
    TEN("10", "10", 10),
    JACK("J", "Jack", 11),
    QUEEN("Q", "Queen", 12),
    KING("K", "King", 13),
    ACE("A", "Ace", 14);

    private static final Map<String, CardValueType> lookup = new HashMap();
    static {
        for(CardValueType cardValue : CardValueType.values())
            lookup.put(cardValue.getSymbol(), cardValue);
    }

    private String symbol;
    private String description;
    private int value;

    CardValueType(String symbol, String description, int value) {
        this.symbol = symbol;
        this.description = description;
        this.value = value;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getDescription() {
        return this.description;
    }

    public int getValue() {
        return this.value;
    }

    public static CardValueType fromSymbol(String symbol) {
        return lookup.get(symbol);
    }
}
