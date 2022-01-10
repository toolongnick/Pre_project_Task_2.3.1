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
    EntityManager entityManager;

    @Transactional
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void remove(Integer id) {
        User user = (User) entityManager.createQuery("select u from User u where u.id = :id")
                .setParameter("id", id).getSingleResult();
        entityManager.remove(user);
    }

    @Transactional
    @Override
    public void edit(User user) {
        User userToEdit = (User) entityManager.createQuery("select u from User u where u.id = :id")
                .setParameter("id", user.getId()).getSingleResult();
        userToEdit.setName(user.getName());
        userToEdit.setMiddle_name(user.getMiddle_name());
        userToEdit.setSurname(user.getSurname());
        userToEdit.setAge(user.getAge());
        entityManager.persist(userToEdit);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Integer id) {
        return (User) entityManager.createQuery("select u from User u where u.id = :id")
                .setParameter("id", id).getSingleResult();
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listOfUsers() {
        List<User> list = (List<User>) entityManager.createQuery("select u from User u order by u.id").getResultList();
        return list;
    }

}
