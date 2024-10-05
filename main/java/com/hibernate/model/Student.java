package com.hibernate.model;

public class Student {
    private int id;
    private String nameStudent;
    private String phoneNumber;

    public Student(int id, String nameStudent, String phoneNumber) {
        this.id = id;
        this.nameStudent = nameStudent;
        this.phoneNumber = phoneNumber;
    }

    public Student(String nameStudent, String phoneNumber) {
        this.nameStudent = nameStudent;
        this.phoneNumber = phoneNumber;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
