package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.Meeting;

import java.util.List;

public interface MeetingDao extends AbstractDao<Meeting> {

    List<Meeting> getAllByManagementCompany(Long id);
}
