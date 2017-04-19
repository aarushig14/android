package com.example.agupta1409.sharedpreffile;

import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.jar.Manifest;


/*

* #Does not equire permission
*   # API 21 and below
*   /data/data/packagename/
*   # aPI 22 and above
*   /data/user/0/packagename/
*
*   #This is almost always the internal SD card
*   /storage/emulated/0/Android/data/packagename/
* # Requires Permission
*   /storage/emulated/0/....
*
*   #these could be multiple
*   /storage/<devic id>
*

cd*/
public class Main2Activity extends AppCompatActivity {

    public static final String TAG = "Directory";

    EditText et;
    TextView tv;
    Button btn;
    Button btn2;

    AskPerm perm;

    public static final String FILE_NAME = "firstfile";
    public static final String permission = android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et = (EditText) findViewById(R.id.editText);
        tv = (TextView) findViewById(R.id.textView2);
        btn = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);


        Log.d(TAG,"Files Dir " + getFilesDir().getPath());
        Log.d(TAG,"CacheDir " + getCacheDir().getPath());
        try {
            Log.d(TAG, "ExtCacheDir " + getExternalCacheDir().getPath());
            Log.d(TAG, "ExtFilesDir " + getExternalFilesDir(null).getPath());
        }catch (Exception e){
            Log.d(TAG,"onCreate: Could not fetch external directory" + e.getMessage());
        }

        // data/ ke alava saare external storage hote hain

        //storage/emulated/0/...        =>  internal SDCARD
        //storage/emulated/1/...        =>  external SDCARD


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            File[] extFilesDirs = getExternalFilesDirs(null);
            for(File f:extFilesDirs) {
                Log.d(TAG, "SDCARD" + f.getPath());
            }
            // two values if external sd card available
            // three values if otg pd attached
        }

        //above dont need any permission

        Log.d(TAG,"onCreate : " + Environment.getExternalStorageDirectory());
        // we cannot read and write here without special permisssion

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AskPerm.setOnPermissionResult(Main2Activity.this,new AskPerm.onPermissionResult() {
                    @Override
                    public void onGranted(String perm) {
                        Toast.makeText(Main2Activity.this,"Granted",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDenied(String perm) {

                    }
                }, permission);

                writeFile(FILE_NAME,et.getText().toString());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(readFile(FILE_NAME));
            }
        });

        File f = new File("/");
        File[] files = f.listFiles(); //list them all but it doesn't allow cd or give permissions to access ;
        for(File l: files){
            Log.d(TAG,"dmkvnre " + l.getName());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
         AskPerm.onPermissionResult(requestCode,permissions,grantResults);

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void writeFile(String filename, String data){

       File f = new File(getExternalFilesDir(null),filename);
       if(!f.exists()){
           try {
              /* boolean ifFileCreated = */ f.createNewFile();   // returns boolean that if file is created or not
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       FileOutputStream fos = null;
       try {
           fos = new FileOutputStream(f, true);
       }catch (FileNotFoundException e){
           e.printStackTrace();
           return;
       }

       try {
           fos.write(data.getBytes());
       } catch (IOException e) {
           e.printStackTrace();
       }




   }

    public String readFile(String filename){
        File f = new File(getFilesDir(),filename);
        if(!f.exists()){
            return "";
        }
        Log.w(TAG, "readFile: File did not exist"+f.getPath() );

        String data = "";

        try {
            FileInputStream fis = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufread = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String buf = "";
            while((buf = bufread.readLine()) != null){
                sb.append(buf);
            }
            data = sb.toString();
        }  catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
