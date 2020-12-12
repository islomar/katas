import java.util.UUID;

public class UserRegistration {
    private final UserRepository userRepository;

    public UserRegistration(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public void register(String email, String password) {
        UUID userId = UUID.randomUUID();
        this.userRepository.save(new User(userId.toString(), email, password));
    }
}
