package model.drinks;

import model.Money;

import java.math.BigDecimal;

public class Chocolate extends Drink {
    public Chocolate(int numberOfSugars) {
        super(numberOfSugars);
    }

    @Override
    public Money drinkPrice() {
        return new Money(BigDecimal.valueOf(50));
    }

    @Override
    public String convertToDrinkMaker() {
        return "H";
    }

    @Override
    public String toString() {
        return "Chocolate";
    }
}
