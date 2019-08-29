package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.ReportDao;
import ru.javamentor.EcoCRM.model.Report;

@Service
public class ReportServiceImpl extends AbstractServiceImpl<Report> implements ReportService {

    private ReportDao reportDao;

    @Autowired
    public ReportServiceImpl(ReportDao reportDao) {
        this.reportDao = reportDao;
    }

    @Override
    public ReportDao getDao() {
        return reportDao;
    }
}
