import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;
import static org.testng.Assert.fail;

@Test
public class ActionTest {

  public void should_print_statement_containing_all_transactions() {

    account.deposit(1000);
    account.withdraw(100);
    account.deposit(500);

    account.printStatement();

    verify(console).printLine("DATE | AMOUNT | BALANCE");
    verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
    verify(console).printLine("02/04/2014 | -100 | 900.00");
    verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
  }

}
