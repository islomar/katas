import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

@Test
public class FizzBuzzShould {

    public void blablabla() {
        assertThat(10, is(not(nullValue())));
    }
}
