public class CoffeeMachine {
    private final DrinkMaker drinkMaker;
    private static final String COMMAND_FORMAT = "%s:%s:%s";

    public CoffeeMachine(DrinkMaker drinkMaker) {

        this.drinkMaker = drinkMaker;
    }

    public void orderBeverage(Drink drink, Money payment) {
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

    private String extractDrinkType(String beverageType) {
        if ("chocolate".equalsIgnoreCase(beverageType)) {
            return "H";
        } else if ("tea".equalsIgnoreCase(beverageType)) {
            return "T";
        } else {
            return "C";
        }
    }
}
