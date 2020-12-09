public abstract class Drink {
    private final int numberOfSugars;

    public Drink(int numberOfSugars) {
        this.numberOfSugars = numberOfSugars;
    }

    public int numberOfSugars() {
        return numberOfSugars;
    }

    abstract Money drinkPrice();

    abstract String convertToDrinkMaker();
}
