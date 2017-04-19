package com.example.agupta1409.lecture8task;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by a.gupta1409 on 28-06-2016.
 */
public class MyTask extends AsyncTask<Integer , Float, String> {

    private Activity contxt;
    public void setcontext(Activity cont){
        this.contxt = cont;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Float... values) {
        super.onProgressUpdate(values);
        if(values[0] == (float)1.001){
            ((TextView)contxt.findViewById(R.id.tv_secUpdate)).setText( values[1] + " times ran in 10 seconds.");
        }else {
            ((TextView) contxt.findViewById(R.id.tv_secUpdate)).setText("progress : " + values[0]);
        }
    }

    @Override
    protected String doInBackground(Integer... params) {  // ... means varals : variable number of arguments
        long timesRun=0;
        int i;
        for(i = 0;i<params[0];i++){
            timesRun += loopOneSec();
            publishProgress(((float)i+1)/(params[0]));
        }
        publishProgress((float)1.001,(float)timesRun);
        return "Completed";
    }

    static Long loopOneSec() {
        long timesRun = 0;
        long startTime = SystemClock.uptimeMillis();
        while ((SystemClock.uptimeMillis() - startTime) < 1000) {
            timesRun++;
        }
        return timesRun;
    }


    /*
    private String TAG = "AsyncTask";
    private int a;
    private Activity contxt;
    private TextView tv;

    public void setcontext(Activity cont){
       this.contxt = cont;
    }

    //onPreExecute onPostExecute OnProgress works on the thread jis pr object bnaya tha
    // only doInBackground function works on different thread

    protected void onPreExecute(){ //works on foreground thread
        super.onPreExecute();
        a=10;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Long doInBackground(String... params) { // works on background thread

        if(a==10) {
            //true
        }
        long timesRun = 0;
        for(int i =0;i<a;i++) {

            timesRun+= loopOneSec();
            final long tr = timesRun;
            contxt.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ((TextView)contxt.findViewById(R.id.tv_secUpdate)).setText(tr + " times ran");
                }
            });
            Log.d(TAG,timesRun + " times ran in " + i + " seconds");
        }
        return timesRun;
    }

    static Long loopOneSec(){
        long timesRun = 0;
        long startTime = SystemClock.uptimeMillis();
        while((SystemClock.uptimeMillis()-startTime)<1000){
            timesRun++;
        }

        return timesRun;
    }




    //meanwhile onProgressUpdate

    @Override
    protected void onPostExecute(Long aLong) {  // last call with parameter Result type
        super.onPostExecute(aLong);
        Toast.makeText(contxt,"ran " + aLong + " times",Toast.LENGTH_LONG).show();
        Log.d(TAG,"onPostExecute: ran " + aLong + " times");
    }
    */
}

