package com.example.agupta1409.network;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class L10RuntimePermission extends AppCompatActivity {

    public static final String TAG = "PERM";
    public static final int PERM_REQ_CODE = 231;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l10_runtime_permission);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int permission = ContextCompat.checkSelfPermission(
                        L10RuntimePermission.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);
                //contextWrapper different for diff api so call th function checkSelfP which was added in api23 on contextCompat
                //will work on old phones as well
                if(permission == PackageManager.PERMISSION_GRANTED){
                    writeFile();
                }else{
                    ActivityCompat.requestPermissions(L10RuntimePermission.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, //can request for multiple pemissions by maing single requests
                            PERM_REQ_CODE   //random integer to acces permission later
                            );
                    //same thing function exist in activity class so it will not run in old phones
                    //hence use ActivityCompat
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == PERM_REQ_CODE){
            for(int i=0;i<permissions.length;i++){
                if(permissions[i].equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                    if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                        writeFile();
                    }else{
                        Toast.makeText(this,"Permission not Granted",Toast.LENGTH_SHORT).show();

                    }
                }

            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    void writeFile(){
        Toast.makeText(this,"We are writing file",Toast.LENGTH_SHORT).show();
    }
}
