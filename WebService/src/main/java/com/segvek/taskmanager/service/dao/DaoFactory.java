package com.segvek.taskmanager.service.dao;

import com.segvek.taskmanager.service.model.*;
/**
 *
 * @author Panas
 */
public class DaoFactory {
    private static DaoFactory daofactory = new DaoFactory();
    public static DaoFactory getFactory(){
        return daofactory;
    }
    
    private DaoImpl daoUser = new DaoImpl<>(User.class);

    private DaoFactory() {
    }

    public Dao getDaoUser() {
        return daoUser;
    }
    
}
