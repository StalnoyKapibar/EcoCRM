package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.PointDao;
import ru.javamentor.EcoCRM.model.Point;

@Service
public class PointServiceImpl extends AbstractServiceImpl<Point> implements PointService {

    private PointDao pointDao;

    @Autowired
    public PointServiceImpl(PointDao pointDao) {
        this.pointDao = pointDao;
    }

    @Override
    public PointDao getDao() {
        return pointDao;
    }
}
