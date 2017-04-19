package com.example.agupta1409.pager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Congo extends AppCompatActivity {


    ImageView image;
    TextView tvName;
    int resId;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congo);

        Intent receivedIntent = getIntent();
        resId = receivedIntent.getIntExtra("Position",-1);
        name = receivedIntent.getStringExtra("Name");

        ArrayList<Wishers.Person> list = Wishers.getList();
        image = (ImageView) findViewById(R.id.image_correct);
        tvName = (TextView) findViewById(R.id.tv_name_guessed);

        if(resId != -1) {
            image.setImageResource(resId);
            tvName.setText(name);
        }
    }
}
