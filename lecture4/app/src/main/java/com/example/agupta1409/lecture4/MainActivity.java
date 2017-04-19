package com.example.agupta1409.lecture4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int Req_SecndActivity_code = 1234 ;
    public static final String Key_Name = "myname";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void gotoSecondActivity(View V){

            EditText et = (EditText) findViewById(R.id.editText);

            Intent i = new Intent(this, Main2Activity.class);
            i.putExtra(Key_Name, et.getText().toString());
            startActivityForResult(i,Req_SecndActivity_code);

            Log.e("MainActivity", "onCreate : ");

//            Intent i = new Intent();
//            i.setAction("android.intent.category.LAUNCHER");
//            i.setClassName("com.facebook.katana","com.facebook.katana");
//            startActivity(i);

            //google
//        Intent i = new Intent();
//            i.setAction(Intent.ACTION_VIEW);
//            i.setData(Uri.parse("http://google.com"));
//            startActivity(i);


    }



    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        Log.d("MainActivity", requestCode+"");
        Log.e("MainActivity", resultCode+"");
        if((requestCode == Req_SecndActivity_code) && (resultCode == RESULT_OK)){
            TextView  tvMainActivity = ((TextView) findViewById(R.id.result_tv));
            tvMainActivity.setText(data.getStringExtra(Main2Activity.Key_SecondActivity_Name));
        }

        Log.e("MainActivity", "onActivityResult : ");
    }

    public void gotoFacebookApp(View V){
        Intent i = new Intent("android.intent.category.LAUNCHER");
//            i.setAction("android.intent.category.LAUNCHER");
            i.setClassName("com.facebook.katana","com.facebook.katana.LoginActivity");
            startActivity(i);

    }
}
