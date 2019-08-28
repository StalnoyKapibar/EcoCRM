package ru.javamentor.EcoCRM.dao;

import org.springframework.stereotype.Repository;
import ru.javamentor.EcoCRM.model.CheckPoint;
import ru.javamentor.EcoCRM.model.Project;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CheckPointDaoImpl extends AbstractDaoImpl<CheckPoint> implements CheckPointDao {

    @Override
    public CheckPoint getCheckPointById(Long id) {

        Query query = entityManager.createQuery("select cp from CheckPoint cp where cp.id =:id");
        query.setParameter("id", id);
        return (CheckPoint) query.getSingleResult();
    }
}
