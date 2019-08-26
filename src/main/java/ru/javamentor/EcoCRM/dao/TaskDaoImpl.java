package ru.javamentor.EcoCRM.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javamentor.EcoCRM.model.Step;
import ru.javamentor.EcoCRM.model.Task;
import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.model.embedded.TaskType;
import ru.javamentor.EcoCRM.service.StepService;

import javax.persistence.Query;
import java.util.List;

@Repository
public class TaskDaoImpl extends AbstractDaoImpl<Task> implements TaskDao {

    @Override
    public List<Task> getAllByStepId(Long stepId) {
        Query query = entityManager.unwrap(Session.class).createQuery("from Task as t where t.step.id = :step");
        query.setParameter("step", stepId);
        return query.getResultList();
    }


    @Override
    public Task getDistinctStaticTask(long projectId, StepNumber stepNumber, TaskType taskType) {
        Query query = entityManager.unwrap(Session.class).createQuery("from Task as t where" +
                " t.step.project.id = :projectId " +
                "and t.step.stepNumber = :stepNumber " +
                "and t.type = :taskType");
        query.setParameter("projectId", projectId);
        query.setParameter("stepNumber", stepNumber);
        query.setParameter("taskType", taskType);
        return (Task)query.getResultList().get(0);
    }
}