package actions;

import infrastructure.InMemoryDrinkOrderRepository;
import model.Console;
import model.DrinkMaker;
import model.Money;
import model.drinks.Chocolate;
import model.drinks.Coffee;
import model.drinks.OrangeJuice;
import model.drinks.Tea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetDrinkReportTest {
    private static final Money ONE_EURO = new Money(new BigDecimal(100));
    @Spy
    private Console console;
    @Spy
    private DrinkMaker drinkMaker;

    @BeforeEach
    public void setUp() {
        console = mock(Console.class);
        drinkMaker = mock(DrinkMaker.class);
    }

    @Test
    public void given_no_drinks_are_made_then_0_cents_are_printed() {
        GenerateDrinkReport generateDrinkReport = new GenerateDrinkReport(console, new InMemoryDrinkOrderRepository());

        generateDrinkReport.execute();

        verify(this.console).print("Total amount of money earned: 0 cents");
    }

    @Test
    public void a_report_is_printed_when_orders_were_made() {
        InMemoryDrinkOrderRepository drinkOrderRepository = new InMemoryDrinkOrderRepository();
        GenerateDrinkReport generateDrinkReport = new GenerateDrinkReport(console, drinkOrderRepository);
        OrderDrink orderDrink = new OrderDrink(drinkMaker, drinkOrderRepository);
        orderDrink.execute(new Chocolate(0), ONE_EURO);
        orderDrink.execute(new Tea(0), ONE_EURO);
        orderDrink.execute(new Coffee(0), ONE_EURO);
        orderDrink.execute(new OrangeJuice(0), ONE_EURO);

        generateDrinkReport.execute();

        verify(this.console).print("# of H sold: 1");
        verify(this.console).print("# of T sold: 1");
        verify(this.console).print("# of C sold: 1");
        verify(this.console).print("# of O sold: 1");
        verify(this.console).print("Total amount of money earned: 210 cents");
    }
}