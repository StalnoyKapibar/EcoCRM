package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.model.Task;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.model.embedded.TaskType;

import java.util.List;

public interface TaskService extends AbstractService<Task>{
    List<Task> getAllByStepId(Long stepId);
    Task getDistinctStaticTask(long projectId, StepNumber stepNumber, TaskType taskType);
}
