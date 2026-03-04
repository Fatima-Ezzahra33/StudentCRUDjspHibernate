package com.ensa.studentcrudhibernate.util;


import com.ensa.studentcrudhibernate.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        return new Configuration()
                .addAnnotatedClass(Student.class)
                // Read connection from persistence.xml / system properties
                .setProperty("jakarta.persistence.jdbc.driver",   "com.mysql.cj.jdbc.Driver")
                .setProperty("jakarta.persistence.jdbc.url",      "jdbc:mysql://localhost:3306/studentdb")
                .setProperty("jakarta.persistence.jdbc.user",     "root")
                .setProperty("jakarta.persistence.jdbc.password", "yourpassword")
                .setProperty("hibernate.dialect",                 "org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.hbm2ddl.auto",            "update")
                .setProperty("hibernate.show_sql",                "true")
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() { return sessionFactory; }
}