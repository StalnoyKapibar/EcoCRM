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
        return entityManager.find(entityBeanType, id);
    }

    public List<T> getAll() {
        return entityManager.createQuery("from " + entityBeanType.getSimpleName()).getResultList();
    }

    public void insert(T t) {
        entityManager.persist(t);
    }

    public T findByFieldNameAndValue(String fieldName, String fieldValue) {
        Query query = entityManager.createQuery("select t from " + entityBeanType.getSimpleName() + " t where t." + fieldName + "=:fieldValue");
        query.setParameter("fieldValue", fieldValue);
        return (T)query.getResultList().get(0);
    }
}
