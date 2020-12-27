import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MyTest {

    @Test
    public void one_copy_of_a_book_costs_8_euros() {
        BookStore bookStore = new BookStore();

        int price = bookStore.priceFor(1);

        assertThat(price, is(8));
    }
}