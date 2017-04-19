package com.example.agupta1409.lecture9asynctask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startButton,stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.start_button);
        stopButton = (Button) findViewById(R.id.stop_button);

        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                My2IntentService.startActionFoo(MainActivity.this,"par1","par2");
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                My2IntentService.startActionBaz(MainActivity.this,"par1","par2");
            }
        });

    }
}
