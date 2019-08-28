package ru.javamentor.EcoCRM.dao;

import org.springframework.stereotype.Repository;
import ru.javamentor.EcoCRM.model.Meeting;

import java.util.List;

@Repository
public class MeetingDaoImpl extends AbstractDaoImpl<Meeting> implements MeetingDao{

    public List<Meeting> getAllByManagementCompany(Long id) {
        return entityManager.createQuery("select m from Meeting m where m.managementCompany.id=:id", Meeting.class).setParameter("id", id).getResultList();
    }
}
