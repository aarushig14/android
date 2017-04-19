package com.example.agupta1409.lecture8task;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    Button b;
    static TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.button);
        final MyTask task = new MyTask(); // we make it final because we are sending it on thread so it should not change
        task.setcontext(MainActivity.this);

        new AsyncTask<String,Void,Boolean>(){
            @Override
            protected Boolean doInBackground(String... params) {

                return null;
            }
        }.execute();

        tv = (TextView) findViewById(R.id.tv_secUpdate);

        b.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(task.getStatus() != AsyncTask.Status.RUNNING && task.getStatus() != AsyncTask.Status.FINISHED) {
//                     task.execute(new Integer[]{0}));          NO
                     task.execute(10,0,2);  //yes arra apne aap bnayega tumhe array nhi bhejna hai
                 }else{
                     Toast.makeText(MainActivity.this,"task running",Toast.LENGTH_LONG).show();
                 }
             }
         });
    }

    public static void setTV(long timesRun){
        tv.setText(timesRun + "times ran");
    }
}
// Intent Service starts we cannot stop it once running
// Create thread in system only and run our code but not use thread class directly but use well defined mechanism AsyncTask