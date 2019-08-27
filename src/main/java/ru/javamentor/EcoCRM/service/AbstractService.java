package ru.javamentor.EcoCRM.service;

import ru.javamentor.EcoCRM.dao.AbstractDao;

import java.util.List;

public interface AbstractService<T> {

    AbstractDao<T> getDao();

    void delete(T t);

    void insert(T t);

    void update(T t);

    T get(long id);

    List<T> getAll();
}
