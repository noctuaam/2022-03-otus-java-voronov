package ru.otus.hibernate.repository;

import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public interface DataTemplate<T> {
    Optional<T> findById(Session session, long id);

    Optional<T> findOneByField(Session session, String entityFieldName, Object entityFieldValue);

    List<T> findByEntityField(Session session, String entityFieldName, Object entityFieldValue);

    List<T> findAll(Session session);

    void insert(Session session, T object);

    void update(Session session, T object);
}
