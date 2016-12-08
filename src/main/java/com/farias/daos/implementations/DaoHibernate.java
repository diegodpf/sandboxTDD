package com.farias.daos.implementations;

import com.farias.daos.contracts.Dao;
import com.farias.models.Entidade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

class DaoHibernate<T extends Entidade> implements Dao<T> {

    protected Class<T> persistedClass;

    @PersistenceContext
    protected EntityManager manager;

    protected CriteriaBuilder builder = manager.getCriteriaBuilder();

    DaoHibernate(Class<T> persistedClass) {
        this.persistedClass = persistedClass;
    }

    public void save(T entity) {
        manager.persist(entity);
    }

    public void update(T entity) {
        manager.merge(entity);
    }

    public void delete(T entity) {
        CriteriaDelete<T> criteria = builder.createCriteriaDelete(persistedClass);
        Root root = criteria.from(persistedClass);
        criteria.where(builder.equal(root.get("id"), entity.getId()));
        manager.createQuery(criteria).executeUpdate();
    }

    public List<T> getAll() {
        CriteriaQuery<T> criteria = builder.createQuery(persistedClass);
        Root root = criteria.from(persistedClass);
        criteria.select(root);
        manager.createQuery(criteria).getResultList();
        return manager.createQuery(criteria).getResultList();
    }

    public T getById(Long id) {
        CriteriaQuery<T> criteria = builder.createQuery(persistedClass);
        Root root = criteria.from(persistedClass);
        criteria.where(builder.equal(root.get("id"), id));
        manager.createQuery(criteria).getResultList();
        return manager.createQuery(criteria).getSingleResult();
    }

}
