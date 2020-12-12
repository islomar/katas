import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository{
    private List<User> users;

    public InMemoryUserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public void save(User user) throws DuplicatedEmailException {
        if (findByEmail(user.email()).isPresent()) {
            throw new DuplicatedEmailException();
        }
        this.users.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.users.stream().filter(user -> user.email().equalsIgnoreCase(email)).findFirst();
    }
}
