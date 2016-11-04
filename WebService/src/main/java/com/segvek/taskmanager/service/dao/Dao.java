
package com.segvek.taskmanager.service.dao;

import java.sql.SQLException;
import java.util.List;


public interface Dao<T> {
    public void addEntity(T entity) throws SQLException;
    public void updateEntity(T entity) throws SQLException;
    public List<T> getListEntity() throws SQLException;
    public T getEntity(Long id) throws SQLException;
    public void deleteEntity(T entity) throws SQLException;
}
