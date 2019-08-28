package ru.javamentor.EcoCRM.dao;

import ru.javamentor.EcoCRM.model.CheckPoint;

public interface CheckPointDao extends AbstractDao<CheckPoint> {

    CheckPoint getCheckPointById(Long id);
}
