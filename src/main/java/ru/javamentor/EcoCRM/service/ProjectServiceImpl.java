package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.ProjectDao;
import ru.javamentor.EcoCRM.dao.UserDao;
import ru.javamentor.EcoCRM.dto.PersonProjectDTO;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.Report;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl extends AbstractServiceImpl<Project> implements ProjectService {

    private ProjectDao projectDao;

    @Autowired
    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public ProjectDao getDao() {
        return projectDao;
    }

    @Override
    public Map<StepNumber, List<Project>> getListByStepInProgress() {
        return projectDao.getListByStepInProgress();
    }

    @Override
    public List<Project> getProjVolunteerByUserId(Long id) {
        return projectDao.getProjVolunteerByUserId(id);
    }

    //todo
    @Override
    public List<Project> getProjectsByUserId(Long id) {
        return null;
    }

    @Override
    public List<PersonProjectDTO> getPersonProjectDto(Long id) {
        return projectDao.getProjectDtoByUserId(id);
    }

    @Override
    public boolean isManageProject(Long authInitiatorId, Long projectId) {
        Project project = projectDao.get(projectId);
        if (project.getManager().getId().equals(authInitiatorId)) {
            return true;
        } else {
            for (User projectMember : project.getUsers()) {
                if (authInitiatorId.equals(projectMember.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Report getReportByWithIdProject(Long id) {
        return projectDao.getReportByWithIdProject(id);
    }

    @Override
    public List<Project> getProjManagerByUserId(Long id) {
        return projectDao.getProjManagerByUserId(id);
    }

}
