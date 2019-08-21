package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.dao.AbstractDao;

import java.util.List;

public abstract class AbstractServiceImpl<T> implements AbstractService<T>{

    public abstract AbstractDao<T> getDao();

    public void delete(T t) {
        getDao().delete(t);
    }

    public void insert(T t) {
        getDao().insert(t);
    }

    public void update(T t) {
        getDao().update(t);
    }

    public T get(long id) {
        return getDao().get(id);
    }

    public List<T> getAll() {
        return getDao().getAll();
    }
}
