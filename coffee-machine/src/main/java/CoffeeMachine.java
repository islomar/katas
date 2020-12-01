public class CoffeeMachine {
    private final DrinkMaker drinkMaker;
    private final String COMMAND_FORMAT = "%s:%s:%s";

    public CoffeeMachine(DrinkMaker drinkMaker) {

        this.drinkMaker = drinkMaker;
    }

    public void orderBeverage(Beverage beverage) {
        String drinkMakerCommand = "";
        String drinkType = extractDrinkType(beverage.beverageType());
        drinkMakerCommand += drinkType;
        if (beverage.numberOfSugars() > 0) {
            drinkMakerCommand += beverage.numberOfSugars() + ":0";
        } else {
            drinkMakerCommand += ":";
        }
        this.drinkMaker.execute(drinkMakerCommand);
    }

    private String extractDrinkType(String beverageType) {
        if ("chocolate".equalsIgnoreCase(beverageType)) {
            return "H:";
        }
        return "";
    }
}
