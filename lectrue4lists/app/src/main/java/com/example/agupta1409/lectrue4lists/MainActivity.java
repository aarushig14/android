package com.example.agupta1409.lectrue4lists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> CourseLists = new ArrayList<>(4);
        CourseLists.add("Crux");
        CourseLists.add("Launchpad");
        CourseLists.add("pandora");
        CourseLists.add("Elixir");

        ListView lv = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, CourseLists);
        lv.setAdapter(adapter);


        lv.setOnClickListener(new AdapterView.OnClickListener(){
            public void onItemClick(AdapterView<?> parent,View view,int position, long id){
                String CourseName = ((TextView) view.findView)
            }
        });
    }
}
