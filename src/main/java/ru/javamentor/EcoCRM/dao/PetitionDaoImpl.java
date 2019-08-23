package ru.javamentor.EcoCRM.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javamentor.EcoCRM.model.Petition;
import ru.javamentor.EcoCRM.model.embedded.Status;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PetitionDaoImpl extends AbstractDaoImpl<Petition> implements PetitionDao {

    public List<Petition> getAllPetitionWithStatusTodo(){
        String select = "from Petition where status = :status";
        Query query = entityManager.createQuery(select, Petition.class);
        query.setParameter("status", Status.TODO);
        List<Petition> petitionList = query.getResultList();
        return petitionList;
    }
}
