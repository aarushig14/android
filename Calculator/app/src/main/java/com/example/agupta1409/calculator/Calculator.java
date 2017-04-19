package com.example.agupta1409.calculator;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Calculator extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private ArrayList<Double> num_input = new ArrayList<>();
    private ArrayList<Character> Operator_input = new ArrayList<>();
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,add_b,sub_b,multiply_b,divide_b,clear_b,equal_b,dot_b;
    private TextView tvDisplay;
    private EditText etEnter;
    private ImageButton back_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        b0 = (Button) findViewById(R.id.b0);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        clear_b= (Button) findViewById(R.id.clear);
        add_b = (Button) findViewById(R.id.add);
        sub_b = (Button) findViewById(R.id.sub);
        multiply_b = (Button) findViewById(R.id.multiply);
        divide_b = (Button) findViewById(R.id.divide);
        equal_b = (Button) findViewById(R.id.equal);
        dot_b = (Button) findViewById(R.id.dot);
        back_b  = (ImageButton) findViewById(R.id.back);

        etEnter = (EditText) findViewById(R.id.etNumber);
        tvDisplay = (TextView) findViewById(R.id.tvDisplay);


        View.OnClickListener clicklistener = new View.OnClickListener(){

            public void onClick(View v){

                String input = etEnter.getText().toString();
                String add= "0";

            switch(v.getId()){
                case R.id.b0 : add = "0";
                    etEnter.setText(input.concat(add));
                    break;
                case R.id.b1 : add = "1";etEnter.setText(input.concat(add));
                    break;
                case R.id.b2 : add = "2";etEnter.setText(input.concat(add));
                    break;
                case R.id.b3 : add = "3";etEnter.setText(input.concat(add));
                    break;
                case R.id.b4 : add = "4";etEnter.setText(input.concat(add));
                    break;
                case R.id.b5 : add = "5";etEnter.setText(input.concat(add));
                    break;
                case R.id.b6 : add = "6";etEnter.setText(input.concat(add));
                    break;
                case R.id.b7 : add = "7";etEnter.setText(input.concat(add));
                    break;
                case R.id.b8 : add = "8";etEnter.setText(input.concat(add));
                    break;
                case R.id.b9 : add = "9";etEnter.setText(input.concat(add));
                    break;
                case R.id.dot : add = ".";etEnter.setText(input.concat(add));
                    break;
                case R.id.add :add = "+";
                                tvDisplay.setText(etEnter.getText().toString().concat(add));
                                num_input.add(Double.parseDouble(etEnter.getText().toString()));
                                etEnter.setText("");
                                sub_b.setClickable(false);
                                multiply_b.setClickable(false);
                                divide_b.setClickable(false);
                                add_b.setClickable(false);

                    break;
                case R.id.sub : add = "-";
                    tvDisplay.setText(etEnter.getText().toString().concat(add));
                    num_input.add(Double.parseDouble(etEnter.getText().toString()));
                    etEnter.setText("");
                    sub_b.setClickable(false);
                    multiply_b.setClickable(false);
                    divide_b.setClickable(false);
                    add_b.setClickable(false);

                    break;
                case R.id.divide : add = "/";
                    tvDisplay.setText(etEnter.getText().toString().concat(add));
                    num_input.add(Double.parseDouble(etEnter.getText().toString()));
                    etEnter.setText("");
                    sub_b.setClickable(false);
                    multiply_b.setClickable(false);
                    divide_b.setClickable(false);
                    add_b.setClickable(false);

                    break;
                case R.id.multiply : add = "*";
                    tvDisplay.setText(etEnter.getText().toString().concat(add));
                    num_input.add(Double.parseDouble(etEnter.getText().toString()));
                    etEnter.setText("");
                    sub_b.setClickable(false);
                    multiply_b.setClickable(false);
                    divide_b.setClickable(false);
                    add_b.setClickable(false);

                    break;
                case R.id.clear : etEnter.setText("");
                                     tvDisplay.setText("");
                                    num_input.clear();
                                    Operator_input.clear();
                    sub_b.setClickable(true);
                    multiply_b.setClickable(true);
                    divide_b.setClickable(true);
                    add_b.setClickable(true);

                    break;

                case R.id.back :  etEnter.setText(input.substring(0,input.length()-1));
                    break;

                case R.id.equal : String s = tvDisplay.getText().toString();
                                    char c = s.charAt(s.length()-1);
                                    String et = etEnter.getText().toString();
                                    Double sec_num = et==""? 0.0 : Double.parseDouble(etEnter.getText().toString());
                                    num_input.add(sec_num);
                                    tvDisplay.setText(s.concat(et));
                    Double output = 0.0 ;
                                    switch(c){
                                        case '+' : output = num_input.get(0) + num_input.get(1);
                                            break;
                                        case '-' : output = num_input.get(0) - num_input.get(1);
                                            break;
                                        case '*' : output = num_input.get(0) * num_input.get(1);
                                            break;
                                        case '/' :
                                            if(num_input.get(1)!=0){
                                                output = num_input.get(0) / num_input.get(1);
                                            }else{
                                                Log.e(TAG, "onCLick: cannot calculate");
                                                Toast.makeText(Calculator.this,"Cannot Calculate",Toast.LENGTH_LONG).show();
                                            }
                                            break;
                                    }
                    if(output!=0.0){
                    etEnter.setText(output + "");}
                    else{
                        tvDisplay.setText(et);
                        etEnter.setText("");
                        sub_b.setClickable(true);
                        multiply_b.setClickable(true);
                        divide_b.setClickable(true);
                        add_b.setClickable(true);
                        
                    }
                    break;
            }


            }


        };

        b0.setOnClickListener(clicklistener);
        b1.setOnClickListener(clicklistener);
        b2.setOnClickListener(clicklistener);
        b3.setOnClickListener(clicklistener);
        b4.setOnClickListener(clicklistener);
        b5.setOnClickListener(clicklistener);
        b6.setOnClickListener(clicklistener);
        b7.setOnClickListener(clicklistener);
        b8.setOnClickListener(clicklistener);
        b9.setOnClickListener(clicklistener);
        add_b.setOnClickListener(clicklistener);
        sub_b.setOnClickListener(clicklistener);
        multiply_b.setOnClickListener(clicklistener);
        divide_b.setOnClickListener(clicklistener);
        dot_b.setOnClickListener(clicklistener);
        clear_b.setOnClickListener(clicklistener);
        equal_b.setOnClickListener(clicklistener);
        back_b.setOnClickListener(clicklistener);


        Log.e(TAG,"onCreate : has been created");
    }

    protected void onPause(){
        super.onPause();
        Log.e(TAG,"onPause:");

    }

    protected void onResume(){
        super.onResume();
        Log.e(TAG,"onResume:");

    }

    protected void onStop(){
        super.onStop();
        Log.e(TAG,"onStop:");

    }
    protected void onDestroy(){
        super.onDestroy();
        Log.e(TAG,"onDestroy:");

    }
}
