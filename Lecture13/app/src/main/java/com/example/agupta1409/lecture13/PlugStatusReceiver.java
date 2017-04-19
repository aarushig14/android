package com.example.agupta1409.lecture13;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class PlugStatusReceiver extends BroadcastReceiver {
    public static final String TAG = "PSR";
    public static final String STATUS = "status";
    public static final String CHARGEPLUG = "chargePlug";

    public PlugStatusReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

                Log.d(TAG,"onReceiver: " + intent.getAction());
//                int status =intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
//                int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
                Intent i = new Intent(context,BatteryMonitorService.class);
//                i.putExtra(STATUS,status);
//                i.putExtra(CHARGEPLUG,chargePlug);
                context.startService(i);

    }
}
