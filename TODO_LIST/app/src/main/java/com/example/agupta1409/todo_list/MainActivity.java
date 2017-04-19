package com.example.agupta1409.todo_list;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.agupta1409.todo_list.db.ToDo_Table;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    EditText et_new_task,et_date;
    Button btnCLR,btnADD;
    ListView listView;
    ArrayList<String> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase myDb = MyDbOpener.getWritableDatabase(this);
        et_new_task = (EditText) findViewById(R.id.et_add_event);
        et_date = (EditText) findViewById(R.id.et_add_date);
        btnADD = (Button) findViewById(R.id.button_add);
        btnCLR = (Button) findViewById(R.id.button_clear);

        final SQLiteDatabase myDatabase = MyDbOpener.getWritableDatabase(this);
        String[] PROJECTION = {
                ToDo_Table.Columns.ID,
                ToDo_Table.Columns.TASK_NAME,
                ToDo_Table.Columns.DATE_ADDED,
                ToDo_Table.Columns.STATUS
        };

        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put(ToDo_Table.Columns.TASK_NAME,et_new_task.getText().toString());
                values.put(ToDo_Table.Columns.DATE_ADDED,et_date.getText().toString() );
                myDatabase.insert(ToDo_Table.TABLE_NAME,null,values);
           }
        });

        Cursor c = myDatabase.query(
                ToDo_Table.TABLE_NAME,
                PROJECTION,
                null,null,null,null,ToDo_Table.Columns.DATE_ADDED
        );

        TaskAdapter adapter = new TaskAdapter(c);
        listView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    public class TaskAdapter extends BaseAdapter{

        private Cursor c;

        public class ViewHolder{
            TextView task;
        }

        public TaskAdapter(Cursor c) {
            this.c = c;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater li = getLayoutInflater();
            ViewHolder holder;

            if(convertView == null){
                holder = new ViewHolder();
                holder.task = (TextView) convertView.findViewById(android.R.id.text1);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }

            c.moveToPosition(position);
            String taskName = c.getString(c.getColumnIndex(ToDo_Table.Columns.TASK_NAME));
            String status = c.getString(c.getColumnIndex(ToDo_Table.Columns.STATUS));
            holder.task.setText(taskName);
            if(status.equals("done")){
                holder.task.setTextColor(Color.LTGRAY);
            }else{
                holder.task.setTextColor(Color.BLACK);
            }

            return convertView;
        }

        @Override
        public long getItemId(int position) {
            c.moveToPosition(position);
            return c.getInt(c.getColumnIndex(ToDo_Table.Columns.ID));
        }


        @Override
        public Object getItem(int position) {
            return c.moveToPosition(position);
        }

        @Override
        public int getCount() {
            return c.getCount();
        }
    }


}
