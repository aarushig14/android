package com.example.agupta1409.lecture3;

import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private EditText etVarOne, etVarTwo;
    private Button Add,Sub,Multiply,Divide;
    private TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etVarOne = (EditText) findViewById(R.id.et_var_one);
        etVarTwo=  (EditText) findViewById(R.id.et_var_two);

        Add = (Button) findViewById(R.id.button);
        Sub = (Button) findViewById(R.id.button2);
        Multiply = (Button) findViewById(R.id.button3);
        Divide = (Button) findViewById(R.id.button4);

        Result = (TextView) findViewById(R.id.textView3);

       View.OnClickListener clicklistener = (
                new View.OnClickListener(){
            @Override
            public void onClick(View v){

//                if(etVarOne.getText().toString().isEmpty()){
//
//                }

                try {
                    int i = etVarOne.getText().toString().isEmpty() ? 0 : Integer.parseInt(etVarOne.getText().toString());
                    int j = etVarTwo.getText().toString().isEmpty() ? 0 : Integer.parseInt(etVarTwo.getText().toString());

                    int result=0;
                    switch(v.getId()){
                        case R.id.button :
                            result = i+j;
                            break;
                        case R.id.button2: result = i-j;
                            break;
                        case R.id.button3: result = i*j;
                            break;
                        case R.id.button4: result = i/j;
                            break;
                    }


                    Result.setText(String.valueOf(result));
                }catch(NumberFormatException e){
                    Log.e(TAG, "onClick: Numbers are not int",e);
                    Toast.makeText(MainActivity.this,"Numbers are not integer",Toast.LENGTH_SHORT).show();
                }catch(ArithmeticException e){
                    Log.e(TAG, "onClick: Numbers are not correct",e);
                    Toast.makeText(MainActivity.this,"Cannot calculate",Toast.LENGTH_SHORT).show();
                }

            }
        });

        Add.setOnClickListener(clicklistener);
        Sub.setOnClickListener(clicklistener);
        Multiply.setOnClickListener(clicklistener);
        Divide.setOnClickListener(clicklistener);




        Log.d(TAG,"onCreate: has been called");
//        try{
//            int i = 10/10;
//        }catch(Exception e){
//            Log.e(TAG, "onCreate : error");
//            e.printStackTrace();
//        }
    }



    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy : has been destroyed");
    }

    protected void onPause(){
        super.onPause();
        Log.e(TAG,"onPause : has been Paused");
    }

    protected void onResume(){
        super.onResume();
        Log.e(TAG,"onResume: resumed");
    }

    protected void onStop(){
        super.onStop();
        Log.e(TAG, "onStop: has been stopped");
    }
}
