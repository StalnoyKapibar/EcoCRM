package ru.javamentor.EcoCRM.service;


import ru.javamentor.EcoCRM.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    void insertUser(User user);

    List<User> listAllUsers();

    User getUser(int id);

    void updateUser(User user);

    void deleteUser(int id);

    UserDetails loadUserByUsername(String email);
}
