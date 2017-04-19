package com.example.agupta1409.lecture13;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class BatteryMonitorService extends Service {
    public static final String TAG = "BMS";
    int status,chargePlug;
    Context ctx;

    public BatteryMonitorService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        Log.d(TAG,"onStartCommand : "
//                + intent.getAction() + "\n"
//                + "status = " + intent.getIntExtra(PlugStatusReceiver.STATUS,-1)
//                + "\n" + "chargePlug = " + intent.getIntExtra(PlugStatusReceiver.CHARGEPLUG,-1)
//                );

        Toast.makeText(BatteryMonitorService.this, "Plug State Changed", Toast.LENGTH_SHORT).show();

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
