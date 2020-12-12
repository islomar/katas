import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserRegistrationTest {

    private UserRepository userRepository;
    @Captor
    private ArgumentCaptor<User> user;


    @BeforeEach
    void setUp() {
        userRepository = spy(UserRepository.class);
        initMocks(this);
    }

    @Test
    public void should_persist_a_new_user_with_a_random_id() {
        UserRegistration userRegistration = new UserRegistration(userRepository);
        String anyEmail = "any@email.com";
        String anyPassword = "anyPassword";

        userRegistration.register(anyEmail, anyPassword);

        verify(userRepository).save(user.capture());
        User savedUser = user.getValue();
        assertThat(savedUser.email(), is(anyEmail));
        assertThat(savedUser.password(), is(anyPassword));
        assertThat(savedUser.id(), not(isEmptyString()));
    }

}
