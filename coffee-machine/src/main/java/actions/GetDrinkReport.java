package actions;

import infrastructure.InMemoryDrinkOrderRepository;
import model.Console;
import model.drinks.Drink;

import java.util.List;

public class GetDrinkReport {

    private final Console console;
    private final InMemoryDrinkOrderRepository inMemoryDrinkOrderRepository;

    public GetDrinkReport(Console console, InMemoryDrinkOrderRepository inMemoryDrinkOrderRepository) {
        this.console = console;
        this.inMemoryDrinkOrderRepository = inMemoryDrinkOrderRepository;
    }

    public void execute() {
        List<Drink> allOrderedDrinks = this.inMemoryDrinkOrderRepository.findAll();

        this.console.print("");
    }
}
