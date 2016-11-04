package com.segvek.taskmanager.service.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Panas
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties());

        sessionFactory = conf.buildSessionFactory(builder.build());
    }

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
