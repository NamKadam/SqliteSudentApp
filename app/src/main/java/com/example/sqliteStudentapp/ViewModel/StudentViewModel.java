package com.example.sqliteStudentapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.sqliteStudentapp.Model.Student;
import com.example.sqliteStudentapp.Repository.StudentRepository;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {
    private StudentRepository studentRepository;
    private LiveData<List<Student>> allContacts;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        studentRepository=new StudentRepository(application);
        allContacts=studentRepository.getAllContacts();
    }

    public LiveData<List<Student>> getAllContacts(){
        return allContacts;
    }
}
