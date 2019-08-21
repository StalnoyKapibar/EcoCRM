package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.model.Step;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

import java.util.List;

public interface StepService extends AbstractService<Step> {
    Step getProgressStepByProjectId(Long projectId);
    void putProgressStatusToFirstStep();
    List<Step> getAllByprojectId(Long id);
}
