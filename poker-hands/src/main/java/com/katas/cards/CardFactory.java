package com.katas.cards;

public class CardFactory {

    public static Card createCard(CardValueType cardValueType, CardSuitType cardSuitType) {
        return new Card(cardValueType, cardSuitType);
    }

    public static Card createCard(String cardInStringFormat) {
        String cardValueString = cardInStringFormat.substring(0, 1);
        String cardSuitString = cardInStringFormat.substring(1, 2);

        CardValueType cardValue = CardValueType.fromSymbol(cardValueString);
        CardSuitType cardSuit = CardSuitType.fromSymbol(cardSuitString);
        return createCard(cardValue, cardSuit);
    }

}
