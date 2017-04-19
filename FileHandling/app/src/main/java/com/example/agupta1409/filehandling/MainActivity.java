package com.example.agupta1409.filehandling;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "ManAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String s = getFilesDir().getPath();
//        Log.d(TAG,"onCreate : file dir : " + s);
//        String s1 = getCacheDir().getPath();
//        Log.d(TAG,"onCreae : Cache Dir :" + s1);
//
//        try {
//            String s2 = getFilesDir().getCanonicalPath();
//            String s3 = getCacheDir().getCanonicalPath();
//            Log.d(TAG,"OnCreate : File Canocial : " + s2 + " \n" + "Cache Canonical : " + s3);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        String fileName = "testFile";
//        File myFile = new File(MainActivity.this.getFilesDir(),fileName);
//
//        if(myFile.canRead()){
//            Log.d(TAG,"onCreate : 1. can read file = " + fileName);
//        }
//
//        String string = "Hello World";
//        FileOutputStream outputStream;
//
//
//        try {
//            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
//            outputStream.write(string.getBytes());
//            outputStream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if(myFile.canRead()){
//            Log.d(TAG,"onCreate : 2. can read file = " + fileName);
//        }

        Log.d(TAG,"onCreate : dataDir Path " + Environment.getDataDirectory().getPath());
        Log.d(TAG,"onCreate : dataDir absPath " + Environment.getDataDirectory().getAbsolutePath());
        try {
            Log.d(TAG,"onCreate : dataDir canPath " + Environment.getDataDirectory().getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d(TAG,"onCreate : extDir Path " + Environment.getExternalStorageDirectory().getPath());
        Log.d(TAG,"onCreate : extDir absPath " + Environment.getExternalStorageDirectory().getAbsolutePath());
        try {
            Log.d(TAG,"onCreate : extDir canPath " + Environment.getExternalStorageDirectory().getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d(TAG,"onCreate : dlCache Path " + Environment.getDownloadCacheDirectory().getPath());
        Log.d(TAG,"onCreate : dlCache absPath " + Environment.getDownloadCacheDirectory().getAbsolutePath());
        try {
            Log.d(TAG,"onCreate : dlCache canPath " + Environment.getDownloadCacheDirectory().getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d(TAG,"onCreate: free Space :" + Environment.getExternalStorageDirectory().getFreeSpace());
        Log.d(TAG,"Media : " +Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC));

        Log.d(TAG,"OnCreate : " + isExternalStorageReadable());
        Log.d(TAG,"OnCreate : " + isExternalStorageWriteable());

        File newFile = new File(Environment.getExternalStorageDirectory(),"newFile.txt");
        if( !newFile.isFile() ){
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream fStream = new FileOutputStream(newFile,true);
            fStream.write(("Hello Friends".getBytes()));
        }  catch (IOException e) {
            e.printStackTrace();
        }

        String returnString = "";
        try {
            FileInputStream inputStream = new FileInputStream(newFile);
            returnString = isToString(inputStream);
            Log.d(TAG,"onCreate : fileData : " + returnString);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean isExternalStorageReadable(){
        String status = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(status)){
            return true;
        }
        return false;
    }

    public boolean isExternalStorageWriteable(){
        String status = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(status)){
            return true;
        }
        return false;
    }
    public String isToString (InputStream is) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(is,"utf-8"));
        StringBuilder sb = new StringBuilder();
        String line = r.readLine();
        while(line != null && !line.isEmpty() ){
            sb.append(line);
            line=r.readLine();
        }
//        char[] buffer = new char[10];
//        r.read(buffer);

//        return new String(buffer);
        return sb.toString();
    }
}
