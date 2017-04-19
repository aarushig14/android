package com.example.agupta1409.lectureten;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDownload;
    TextView evName,evType,evLoc,evTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDownload = (Button) findViewById(R.id.button_net);
        evName = (TextView) findViewById(R.id.eventName);
        evTopic = (TextView) findViewById(R.id.eventTopic);
        evLoc = (TextView) findViewById(R.id.eventLoc);
        evType = (TextView) findViewById(R.id.eventType);


        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkConnection();
            }
        });
    }


//        NetFetchTask myTask = new NetFetchTask(tv);

    public void checkConnection() {
        ConnectivityManager cMGr = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cMGr.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
//            NetFetchTask myTask = new NetFetchTask(new NetFetchTask.PostExecuteListener() {
            NetFetchTaskEvents myTask = new NetFetchTaskEvents(new NetFetchTaskEvents.PostExecuteListener(){
                @Override
                public void postExecuteDone(Events ev) {
                    if (ev != null) {
                        evName.setText(ev.getName());
                        evLoc.setText(ev.getLocation());
                        evTopic.setText(ev.getTopic());
                        evType.setText(ev.getType());
//                    tv1.setText(string);
//                    Toast.makeText(MainActivity.this, "Response is" + respCode, Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(MainActivity.this, "FDVwervwrev", Toast.LENGTH_SHORT).show();
                    }
                }
            });

                myTask.execute("http://open-event.herokuapp.com/api/v2/events/4");

        } else {
            Toast.makeText(MainActivity.this, "Internet not connected", Toast.LENGTH_LONG).show();
        }
    }

}
