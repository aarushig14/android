package com.example.agupta1409.audiomanager;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    AudioManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        am=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
    }



    public void normal(View v)
    {
        if(am.getRingerMode()!=AudioManager.RINGER_MODE_NORMAL)
        {
            am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        }

        else {
        }
    }

    public void vibrate(View v)
    {
        if(am.getRingerMode()!=AudioManager.RINGER_MODE_VIBRATE)
        {
            am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        }

        else {
        }
    }

    public void silent(View v)
    {
        if(am.getRingerMode()!=AudioManager.RINGER_MODE_SILENT)
        {
            am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        }

        else {
        }
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
