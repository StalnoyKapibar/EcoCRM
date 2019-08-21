package ru.javamentor.EcoCRM.service;

import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.model.TaskByStep;

@Service
public class TaskServiceImpl extends AbstractServiceImpl<TaskByStep> implements TaskService{

    public TaskServiceImpl(AbstractDao<TaskByStep> abstractDao) {
        super(abstractDao);
    }
}
