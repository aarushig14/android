package com.example.agupta1409.audioplayer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv;

    List<String> path,name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listView);

        path=new ArrayList<>();
        name=new ArrayList<>();
        Cursor c=getContentResolver().query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI,null,null,null,null);
        c.moveToFirst();
        do {
            path.add(c.getString(c.getColumnIndex(MediaStore.Audio.Media.DATA)));
            name.add(c.getString(c.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)));
        }while(c.moveToNext());

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                SharedPreferences sp=getSharedPreferences("song",MODE_PRIVATE);
                SharedPreferences.Editor ed=sp.edit();
                ed.putString("path", path.get(position));
                ed.commit();

                //activity navigation
                Intent i=new Intent(MainActivity.this,MyPlayer.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
