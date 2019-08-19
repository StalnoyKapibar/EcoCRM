package ru.javamentor.EcoCRM.service;

import java.util.List;

public interface AbstractService<T> {
    void delete(T t);

    void insert(T t);

    void update(T t);

    T get(long id);

    List<T> getAll();
}
