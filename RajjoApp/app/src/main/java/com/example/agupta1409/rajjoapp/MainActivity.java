package com.example.agupta1409.rajjoapp;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0;

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        }

        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);

        if(cur.getCount()>0)
        {
            while(cur.moveToNext()){
                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String num = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.TIMES_CONTACTED.toString()));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                if(Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)))>0){
                    if(Float.parseFloat(num)>100){
                    Log.i("Content",name);
                    Log.i("Times",num);}
                }
            }
        }
    }
}
