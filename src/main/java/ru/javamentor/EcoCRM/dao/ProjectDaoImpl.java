package ru.javamentor.EcoCRM.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.javamentor.EcoCRM.dto.PersonProjectDTO;
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

    @Override
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

    @Override
    public List<Project> getProjectsByUserId(Long id) {
        Query query = entityManager.createQuery("select p from Project p where p.manager.id = :id");
        query.setParameter("id", id);
        List<Project> projects = query.getResultList();
        return projects;
    }

    @Override
    public List<PersonProjectDTO> getProjectDtoByUserId(Long id) {
        List<PersonProjectDTO> projects = new ArrayList<>();
        List petitions = entityManager
                .createNativeQuery("select uprs.proj_id as id, uprs.step_number as number, uprs.start_time_project as time, pe.house_area as area from\n" +
                        "(select * from \n" +
                        "(select pr.id as proj_id, pr.start_step as start_time_project, pr.petition_id\n" +
                        "from users as u \n" +
                        "inner join projects as pr on u.id=pr.manager_id where u.id=:id) as upr \n" +
                        "inner join steps as s on upr.proj_id=s.project_id where s.status='IN_PROGRESS') as uprs\n" +
                        "inner join petitions as pe on uprs.petition_id=pe.id;")
                .setParameter("id", id).getResultList();
        if (!petitions.isEmpty()) {
            for (Object project : petitions) {
                PersonProjectDTO dto = new PersonProjectDTO();
                if (((Object[]) project)[0] != null) {
                    dto.setId(((Object[]) project)[0].toString());
                }
                if (((Object[]) project)[1] != null) {
                    dto.setNumber(((Object[]) project)[1].toString());
                }
                if (((Object[]) project)[2] != null) {
                    dto.setTime(((Object[]) project)[2].toString());
                }
                if (((Object[]) project)[3] != null) {
                    dto.setArea(((Object[]) project)[3].toString());
                }
                projects.add(dto);
            }
        }
        return projects;
    }
}
