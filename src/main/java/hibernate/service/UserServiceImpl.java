package hibernate.service;

import hibernate.dao.UserDao;
import hibernate.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User showUserById(Long id) {
        return userDao.showUserById(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void updateUserById(Long id, User user) {
        userDao.updateUserById(id, user);
    }
}
