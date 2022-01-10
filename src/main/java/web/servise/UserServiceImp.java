package web.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.*;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao = new UserDaoImp();

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listOfUsers() {
        return userDao.listOfUsers();
    }

    @Override
    public void remove(Integer id) {
        userDao.remove(id);
    }

    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }
}
