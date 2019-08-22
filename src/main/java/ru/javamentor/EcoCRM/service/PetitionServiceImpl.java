package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.PetitionDao;
import ru.javamentor.EcoCRM.model.Petition;

@Service
public class PetitionServiceImpl extends AbstractServiceImpl<Petition> implements PetitionService {
    private PetitionDao petitionDao;

    @Autowired
    public PetitionServiceImpl(PetitionDao petitionDao) {
        this.petitionDao = petitionDao;
    }

    @Override
    public PetitionDao getDao() {
        return petitionDao;
    }
}
