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
        return calculatePrice(booksSeriesWithFrequency);
    }

    private double calculatePrice(Map<Integer, Long> booksSeriesWithFrequency) {
        int numberOfDifferentBookSeries = (int) booksSeriesWithFrequency.values().stream().filter((numberOfBooks) -> numberOfBooks > 0).count();
        if (numberOfDifferentBookSeries > 0) {
            Map<Integer, Long> newBooksSeriesWithFrequency = substractOneBookFromEachSerie(booksSeriesWithFrequency);
            return numberOfDifferentBookSeries * ONE_BOOK_BASE_PRICE_IN_EUROS * discountsForNumberOfDifferentSeries.get(numberOfDifferentBookSeries) +
                    calculatePrice(newBooksSeriesWithFrequency);
        }
        return 0;
    }

    private Map<Integer, Long> substractOneBookFromEachSerie(Map<Integer, Long> booksSeriesWithFrequency) {
        return booksSeriesWithFrequency.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue() - 1));
    }
}
