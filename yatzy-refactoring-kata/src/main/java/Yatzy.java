import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.function.Function.identity;

public class Yatzy {

    private final List<Integer> diceList;

    public Yatzy(int die1, int die2, int die3, int die4, int die5) {
        diceList = List.of(die1, die2, die3, die4, die5);
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
        Integer maximumDieNumber = dice.stream().max(Integer::compare).get();
        return scoreTheSumOfTheDiceThatReads(dice, maximumDieNumber);
    }

    public static int two_pair(int die1, int die2, int die3, int die4, int die5) {
        List<Integer> dice = List.of(die1, die2, die3, die4, die5);
        Map<Integer, Long> dieNumberToFrequency = extractDieNumberToFrequency(dice);
        return dieNumberToFrequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= 2)
                .map(x -> x.getKey().intValue() * 2)
                .reduce(0, Integer::sum);
    }

    public static int four_of_a_kind(int die1, int die2, int die3, int die4, int die5) {
        List<Integer> dice = List.of(die1, die2, die3, die4, die5);
        int numberOfOccurrences = 4;
        return calculate_n_of_a_kind(dice, numberOfOccurrences);
    }

    public static int three_of_a_kind(int die1, int die2, int die3, int die4, int die5) {
        List<Integer> dice = List.of(die1, die2, die3, die4, die5);
        int numberOfOccurences = 3;
        return calculate_n_of_a_kind(dice, numberOfOccurences);
    }

    private static int calculate_n_of_a_kind(List<Integer> dice, int numberOfOccurrences) {
        Map<Integer, Long> dieNumberToFrequency = extractDieNumberToFrequency(dice);
        return dieNumberToFrequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= numberOfOccurrences)
                .map(x -> x.getKey().intValue() * numberOfOccurrences)
                .reduce(0, Integer::sum);
    }

    private static Map<Integer, Long> extractDieNumberToFrequency(List<Integer> dice) {
        return dice.stream().collect(
                Collectors.groupingBy(
                        identity(), Collectors.counting()
                )
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
        Map<Integer, Long> dieNumberToFrequency = extractDieNumberToFrequency(dice);
        Integer twoOfAKind = dieNumberToFrequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 2)
                .map(x -> x.getKey().intValue() * 2)
                .reduce(0, Integer::sum);
        Integer threeOfAKind = dieNumberToFrequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 3)
                .map(x -> x.getKey().intValue() * 3)
                .reduce(0, Integer::sum);

        return twoOfAKind + threeOfAKind;
    }

    private static int scoreTheSumOfTheDiceThatReads(List<Integer> dice, int number) {
        int numberOfDiceWithValueNumber = ((int) dice.stream().filter(die -> die == number).count());
        return numberOfDiceWithValueNumber * number;
    }

    public int fours() {
        return scoreTheSumOfTheDiceThatReads(this.diceList, 4);
    }

    public int fives() {
        return scoreTheSumOfTheDiceThatReads(this.diceList, 5);
    }

    public int sixes() {
        return scoreTheSumOfTheDiceThatReads(this.diceList, 6);
    }
}


