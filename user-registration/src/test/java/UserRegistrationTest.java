import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class UserRegistrationTest {
    @Test
    public void should_persist_a_new_user(){
        UserRepository userRepository = mock(UserRepository.class);
        UserRegistration userRegistration = new UserRegistration(userRepository);
        String anyEmail = "any@email.com";
        String anyPassword = "anyPassword";

        userRegistration.register(anyEmail, anyPassword);

        verify(userRepository, times(1)).save(new User("", anyEmail, anyPassword));
    }

}
