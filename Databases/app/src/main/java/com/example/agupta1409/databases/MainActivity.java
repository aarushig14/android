package com.example.agupta1409.databases;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.agupta1409.databases.db.StudentTable;
import com.example.agupta1409.databases.models.Student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MyDbOpener dbOpener = new MyDbOpener(this);
//
//        SQLiteDatabase myDb = dbOpener.getWritableDatabase();
//

        SQLiteDatabase myDb = MyDbOpener.openWriteableDatabase(this);
        Student stu = new Student(
                2,
                "John Doe",
                5,
                11
        );
        ContentValues values = new ContentValues();
        values.put(StudentTable.Columns.ID,stu.getId());
        values.put(StudentTable.Columns.NAME,stu.getName());
        values.put(StudentTable.Columns.AGE,stu.getAge());
        values.put(StudentTable.Columns.CLASS,stu.getStudentClass());

        myDb.insert(StudentTable.TABLE_NAME,null,values);

        String[] projection = {
            StudentTable.Columns.ID,
            StudentTable.Columns.NAME
        };

        Cursor c = myDb.query(
                StudentTable.TABLE_NAME,
                projection,
                null,null,null,null,null
        );

        Log.d("MainActivity","onCreate: Cursor count : " + c.getCount());

        while(c.moveToNext()) {
            int stuId = c.getInt(c.getColumnIndex(StudentTable.Columns.ID));
            String stuName = c.getString(c.getColumnIndex(StudentTable.Columns.NAME));
            Log.d("MainActivity", "onCreate: student = " + stuId + " " + stuName);
        }

    }
}
