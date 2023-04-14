package hibernate.service;

import hibernate.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User showUserById(Long id);
    void saveUser(User user);
    void deleteUserById(Long id);
    void updateUserById(Long id, User user);
}
