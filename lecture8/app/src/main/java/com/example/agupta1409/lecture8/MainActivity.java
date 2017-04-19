package com.example.agupta1409.lecture8;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MyLoop loop = new MyLoop();
        MyLoop.LoopDoneListener loopDoneListener = new MyLoop.LoopDoneListener() {
            @Override
            public void onLoopDone() {
                Toast.makeText(MainActivity.this, "lopp is done", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLoopStart() {
                Toast.makeText(MainActivity.this, "lopp starts", Toast.LENGTH_LONG).show();

            }
        };

        loop.setLoopDoneListener(loopDoneListener);

        FragmentCallBack fragment = new FragmentCallBack();
        FragmentCallBack.MyListener myListener = new FragmentCallBack.MyListener() {
            @Override
            public void onCallBack() {
                Toast.makeText(MainActivity.this, "onCreateView called", Toast.LENGTH_LONG).show();
            }
        };
        fragment.setListener(myListener);

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frg);
        FragmentManager mngr = getSupportFragmentManager();
        FragmentTransaction transx = mngr.beginTransaction();
        transx.replace(R.id.frg, fragment);
        transx.commit();


        Button bOne = (Button) findViewById(R.id.button);
        bOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loop.doLoop();
            }
        });
    }
}
