package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.Petition;
import ru.javamentor.EcoCRM.model.Report;
import ru.javamentor.EcoCRM.model.User;

import java.util.List;
import java.util.Set;

public interface PetitionDao extends AbstractDao<Petition> {
     List<Petition> getAllPetitionWithStatusTodo();
     List<Petition> getAllPetitionForAdmin();
     Set<User> getAllUserForAdmin(Long id);
}
