package ru.javamentor.EcoCRM.service;


import ru.javamentor.EcoCRM.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService extends AbstractService<User> {
    UserDetails loadUserByUsername(String email);
    User getUserByEmail(String email);
}
