package utils;

import model.drinks.Chocolate;

public class ChocolateBuilder {

    private int numberOfSugars;

    public static ChocolateBuilder aChocolate() {
        return new ChocolateBuilder();
    }

    public ChocolateBuilder withSugar(int numberOfSugars) {
        this.numberOfSugars = numberOfSugars;
        return this;
    }

    public Chocolate build() {
        return new Chocolate(numberOfSugars);
    }
}
