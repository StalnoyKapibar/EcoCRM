package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.TaskDao;
import ru.javamentor.EcoCRM.model.Task;

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
}
