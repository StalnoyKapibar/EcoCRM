package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.model.CheckPoint;


public interface CheckPointService extends AbstractService<CheckPoint> {

    CheckPoint getCheckPointById(Long id);
}
