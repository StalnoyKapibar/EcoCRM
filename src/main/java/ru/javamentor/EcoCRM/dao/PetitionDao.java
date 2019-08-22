package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.Petition;

import java.util.List;

public interface PetitionDao extends AbstractDao<Petition>  {

    List<Petition> getPetitionsFromProjectByUserId(Long id);

}
