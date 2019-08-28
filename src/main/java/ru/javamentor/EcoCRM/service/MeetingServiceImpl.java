package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.MeetingDao;
import ru.javamentor.EcoCRM.model.Contractor;
import ru.javamentor.EcoCRM.model.ManagementCompany;
import ru.javamentor.EcoCRM.model.Meeting;
import ru.javamentor.EcoCRM.model.Project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MeetingServiceImpl extends AbstractServiceImpl<Meeting> implements MeetingService{

    private MeetingDao meetingDao;

    @Autowired
    private ContractorService contractorService;

    @Autowired
    private ManagementCompanyService managementCompanyService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    public MeetingServiceImpl(MeetingDao meetingDao) {
        this.meetingDao = meetingDao;
    }

    @Override
    public AbstractDao<Meeting> getDao() {
        return meetingDao;
    }

    @Override
    public Meeting saveMeeting(Long id, String date, Long projectId) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        Project project = projectService.get(projectId);
        Contractor contractor = contractorService.get(id);
        ManagementCompany managementCompany = project.getManagementCompany();
        Meeting meeting = new Meeting(contractor, managementCompany, localDate);
        meetingDao.insert(meeting);
        return meeting;
    }

    @Override
    public List<Meeting> getAllByManagementCompany(Long id) {
        ManagementCompany managementCompany = projectService.get(id).getManagementCompany();
        return meetingDao.getAllByManagementCompany(managementCompany.getId());
    }
}
