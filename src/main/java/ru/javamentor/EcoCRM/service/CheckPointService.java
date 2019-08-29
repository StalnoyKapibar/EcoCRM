package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.model.CheckPoint;

import java.util.Date;
import java.util.List;


public interface CheckPointService extends AbstractService<CheckPoint> {

    CheckPoint getCheckPointById(Long id);

    List<CheckPoint> getAllCheckPoints(Long id);
}
