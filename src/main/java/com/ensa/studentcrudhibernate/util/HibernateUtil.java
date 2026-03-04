package com.ensa.studentcrudhibernate.util;

import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;

public class HibernateUtil {
    private static final SessionFactory sessionFactory =
            Persistence.createEntityManagerFactory("default")
                    .unwrap(SessionFactory.class);

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}