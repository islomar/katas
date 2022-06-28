import io.vavr.control.Either;

public class DNI {

    private final String value;

    private DNI(String value) {
        this.value = value;
    }
    public static Either<DNIErrors, DNI> from(String value) {
        return Either.right(new DNI(value));
    }
}
