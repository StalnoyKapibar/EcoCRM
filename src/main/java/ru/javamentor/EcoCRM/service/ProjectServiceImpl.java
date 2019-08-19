package ru.javamentor.EcoCRM.service;

import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDaoImpl;
import ru.javamentor.EcoCRM.dao.ProjectDao;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.Step;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractServiceImpl<Project> implements ProjectService {
    public ProjectServiceImpl(ProjectDao projectDao) {
        super(projectDao);
    }

    @Override
    public List<Project> getProjectsByStep(Step step) {
        return null;
    }
}
