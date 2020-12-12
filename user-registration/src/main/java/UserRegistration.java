public class UserRegistration {
    private final UserRepository userRepository;

    public UserRegistration(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public void register(String email, String password) {
        this.userRepository.save(new User("", email, password));
    }
}
