import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
        int[] counts = new int[6];
        for (int die : dice)
            counts[die - 1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
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
        int[] counts = new int[6];
        counts[die1 - 1]++;
        counts[die2 - 1]++;
        counts[die3 - 1]++;
        counts[die4 - 1]++;
        counts[die5 - 1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
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
        Map<Integer, Long> dieNumberToFrequency =
                dice.stream().collect(
                        Collectors.groupingBy(
                                identity(), Collectors.counting()
                        )
                );
        Optional<Integer> numberThatAppearsAtLeastNTimes = dieNumberToFrequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= numberOfOccurrences)
                .map(Map.Entry::getKey).findFirst();

        if (numberThatAppearsAtLeastNTimes.isPresent()) {
            return numberThatAppearsAtLeastNTimes.get() * numberOfOccurrences;
        }
        return 0;
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
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        tallies = new int[6];
        tallies[die1 - 1] += 1;
        tallies[die2 - 1] += 1;
        tallies[die3 - 1] += 1;
        tallies[die4 - 1] += 1;
        tallies[die5 - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
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


