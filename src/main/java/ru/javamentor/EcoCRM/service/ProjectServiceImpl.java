package ru.javamentor.EcoCRM.service;

import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.ProjectDao;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl extends AbstractServiceImpl<Project> implements ProjectService {
    private ProjectDao projectDao;
    public ProjectServiceImpl(ProjectDao projectDao) {
        super(projectDao);
        this.projectDao = projectDao;
    }

    @Override
    public Map<Project, StepNumber> getListByStepInProgress(StepNumber stepNumber, Status status) {
//        Map<Project, StepNumber> projectsMap = projectDao.getListByStepInProgress(stepNumber, status);
        return null;
    }
}
