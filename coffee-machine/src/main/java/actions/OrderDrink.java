package actions;

import infrastructure.DrinkMaker;
import model.Money;
import model.drinks.Drink;

public class OrderDrink {
    private final DrinkMaker drinkMaker;
    private static final String COMMAND_FORMAT = "%s:%s:%s";

    public OrderDrink(DrinkMaker drinkMaker) {

        this.drinkMaker = drinkMaker;
    }

    public void execute(Drink drink, Money payment) {
        if (payment.amountInEuroCents().intValue() < drink.drinkPrice().amountInEuroCents().intValue()) {
            int missingCents = drink.drinkPrice().amountInEuroCents().intValue() - payment.amountInEuroCents().intValue();
            this.drinkMaker.execute(String.format("There are %s cents missing", missingCents));
            return;
        }
        String drinkMakerCommand = convertBeverageToDrinkMakerCommand(drink);
        this.drinkMaker.execute(drinkMakerCommand);
    }

    private String convertBeverageToDrinkMakerCommand(Drink drink) {
        return COMMAND_FORMAT.formatted(
                drink.convertToDrinkMaker(),
                extractNumberOfSugarsAndStick(drink.numberOfSugars()),
                extractStick(drink.numberOfSugars())
        );
    }

    private String extractNumberOfSugarsAndStick(int numberOfSugars) {
        if (numberOfSugars > 0) {
            return String.valueOf(numberOfSugars);
        } else {
            return "";
        }
    }

    private String extractStick(int numberOfSugars) {
        if (numberOfSugars > 0) {
            return "0";
        } else {
            return "";
        }
    }
}
