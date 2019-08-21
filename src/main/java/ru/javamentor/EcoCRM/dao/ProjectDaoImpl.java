package ru.javamentor.EcoCRM.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProjectDaoImpl extends AbstractDaoImpl<Project> implements ProjectDao {

    public Map<StepNumber, List<Project>> getListByStepInProgress() {
        Map<StepNumber, List<Project>> projectsBySteps = new HashMap<>();
        for(StepNumber step : StepNumber.values()) {
            projectsBySteps.put(step, new ArrayList<>());
        }
        Query query = entityManager.unwrap(Session.class).createQuery("select new map(s.stepNumber, s.project) from Step as s where s.status = :status");
        query.setParameter("status", Status.IN_PROGRESS);
        for(Map<Object, Object> map : (List<Map<Object, Object>>)query.getResultList()) {
            projectsBySteps.get(map.get("0")).add((Project)map.get("1"));
        }
        return projectsBySteps;
    }
}
