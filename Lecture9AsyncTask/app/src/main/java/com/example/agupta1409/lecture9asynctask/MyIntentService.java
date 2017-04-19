package com.example.agupta1409.lecture9asynctask;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    private static final String TAG = "MyIntentService";
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String ACTION_FOO = "com.example.agupta1409.lecture9asynctask.action.FOO";
    public static final String ACTION_BAZ = "com.example.agupta1409.lecture9asynctask.action.BAZ";

    // TODO: Rename parameters


    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Log.d(TAG,"startActionFoo");
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_FOO);
        context.startService(intent);

    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Log.d(TAG,"startActionBaz");
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_BAZ);

        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {

                handleActionFoo();
            } else if (ACTION_BAZ.equals(action)) {

                handleActionBaz();
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo() {
        // TODO: Handle action Foo
        Log.d(TAG,"handleActionFoo");
        long startTime = SystemClock.uptimeMillis();
        while(SystemClock.uptimeMillis()< startTime+10000){
            Log.d(TAG, "loop running");
        }
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz() {
        Log.d(TAG,"handleActionBaz");
        // TODO: Handle action Baz
        long startTime = SystemClock.uptimeMillis();
        while(SystemClock.uptimeMillis()< startTime+10000){
            Log.d(TAG, "loop running");
        }
    }
}
