package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.Authorities;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AuthoritiesDaoImpl implements AuthoritiesDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Authorities getAuthorityByName(String authorityName) {
        Query query = entityManager.createQuery("select a FROM Authorities a where a.authority=:authority", Authorities.class);
        query.setParameter("authority", authorityName);
        return (Authorities) query.getSingleResult();

    }
    //todo marfall codestyle
    @Override
    public Authorities getAuthority(int id) {

        Authorities authority = entityManager.find(Authorities.class, id);
        System.out.println(authority);
        System.out.println("Authority successfully loaded. Authority details: " + authority.getAuthority());
        return authority;
    }

    @Override
    public List<Authorities> listAllAuthorities() {
        List<Authorities> authorityList = entityManager.createQuery("from Authorities").getResultList();
//        for (Authorities authority : authorityList) {
//            System.out.println("AuthorityList:" + authority);
//        }
        return authorityList;
    }
}
