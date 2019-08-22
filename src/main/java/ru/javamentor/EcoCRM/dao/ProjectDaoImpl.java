package ru.javamentor.EcoCRM.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

import javax.persistence.Query;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Repository
public class ProjectDaoImpl extends AbstractDaoImpl<Project> implements ProjectDao {
    public List<Map<Project, StepNumber>> getListByStepInProgress(StepNumber stepNumber, Status status) {
        Query query = entityManager.unwrap(Session.class).createQuery("select new map(s.project, s.stepNumber) from Step as s where s.status = :status");
        query.setParameter("status", Status.IN_PROGRESS);
        List<Map<Project, StepNumber>> projects = query.getResultList();
        return projects;
    }

    @Override
    public List<Project> getProjectsByUserId(Long id) {

        Query query = entityManager.createQuery("select p from Project p where p.manager.id = :id");
        query.setParameter("id", id);
        List<Project> projects = query.getResultList();
        return projects;
    }
}
