package model.drinks;

import model.Money;

import java.math.BigDecimal;

public class OrangeJuice extends Drink {
    public OrangeJuice(int numberOfSugars) {
        super(numberOfSugars);
    }

    @Override
    public Money drinkPrice() {
        return new Money(BigDecimal.valueOf(60));
    }

    @Override
    public String convertToDrinkMaker() {
        return "O";
    }
}
