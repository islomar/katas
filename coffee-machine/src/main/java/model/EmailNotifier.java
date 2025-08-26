package model;

import model.drinks.Drink;

public interface EmailNotifier {
    void notifyMissingDrink(Drink drink);
}
