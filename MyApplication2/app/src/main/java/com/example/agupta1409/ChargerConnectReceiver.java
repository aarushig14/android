package com.example.agupta1409;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.agupta1409.myapplication.R;

public class ChargerConnectReceiver extends BroadcastReceiver {

    public static final String TAG = "BR";

    public ChargerConnectReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            Toast.makeText(context, "Power connected", Toast.LENGTH_SHORT).show();
        }
        if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            Toast.makeText(context, "Power disconnected", Toast.LENGTH_SHORT).show();
        }
    }
}
