package com.example.agupta1409.pushmsg;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by a.gupta1409 on 28-07-2016.
 */
public class IdService extends FirebaseInstanceIdService {

public static final String TAG = "IdService";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        Log.d(TAG,"onTokenService: ");
    }

    public IdService() {
        super();
        Log.d(TAG,"IdService: ");
    }
}
