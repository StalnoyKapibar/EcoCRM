package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.model.Task;

import java.util.List;

public interface TaskService extends AbstractService<Task>{
    List<Task> getAllByStepId(Long stepId);
}
