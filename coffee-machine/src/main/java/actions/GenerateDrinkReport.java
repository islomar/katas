package actions;

import infrastructure.InMemoryDrinkOrderRepository;
import model.Console;
import model.drinks.Drink;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenerateDrinkReport {

    private final Console console;
    private final InMemoryDrinkOrderRepository inMemoryDrinkOrderRepository;

    public GenerateDrinkReport(Console console, InMemoryDrinkOrderRepository inMemoryDrinkOrderRepository) {
        this.console = console;
        this.inMemoryDrinkOrderRepository = inMemoryDrinkOrderRepository;
    }

    public void execute() {
        List<Drink> allOrderedDrinks = this.inMemoryDrinkOrderRepository.findAll();

        Map<Drink, Long> drinksWithCounter = allOrderedDrinks.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        drinksWithCounter.forEach((drink, numberOfDrinks) -> this.console.print(String.format("# of %s sold: %s", drink.convertToDrinkMaker(), numberOfDrinks)));

        BigDecimal totalAmountOfMoneyEarned = allOrderedDrinks.stream()
                .map(drink -> drink.drinkPrice().amountInEuroCents())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        this.console.print(String.format("Total amount of money earned: %s cents", totalAmountOfMoneyEarned));
    }
}
