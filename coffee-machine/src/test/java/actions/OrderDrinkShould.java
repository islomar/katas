package actions;

import infrastructure.InMemoryDrinkOrderRepository;
import model.DrinkMaker;
import model.Money;
import model.drinks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OrderDrinkShould {

    private static final Money ONE_EURO = new Money(new BigDecimal(100));
    private InMemoryDrinkOrderRepository drinkOrderRepository;

    @Spy
    DrinkMaker drinkMaker;

    @BeforeEach
    public void setUp() {
        drinkMaker = mock(DrinkMaker.class);
        drinkOrderRepository = new InMemoryDrinkOrderRepository();
    }

    @Test
    public void order_a_hot_chocolate_without_sugar() {
        OrderDrink coffeeMachine = new OrderDrink(drinkMaker, drinkOrderRepository);

        coffeeMachine.execute(new Chocolate(0), ONE_EURO);

        verify(this.drinkMaker).execute("H::");
    }

    @Test
    public void order_a_hot_chocolate_with_one_sugar_and_stick() {
        OrderDrink coffeeMachine = new OrderDrink(drinkMaker, drinkOrderRepository);

        coffeeMachine.execute(new Chocolate(1), ONE_EURO);

        verify(this.drinkMaker).execute("H:1:0");
    }


    @Test
    public void order_a_tea_with_two_sugars_and_stick() {
        OrderDrink coffeeMachine = new OrderDrink(drinkMaker, drinkOrderRepository);

        coffeeMachine.execute(new Tea(2), ONE_EURO);

        verify(this.drinkMaker).execute("T:2:0");
    }

    @Test
    public void order_an_orange_juice_for_60_cents_with_two_sugars_and_stick() {
        OrderDrink coffeeMachine = new OrderDrink(drinkMaker, drinkOrderRepository);

        coffeeMachine.execute(new OrangeJuice(2), new Money(new BigDecimal(60)));

        verify(this.drinkMaker).execute("O:2:0");
    }


    @Test
    public void order_a_coffee_with_two_sugars_and_stick() {
        OrderDrink coffeeMachine = new OrderDrink(drinkMaker, drinkOrderRepository);

        coffeeMachine.execute(new Coffee(2), ONE_EURO);

        verify(this.drinkMaker).execute("C:2:0");
    }

    @Test
    public void make_a_coffee_if_60_cents_are_introduced() {
        OrderDrink coffeeMachine = new OrderDrink(drinkMaker, drinkOrderRepository);

        coffeeMachine.execute(new Coffee(1), new Money(new BigDecimal(60)));

        verify(this.drinkMaker).execute("C:1:0");
    }

    @Test
    public void make_a_tea_if_40_cents_are_introduced() {
        OrderDrink coffeeMachine = new OrderDrink(drinkMaker, drinkOrderRepository);

        coffeeMachine.execute(new Tea(1), new Money(new BigDecimal(40)));

        verify(this.drinkMaker).execute("T:1:0");
    }

    @Test
    public void make_a_chocolate_if_50_cents_are_introduced() {
        OrderDrink coffeeMachine = new OrderDrink(drinkMaker, drinkOrderRepository);

        coffeeMachine.execute(new Chocolate(1), new Money(new BigDecimal(50)));

        verify(this.drinkMaker).execute("H:1:0");
    }

    @Test
    public void show_message_with_the_amount_of_money_missing() {
        OrderDrink coffeeMachine = new OrderDrink(drinkMaker, drinkOrderRepository);

        coffeeMachine.execute(new Chocolate(1), new Money(new BigDecimal(32)));

        verify(this.drinkMaker).execute("There are 18 cents missing");
    }

    @Test
    public void order_extra_hot_tea() {
        OrderDrink coffeeMachine = new OrderDrink(drinkMaker, drinkOrderRepository);

        coffeeMachine.execute(new ExtraHot(new Tea(1)), ONE_EURO);

        verify(this.drinkMaker).execute("Th:1:0");
    }

    @Test
    public void order_extra_hot_chocolate() {
        OrderDrink coffeeMachine = new OrderDrink(drinkMaker, drinkOrderRepository);

        coffeeMachine.execute(new ExtraHot(new Chocolate(1)), ONE_EURO);

        verify(this.drinkMaker).execute("Hh:1:0");
    }

    @Test
    public void order_extra_hot_coffee() {
        OrderDrink coffeeMachine = new OrderDrink(drinkMaker, drinkOrderRepository);

        coffeeMachine.execute(new ExtraHot(new Coffee(1)), ONE_EURO);

        verify(this.drinkMaker).execute("Ch:1:0");
    }

}
