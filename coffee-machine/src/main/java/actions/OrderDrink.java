package actions;

import infrastructure.DrinkMaker;
import model.DrinkOrderRepository;
import model.Money;
import model.drinks.Drink;

import java.math.BigDecimal;

public class OrderDrink {
    private final DrinkMaker drinkMaker;
    private final DrinkOrderRepository drinkOrderRepository;
    private static final String COMMAND_FORMAT = "%s:%s:%s";

    public OrderDrink(DrinkMaker drinkMaker, DrinkOrderRepository drinkOrderRepository) {

        this.drinkMaker = drinkMaker;
        this.drinkOrderRepository = drinkOrderRepository;
    }

    public void execute(Drink drink, Money payment) {
        if (payment.isLessThan(drink.drinkPrice())) {
            BigDecimal missingCents = drink.drinkPrice().differenceInCentsWith(payment);
            this.drinkMaker.execute(String.format("There are %s cents missing", missingCents));
            return;
        }
        String drinkMakerCommand = convertBeverageToDrinkMakerCommand(drink);
        this.drinkMaker.execute(drinkMakerCommand);
        this.drinkOrderRepository.save(drink);
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
