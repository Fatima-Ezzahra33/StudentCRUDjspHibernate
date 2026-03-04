package com.ensa.studentcrudhibernate.dao;

import com.ensa.studentcrudhibernate.model.Student;
import com.ensa.studentcrudhibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class StudentDAO {

    public void save(Student s) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(s);
            tx.commit();
        }
    }

    public void update(Student s) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(s);
            tx.commit();
        }
    }

    public void delete(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Student s = session.get(Student.class, id);
            if (s != null) session.remove(s);
            tx.commit();
        }
    }

    public Student getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Student.class, id);
        }
    }

    public List<Student> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        }
    }
}