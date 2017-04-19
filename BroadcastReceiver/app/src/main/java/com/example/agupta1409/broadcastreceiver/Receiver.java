package com.example.agupta1409.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by a.gupta1409 on 18-10-2015.
 */

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String number=intent.getExtras().getString(Intent.EXTRA_PHONE_NUMBER).toString();
        if(null!=number)
        {
            setResultData(9650545845);
            Toast.makeText(context,"pagal ho kya!!",Toast.LENGTH_LONG).show();
        }
    }
}
