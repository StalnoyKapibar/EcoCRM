package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.Step;

import java.util.List;

public interface ProjectService extends AbstractService<Project> {
    List<Project> getProjectsByStep(Step step);
}
