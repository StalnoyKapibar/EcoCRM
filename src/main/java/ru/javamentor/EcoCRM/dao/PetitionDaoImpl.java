package ru.javamentor.EcoCRM.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javamentor.EcoCRM.model.Petition;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.model.embedded.Status;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class PetitionDaoImpl extends AbstractDaoImpl<Petition> implements PetitionDao {

    public List<Petition> getAllPetitionWithStatusTodo(){
        String select = "from Petition where status = :statusone or status =:statustwo";
        Query query = entityManager.createQuery(select, Petition.class);
        query.setParameter("statusone", Status.TODO);
        query.setParameter("statustwo", Status.IN_PROGRESS);
        List<Petition> petitionList = query.getResultList();
        return petitionList;
    }

    public List<Petition> getAllPetitionForAdmin(){
        String select = "from Petition where status = :status";
        Query query = entityManager.createQuery(select, Petition.class);
        query.setParameter("status", Status.IN_PROGRESS);
        List<Petition> petitionList = query.getResultList();
        return petitionList;
    }

    public Set<User> getAllUserForAdmin(Long id){
        String select = "select p.userPetition from Petition p where p.id = :id";
        Query query = entityManager.createQuery(select);
        query.setParameter("id",id);
        List<User> lists = query.getResultList();
        Set<User> users = new HashSet<>();
        users.addAll(query.getResultList() );
        return users;
    }

}
