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
        DNIErrors letterValidationErrors = validateLetter(value);
        if (letterValidationErrors.containsAny()) {
            return Either.left(letterValidationErrors);
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
        if (!isNumeric(number)) {
            errors.add("The first 8 characters of the DNI should be numbers");
        }
        return errors;
    }

    private static DNIErrors validateLetter(String value) {
        DNIErrors errors = new DNIErrors();
        String letter = value.substring(DNI_LENGTH - 1);
        if (isNumeric(letter)) {
            errors.add("The last character of the DNI should be a valid letter");
        }
        return errors;
    }

    private static boolean isNumeric(String value) {
        return value.chars().allMatch(Character::isDigit);
    }
}
