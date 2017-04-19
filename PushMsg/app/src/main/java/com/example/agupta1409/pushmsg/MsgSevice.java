package com.example.agupta1409.pushmsg;

import android.util.Log;
import android.view.textservice.TextServicesManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by a.gupta1409 on 28-07-2016.
 */
public class MsgSevice extends FirebaseMessagingService {
    public static final String TAG = "MsgService";

    public MsgSevice() {
        super();
        Log.d(TAG,"MsgService : ");
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG,"onMsgRecieved : ");
        Map<String,String> msgData = remoteMessage.getData();
        for(String s : msgData.keySet()){
            Log.d(TAG,"onMessageRecieved : "  + s + ":" + msgData.get(s));
        }

    }
}
