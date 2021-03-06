package actions;

import infrastructure.InMemoryDrinkOrderRepository;
import model.BeverageQuantityChecker;
import model.DrinkMaker;
import model.EmailNotifier;
import model.Money;
import model.drinks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static utils.ChocolateBuilder.aChocolate;
import static utils.TestData.ONE_EURO;
import static utils.TestData.aCoffee;

public class OrderDrinkShould {

    private InMemoryDrinkOrderRepository drinkOrderRepository;
    @Mock private DrinkMaker drinkMaker;
    @Mock private EmailNotifier emailNotifier;
    @Mock private BeverageQuantityChecker beverageQuantityChecker;

    private static Stream<Arguments> providesDrinksWithPrices() {
        return Stream.of(
                Arguments.of(aChocolate().withSugar(1).build(), new Money(new BigDecimal(50)), "H:1:0"),
                Arguments.of(new Tea(1), new Money(new BigDecimal(40)), "T:1:0"),
                Arguments.of(aCoffee(), new Money(new BigDecimal(60)), "C::")
        );
    }

    @BeforeEach
    public void setUp() {
        drinkMaker = mock(DrinkMaker.class);
        emailNotifier = mock(EmailNotifier.class);
        beverageQuantityChecker = mock(BeverageQuantityChecker.class);
        drinkOrderRepository = new InMemoryDrinkOrderRepository();
    }

    @Test
    public void order_a_hot_chocolate_without_sugar() {
        OrderDrink coffeeMachine = anOrderDrink();

        coffeeMachine.execute(aChocolate().build(), ONE_EURO);

        verify(this.drinkMaker).execute("H::");
    }

    @Test
    public void order_a_hot_chocolate_with_one_sugar_and_stick() {
        OrderDrink coffeeMachine = anOrderDrink();

        coffeeMachine.execute(aChocolate().withSugar(1).build(), ONE_EURO);

        verify(this.drinkMaker).execute("H:1:0");
    }

    @Test
    public void order_a_tea_with_two_sugars_and_stick() {
        OrderDrink coffeeMachine = anOrderDrink();

        coffeeMachine.execute(new Tea(2), ONE_EURO);

        verify(this.drinkMaker).execute("T:2:0");
    }

    @Test
    public void order_an_orange_juice_for_60_cents_with_two_sugars_and_stick() {
        OrderDrink coffeeMachine = anOrderDrink();

        coffeeMachine.execute(new OrangeJuice(2), new Money(new BigDecimal(60)));

        verify(this.drinkMaker).execute("O:2:0");
    }

    @Test
    public void order_a_coffee_with_two_sugars_and_stick() {
        OrderDrink coffeeMachine = anOrderDrink();

        coffeeMachine.execute(new Coffee(2), ONE_EURO);

        verify(this.drinkMaker).execute("C:2:0");
    }

    @ParameterizedTest(name = "{0} costs {1} cents")
    @MethodSource("providesDrinksWithPrices")
    public void make_any_drink_if_enough_money_is_introduced(Drink orderedDrink, Money moneyIntroduced, String expectedCommandSentToDrinkMaker) {
        OrderDrink coffeeMachine = anOrderDrink();

        coffeeMachine.execute(orderedDrink, moneyIntroduced);

        verify(this.drinkMaker).execute(expectedCommandSentToDrinkMaker);
    }

    @Test
    public void show_message_with_the_amount_of_money_missing() {
        OrderDrink coffeeMachine = anOrderDrink();
        Chocolate drinkToBeOrdered = aChocolate().build();
        int introducedMoneyInCents = 32;
        Money moneyIntroduced = new Money(new BigDecimal(introducedMoneyInCents));

        coffeeMachine.execute(drinkToBeOrdered, moneyIntroduced);

        String expectedAmountMissing = String.valueOf(drinkToBeOrdered.drinkPrice().amountInEuroCents().intValue() - introducedMoneyInCents);
        verify(this.drinkMaker).execute(String.format("There are %s cents missing", expectedAmountMissing));
    }

    @Test
    public void order_extra_hot_tea() {
        OrderDrink coffeeMachine = anOrderDrink();

        coffeeMachine.execute(new ExtraHot(new Tea(1)), ONE_EURO);

        verify(this.drinkMaker).execute("Th:1:0");
    }

    @Test
    public void order_extra_hot_chocolate() {
        OrderDrink coffeeMachine = anOrderDrink();

        coffeeMachine.execute(new ExtraHot(aChocolate().withSugar(1).build()), ONE_EURO);

        verify(this.drinkMaker).execute("Hh:1:0");
    }

    @Test
    public void order_extra_hot_coffee() {
        OrderDrink coffeeMachine = anOrderDrink();

        coffeeMachine.execute(new ExtraHot(aCoffee()), ONE_EURO);

        verify(this.drinkMaker).execute("Ch::");
    }

    @Test
    public void when_shortage_in_drink_then_send_email_and_tell_the_user() {
        given(beverageQuantityChecker.isEmpty(any())).willReturn(true);
        OrderDrink coffeeMachine = new OrderDrink(drinkMaker, drinkOrderRepository, emailNotifier, beverageQuantityChecker);
        Coffee orderedDrink = aCoffee();

        coffeeMachine.execute(orderedDrink, ONE_EURO);

        verify(this.emailNotifier).notifyMissingDrink(orderedDrink);
        verify(this.drinkMaker).execute("Sorry, we have currently a shortage in your drink. A notification has been sent to be refilled.");
    }

    @Test
    public void when_enough_drinks_then_do_not_send_email_nor_tell_the_user() {
        given(beverageQuantityChecker.isEmpty(any())).willReturn(false);
        OrderDrink coffeeMachine = new OrderDrink(drinkMaker, drinkOrderRepository, emailNotifier, beverageQuantityChecker);
        Coffee orderedDrink = aCoffee();

        coffeeMachine.execute(orderedDrink, ONE_EURO);

        verify(this.emailNotifier, never()).notifyMissingDrink(orderedDrink);
        verify(this.drinkMaker, never()).execute(OrderDrink.DRINK_SHORTAGE_NOTIFICATION_MESSAGE);
    }


    private OrderDrink anOrderDrink() {
        return new OrderDrink(drinkMaker, drinkOrderRepository, emailNotifier, beverageQuantityChecker);
    }
}
