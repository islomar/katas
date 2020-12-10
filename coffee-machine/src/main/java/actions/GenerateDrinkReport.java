package actions;

import infrastructure.InMemoryDrinkOrderRepository;
import model.Console;
import model.drinks.Drink;

import java.math.BigDecimal;
import java.util.List;

public class GenerateDrinkReport {

    private final Console console;
    private final InMemoryDrinkOrderRepository inMemoryDrinkOrderRepository;

    public GenerateDrinkReport(Console console, InMemoryDrinkOrderRepository inMemoryDrinkOrderRepository) {
        this.console = console;
        this.inMemoryDrinkOrderRepository = inMemoryDrinkOrderRepository;
    }

    //TODO: I want to be able to print a report anytime that contains:
    // how many of each drink was sold and the total amount of money earned so far.
    public void execute() {
        List<Drink> allOrderedDrinks = this.inMemoryDrinkOrderRepository.findAll();
        BigDecimal totalAmountOfMoneyEarned = allOrderedDrinks.stream()
                .map(drink -> drink.drinkPrice().amountInEuroCents())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        this.console.print(String.format("Total amount of money earned: %s cents", totalAmountOfMoneyEarned));
    }
}
