package com.example.agupta1409.databases.models;

/**
 * Created by a.gupta1409 on 12-07-2016.
 */
public class Student {
    int id;
    String name;
    int studentClass;
    int age;

    public Student(int id, String name, int studentClass, int age) {
        this.id = id;
        this.name = name;
        this.studentClass = studentClass;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(int studentClass) {
        this.studentClass = studentClass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
