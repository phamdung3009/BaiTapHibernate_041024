package com.hibernate;

import com.hibernate.model.Student;
import com.hibernate.repository.StudentRepo;
import com.hibernate.service.StudentService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ManageStudent {

    private static SessionFactory factory;

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

    /*public void listStudents() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            List<Student> students = session.createQuery("FROM student").list();
            List<Student> list = (List<Student>) session.createQuery("FROM student").list();

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
        }
    }*/

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

    public static void main(String[] args) {

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        ManageStudent manageStudent = new ManageStudent();

        // add
        Student addStu = new Student("Tran Ngoc Minh", "0989989989");
        /*manageStudent.addStudent(addStu);*/

        // Update
        Student updateStu = new Student(3,"Tran Ngoc Minhhh", "0912345678");
        /*manageStudent.updateStudent(updateStu);*/

        // delete
        /*manageStudent.deleteStudent(4);*/

        // list
        /*manageStudent.listStudents();*/
    }
}
