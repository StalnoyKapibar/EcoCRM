package ru.javamentor.EcoCRM.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dto.CurrentUserDTO;
import ru.javamentor.EcoCRM.model.User;
import java.util.Base64;
@Service
public class DTOServiceImpl  implements  DTOService{
    @Autowired
    UserService userService;
    @Override
    public User convertDTOToCurrentUser(CurrentUserDTO userDTO) {
        User user = userService.get(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setPhone(userDTO.getPhone());
        user.setPatronymic(userDTO.getPatronymic());
        user.setEmail(userDTO.getEmail());
        user.setLink(userDTO.getLink());
        user.setProfession(userDTO.getProfession());
        user.setNotToDo(userDTO.getNotToDo());
       // user.setPhoto(Base64.getDecoder().decode(userDTO.getPhoto()));
        return user;
    }
    @Override
    public CurrentUserDTO convertCurrentUserToDTO(User user) {
        CurrentUserDTO userDTO = new CurrentUserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setPhone(user.getPhone());
        userDTO.setPatronymic(user.getPatronymic());
        userDTO.setEmail(user.getEmail());
        userDTO.setLink(user.getLink());
        userDTO.setProfession(user.getProfession());
        userDTO.setNotToDo(user.getNotToDo());
        userDTO.setStatus(user.getStatus());
        userDTO.setPhoto(user.getEncoderPhoto());
        return userDTO;
    }
}
//    private long id;
//    private String name;
//    private String surname;
//    private String phone;
//    private String patronymic;
//    private String email;
//    private String link;
//    private String profession;
//    private String notToDo;
//    private byte[] photo;
