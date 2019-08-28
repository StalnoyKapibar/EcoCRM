package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.UserDetailsDao;
import ru.javamentor.EcoCRM.dto.UserEncoderPhotoDTO;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.model.embedded.UserStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl  extends AbstractServiceImpl<User> implements UserService , UserDetailsService {

    private UserDetailsDao userDetailsDao;

    @Autowired
    public UserServiceImpl(UserDetailsDao userDetailsDao) {
        this.userDetailsDao = userDetailsDao;
    }

    @Override
    public UserDetailsDao getDao() {
        return userDetailsDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDetailsDao.findByFieldNameAndValue("email", email);
        if(user == null) {
            throw new UsernameNotFoundException("User with name " + email + " not found");
        }
        return user;
    }

    @Override
    public User getUserByEmail(String email){
        User user = userDetailsDao.findByFieldNameAndValue("email", email);
        return user;
    }

    @Override
    public List<String> getAllUsersPhoto() {
        List<String> photos = new ArrayList<>();
        for (User user : getAll()) {
            photos.add(user.getEncoderPhoto());
        }
        return photos;
    }

    @Override
    public List<UserEncoderPhotoDTO> getUsersWithEncoderPhoto() {
        List<User> users = getAll();
        List<UserEncoderPhotoDTO> userList = new ArrayList<>();
        for (User user : users) {
            Long id = user.getId();
            String name = user.getName();
            String surname = user.getSurname();
            UserStatus status = user.getStatus();
            String photo = user.getEncoderPhoto();
            userList.add(new UserEncoderPhotoDTO(id, name, surname, status, photo));
        }
        return userList;
    }
}
