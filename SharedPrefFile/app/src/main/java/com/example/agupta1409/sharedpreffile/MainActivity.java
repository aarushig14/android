package com.example.agupta1409.sharedpreffile;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_REF = "result";
    public static final String PREF_REF = "My_Pref";
    EditText et1;
    EditText et2;
    TextView tv1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SharedPreferences sPref = getSharedPreferences("My_Pref",MODE_PRIVATE);

        et1 = (EditText) findViewById(R.id.et_1);
        et2 = (EditText) findViewById(R.id.et_2);
        btn = (Button) findViewById(R.id.btn);
        tv1 = (TextView) findViewById(R.id.tv1);

        tv1.setText(String.valueOf(sPref.getInt("result",0)));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = (Integer.parseInt(String.valueOf(et1.getText()))+Integer.parseInt(String.valueOf(et2.getText())));
                tv1.setText(result+"");


                SharedPreferences.Editor prefEditor = sPref.edit(); //prefEditor writeable copy in the file // save in RAM
                prefEditor.putInt("result",result);
                // add all changes in RAM more efficient than wriing files on Disk everytime
                prefEditor.apply();     // Save on DISK
            }
        });

    }
}
