package org.company.dao;

import org.company.config.HibernateConfiguration;
import org.company.entity.Gender;
import org.company.entity.Student;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {

    public Student getById(Integer id) {
        Transaction transaction = null;
        Student student = null;
        Session session = null;
        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            student = (Student) session.get(Student.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null)
                session.close();

        }
        return student;

    }


    public void save(Student student) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null)
                session.close();

        }

    }


    public void update(Student student) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();


            SQLQuery sqlQuery = session
                    .createSQLQuery("UPDATE Student set name= :name, surname = :surname,age= :age WHERE id = :id");
            sqlQuery.setParameter("id", student.getId());
            sqlQuery.setParameter("name", student.getName());
            sqlQuery.setParameter("surname", student.getSurname());
            sqlQuery.setParameter("age", student.getAge());
            sqlQuery.executeUpdate();

            transaction.commit();


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null)
                session.close();

        }

    }

    public void delete(Integer id) {
        Transaction transaction = null;
        Student student = null;
        Session session = null;
        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            student = (Student) session.get(Student.class, id);
            session.save(student);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null)
                session.close();

        }


    }

}
