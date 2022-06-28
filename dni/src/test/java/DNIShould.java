import io.vavr.control.Either;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class DNIShould {

    public static final String VALID_DNI = "21515717E";

    @ParameterizedTest
    @ValueSource(strings = { VALID_DNI })
    public void have_9_characters(String dniCandidate) {
        Either<DNIErrors, DNI> dni = DNI.from(dniCandidate);

        assertTrue(dni.isRight());
    }

    @Test
    public void be_invalid_with_8_characters() {
        Either<DNIErrors, DNI> dni = DNI.from("12345678");

        assertTrue(dni.isLeft());
        assertThat(dni.getLeft().reason(), is("The DNI should have 9 characters (no more, no less)"));
    }

    @Test
    public void be_invalid_with_10_characters() {
        Either<DNIErrors, DNI> dni = DNI.from("0123456789");

        assertTrue(dni.isLeft());
        assertThat(dni.getLeft().reason(), is("The DNI should have 9 characters (no more, no less)"));
    }
}
