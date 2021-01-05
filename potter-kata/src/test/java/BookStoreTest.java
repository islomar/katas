import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BookStoreTest {

    @Test
    public void one_copy_of_a_book_costs_8_euros() {
        BookStore bookStore = new BookStore();

        double price = bookStore.priceFor(1);

        assertThat(price, is(8d));
    }

    @Test
    public void when_you_buy_2_different_books_you_get_5_percent_discount() {
        BookStore bookStore = new BookStore();

        double price = bookStore.priceFor(1, 2);

        assertThat(price, is(15.2));
    }

    @Test
    public void when_you_buy_3_different_books_you_get_10_percent_discount() {
        BookStore bookStore = new BookStore();

        double price = bookStore.priceFor(1, 2, 3);

        assertThat(price, is(21.6));
    }


    @Test
    public void when_you_buy_4_different_books_you_get_20_percent_discount() {
        BookStore bookStore = new BookStore();

        double price = bookStore.priceFor(1, 2, 3, 4);

        assertThat(price, is(25.6));
    }


    @Test
    public void when_you_buy_all_5_different_series_you_get_25_percent_discount() {
        BookStore bookStore = new BookStore();

        double price = bookStore.priceFor(1, 2, 3, 4, 5);

        assertThat(price, is(30d));
    }
}