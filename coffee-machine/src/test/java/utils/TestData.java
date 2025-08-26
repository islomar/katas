package utils;

import model.Money;
import model.drinks.Coffee;

import java.math.BigDecimal;

public class TestData {
    public static final Money ONE_EURO = new Money(new BigDecimal(100));

    public static Coffee aCoffee() {
        return new Coffee(0);
    }
}
