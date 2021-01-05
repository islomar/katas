import java.util.Map;
import java.util.stream.IntStream;

public class BookStore {

    private static final int ONE_BOOK_BASE_PRICE_IN_EUROS = 8;
    private static final Map<Integer, Double> discountsForNumberOfDifferentSeries = Map.of(
            1, 1.0,
            2, 0.95,
            3, 0.90,
            4, 0.80,
            5, 0.75
    );


    public double priceFor(int... bookSeries) {
        int numberOfDifferentBookSeries = (int) IntStream.of(bookSeries).distinct().count();
        int numberOfBooksOutOfSet = bookSeries.length - numberOfDifferentBookSeries;
        return numberOfDifferentBookSeries * ONE_BOOK_BASE_PRICE_IN_EUROS * discountsForNumberOfDifferentSeries.get(numberOfDifferentBookSeries) + numberOfBooksOutOfSet * ONE_BOOK_BASE_PRICE_IN_EUROS;
    }
}
