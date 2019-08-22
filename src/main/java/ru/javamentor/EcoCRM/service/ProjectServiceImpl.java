package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.ProjectDao;
import ru.javamentor.EcoCRM.model.Project;
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
}
