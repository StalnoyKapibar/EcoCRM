package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.TaskDao;
import ru.javamentor.EcoCRM.model.Task;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.model.embedded.TaskType;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class TaskServiceImpl extends AbstractServiceImpl<Task> implements TaskService{

    private TaskDao taskDao;

    @Autowired
    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public TaskDao getDao() {
        return taskDao;
    }

    @Override
    public List<Task> getAllByStepId(Long stepId) {
        return getDao().getAllByStepId(stepId);
    }

    @Override
    public Task getDistinctStaticTask(Long projectId, StepNumber stepNumber, TaskType taskType) {
        return taskDao.getDistinctStaticTask(projectId, stepNumber, taskType);
    }
}
