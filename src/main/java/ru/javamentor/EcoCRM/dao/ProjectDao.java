package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.Petition;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

import java.util.List;
import java.util.Map;

public interface ProjectDao extends AbstractDao<Project> {
    Map<StepNumber, List<Project>> getListByStepInProgress();
    List<Petition> getProjManagerByUserId(Long id);
    List<Petition> getProjVolunteerByUserId(Long id);
}
