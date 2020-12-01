public class CoffeeMachine {
    private final DrinkMaker drinkMaker;
    private static final String COMMAND_FORMAT = "%s:%s:%s";

    public CoffeeMachine(DrinkMaker drinkMaker) {

        this.drinkMaker = drinkMaker;
    }

    public void orderBeverage(Beverage beverage) {
        String drinkMakerCommand = convertBeverageToDrinkMakerCommand(beverage);
        this.drinkMaker.execute(drinkMakerCommand);
    }

    private String convertBeverageToDrinkMakerCommand(Beverage beverage) {
        return COMMAND_FORMAT.formatted(
                extractDrinkType(beverage.beverageType()),
                extractNumberOfSugarsAndStick(beverage.numberOfSugars()),
                extractStick(beverage.numberOfSugars())
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
