package infrastructure;

import model.DrinkOrderRepository;
import model.drinks.Drink;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDrinkOrderRepository implements DrinkOrderRepository {
    private List<Drink> drinks = new ArrayList<>();

    @Override
    public void save(Drink drink) {
        this.drinks.add(drink);
    }

    @Override
    public List<Drink> findAll() {
        return this.drinks;
    }
}
