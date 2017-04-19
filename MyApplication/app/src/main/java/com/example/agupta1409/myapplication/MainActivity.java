package com.example.agupta1409.myapplication;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"onCreate: has been called");
        try{
            int i = 10/10;
        }catch(Exception e){
            Log.e(TAG, "onCreate : error");
            e.printStackTrace();
        }
    }



    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy : has been destroyed");
    }

    protected void onPause(){
        super.onPause();
        Log.e(TAG,"onPause : has been Paused");
    }

    protected void onResume(){
        super.onResume();
        Log.e(TAG,"onResume: resumed");
    }

    protected void onStop(){
        super.onStop();
        Log.e(TAG, "onStop: has been stopped");
    }



}
