package actions;

import infrastructure.InMemoryDrinkOrderRepository;
import model.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetDrinkReportTest {
    @Spy
    Console console;

    @BeforeEach
    public void setUp() {
        console = mock(Console.class);
    }

    @Test
    public void no_drinks_are_printed_when_no_orders_were_made() {
        GetDrinkReport getDrinkReport = new GetDrinkReport(console, new InMemoryDrinkOrderRepository());

        getDrinkReport.execute();

        verify(this.console).print("");
    }

}