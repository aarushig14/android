package com.example.agupta1409.lecture13;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainAct";
    BroadcastReceiver otherReceiver;
    IntentFilter intentFilter;
    TextView textView,tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        textView = (TextView) findViewById(R.id.textView);
//        tv = (TextView) findViewById(R.id.tv);
//
//
//        otherReceiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                Toast.makeText(MainActivity.this,
//                        "Battery state changed ",
//                        Toast.LENGTH_SHORT).show();
//                int status =intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
//                int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
//                setChargeState(status);
//                setChargeSource(chargePlug);
//            }
//        };
//
//        intentFilter = new IntentFilter();
//        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
//
//        registerReceiver(otherReceiver,intentFilter);
    }

//    public void setChargeState(int status) {
//        if (status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL) {
//            textView.setText("Charging");
//            textView.setTextColor(Color.GREEN);
//            tv.setVisibility(View.VISIBLE);
//        } else {
//            textView.setText("Discharging");
//            textView.setTextColor(Color.RED);
//            tv.setVisibility(View.INVISIBLE);
//
//        }
//    }
//
//    public void setChargeSource(int chargePlug){
//        if(chargePlug == BatteryManager.BATTERY_PLUGGED_USB) {
//            tv.setText("Source: USB");
//        }
//        if( chargePlug == BatteryManager.BATTERY_PLUGGED_AC){
//            tv.setText("Source: AC");
//        }
//    }
//
//
//    /**
//     * Dispatch onPause() to fragments.
//     */
//    @Override
//    protected void onResume() {
//        registerReceiver(otherReceiver,intentFilter);
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        unregisterReceiver(otherReceiver);
//        super.onPause();
//    }
}
