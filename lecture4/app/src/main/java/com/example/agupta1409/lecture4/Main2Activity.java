package com.example.agupta1409.lecture4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private EditText et;
    private TextView tv;
    public static final String Key_SecondActivity_Name = "myname";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent received_intent = getIntent();
       String myn = received_intent.getStringExtra(MainActivity.Key_Name);
        ((TextView) findViewById(R.id.textView)).setText("hello" + myn);

        Log.e("MainActivity", "onCreate : ");

    }

    protected void onPause(){
        Intent newIntent = new Intent();
        newIntent.putExtra(Key_SecondActivity_Name,((EditText) findViewById(R.id.editText)).getText().toString());
        setResult(RESULT_OK,newIntent);
        super.onPause();
        Log.e("Main2Activity","onPause:");
    }


    public void onBackPressed(){
        super.onBackPressed();
        Log.e("Main2Activity", "onBackPressed : ");
    }

    protected void onStop(){

        super.onStop();
        Log.e("Main2Activity","onStop:");
    }
}
