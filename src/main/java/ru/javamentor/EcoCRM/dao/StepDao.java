package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.Step;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

import java.util.List;

import java.util.List;

public interface StepDao extends AbstractDao<Step> {

    Step getProgressStepByProjectId(Long projectId);

    List getAllByProjectId(Long projectId);

    Step getStepByProjectIdAndStepNumber(Long projectId, StepNumber stepNumber);
}
