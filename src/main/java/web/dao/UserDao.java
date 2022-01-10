package web.dao;

import web.model.*;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listOfUsers();
    void remove(Integer id);
    void edit (User user);
    User getUserById(Integer id);

}
