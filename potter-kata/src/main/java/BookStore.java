import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.reverseOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class BookStore {

    private static final int ONE_BOOK_BASE_PRICE_IN_EUROS = 8;
    private static final Map<Integer, Double> discountsForNumberOfDifferentSeries = Map.of(
            0, 0.0,
            1, 1.0,
            2, 0.95,
            3, 0.90,
            4, 0.80,
            5, 0.75
    );

    private Map<Integer, Long> extractBookSerieToFrequencySortedByBookSerie(List<Integer> books) {
        return books.stream()
                .sorted(reverseOrder())
                .collect(
                        groupingBy(identity(), LinkedHashMap::new, counting())
                );
    }

    public double priceFor(int[] bookSeries) {
        Map<Integer, Long> booksSeriesWithFrequency = extractBookSerieToFrequencySortedByBookSerie(IntStream.of(bookSeries).boxed().collect(Collectors.toList()));
        int numberOfDifferentBookSeries = booksSeriesWithFrequency.keySet().size();
        int numberOfBooksOutOfSet = bookSeries.length - numberOfDifferentBookSeries;
        return numberOfDifferentBookSeries * ONE_BOOK_BASE_PRICE_IN_EUROS * discountsForNumberOfDifferentSeries.get(numberOfDifferentBookSeries) +
                numberOfBooksOutOfSet * ONE_BOOK_BASE_PRICE_IN_EUROS;
    }
}
