package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.model.Petition;
import ru.javamentor.EcoCRM.dto.PersonProjectDTO;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

import java.util.List;
import java.util.Map;

public interface ProjectService extends AbstractService<Project> {

    Map<StepNumber, List<Project>> getListByStepInProgress();
    List<Project> getProjManagerByUserId(Long id);
    List<Project> getProjVolunteerByUserId(Long id);
    List<Project> getProjectsByUserId(Long id);
    List<PersonProjectDTO> getPersonProjectDto(Long id);

}
