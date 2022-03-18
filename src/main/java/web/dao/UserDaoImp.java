package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void remove(Integer id) {
        User user = entityManager.createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", id).getSingleResult();
        entityManager.remove(user);
    }

    @Transactional
    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Integer id) {
        return entityManager.createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", id).getSingleResult();
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listOfUsers() {
        return entityManager.createQuery("select u from User u order by u.id", User.class).getResultList();
    }

}
