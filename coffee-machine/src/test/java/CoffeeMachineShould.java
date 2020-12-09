import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CoffeeMachineShould {

    @Spy
    DrinkMaker drinkMaker;

    @BeforeEach
    public void setUp() {
        drinkMaker = mock(DrinkMaker.class);
    }

    @Test
    public void order_a_hot_chocolate_without_sugar() {
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker);

        coffeeMachine.orderBeverage(new Beverage("Chocolate", 0), new Money(new BigDecimal(50)));

        verify(this.drinkMaker).execute("H::");
    }

    @Test
    public void order_a_hot_chocolate_with_one_sugar_and_stick() {
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker);

        coffeeMachine.orderBeverage(new Beverage("Chocolate", 1), new Money(new BigDecimal(50)));

        verify(this.drinkMaker).execute("H:1:0");
    }


    @Test
    public void order_a_tea_with_two_sugars_and_stick() {
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker);

        coffeeMachine.orderBeverage(new Beverage("tea", 2), new Money(new BigDecimal(50)));

        verify(this.drinkMaker).execute("T:2:0");
    }


    @Test
    public void order_a_coffee_with_two_sugars_and_stick() {
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker);

        coffeeMachine.orderBeverage(new Beverage("coffee", 2), new Money(new BigDecimal(50)));

        verify(this.drinkMaker).execute("C:2:0");
    }

    // One tea is 0,4 euro, a coffee is 0,6 euro, a chocolate is 0,5 euro

    @Test
    public void make_the_drink_only_if_the_correct_amount_of_money_is_given() {
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker);

        coffeeMachine.orderBeverage(new Beverage("Chocolate", 1), new Money(new BigDecimal(50)));

        verify(this.drinkMaker).execute("H:1:0");
    }

    @Test
    public void show_message_with_the_amount_of_money_missing() {
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker);

        coffeeMachine.orderBeverage(new Beverage("Chocolate", 1), new Money(new BigDecimal(32)));

        verify(this.drinkMaker).execute("There are 18 cents missing");
    }

}
