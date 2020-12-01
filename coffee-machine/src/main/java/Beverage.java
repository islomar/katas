public class Beverage {
    private final String beverageType;
    private final int numberOfSugars;

    public Beverage(String beverageType, int numberOfSugars) {
        this.beverageType = beverageType;
        this.numberOfSugars = numberOfSugars;
    }

    public String beverageType() {
        return beverageType;
    }

    public int numberOfSugars() {
        return numberOfSugars;
    }
}
