package ru.javamentor.EcoCRM.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javamentor.EcoCRM.model.Petition;
import ru.javamentor.EcoCRM.service.ProjectService;

import javax.persistence.Query;

@Repository
public class PetitionDaoImpl extends AbstractDaoImpl<Petition> implements PetitionDao {
}
