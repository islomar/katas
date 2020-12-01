import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class CoffeeMachineShould {

    @Mock
    DrinkMaker drinkMaker;

    @BeforeEach
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void order_a_hot_chocolate_without_sugar() {
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker);

        coffeeMachine.orderBeverage(new Beverage("Chocolate", 0));

        verify(this.drinkMaker).execute("H::");
    }

    @Test
    public void order_a_hot_chocolate_with_one_sugar_and_stick() {
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker);

        coffeeMachine.orderBeverage(new Beverage("Chocolate", 1));

        verify(this.drinkMaker).execute("H:1:0");
    }


    @Test
    public void order_a_tea_with_two_sugars_and_stick() {
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker);

        coffeeMachine.orderBeverage(new Beverage("tea", 2));

        verify(this.drinkMaker).execute("T:2:0");
    }

}
