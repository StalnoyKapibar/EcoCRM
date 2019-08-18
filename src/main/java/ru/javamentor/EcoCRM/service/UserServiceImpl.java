package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.dao.UserDetailsDao;
import ru.javamentor.EcoCRM.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userDetailsService")
public class UserServiceImpl  implements  UserService, UserDetailsService{

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Transactional
    public void insertUser(User user) {

        userDetailsDao.insertUser(user);
    }


    @Transactional
    public List<User> listAllUsers() {

        return userDetailsDao.listAllUsers();
    }


    @Transactional
    public User getUser(int id) {

        return userDetailsDao.getUser(id);
    }


    @Transactional
    public void updateUser(User user) {

        userDetailsDao.updateUser(user);
    }


    @Transactional
    public void deleteUser(int id) {

        userDetailsDao.deleteUser(id);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userDetailsDao.findUserByEmail(email);


        if(user == null)
        {
            throw new UsernameNotFoundException("User with name " + email + " not found");
        }

        return user;
    }
}
