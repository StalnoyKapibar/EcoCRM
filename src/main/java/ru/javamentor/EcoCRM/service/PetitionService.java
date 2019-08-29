package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.dto.PetitionDTO;
import ru.javamentor.EcoCRM.model.Petition;
import ru.javamentor.EcoCRM.model.User;

import java.util.List;

public interface PetitionService extends AbstractService<Petition> {

     List<PetitionDTO> getAllPetition();

     List<PetitionDTO> getAllPetitionForAdmin();

     void addUserPetition(Long petitionId, User user);
}
