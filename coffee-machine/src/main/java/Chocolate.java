import java.math.BigDecimal;

public class Chocolate extends Drink {
    public Chocolate(int numberOfSugars) {
        super(numberOfSugars);
    }

    @Override
    Money drinkPrice() {
        return new Money(BigDecimal.valueOf(50));
    }

    @Override
    String convertToDrinkMaker() {
        return "H";
    }
}
