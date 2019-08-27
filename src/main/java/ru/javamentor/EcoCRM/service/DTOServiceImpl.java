package ru.javamentor.EcoCRM.service;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dto.CurrentUserDTO;
import ru.javamentor.EcoCRM.model.User;
@Service
public class DTOServiceImpl  implements  DTOService{
    @Override
    public User convertDTOToCurrentUser(CurrentUserDTO currentUserDTO) {
        return null;
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
        userDTO.setPhoto(user.getPhoto());
        System.out.println("USER PHOTO IS:" + user.getPhoto());
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