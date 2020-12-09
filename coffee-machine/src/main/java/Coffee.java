import java.math.BigDecimal;

public class Coffee extends Drink {
    public Coffee(int numberOfSugars) {
        super(numberOfSugars);
    }

    @Override
    Money drinkPrice() {
        return new Money(BigDecimal.valueOf(60));
    }

    @Override
    String convertToDrinkMaker() {
        return "C";
    }
}
