package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.EcoCRM.dao.UserDetailsDao;
import ru.javamentor.EcoCRM.model.User;

import java.util.List;

@Transactional
@Service("userDetailsService")
public class UserServiceImpl  implements  UserService, UserDetailsService{

    @Autowired
    private UserDetailsDao userDetailsDao;

    public void insertUser(User user) {
        userDetailsDao.insertUser(user);
    }

    public List<User> listAllUsers() {
        return userDetailsDao.listAllUsers();
    }

    public User getUser(int id) {
        return userDetailsDao.getUser(id);
    }

    public void updateUser(User user) {
        userDetailsDao.updateUser(user);
    }

    public void deleteUser(int id) {
        userDetailsDao.deleteUser(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDetailsDao.findUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User with name " + email + " not found");
        }
        return user;
    }
}
