package com.example.sqliteStudentapp.Interface;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.sqliteStudentapp.Model.Student;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert
    void insert(Student student);



    @Query("Select * FROM student_table ORDER BY rollNo ASC")
    LiveData<List<Student>> getAllStudentList();
}
