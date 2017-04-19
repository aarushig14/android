package com.example.agupta1409.runtimepermissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String[] reqPerms = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    Button btnWriteFile;

    static int REQ_CODE_STORAGE_PERM = 445;

    public static final String TAG = "RuntimePermission";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWriteFile = (Button) findViewById(R.id.btn_write_file);

        btnWriteFile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (hasWritePerm()) {
                    writeMyFile();
                }else{
                    askWritePerm();
                }
            }

        });
//        int permStatus = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);
//            switch (permStatus){
//                case (PackageManager.PERMISSION_GRANTED) :
//                    Log.d(TAG,"onCreate : permission granted");
//                    break;
//                case (PackageManager.PERMISSION_DENIED) :
//                    Log.d(TAG,"onCreate : permission denied");
//                    break;
//            }
//        if (permStatus == PackageManager.PERMISSION_DENIED) {
//            ActivityCompat.requestPermissions(this, reqPerms, REQ_CODE_STORAGE_PERM);
//        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if ((requestCode == REQ_CODE_STORAGE_PERM)) {
//            if (permissions.length > 0) {
//                for (String perm : permissions) {
//                    Log.d(TAG, "onRequestPermissionResult: " + perm);
//                }
//            }
            if (grantResults.length > 0) {
//                for (int res : grantResults) {
//                    Log.d(TAG, "onRequestPermisionResult: " + res);
//                }
                if(grantResults[1] == PackageManager.PERMISSION_GRANTED){
                    writeMyFile();
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void writeMyFile() {
        File myFile = new File(Environment.getExternalStorageDirectory(), "myFile");
        try {
            FileOutputStream fOut = new FileOutputStream(myFile);
            fOut.write("Hello".getBytes());

            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasWritePerm(){
        return ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED;
    }

    public void askWritePerm(){
        ActivityCompat.requestPermissions(this, reqPerms, REQ_CODE_STORAGE_PERM);
    }
}
