package com.example.agupta1409.hardwaresensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //sampling period while coverting analog into digital

    SensorManager sm;
    private static final String TAG = "mySensor";
    RelativeLayout relativeLayout;
    SensorEventListener sel;
    Sensor accelSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> mySensors = sm.getSensorList(Sensor.TYPE_ALL);

        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);

        for(Sensor sensor:mySensors){
            Log.d(TAG,"name: "+ sensor.getName());
            Log.d(TAG, "vendor: " + sensor.getVendor());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
                Log.d(TAG, "String type: " + sensor.getStringType());
            }
            Log.d(TAG, "onCreate: --------------------------------------------");
        }
        accelSensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // returns best sensor of type accelerometer for that condition or situation(off screen / on screen)


        sel = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
//                event.accuracy
//                event.timestamp = time where event was reported
//                event.values = array of number of values measured by an sensor

                Log.d(TAG, "onSensorChanged: "+ event.values[0]);
                Log.d(TAG, "onSensorChanged: "+event.values[1]);
                Log.d(TAG, "onSensorChanged: "+event.values[2]);
                Log.d(TAG, "onSensorChanged: =================================");
                relativeLayout.setBackgroundColor(Color.rgb(acc2col(event.values[0]),acc2col(event.values[1]),acc2col(event.values[2])));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        sm.registerListener(sel,accelSensor,SensorManager.SENSOR_DELAY_UI);

    }

    int acc2col(float value){
        return (int)((value/24)*255);
    }

    @Override
    protected void onResume() {
        sm.registerListener(sel,accelSensor,SensorManager.SENSOR_DELAY_UI);
        super.onResume();
    }

    @Override
    protected void onPause() {
        sm.unregisterListener(sel);
        super.onPause();
    }
}
