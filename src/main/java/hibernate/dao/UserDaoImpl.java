package hibernate.dao;

import hibernate.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public User showUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        entityManager.remove(showUserById(id));
    }

    @Override
    @Transactional
    public void updateUserById(Long id, User user) {
        User updatedUser = showUserById(id);
        updatedUser.setName(user.getName());
        updatedUser.setLastName(user.getLastName());
        entityManager.merge(updatedUser);
    }
}
