import io.vavr.control.Either;

public class DNI {

    public static final int DNI_LENGTH = 9;
    private final String value;

    private DNI(String value) {
        this.value = value;
    }
    public static Either<DNIErrors, DNI> from(String value) {
        DNIErrors lengthValidationErrors = validateLength(value);
        if (lengthValidationErrors.containsAny()) {
            return Either.left(lengthValidationErrors);
        }
        DNIErrors numberValidationErrors = validateNumber(value);
        if (numberValidationErrors.containsAny()) {
            return Either.left(numberValidationErrors);
        }

        return Either.right(new DNI(value));
    }

    private static DNIErrors validateLength(String value) {
        DNIErrors errors = new DNIErrors();
        if (value == null || value.length() != DNI_LENGTH) {
            errors.add(String.format("The DNI should have %s characters (no more, no less)", DNI_LENGTH));
        }
        return errors;
    }

    private static DNIErrors validateNumber(String value) {
        DNIErrors errors = new DNIErrors();
        String number = value.substring(0, DNI_LENGTH - 1);
        boolean isNumeric = number.chars().allMatch(Character::isDigit);
        if (!isNumeric) {
            errors.add("The first 8 characters of the DNI should be numbers");
        }
        return errors;
    }
}
