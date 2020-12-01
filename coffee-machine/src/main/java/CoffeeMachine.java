public class CoffeeMachine {
    private final DrinkMaker drinkMaker;

    public CoffeeMachine(DrinkMaker drinkMaker) {

        this.drinkMaker = drinkMaker;
    }

    public void orderBeverage(Beverage beverage) {
        String drinkMakerCommand = "";
        this.drinkMaker.execute(drinkMakerCommand);
    }
}
