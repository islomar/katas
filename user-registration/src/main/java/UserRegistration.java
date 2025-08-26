import java.util.Optional;
import java.util.UUID;

public class UserRegistration {
    private final UserRepository userRepository;

    public UserRegistration(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public void register(String email, String password) throws DuplicatedEmailException {
        throwExceptionIfEmailAlreadyExists(email);

        UUID userId = UUID.randomUUID();
        this.userRepository.save(new User(userId.toString(), email, password));
    }

    private void throwExceptionIfEmailAlreadyExists(String email) throws DuplicatedEmailException {
        Optional<User> foundUser = this.userRepository.findByEmail(email);
        if (foundUser.isPresent()) {
            throw new DuplicatedEmailException();
        }
    }
}
