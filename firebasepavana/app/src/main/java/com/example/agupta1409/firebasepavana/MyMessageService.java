package com.example.agupta1409.firebasepavana;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyMessageService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d("Service", "onMessageReceived: ");

        String msg;
        if(remoteMessage.getNotification()!=null)
        {
            //for data message
            msg=remoteMessage.getNotification().getBody();
        }

        else if(remoteMessage.getData()!=null){
            //for noyification message
            msg=remoteMessage.getData().get("message");
            NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(this);

            // notifBuilder.setContentText("Some Content").setColor(Color.BLUE).setSubText("Some More Text").setSmallIcon(R.mipmap.ic_launcher);
            //notifBuilder.setContentText("Some Content").setSubText(remoteMessage.getNotification().getBody()).setAutoCancel(true).setColor(Color.BLUE).setSubText("Some More Text").setSmallIcon(R.mipmap.ic_launcher);

                    notifBuilder.setContentText("Some Content").setSubText(msg).setAutoCancel(true).setColor(Color.BLUE).setSubText("Some More Text").setSmallIcon(R.mipmap.ic_launcher);

            PendingIntent pi = PendingIntent.getActivity(this, 123, new Intent(this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
            notifBuilder.setContentIntent(pi);   //what will happen when notification is opened
            notifBuilder.setDeleteIntent(pi);  //what will happen in case notification is delete

            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(234, notifBuilder.build());
        }
    }
}
