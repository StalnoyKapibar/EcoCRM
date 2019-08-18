package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.dao.AbstractDao;

import java.util.List;

public abstract class AbstractService<T> {
    private AbstractDao<T> abstractDao;

    public void delete(T t) {
        abstractDao.delete(t);
    }

    public void insert(T t) {
        abstractDao.insert(t);
    }

    public void update(T t) {
        abstractDao.update(t);
    }

    public T get(long id) {
        return abstractDao.get(id);
    }

    public List<T> getAll() {
        return abstractDao.getAll();
    }

}
