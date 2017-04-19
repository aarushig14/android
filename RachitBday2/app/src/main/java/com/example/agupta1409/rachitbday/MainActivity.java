package com.example.agupta1409.rachitbday;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        static ArrayList<FriendsDetails.friend> friendList;
        ListView friendListView;

        FragmentManager manager = getSupportFragmentManager();
        String groupID;

    }
}
