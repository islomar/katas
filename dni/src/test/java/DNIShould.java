import io.vavr.control.Either;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DNIShould {

    @ParameterizedTest
    @ValueSource(strings = { "31970165G", "10448738E", "90250990W", "94985972C" })
    public void have_9_characters(String dniValue) {
        Either<DNIErrors, DNI> dni = DNI.from(dniValue);

        assertTrue(dni.isRight());
    }

    @ParameterizedTest
    @ValueSource(strings = { "Z5090857L", "Y0468622B", "X4326926M" })
    public void be_valid_for_NIE(String nieValue) {
        Either<DNIErrors, DNI> nie = DNI.from(nieValue);

        assertTrue(nie.isRight());
    }

    @ParameterizedTest
    @ValueSource(strings = { "12345678", "0123456789" })
    public void be_invalid_when_length_is_not_8_characters(String dniValue) {
        Either<DNIErrors, DNI> dni = DNI.from(dniValue);

        assertTrue(dni.isLeft());
        assertThat(dni.getLeft().reasons().get(0), is("The DNI should have 9 characters (no more, no less)"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    public void be_invalid_for_null_or_empty_values(String dniValue) {
        Either<DNIErrors, DNI> dni = DNI.from(dniValue);

        assertTrue(dni.isLeft());
        assertThat(dni.getLeft().reasons().get(0), is("The DNI should have 9 characters (no more, no less)"));
    }

    @ParameterizedTest
    @CsvSource({
            "A1234567C, The first character should be a number or a valid NIE letter",
            "12C34567D, The first 8 characters of the DNI should be numbers",
            "1234567AB, The first 8 characters of the DNI should be numbers",
    })
    public void have_8_numbers_at_the_beginning_for_NIF(String dniValue, String errorMessage) {
        Either<DNIErrors, DNI> dni = DNI.from(dniValue);

        assertTrue(dni.isLeft());
        assertThat(dni.getLeft().reasons().get(0), is(errorMessage));
    }

    @ParameterizedTest
    @CsvSource({
            "123456789, The last character of the DNI should be a valid letter",
    })
    public void have_a_valid_letter_at_the_end(String dniValue, String errorMessage) {
        Either<DNIErrors, DNI> dni = DNI.from(dniValue);

        assertTrue(dni.isLeft());
        assertThat(dni.getLeft().reasons().get(0), is(errorMessage));
    }
}
