package model.drinks;

import model.Money;

import java.math.BigDecimal;

public class Tea extends Drink {
    public Tea(int numberOfSugars) {
        super(numberOfSugars);
    }

    @Override
    public Money drinkPrice() {
        return new Money(BigDecimal.valueOf(40));
    }

    @Override
    public String convertToDrinkMaker() {
        return "T";
    }

    @Override
    public String toString() {
        return "Tea";
    }
}
