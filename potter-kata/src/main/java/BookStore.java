import java.util.stream.IntStream;

public class BookStore {
    public double priceFor(int... bookSeries) {
        long numberOfDifferentBookSeries = IntStream.of(bookSeries).distinct().count();
        if (numberOfDifferentBookSeries > 1) {
            return numberOfDifferentBookSeries * 8 * 0.95;
        }
        return 8;
    }
}
