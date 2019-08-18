package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.entity.User;

import java.util.List;

/**
 * Created by whitenoise on 18.08.19.
 */
public interface UserDetailsDao {
    User findUserByEmail(String email);

    void insertUser(User user);

    List<User> listAllUsers();

    void deleteUser(int id);

    User getUser(int id);

    void updateUser(User user);

}
