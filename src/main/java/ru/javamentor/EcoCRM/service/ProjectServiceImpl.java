package ru.javamentor.EcoCRM.service;

import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDaoImpl;
import ru.javamentor.EcoCRM.dao.ProjectDao;
import ru.javamentor.EcoCRM.model.Project;

@Service
public class ProjectServiceImpl extends AbstractServiceImpl<Project> implements ProjectService {
    public ProjectServiceImpl(ProjectDao projectDao) {
        super(projectDao);
    }
}
