package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.PetitionDao;
import ru.javamentor.EcoCRM.model.Petition;

@Service
public class PetitionServiceImpl extends AbstractServiceImpl<Petition> implements PetitionService {
    @Autowired
    public PetitionServiceImpl(PetitionDao petitionDao) {
        super(petitionDao);
    }
}
