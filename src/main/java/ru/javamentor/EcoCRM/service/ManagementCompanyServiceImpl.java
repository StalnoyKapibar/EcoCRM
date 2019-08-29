package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.ManagementCompanyDao;
import ru.javamentor.EcoCRM.model.ManagementCompany;

@Service
public class ManagementCompanyServiceImpl extends AbstractServiceImpl<ManagementCompany> implements ManagementCompanyService {

    private ManagementCompanyDao managementCompanyDao;

    @Autowired
    public ManagementCompanyServiceImpl(ManagementCompanyDao managementCompanyDao) {
        this.managementCompanyDao = managementCompanyDao;
    }

    @Override
    public ManagementCompanyDao getDao() {
        return managementCompanyDao;
    }
}
