package ru.javamentor.EcoCRM.dao;

import org.springframework.stereotype.Repository;
import ru.javamentor.EcoCRM.model.Petition;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PetitionDaoImpl extends AbstractDaoImpl<Petition> implements PetitionDao {

    @Override
    public List<Petition> getPetitionsFromProjectByUserId(Long id) {
        List<Petition> petitions = entityManager
                .createNativeQuery("select pe.* from (select pr.* from users as u inner join projects as pr on u.id=pr.manager_id where u.id=5) as upr inner join petitions as pe on upr.petition_id=pe.id", Petition.class)
                .getResultList();
        return petitions;
    }
}
