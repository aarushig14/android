package com.example.agupta1409.databases;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.agupta1409.databases.db.StudentTable;

public class MyDbOpener extends SQLiteOpenHelper {

    public static final  String DB_NAME = "mydatabase";
    public static final int DB_VER = 1;

    private static MyDbOpener myDbOpener = null;

    public static SQLiteDatabase openReadableDatabase(Context c){
        if(myDbOpener == null){
            myDbOpener = new MyDbOpener(c);
        }
        return myDbOpener.getReadableDatabase();
    }

    public static SQLiteDatabase openWriteableDatabase(Context c){
        if(myDbOpener == null){
            myDbOpener = new MyDbOpener(c);
        }
        return myDbOpener.getWritableDatabase();
    }

    public MyDbOpener(Context context) {
        super(context, DB_NAME,null, DB_VER);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("TABLE",StudentTable.TABLE_CREATE_CMD);
        db.execSQL(StudentTable.TABLE_CREATE_CMD);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
