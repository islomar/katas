package model.drinks;

import model.Money;

import java.math.BigDecimal;

public class Coffee extends Drink {
    public Coffee(int numberOfSugars) {
        super(numberOfSugars);
    }

    @Override
    public Money drinkPrice() {
        return new Money(BigDecimal.valueOf(60));
    }

    @Override
    public String convertToDrinkMaker() {
        return "C";
    }

    @Override
    public String toString() {
        return "Coffee";
    }
}
