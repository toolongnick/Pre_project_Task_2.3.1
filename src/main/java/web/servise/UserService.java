package web.servise;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listOfUsers();
    void remove(Integer id);
    void edit (User user);
    User getUserById(Integer id);

}
