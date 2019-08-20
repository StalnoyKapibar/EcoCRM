package ru.javamentor.EcoCRM.service;

import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.ContractorDao;
import ru.javamentor.EcoCRM.model.Contractor;

@Service
public class ContractorServiceImpl extends AbstractServiceImpl<Contractor> implements ContractorService {
    public ContractorServiceImpl(ContractorDao contractorDao) {
        super(contractorDao);
    }
}
