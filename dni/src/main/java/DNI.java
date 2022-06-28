import io.vavr.control.Either;

public class DNI {

    private final String value;

    private DNI(String value) {
        this.value = value;
    }
    public static Either<DNIErrors, DNI> from(String value) {
        if (value.length() != 9) {
            return Either.left(new DNIErrors("The DNI should have 9 characters (no more, no less)"));
        }
        return Either.right(new DNI(value));
    }
}
