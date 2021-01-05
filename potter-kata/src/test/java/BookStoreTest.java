import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BookStoreTest {

    private static Stream<Arguments> provideSimpleBookSeries() {
        return Stream.of(
                Arguments.of(new int[]{1}, 8),
                Arguments.of(new int[]{2}, 8),
                Arguments.of(new int[]{3}, 8),
                Arguments.of(new int[]{4}, 8)
        );
    }

    private static Stream<Arguments> provideTwoDifferentSeriesSet() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, 15.2),
                Arguments.of(new int[]{5, 3}, 15.2),
                Arguments.of(new int[]{4, 1}, 15.2),
                Arguments.of(new int[]{3, 4}, 15.2)
        );
    }

    @Test
    public void no_books_costs_0_euros() {
        BookStore bookStore = new BookStore();

        double price = bookStore.priceFor(new int[]{});

        assertThat(price, is(0d));
    }

    @ParameterizedTest(name = "{0} costs {1} euros")
    @MethodSource("provideSimpleBookSeries")
    public void one_copy_of_a_book_costs_8_euros(int[] bookSeries, double expectedPrice) {
        BookStore bookStore = new BookStore();

        double price = bookStore.priceFor(bookSeries);

        assertThat(price, is(expectedPrice));
    }

    @ParameterizedTest(name = "{0} costs {1} euros")
    @MethodSource("provideTwoDifferentSeriesSet")
    public void when_you_buy_2_different_books_you_get_5_percent_discount(int[] bookSeries, double expectedPrice) {
        BookStore bookStore = new BookStore();

        double price = bookStore.priceFor(bookSeries);

        assertThat(price, is(expectedPrice));
    }

    @Test
    public void only_apply_discount_to_the_set_that_matches_2_different_series() {
        BookStore bookStore = new BookStore();

        double price = bookStore.priceFor(new int[]{1, 2, 1, 2});

        assertThat(price, is(15.2 * 2));
    }

    @Test
    public void when_you_buy_3_different_books_you_get_10_percent_discount() {
        BookStore bookStore = new BookStore();

        double price = bookStore.priceFor(new int[]{1, 2, 3});

        assertThat(price, is(21.6));
    }


    @Test
    public void only_apply_discount_to_the_set_that_matches_3_different_series() {
        BookStore bookStore = new BookStore();

        double price = bookStore.priceFor(new int[]{1, 2, 3, 1});

        assertThat(price, is(21.6 + 8));
    }

    @Test
    public void when_you_buy_4_different_books_you_get_20_percent_discount() {
        BookStore bookStore = new BookStore();

        double price = bookStore.priceFor(new int[]{1, 2, 3, 4});

        assertThat(price, is(25.6));
    }


    @Test
    public void only_apply_discount_to_the_set_that_matches_4_different_series() {
        BookStore bookStore = new BookStore();

        double price = bookStore.priceFor(new int[]{1, 2, 3, 4, 1});

        assertThat(price, is(25.6 + 8));
    }

    @Test
    public void when_you_buy_all_5_different_series_you_get_25_percent_discount() {
        BookStore bookStore = new BookStore();

        double price = bookStore.priceFor(new int[]{1, 2, 3, 4, 5});

        assertThat(price, is(30d));
    }

    @Test
    public void only_apply_discount_to_the_set_that_matches_5_different_series() {
        BookStore bookStore = new BookStore();

        double price = bookStore.priceFor(new int[]{1, 2, 3, 4, 5, 1});

        assertThat(price, is(30d + 8d));
    }

    @Test
    public void apply_discounts_for_2_sets_of_2_different_series() {
        BookStore bookStore = new BookStore();

        double price = bookStore.priceFor(new int[]{1, 1, 2, 2});

        assertThat(price, is(2 * ((8 * 2 * 0.95))));
    }

    //2 copies of the first book + 2 copies of the second book + 2 copies of the third book + 1 copy of the fourth book + 1 copy of the fifth book = 51.20 €
    // 5 * 8 * 0.75 = 30
    //4 * 8 * 0.80 = 25.6
    @Disabled
    public void give_as_big_a_discount_as_possible() {
        BookStore bookStore = new BookStore();

        double price = bookStore.priceFor(new int[]{1, 1, 2, 2, 3, 3, 4, 5});

        assertThat(price, is(25.6 + 25.6));
    }
}