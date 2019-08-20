package ru.javamentor.EcoCRM.service;

import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.ManagementCompanyDao;
import ru.javamentor.EcoCRM.model.ManagementCompany;

@Service
public class ManagementCompanyServiceImpl extends AbstractServiceImpl<ManagementCompany> implements ManagementCompanyService {
    public ManagementCompanyServiceImpl(ManagementCompanyDao managementCompanyDao) {
        super(managementCompanyDao);
    }
}
