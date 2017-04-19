package com.example.agupta1409.pager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.agupta1409.pager.db.Table;

/**
 * Created by a.gupta1409 on 17-07-2016.
 */
public class MyDbOpener extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "database";
    public static final int DB_VERSION = 1;

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
        super(context, DATABASE_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("TABLE", Table.TABLE_CREATE_CMD);
        db.execSQL(Table.TABLE_CREATE_CMD);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
