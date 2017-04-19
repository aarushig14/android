package com.example.agupta1409.lecture9asynctask;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";
    public MyService() {
    }
//Order of ServiceCycle not very abstract just for some rough idea there is no such lifecycle for service many functions are involved
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate:");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand:");
        int a=1;
        long startTime = SystemClock.uptimeMillis();
        while(SystemClock.uptimeMillis()< startTime+10000){
                Log.d(TAG, "loop running");
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestroy:");
        super.onDestroy();
    }
}
