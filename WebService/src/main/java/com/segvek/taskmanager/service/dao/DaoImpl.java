package com.segvek.taskmanager.service.dao;

import com.segvek.taskmanager.service.util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;

public class DaoImpl<T> implements Dao<T> {

    Class<T> type;
    Session session;

    public DaoImpl(Class<T> type) {
        this.type = type;
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public DaoImpl(Class<T> type, Session session) {
        this.type = type;
        this.session = session;
    }

    @Override
    public void addEntity(T entity) throws SQLException {
        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEntity(T entity) throws SQLException {
        try {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> getListEntity() throws SQLException {
        List<T> list = null;
        try {
            session.beginTransaction();
            list = session.createCriteria(type).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public T getEntity(Long id) throws SQLException {
        T result = null;
        try {
            session.beginTransaction();
            result = (T) session.get(type, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void deleteEntity(T entity) throws SQLException {
        try {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeSession(){
        session.close();
    }
}
