import io.vavr.control.Either;

import java.util.List;
import java.util.Map;

public class DNI {

    private static final int DNI_LENGTH = 9;
    private static final Map<String, Integer> NIE_FIRST_LETTER_TO_NUMBER = Map.of(
            "X", 0,
            "Y", 1,
            "Z", 2
    );
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
        DNIErrors letterValidationErrors = validateLastCharacter(value);
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
        String numberWithoutFirstCharacter = value.substring(1, DNI_LENGTH - 1);
        if (containsAnyLetter(numberWithoutFirstCharacter)) {
            errors.add("The first 8 characters of the DNI should be numbers");
        }
        if (!isFirstCharacterValid(value)) {
            errors.add("The first character should be a number or a valid NIE letter");
        }
        return errors;
    }

    private static boolean isFirstCharacterValid(String value) {
        String firstCharacter = String.valueOf(value.charAt(0));
        return isNumeric(firstCharacter) || mightBeNIE(firstCharacter);
    }

    private static boolean mightBeNIE(String value) {
        return NIE_FIRST_LETTER_TO_NUMBER.containsKey(value);
    }

    private static DNIErrors validateLastCharacter(String value) {
        DNIErrors errors = new DNIErrors();
        String lastCharacter = value.substring(DNI_LENGTH - 1);
        if (isNumeric(lastCharacter)) {
            errors.add("The last character of the DNI should be a valid letter");
        }
        String expectedLastLetter = calculateExpectedLastLetter(value);
        if (!expectedLastLetter.equalsIgnoreCase(lastCharacter)) {
            errors.add(String.format("The last character of the DNI is not the right letter: expected %s but found %s", expectedLastLetter, lastCharacter));
        }
        return errors;
    }

    private static String calculateExpectedLastLetter(String value) {
        String CHARACTER_SET = "TRWAGMYFPDXBNJZSQVHLCKE";
        Integer numericDigits = numericDigitsFor(value);
        int module = numericDigits % 23;
        return String.valueOf(CHARACTER_SET.charAt(module));
    }

    private static Integer numericDigitsFor(String value) {
        String firstCharacter = String.valueOf(value.charAt(0));
        if (mightBeNIE(firstCharacter)) {
            value = replaceFirstLetterWithNumber(value, firstCharacter);
        }
        return Integer.parseInt(value.substring(0, DNI_LENGTH - 1));
    }

    private static String replaceFirstLetterWithNumber(String value, String firstCharacter) {
        int numberForFirstNIELetter = NIE_FIRST_LETTER_TO_NUMBER.get(firstCharacter);
        char[] chars = value.toCharArray();
        chars[0] = Integer.toString(numberForFirstNIELetter).charAt(0);
        return String.valueOf(chars);
    }

    private static boolean isNumeric(String value) {
        return value.chars().allMatch(Character::isDigit);
    }

    private static boolean containsAnyLetter(String value) {
        return !isNumeric(value);
    }
}
