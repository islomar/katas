import java.util.stream.IntStream;

public class BookStore {

    private static final int ONE_BOOK_BASE_PRICE_IN_EUROS = 8;

    public double priceFor(int... bookSeries) {
        long numberOfDifferentBookSeries = IntStream.of(bookSeries).distinct().count();
        double numberOfBooksOutOfSet = bookSeries.length - numberOfDifferentBookSeries;
        if (numberOfDifferentBookSeries == 2) {
            return numberOfDifferentBookSeries * ONE_BOOK_BASE_PRICE_IN_EUROS * 0.95;
        }
        if (numberOfDifferentBookSeries == 3) {
            return numberOfDifferentBookSeries * ONE_BOOK_BASE_PRICE_IN_EUROS * 0.90 + numberOfBooksOutOfSet * ONE_BOOK_BASE_PRICE_IN_EUROS;
        }
        if (numberOfDifferentBookSeries == 4) {
            return numberOfDifferentBookSeries * ONE_BOOK_BASE_PRICE_IN_EUROS * 0.80;
        }
        if (numberOfDifferentBookSeries == 5) {
            return numberOfDifferentBookSeries * ONE_BOOK_BASE_PRICE_IN_EUROS * 0.75;
        }
        return ONE_BOOK_BASE_PRICE_IN_EUROS;
    }
}
