package ru.javamentor.EcoCRM.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.Step;

import javax.persistence.Query;
import java.util.List;

@Repository
public class StepDaoImpl extends AbstractDaoImpl<Step> implements StepDao {
}
