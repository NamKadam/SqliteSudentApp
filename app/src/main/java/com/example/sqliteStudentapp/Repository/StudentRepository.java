package com.example.sqliteStudentapp.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.sqliteStudentapp.Database.StudentDatabase;
import com.example.sqliteStudentapp.Interface.StudentDao;
import com.example.sqliteStudentapp.Model.Student;

import java.util.List;

public class StudentRepository {
    private StudentDao studentDao;
    private LiveData<List<Student>> allContacts;

    public StudentRepository(Application application)
    {
        StudentDatabase studentDatabase=StudentDatabase.getInstance(application);
        studentDao=studentDatabase.studentDao();
        allContacts=studentDao.getAllStudentList();
    }

    public LiveData<List<Student>> getAllContacts(){
        return  allContacts;
    }


}
