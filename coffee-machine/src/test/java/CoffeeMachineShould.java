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

}
