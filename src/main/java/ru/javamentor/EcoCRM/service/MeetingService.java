package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.model.Meeting;

import java.time.LocalDate;

public interface MeetingService extends AbstractService<Meeting> {

    Meeting saveMeeting(Long id, String date, Long projectId);
}
