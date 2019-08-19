package ru.javamentor.EcoCRM.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
public abstract class AbstractDaoImpl<T> implements AbstractDao<T>{

    @PersistenceContext
    @Autowired
    EntityManager entityManager;
    private Class<T> entityBeanType;

    public AbstractDaoImpl() {
        this.entityBeanType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void delete(T t) {
        entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
    }

    public void update(T t) {
        entityManager.merge(t);
    }

    public T get(long id) {
        return (T)entityManager.find(entityBeanType, id);    }

    public List<T> getAll() {
        return entityManager.createQuery("from" + entityBeanType.getClass().getName()).getResultList();
    }

    public void insert(T t) {
        entityManager.persist(t);
    }

    public T findByFieldNameAndValue(String fieldName,
                                     String fieldValue) {
        Query query = entityManager.createQuery("select * from " + entityBeanType.getClass().getName() + " where :fieldName = :fieldValue");
        return (T)query.getResultList().get(0);
    }
}
