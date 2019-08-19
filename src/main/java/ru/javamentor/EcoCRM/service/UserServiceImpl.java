package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.dao.UserDetailsDao;
import ru.javamentor.EcoCRM.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userDetailsService")
public abstract class UserServiceImpl  extends AbstractServiceImpl<User> implements AbstractService<User> ,UserService, UserDetailsService{



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = abstractDao.findByFieldNameAndValue("email",email);


        if(user == null)
        {
            throw new UsernameNotFoundException("User with name " + email + " not found");
        }

        return user;
    }
}
