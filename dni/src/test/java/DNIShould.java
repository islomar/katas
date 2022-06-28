import io.vavr.control.Either;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class DNIShould {

    @Test
    public void have_9_characters() {
        Either<DNIErrors, DNI> dni = DNI.from("123456789");

        assertTrue(dni.isRight());
    }

    @Test
    public void be_invalid_with_8_characters() {
        Either<DNIErrors, DNI> dni = DNI.from("12345678");

        assertTrue(dni.isLeft());
    }

    @Test
    public void be_invalid_with_10_characters() {
        Either<DNIErrors, DNI> dni = DNI.from("0123456789");

        assertTrue(dni.isLeft());
    }
}
