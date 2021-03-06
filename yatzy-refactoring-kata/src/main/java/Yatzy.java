import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.reverseOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Yatzy {

    private final List<Integer> dice;

    public Yatzy(int die1, int die2, int die3, int die4, int die5) {
        dice = List.of(die1, die2, die3, die4, die5);
    }

    public static int chance(int die1, int die2, int die3, int die4, int die5) {
        return die1 + die2 + die3 + die4 + die5;
    }

    public static int yatzy(int... dice) {
        boolean areAllNumbersEqual = IntStream.of(dice).distinct().count() <= 1;
        if (areAllNumbersEqual) {
            return 50;
        }
        return 0;
    }

    public static int ones(int die1, int die2, int die3, int die4, int die5) {
        List<Integer> dice = List.of(die1, die2, die3, die4, die5);
        return scoreTheSumOfTheDiceThatReads(dice, 1);
    }

    public static int twos(int die1, int die2, int die3, int die4, int die5) {
        List<Integer> dice = List.of(die1, die2, die3, die4, die5);
        return scoreTheSumOfTheDiceThatReads(dice, 2);
    }

    public static int threes(int die1, int die2, int die3, int die4, int die5) {
        List<Integer> dice = List.of(die1, die2, die3, die4, die5);
        return scoreTheSumOfTheDiceThatReads(dice, 3);
    }

    public static int score_pair(int die1, int die2, int die3, int die4, int die5) {
        List<Integer> dice = List.of(die1, die2, die3, die4, die5);
        return calculate_exactly_n_of_a_kind_for_max_die_number(dice, 2);
    }

    public static int two_pair(int die1, int die2, int die3, int die4, int die5) {
        List<Integer> dice = List.of(die1, die2, die3, die4, die5);
        long numberOfPairs = convertToMapWithDieNumberWithMinimumOccurrences(dice, 2).size();
        if (numberOfPairs >= 2) {
            return calculate_at_least_n_of_a_kind(dice, 2);
        }
        return 0;
    }

    public static int four_of_a_kind(int die1, int die2, int die3, int die4, int die5) {
        List<Integer> dice = List.of(die1, die2, die3, die4, die5);
        return calculate_exactly_n_of_a_kind_for_max_die_number(dice, 4);
    }

    public static int three_of_a_kind(int die1, int die2, int die3, int die4, int die5) {
        List<Integer> dice = List.of(die1, die2, die3, die4, die5);
        return calculate_at_least_n_of_a_kind(dice, 3);
    }

    private static int calculate_at_least_n_of_a_kind(List<Integer> dice, int numberOfOccurrences) {
        return convertToMapWithDieNumberWithMinimumOccurrences(dice, numberOfOccurrences)
                .entrySet()
                .stream()
                .map(x -> x.getKey().intValue() * numberOfOccurrences)
                .reduce(0, Integer::sum);
    }

    private static Map<Integer, Long> convertToMapWithDieNumberWithMinimumOccurrences(List<Integer> dice, int numberOfOccurrences) {
        Map<Integer, Long> dieNumberToFrequency = extractDieNumberToFrequencySortedByDieNumber(dice);
        return dieNumberToFrequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= numberOfOccurrences)
                .collect(Collectors.toMap(m -> m.getKey(), m -> m.getValue()));
    }

    private static int calculate_exactly_n_of_a_kind_for_max_die_number(List<Integer> dice, int numberOfOccurrences) {
        Map<Integer, Long> dieNumberToFrequency = extractDieNumberToFrequencySortedByDieNumber(dice);
        return dieNumberToFrequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == numberOfOccurrences)
                .map(x -> x.getKey().intValue() * numberOfOccurrences)
                .findFirst()
                .orElse(0);
    }

    private static Map<Integer, Long> extractDieNumberToFrequencySortedByDieNumber(List<Integer> dice) {
        return dice.stream()
                .sorted(reverseOrder())
                .collect(
                        groupingBy(identity(), LinkedHashMap::new, counting())
                );
    }

    public static int smallStraight(int die1, int die2, int die3, int die4, int die5) {
        List<Integer> sortedDice = List.of(die1, die2, die3, die4, die5).stream().sorted().collect(Collectors.toList());
        if (sortedDice.equals(List.of(1, 2, 3, 4, 5))) {
            return 15;
        }
        return 0;
    }

    public static int largeStraight(int die1, int die2, int die3, int die4, int die5) {
        List<Integer> sortedDice = List.of(die1, die2, die3, die4, die5).stream().sorted().collect(Collectors.toList());
        if (sortedDice.equals(List.of(2, 3, 4, 5, 6))) {
            return 20;
        }
        return 0;
    }

    public static int fullHouse(int die1, int die2, int die3, int die4, int die5) {
        List<Integer> dice = List.of(die1, die2, die3, die4, die5);
        return calculate_exactly_n_of_a_kind_for_max_die_number(dice, 2) + calculate_exactly_n_of_a_kind_for_max_die_number(dice, 3);
    }

    private static int scoreTheSumOfTheDiceThatReads(List<Integer> dice, int number) {
        int numberOfDiceWithValueNumber = ((int) dice.stream().filter(die -> die == number).count());
        return numberOfDiceWithValueNumber * number;
    }

    public int fours() {
        return scoreTheSumOfTheDiceThatReads(this.dice, 4);
    }

    public int fives() {
        return scoreTheSumOfTheDiceThatReads(this.dice, 5);
    }

    public int sixes() {
        return scoreTheSumOfTheDiceThatReads(this.dice, 6);
    }
}


