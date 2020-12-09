package model.drinks;

import model.Money;

public class ExtraHot extends Drink {
    private final Drink drink;

    public ExtraHot(Drink drink) {
        super(drink.numberOfSugars());
        this.drink = drink;
    }

    @Override
    public Money drinkPrice() {
        return this.drink.drinkPrice();
    }

    @Override
    public String convertToDrinkMaker() {
        return this.drink.convertToDrinkMaker() + "h";
    }
}
