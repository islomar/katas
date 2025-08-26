package actions;

import infrastructure.InMemoryDrinkOrderRepository;
import model.BeverageQuantityChecker;
import model.Console;
import model.DrinkMaker;
import model.EmailNotifier;
import model.drinks.OrangeJuice;
import model.drinks.Tea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static utils.ChocolateBuilder.aChocolate;
import static utils.TestData.ONE_EURO;
import static utils.TestData.aCoffee;

class GenerateDrinkReportTest {
    @Mock private EmailNotifier emailNotifier;
    @Mock private BeverageQuantityChecker beverageQuantityChecker;
    @Mock private Console console;
    @Mock private DrinkMaker drinkMaker;
    private InMemoryDrinkOrderRepository drinkOrderRepository;

    @BeforeEach
    public void setUp() {
        console = mock(Console.class);
        drinkMaker = mock(DrinkMaker.class);
        emailNotifier = mock(EmailNotifier.class);
        beverageQuantityChecker = mock(BeverageQuantityChecker.class);
        drinkOrderRepository = new InMemoryDrinkOrderRepository();
    }

    @Test
    public void given_no_drinks_are_made_then_0_cents_are_printed() {
        GenerateDrinkReport generateDrinkReport = new GenerateDrinkReport(console, drinkOrderRepository);

        generateDrinkReport.execute();

        verify(this.console, times(1)).print(anyString());
        verify(this.console).print("Total amount of money earned: 0 cents");
    }

    @Test
    public void a_report_is_printed_including_number_of_drinks_and_total_amount_of_money_earned() {
        GenerateDrinkReport generateDrinkReport = new GenerateDrinkReport(console, drinkOrderRepository);
        OrderDrink orderDrink = new OrderDrink(drinkMaker, drinkOrderRepository, emailNotifier, beverageQuantityChecker);
        orderDrink.execute(aChocolate().build(), ONE_EURO);
        orderDrink.execute(new Tea(0), ONE_EURO);
        orderDrink.execute(aCoffee(), ONE_EURO);
        orderDrink.execute(new OrangeJuice(0), ONE_EURO);

        generateDrinkReport.execute();

        verify(this.console, times(5)).print(anyString());
        verify(this.console).print("# of H sold: 1");
        verify(this.console).print("# of T sold: 1");
        verify(this.console).print("# of C sold: 1");
        verify(this.console).print("# of O sold: 1");
        verify(this.console).print("Total amount of money earned: 210 cents");
    }
}