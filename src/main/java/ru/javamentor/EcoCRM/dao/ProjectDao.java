package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.dto.PersonProjectDTO;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.Report;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

import java.util.List;
import java.util.Map;

public interface ProjectDao extends AbstractDao<Project> {

    Map<StepNumber, List<Project>> getListByStepInProgress();
    List<Project> getProjectsByUserId(Long id);
    List<Project> getProjManagerByUserId(Long id);
    List<Project> getProjVolunteerByUserId(Long id);
    List<PersonProjectDTO> getProjectDtoByUserId(Long id);
    Report getReportByWithIdProject(Long id);
}
