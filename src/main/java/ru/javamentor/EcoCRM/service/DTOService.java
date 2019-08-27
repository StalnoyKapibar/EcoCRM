package ru.javamentor.EcoCRM.service;


import ru.javamentor.EcoCRM.dto.CurrentUserDTO;
import ru.javamentor.EcoCRM.model.User;

public interface DTOService {

    CurrentUserDTO convertCurrentUserToDTO(User user);

    User convertDTOToCurrentUser(CurrentUserDTO currentUserDTO);
}
