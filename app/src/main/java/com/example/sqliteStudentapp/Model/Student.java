package com.example.sqliteStudentapp.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table")
public class Student {

    public Student(String name, String age, String rollNo, String Class_name) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
        this.Class_name = Class_name;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String age;
    private String rollNo;
    private String Class_name;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getClass_name() {
        return Class_name;
    }

    public void setClass_name(String class_name) {
        Class_name = class_name;
    }
}
