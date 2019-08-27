package ru.javamentor.EcoCRM.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.Step;
import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.service.ProjectService;

import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Repository
public class StepDaoImpl extends AbstractDaoImpl<Step> implements StepDao {

    @Autowired
    ProjectService projectService;
    public Step getProgressStepByProjectId(Long projectId){
        Query query = entityManager.unwrap(Session.class).createQuery("from Step as s where s.project = :project and s.status = :status");
        query.setParameter("project", projectService.get(projectId));
        query.setParameter("status", Status.IN_PROGRESS);
        return (Step) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<Step> getAllByProjectId(Long projectId){
        Query query = entityManager.unwrap(Session.class).createQuery("from Step as s where s.project = :project");
        query.setParameter("project", projectService.get(projectId));
        return query.getResultList();
    }

    @Override
    public Step getStepByProjectIdAndStepNumber(Long projectId, StepNumber stepNumber) {
        Query query = entityManager.unwrap(Session.class).createQuery("from Step as s where s.project = :project and s.stepNumber = :stepnumber");
        query.setParameter("project", projectService.get(projectId));
        query.setParameter("stepnumber", stepNumber);
        return (Step) query.getSingleResult();
    }
}
