package com.example.sqliteStudentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sqliteStudentapp.Adapter.StudentAdapter;
import com.example.sqliteStudentapp.Model.Student;
import com.example.sqliteStudentapp.ViewModel.StudentViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StudentViewModel studentViewModel;
    private RecyclerView mRecyclStud;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mRecyclStud=findViewById(R.id.stud_recycler);
         mRecyclStud.setLayoutManager(new LinearLayoutManager(this));
         mRecyclStud.setHasFixedSize(true);

         studentAdapter=new StudentAdapter();
         mRecyclStud.setAdapter(studentAdapter);

         studentViewModel= ViewModelProviders.of(this).get(StudentViewModel.class);
         studentViewModel.getAllContacts().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
             studentAdapter.setStudents(students);
            }
        });
    }
}
