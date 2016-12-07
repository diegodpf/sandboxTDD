package com.farias.daos.contracts;

import java.util.List;

public interface Dao<T> {

    void save(T entity);
    void update(T entity);
    void delete(T entity);
    List<T> getAll();
    T getById(Long id);

}
