package com.farias.daos.contracts;

import com.farias.models.Entidade;

import java.util.List;

public interface Dao<T extends Entidade> {

    void save(T entity);
    void update(T entity);
    void delete(T entity);
    List<T> getAll();
    T getById(Long id);

}
