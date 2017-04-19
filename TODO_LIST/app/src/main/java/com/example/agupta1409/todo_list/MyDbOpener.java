package com.example.agupta1409.todo_list;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.agupta1409.todo_list.db.ToDo_Table;

/**
 * Created by a.gupta1409 on 16-07-2016.
 */
public class MyDbOpener extends SQLiteOpenHelper {
    public static final String TAG = "MyDbOpener";
    public static final String DB_NAME = "database";
    public static final int DB_VERSION = 1;

    private static MyDbOpener myDbOpener = null;

    public static SQLiteDatabase getReadableDatabase(Context context) {
        if (myDbOpener == null) {
            myDbOpener = new MyDbOpener(context);
        }
        return myDbOpener.getReadableDatabase();
    }

    public static SQLiteDatabase getWritableDatabase(Context context) {
        if (myDbOpener == null) {
            myDbOpener = new MyDbOpener(context);
        }
        return myDbOpener.getWritableDatabase();
    }

    public MyDbOpener(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, ToDo_Table.TABLE_CREATE_COMMND);
        db.execSQL(ToDo_Table.TABLE_CREATE_COMMND);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
