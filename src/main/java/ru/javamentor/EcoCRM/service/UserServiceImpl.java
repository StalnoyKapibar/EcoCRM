package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.UserDetailsDao;
import ru.javamentor.EcoCRM.model.User;

@Service
public class UserServiceImpl  extends AbstractServiceImpl<User> implements UserService , UserDetailsService {

    private UserDetailsDao userDetailsDao;

    @Autowired
    public UserServiceImpl(UserDetailsDao userDetailsDao) {
        super(userDetailsDao);
        this.userDetailsDao = userDetailsDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDetailsDao.findByFieldNameAndValue("email", email);
        if(user == null)
        //todo
        {
            throw new UsernameNotFoundException("User with name " + email + " not found");
        }
        return user;
    }
}
