package com.example.agupta1409.webndocview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student.Students> student;
    ListView studentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        student=Student.getdata();
        studentListView = (ListView) findViewById(R.id.listView);

        StudentAdapter studentAdapter = new StudentAdapter(student);
        studentListView.setAdapter(studentAdapter);
    }


    class StudentAdapter extends BaseAdapter{

        ArrayList<Student.Students> student;
        public StudentAdapter(ArrayList<Student.Students> student) {
            this.student=student;
        }

        class StudentViewHolder{
            TextView name;
            TextView course;
        }
        @Override
        public int getCount() {
            return student.size();
        }

        @Override
        public Student.Students getItem(int position) {
            return student.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            StudentViewHolder studentViewHolder;
            LayoutInflater li = getLayoutInflater();

            convertView = li.inflate(R.layout.list_item,null);
            studentViewHolder = new StudentViewHolder();

            studentViewHolder.name = (TextView) convertView.findViewById(R.id.name);
            studentViewHolder.course = (TextView) convertView.findViewById(R.id.course);

            convertView.setTag(studentViewHolder);

            Student.Students thisStudent = getItem(position);

            studentViewHolder.name.setText(thisStudent.name);
            studentViewHolder.course.setText(thisStudent.course);

            return convertView;

        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
    }
}
