package ru.javamentor.EcoCRM.service;

import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.PointDao;
import ru.javamentor.EcoCRM.model.Point;

@Service
public class PointServiceImpl extends AbstractServiceImpl<Point> implements PointService {
    public PointServiceImpl(PointDao pointDao) {
        super(pointDao);
    }

}
