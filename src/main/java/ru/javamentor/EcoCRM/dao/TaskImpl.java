package ru.javamentor.EcoCRM.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javamentor.EcoCRM.model.Step;
import ru.javamentor.EcoCRM.model.Task;
import ru.javamentor.EcoCRM.service.StepService;

import javax.persistence.Query;
import java.util.List;

@Repository
public class TaskImpl extends AbstractDaoImpl<Task> implements TaskDao {

    @Autowired
    StepService stepService;

    @Override
    public List<Task> getAllByStepId(Long stepId) {
        Query query = entityManager.unwrap(Session.class).createQuery("from Task as t where t.step = :step");
        query.setParameter("step", stepService.get(stepId));
        return query.getResultList();
    }
}
