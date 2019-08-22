package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.Petition;

import java.util.List;

public interface PetitionDao extends AbstractDao<Petition>  {
    public List<Petition> getAllPetitionWithStatusTodo();
}
