package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.CheckPoint;

import java.util.Date;
import java.util.List;

public interface CheckPointDao extends AbstractDao<CheckPoint> {

    CheckPoint getCheckPointById(Long id);
    List<CheckPoint> getAllCheckPoints(Long id);
}
