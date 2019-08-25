package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.Task;

import java.util.List;

public interface TaskDao extends AbstractDao<Task> {
    List<Task> getAllByStepId(Long stepId);
}
