package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.PhotoDao;
import ru.javamentor.EcoCRM.model.Photo;

@Service
public class PhotoServiceImpl extends AbstractServiceImpl<Photo> implements PhotoService {

    private PhotoDao photoDao;

    @Autowired
    public PhotoServiceImpl(PhotoDao photoDao) {
        this.photoDao = photoDao;
    }

    @Override
    public PhotoDao getDao() {
        return photoDao;
    }
}
