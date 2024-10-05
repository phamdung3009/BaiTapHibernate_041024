package com.hibernate.repository;

import com.hibernate.model.Student;

public interface StudentRepo {
    void addStudent(Student student);

    void listStudents();

    void updateStudent(Student student);

    void deleteStudent(Integer id);
}
