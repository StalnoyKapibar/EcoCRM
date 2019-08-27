package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.ContractorDao;
import ru.javamentor.EcoCRM.model.Contractor;

@Service
public class ContractorServiceImpl extends AbstractServiceImpl<Contractor> implements ContractorService {

    private ContractorDao contractorDao;

    @Autowired
    public ContractorServiceImpl(ContractorDao contractorDao) {
        this.contractorDao = contractorDao;
    }

    @Override
    public AbstractDao<Contractor> getDao() {
        return contractorDao;
    }
}
