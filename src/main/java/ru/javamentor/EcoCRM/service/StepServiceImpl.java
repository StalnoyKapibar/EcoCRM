package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.model.Step;

@Service
public class StepServiceImpl extends AbstractServiceImpl<Step> implements StepService {

    public StepServiceImpl(AbstractDao<Step> abstractDao) {
        super(abstractDao);
    }
}
