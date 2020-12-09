package model;

import model.drinks.Drink;

import java.util.List;

public interface DrinkOrderRepository {
    void save(Drink drink);

    List<Drink> findAll();
}
