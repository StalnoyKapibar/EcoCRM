package ru.javamentor.EcoCRM.service;

import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.ReportDao;
import ru.javamentor.EcoCRM.model.Report;

@Service
public class ReportServiceImpl extends AbstractServiceImpl<Report> implements ReportService {
    public ReportServiceImpl(ReportDao reportDao) {
        super(reportDao);
    }
}
