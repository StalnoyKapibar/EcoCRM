package ru.javamentor.EcoCRM.dao;

import java.util.List;

public interface AbstractDao<T> {
    void delete(T t);
    void update(T t);
    T get(long id) ;
    List<T> getAll() ;
    void insert(T t);
    T findByFieldNameAndValue(String fieldName, String fieldValue);
}
