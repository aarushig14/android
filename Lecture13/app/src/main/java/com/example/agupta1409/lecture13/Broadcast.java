package com.example.agupta1409.lecture13;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by a.gupta1409 on 14-07-2016.
 */
public class Broadcast extends BroadcastReceiver {

    public static final String TAG = "MyReceiver";
    public Broadcast(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceiver: " + intent.getAction()
        + "\n" + intent.getDataString()
        + "\n" + intent.getStringExtra(TelephonyManager.EXTRA_STATE));
    }
}
