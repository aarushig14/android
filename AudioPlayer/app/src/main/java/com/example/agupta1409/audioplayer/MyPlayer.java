package com.example.agupta1409.audioplayer;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;

public class MyPlayer extends AppCompatActivity {
    final MediaPlayer mp=new MediaPlayer();
    SharedPreferences sp;
    String path="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_player);
       sp=getSharedPreferences("song",MODE_PRIVATE);
        path=sp.getString("path", "no value found");
        try {
            mp.setDataSource(path);
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play(View v)
    {
        mp.start();
    }

    public void pause(View v)
    {
        mp.pause();
    }

    public void stop(View v)
    {
        mp.stop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_player, menu);
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
