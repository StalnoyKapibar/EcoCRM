package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.Task;
import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.model.embedded.TaskType;

import java.util.List;

public interface TaskDao extends AbstractDao<Task> {
    List<Task> getAllByStepId(Long stepId);
    Task getDistinctStaticTask(long projectId, StepNumber stepNumber, TaskType taskType);
}
