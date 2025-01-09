package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
    userDao.updateUsers(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public List<User> findUsers() {
        return userDao.findUsers();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userDao.findUserById(id);
    }
}
