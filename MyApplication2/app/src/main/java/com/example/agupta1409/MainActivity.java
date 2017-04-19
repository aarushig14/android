package com.example.agupta1409;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.agupta1409.myapplication.R;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = "BR";

    BroadcastReceiver myReceiver;
    IntentFilter intentFilter;
    RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (RelativeLayout) findViewById(R.id.activity_main);

        myReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
                        mainLayout.setBackgroundColor(Color.RED);
                }
                if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
                    mainLayout.setBackgroundColor(Color.BLUE);
                }
            }
        };

        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);


//        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
//
//        PendingIntent pi = PendingIntent.getActivity(
//                    this,
//                    111,
//                    new Intent(this,MainActivity.class),
//                    PendingIntent.FLAG_UPDATE_CURRENT
//        );
//
//        Log.d(TAG, "onCreate: " + pi);

//        am.setRepeating(
//                AlarmManager.ELAPSED_REALTIME,
//                SystemClock.elapsedRealtime()+5000,
//                60000,
//                pi
//        );

//        Toast.makeText(this, "Alarm is set", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReceiver);
    }
}
