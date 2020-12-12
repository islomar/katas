import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserRegistrationTest {

    private UserRepository userRepository;
    @Captor
    private ArgumentCaptor<User> user;
    private static final String ANY_EMAIL = "any@email.com";
    private static final String ANY_PASSWORD = "anyPassword";


    @BeforeEach
    void setUp() {
        userRepository = spy(UserRepository.class);
        initMocks(this);
    }

    @Test
    public void should_persist_a_new_user_with_an_id() throws DuplicatedEmailException {
        UserRegistration userRegistration = new UserRegistration(userRepository);
        String anyPassword = "anyPassword";

        userRegistration.register(ANY_EMAIL, anyPassword);

        verify(userRepository).save(user.capture());
        User savedUser = user.getValue();
        assertThat(savedUser.email(), is(ANY_EMAIL));
        assertThat(savedUser.password(), is(anyPassword));
        assertThat(savedUser.id(), not(isEmptyString()));
    }

    //TODO: this is complex... maybe just return the user and check that they have different ids...
    @Test
    public void users_should_be_registered_with_different_ids() throws DuplicatedEmailException {
        UserRegistration userRegistration = new UserRegistration(userRepository);
        String anotherEmail = "another@email.com";

        userRegistration.register(ANY_EMAIL, ANY_PASSWORD);
        verify(userRepository, times(1)).save(user.capture());
        User savedUser1 = user.getValue();

        userRegistration.register(anotherEmail, ANY_PASSWORD);
        verify(userRepository, times(2)).save(user.capture());
        User savedUser2 = user.getValue();

        assertThat(savedUser1.id(), not(savedUser2.id()));
    }

    @Test
    public void can_not_exist_two_users_with_same_email() throws DuplicatedEmailException {
        UserRegistration userRegistration = new UserRegistration(new InMemoryUserRepository());

        userRegistration.register(ANY_EMAIL, ANY_PASSWORD);
        assertThrows(DuplicatedEmailException.class, () -> {
            userRegistration.register(ANY_EMAIL, ANY_PASSWORD);
        });
    }

}
