package com.example.agupta1409.lecture8;

import android.os.SystemClock;
import android.util.Log;

/**
 * Created by a.gupta1409 on 28-06-2016.
 */
public class MyLoop {

    private LoopDoneListener ldl;
    public void setLoopDoneListener (LoopDoneListener doneListener){
        ldl = doneListener;
    }

    public void doLoop(){
       long startTime = SystemClock.uptimeMillis();
        Log.d("time:",startTime+"");
        while((SystemClock.uptimeMillis() - startTime) < 10000){

        }
        Log.d("time:",SystemClock.uptimeMillis()+"LoopDone");
        ldl.onLoopStart();
        ldl.onLoopDone();
    }

    public interface LoopDoneListener {
        void onLoopStart();
        void onLoopDone();
    }

}
