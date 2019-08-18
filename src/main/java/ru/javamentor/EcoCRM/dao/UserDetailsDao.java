package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.User;

import java.util.List;

/**
 * Created by whitenoise on 18.08.19.
 */
public interface UserDetailsDao {
    User findUserByUsername(String username);

    void insertUser(User user);

    List<User> listAllUsers();

    void deleteUser(int id);

    User getUser(int id);

    void updateUser(User user);

}
