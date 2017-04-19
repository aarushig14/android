package com.example.agupta1409.zappin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Intent i = new Intent(com.android.music.musicservicecommand);
    }
}
