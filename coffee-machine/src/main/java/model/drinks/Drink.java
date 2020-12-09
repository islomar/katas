package model.drinks;

import model.Money;

public abstract class Drink {
    private final int numberOfSugars;

    public Drink(int numberOfSugars) {
        this.numberOfSugars = numberOfSugars;
    }

    public int numberOfSugars() {
        return numberOfSugars;
    }

    public abstract Money drinkPrice();

    public abstract String convertToDrinkMaker();
}
