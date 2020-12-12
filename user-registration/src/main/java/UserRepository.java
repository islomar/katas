import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    void save(User user) throws DuplicatedEmailException;

    Optional<User> findByEmail(String userId);
}
