package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.StepDao;
import ru.javamentor.EcoCRM.model.Step;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

import java.util.List;

@Service
public class StepServiceImpl extends AbstractServiceImpl<Step> implements StepService {
    private StepDao stepDao;

    @Autowired
    public StepServiceImpl(StepDao stepDao) {
        this.stepDao = stepDao;
    }

    public StepDao getDao() {
        return stepDao;
    }

}
