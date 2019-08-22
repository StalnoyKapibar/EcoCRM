package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

import java.util.List;
import java.util.Map;

public interface ProjectDao extends AbstractDao<Project> {
    List<Map<Project, StepNumber>> getListByStepInProgress(StepNumber stepNumber, Status status);
    List<Project> getProjectsByUserId(Long id);
}
