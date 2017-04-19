package com.example.agupta1409.firebasepavana;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIdService extends FirebaseInstanceIdService {

    private static final String TAG = "fbs";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String myToken= FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "onTokenRefresh: "+myToken);

        FirebaseMessaging.getInstance().subscribeToTopic("pandora");
    }
}
