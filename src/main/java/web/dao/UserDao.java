package web.dao;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void saveUser(User user);
    void updateUsers(User user);
    void deleteUserById(Long id);
    Optional<User> findUserById(Long id);
    List<User> findUsers();

}
