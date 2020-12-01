public class CoffeeMachine {
    private final DrinkMaker drinkMaker;

    public CoffeeMachine(DrinkMaker drinkMaker) {

        this.drinkMaker = drinkMaker;
    }

    public void orderBeverage(Beverage beverage) {
        String drinkMakerCommand = "";
        if ("chocolate".equalsIgnoreCase(beverage.beverageType())) {
            drinkMakerCommand += "H:";
        }
        if (beverage.numberOfSugars() > 0) {
            drinkMakerCommand += beverage.numberOfSugars() + ":0";
        } else {
            drinkMakerCommand += ":";
        }
        this.drinkMaker.execute(drinkMakerCommand);
    }
}
