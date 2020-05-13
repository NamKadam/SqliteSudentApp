package com.example.sqliteStudentapp.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.sqliteStudentapp.Interface.StudentDao;
import com.example.sqliteStudentapp.Model.Student;
import com.example.sqliteStudentapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Database(entities = {Student.class},version = 1)
public abstract class StudentDatabase extends RoomDatabase {

    private static  StudentDatabase instance;

    public abstract StudentDao studentDao();
    private static Context activity;

    public static  synchronized StudentDatabase getInstance(Context context)
    {
        activity=context.getApplicationContext();
        if(instance==null)
        {
         instance= Room.databaseBuilder(context.getApplicationContext(),
                 StudentDatabase.class,
                 "student_database")
                 .fallbackToDestructiveMigration()
                 .addCallback(roomCallBack)
                 .build();
        }
        return instance;
    }

   private static RoomDatabase.Callback roomCallBack=new RoomDatabase.Callback(){
       @Override
       public void onCreate(@NonNull SupportSQLiteDatabase db) {
           super.onCreate(db);
           new PopulateDbAsynTask(instance).execute();
       }
   };

    private static class PopulateDbAsynTask extends AsyncTask<Void,Void,Void>{
        private StudentDao studentDao;

        private PopulateDbAsynTask(StudentDatabase db){
         studentDao=db.studentDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            studentDao.insert(new Student("Yash","14","6","7th"));
            studentDao.insert(new Student("Pooja","16","7","9th"));
            //to getdata from raw json file
            fillWithStartingData(activity);
            return null;
        }
    }

    private static void fillWithStartingData(Context context)
    {
      StudentDao dao=getInstance(context).studentDao();
      JSONArray stud=loadJSONArray(context);

      try{
        for(int i=0;i<stud.length();i++)
        {
            JSONObject studJson=stud.getJSONObject(i);
            String studName=studJson.getString("name");
            String studRollNo=studJson.getString("roll_no");
            String studAge=studJson.getString("age");
            String studClass=studJson.getString("class");

            dao.insert(new Student(studName,studAge,studRollNo,studClass));
        }
      }catch (JSONException e){
          e.printStackTrace();
      }
    }
    //to get json from json file
    private static JSONArray loadJSONArray(Context context){
     StringBuilder  builder=new StringBuilder();
        InputStream in=context.getResources().openRawResource(R.raw.student);
        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
        String line ;
        try{
       while((line=reader.readLine())!=null){
        builder.append(line);
       }

       JSONObject json=new JSONObject(builder.toString());

       return json.getJSONArray("Student");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
