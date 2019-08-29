package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.CheckPointDao;
import ru.javamentor.EcoCRM.model.CheckPoint;

import java.util.Date;
import java.util.List;

@Service
public class CheckPointServiceImpl extends AbstractServiceImpl<CheckPoint> implements CheckPointService {

    private CheckPointDao checkPointDao;

    @Autowired
    public CheckPointServiceImpl(CheckPointDao checkPointDao) {
        this.checkPointDao = checkPointDao;
    }

    @Override
    public CheckPointDao getDao() {
        return checkPointDao;
    }

    @Override
    public CheckPoint getCheckPointById(Long id) {
        return checkPointDao.getCheckPointById(id);
    }

    @Override
    public List<CheckPoint> getAllCheckPoints(Long id) {
        return checkPointDao.getAllCheckPoints(id);
    }
}
