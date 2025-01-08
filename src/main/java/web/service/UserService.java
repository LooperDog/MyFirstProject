package web.service;
import web.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
    Optional<User> findUserById(Long id);
    List<User> findUsers();
}
