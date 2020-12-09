import java.math.BigDecimal;

public class Tea extends Drink {
    public Tea(int numberOfSugars) {
        super(numberOfSugars);
    }

    @Override
    Money drinkPrice() {
        return new Money(BigDecimal.valueOf(40));
    }

    @Override
    String convertToDrinkMaker() {
        return "T";
    }
}
