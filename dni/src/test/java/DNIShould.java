import io.vavr.control.Either;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class DNIShould {

    @ParameterizedTest
    @ValueSource(strings = { "31970165G", "10448738E", "90250990W", "94985972C" })
    public void have_9_characters(String dniValue) {
        Either<DNIErrors, DNI> dni = DNI.from(dniValue);

        assertTrue(dni.isRight());
    }

    @ParameterizedTest
    @ValueSource(strings = { "", "12345678", "0123456789" })
    public void be_invalid_when_length_is_not_8_characters(String dniValue) {
        Either<DNIErrors, DNI> dni = DNI.from(dniValue);

        assertTrue(dni.isLeft());
        assertThat(dni.getLeft().reason(), is("The DNI should have 9 characters (no more, no less)"));
    }
}
