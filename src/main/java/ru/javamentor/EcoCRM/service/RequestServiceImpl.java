package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.ReportDao;
import ru.javamentor.EcoCRM.dao.RequestDAO;
import ru.javamentor.EcoCRM.model.Report;
import ru.javamentor.EcoCRM.model.Request;

@Service
public class RequestServiceImpl extends AbstractServiceImpl<Request> implements RequestService {

    private RequestDAO requestDao;

    @Autowired
    public RequestServiceImpl(RequestDAO requestDao) {
        this.requestDao = requestDao;
    }

    @Override
    public RequestDAO getDao() {
        return requestDao;
    }
}
