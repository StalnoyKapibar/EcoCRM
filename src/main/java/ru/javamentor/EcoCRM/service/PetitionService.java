package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.model.Petition;

import java.util.List;

public interface PetitionService extends AbstractService<Petition> {

    List<Petition> getPetitionsFromProjectByUserId(Long id);
}
