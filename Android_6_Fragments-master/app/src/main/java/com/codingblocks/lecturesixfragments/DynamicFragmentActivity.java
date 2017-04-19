package com.codingblocks.lecturesixfragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DynamicFragmentActivity extends AppCompatActivity {

    public static final String TAG="DynAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);


        final FirstFragment fragOne = new FirstFragment();
        final SecondFragment fragTwo = new SecondFragment();

        fragOne.setOnCreateViewCalledListener(new FirstFragment.OnCreateViewCalledListener(){
            @Override
            public void onCreateViewCalled(){
                Log.d(TAG,"onCreateViewCalled: ");
            }
        });

        final FragmentManager fragMgr = getSupportFragmentManager();

        FragmentTransaction fragTxn = fragMgr.beginTransaction();
        fragTxn.add(R.id.fragment_container, fragOne, null);
        fragTxn.commit();

        Button bOne = (Button) findViewById(R.id.button_one);
        Button bTwo = (Button) findViewById(R.id.button_two);

        bOne.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {//Long Click neeche vaale k paas chala jayega consume nahi hua abhi event
                return false;
            }
        });

        bOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//onCLick sabse upr vaale view pr jyega with higher z index
                FragmentTransaction fTxn = fragMgr.beginTransaction();
                fTxn.replace(R.id.fragment_container, fragOne, null);
                fTxn.commit();
            }
        });

        bTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTxn = fragMgr.beginTransaction();
                fTxn.replace(R.id.fragment_container, fragTwo, null);
                fTxn.commit();
            }
        });
    }

        public void showToast(){
            Toast.makeText(this,"show this toast",Toast.LENGTH_SHORT).show();
        }
}
