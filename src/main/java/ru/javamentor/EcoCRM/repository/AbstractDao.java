package ru.javamentor.EcoCRM.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AbstractDao<T> extends CrudRepository<T, Long> {
    @Query(value = "select t from #{#entityName} where :fieldName = :fieldValue")
    T findByFieldNameAndValue(@Param("fieldName") String fieldName,
                              @Param("fieldValue") String fieldValue);
}
