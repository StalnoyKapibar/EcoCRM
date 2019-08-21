package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.Step;

import java.util.List;

public interface StepDao extends AbstractDao<Step> {
    Step getProgressStepByProjectId(Long projectId);
    List getAllByProjectId(Long projectId);
}
