import java.util.List;

public class Yatzy {

    private final List<Integer> diceList;
    protected int[] dice;

    public Yatzy(int die1, int die2, int die3, int die4, int die5) {
        dice = new int[5];
        dice[0] = die1;
        dice[1] = die2;
        dice[2] = die3;
        dice[3] = die4;
        dice[4] = die5;
        diceList = List.of(die1, die2, die3, die4, die5);
    }

    public static int chance(int die1, int die2, int die3, int die4, int die5) {
        int total = 0;
        total += die1;
        total += die2;
        total += die3;
        total += die4;
        total += die5;
        return total;
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
        int sum = 0;
        if (die1 == 1) sum++;
        if (die2 == 1) sum++;
        if (die3 == 1) sum++;
        if (die4 == 1) sum++;
        if (die5 == 1)
            sum++;

        return sum;
    }

    public static int twos(int die1, int die2, int die3, int die4, int die5) {
        int sum = 0;
        if (die1 == 2) sum += 2;
        if (die2 == 2) sum += 2;
        if (die3 == 2) sum += 2;
        if (die4 == 2) sum += 2;
        if (die5 == 2) sum += 2;
        return sum;
    }

    public static int threes(int die1, int die2, int die3, int die4, int die5) {
        int s;
        s = 0;
        if (die1 == 3) s += 3;
        if (die2 == 3) s += 3;
        if (die3 == 3) s += 3;
        if (die4 == 3) s += 3;
        if (die5 == 3) s += 3;
        return s;
    }

    public static int score_pair(int die1, int die2, int die3, int die4, int die5) {
        int[] counts = new int[6];
        counts[die1 - 1]++;
        counts[die2 - 1]++;
        counts[die3 - 1]++;
        counts[die4 - 1]++;
        counts[die5 - 1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6 - at - 1] >= 2)
                return (6 - at) * 2;
        return 0;
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

    public static int four_of_a_kind(int _1, int _2, int die3, int die4, int die5) {
        int[] tallies;
        tallies = new int[6];
        tallies[_1 - 1]++;
        tallies[_2 - 1]++;
        tallies[die3 - 1]++;
        tallies[die4 - 1]++;
        tallies[die5 - 1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int die1, int die2, int die3, int die4, int die5) {
        int[] t;
        t = new int[6];
        t[die1 - 1]++;
        t[die2 - 1]++;
        t[die3 - 1]++;
        t[die4 - 1]++;
        t[die5 - 1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    public static int smallStraight(int die1, int die2, int die3, int die4, int die5) {
        int[] tallies;
        tallies = new int[6];
        tallies[die1 - 1] += 1;
        tallies[die2 - 1] += 1;
        tallies[die3 - 1] += 1;
        tallies[die4 - 1] += 1;
        tallies[die5 - 1] += 1;
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int die1, int die2, int die3, int die4, int die5) {
        int[] tallies;
        tallies = new int[6];
        tallies[die1 - 1] += 1;
        tallies[die2 - 1] += 1;
        tallies[die3 - 1] += 1;
        tallies[die4 - 1] += 1;
        tallies[die5 - 1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
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

    public int fours() {
        int sum;
        sum = 0;
        for (int at = 0; at != 5; at++) {
            if (dice[at] == 4) {
                sum += 4;
            }
        }
        return sum;
    }

    public int fives() {
        int s = 0;
        int i;
        for (i = 0; i < dice.length; i++)
            if (dice[i] == 5)
                s = s + 5;
        return s;
    }

    public int sixes() {
        int sum = 0;
        for (int at = 0; at < dice.length; at++)
            if (dice[at] == 6)
                sum = sum + 6;
        return sum;
    }
}


