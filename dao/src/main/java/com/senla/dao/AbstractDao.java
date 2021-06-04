package com.senla.dao;


import com.senla.api.dao.GenericDao;

import com.senla.model.AEntity;
import lombok.extern.log4j.Log4j;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Log4j
public abstract class AbstractDao<T extends AEntity> implements GenericDao<T> {


    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    protected EntityManager entityManager;


    @Override
    public void save(T entity) {
        entityManager.persist(entity);

    }

    @Override
    public T getById(Integer id) {
        return entityManager.find(getClazz(), id);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(getClazz());
        Root<T> rootEntry = cq.from(getClazz());
        CriteriaQuery<T> all = cq.select(rootEntry);

        TypedQuery<T> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    protected abstract Class<T> getClazz();


}
