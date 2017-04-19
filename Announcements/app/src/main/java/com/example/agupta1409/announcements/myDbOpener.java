package com.example.agupta1409.announcements;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.agupta1409.announcements.myDb.AnnTable;
import com.example.agupta1409.announcements.myDb.User_Table;

/**
 * Created by a.gupta1409 on 03-09-2016.
 */
public class myDbOpener extends SQLiteOpenHelper{

    public static final  String DB_NAME = "classdatabase";
    public static final int DB_VER = 1;

    private static myDbOpener myDbOpener = null;

    public static SQLiteDatabase openReadableDatabase(Context c){
        if(myDbOpener == null){
            myDbOpener = new myDbOpener(c);
        }
        return myDbOpener.getReadableDatabase();
    }

    public static SQLiteDatabase openWriteableDatabase(Context c){
        if(myDbOpener == null){
            myDbOpener = new myDbOpener(c);
        }
        return myDbOpener.getWritableDatabase();
    }

    public myDbOpener(Context context) {
        super(context, DB_NAME,null, DB_VER);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("TABLE", AnnTable.TABLE_CREATE_CMD);
        db.execSQL(AnnTable.TABLE_CREATE_CMD);
        db.execSQL(User_Table.TABLE_CREATE_CMD);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
