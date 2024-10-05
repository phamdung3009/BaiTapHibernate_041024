package com.hibernate.service;

import com.hibernate.model.Employee;
import com.hibernate.model.Student;
import com.hibernate.repository.StudentRepo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentService implements StudentRepo {

    private static SessionFactory factory;

    @Override
    public void addStudent(Student student) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void listStudents() {
        /*Session session = factory.openSession();
        Transaction tx = null;
        try {
            List<Student> students = session.createQuery("FROM student").list();
            for (Student student : students) {
                System.out.print("Name Student: " + student.getNameStudent());
                System.out.print("Phone Number: " + student.getPhoneNumber());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }*/
    }

    @Override
    public void updateStudent(Student student) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Student stu = (Student) session.get(Student.class, student.getId());
            stu.setNameStudent(student.getNameStudent());
            stu.setPhoneNumber(student.getPhoneNumber());
            session.update(stu);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteStudent(Integer id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Student stu = (Student) session.get(Student.class, id);
            session.delete(stu);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
