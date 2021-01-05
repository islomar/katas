import java.util.stream.IntStream;

public class BookStore {

    public static final int ONE_BOOK_BASE_PRICE_IN_EUROS = 8;

    public double priceFor(int... bookSeries) {
        long numberOfDifferentBookSeries = IntStream.of(bookSeries).distinct().count();
        if (numberOfDifferentBookSeries == 2) {
            return numberOfDifferentBookSeries * ONE_BOOK_BASE_PRICE_IN_EUROS * 0.95;
        }
        if (numberOfDifferentBookSeries == 3) {
            return numberOfDifferentBookSeries * ONE_BOOK_BASE_PRICE_IN_EUROS * 0.90;
        }
        return ONE_BOOK_BASE_PRICE_IN_EUROS;
    }
}
