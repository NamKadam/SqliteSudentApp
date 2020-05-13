package com.example.sqliteStudentapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqliteStudentapp.Model.Student;
import com.example.sqliteStudentapp.R;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {

    private List<Student> mArraylistStudent=new ArrayList<>();
    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
       View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new StudentHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
      Student studentList=mArraylistStudent.get(position);
      holder.mTxtName.setText(studentList.getName());
      holder.mTxtrollNo.setText("Roll No : "+studentList.getRollNo());
      holder.mTxtAge.setText("Age : "+studentList.getAge());
      holder.mTxtClass.setText("Class : "+studentList.getClass_name());
    }

    @Override
    public int getItemCount() {
        return mArraylistStudent.size();
    }

    public void setStudents(List<Student> students){
        this.mArraylistStudent=students;
        notifyDataSetChanged();
    }

    class StudentHolder extends RecyclerView.ViewHolder{
        TextView mTxtName,mTxtAge,mTxtrollNo,mTxtClass;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            mTxtName=itemView.findViewById(R.id.studName);
            mTxtrollNo=itemView.findViewById(R.id.studRollNo);
            mTxtAge=itemView.findViewById(R.id.studAge);
            mTxtClass=itemView.findViewById(R.id.studClass);
        }
    }
}
