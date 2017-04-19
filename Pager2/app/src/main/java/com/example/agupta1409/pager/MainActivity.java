package com.example.agupta1409.pager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.agupta1409.pager.db.Table;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    static TextView tvName;
//    ImageView image;
//    TextView tv_msg;
//    static EditText et_name_entered;
//    static Button btnGuess;
//    int pos;
//    static Context context;
    public static final String TAG = "TAGS";
    static SQLiteDatabase myDb;
    static Cursor c;
    String[] projection = {
            Table.Columns.IMAGE,
            Table.Columns.NAME,
            Table.Columns.FLAG,
            Table.Columns.MESSAGE
    };

    pageAdapter adapter;
    ViewPager pager;
    ArrayList<Fragment> list;



    public ArrayList<Fragment> getFragments(int count) {
        list = new ArrayList<Fragment>();
        int position = 0;
        while(count>0) {
            FragmentRia frg = new FragmentRia();
            frg.setArgs(position, this);
            list.add(frg);
            count--;position++;
        }
        return list;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = MyDbOpener.openWriteableDatabase(this);
        c = myDb.query(
                Table.TABLE_NAME,
                projection,
                null, null, null, null, null
        );

        if (c.getCount() <= 0) {
            for (Wishers.Person person : Wishers.getList()) {
                ContentValues values = new ContentValues();
                values.put(Table.Columns.FLAG, person.getFlag());
                values.put(Table.Columns.IMAGE, person.image);
                values.put(Table.Columns.MESSAGE, person.birthdayMessage);
                values.put(Table.Columns.NAME, person.name);
                myDb.insert(Table.TABLE_NAME, null, values);
            }
        }

        c = myDb.query(
                Table.TABLE_NAME,
                projection,
                null, null, null, null, null
        );

        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new pageAdapter(getSupportFragmentManager(), getFragments(c.getCount()));
        pager.setAdapter(adapter);


    }

//    public static void checkAnswer(EditText et,int position) {
//        et_name_entered = et;
//        String nameEntered = et_name_entered.getText().toString();
//        if ((nameEntered.trim()).equalsIgnoreCase(c.getString(c.getColumnIndex(Table.Columns.NAME)))) {
//            updateStatus(position, myDb, c);
//            et_name_entered.setVisibility(View.INVISIBLE);
//            btnGuess.setVisibility(View.INVISIBLE);
//            tvName.setText(c.getString(c.getColumnIndex(Table.Columns.NAME)).toUpperCase());
//
//            Intent i = new Intent(context, CorrectAnswer.class);
//            i.setAction(Intent.ACTION_VIEW);
//            i.putExtra("Position", c.getInt(c.getColumnIndex(Table.Columns.IMAGE)));
//            i.putExtra("Name", c.getInt(c.getColumnIndex(Table.Columns.NAME)));
//            startActivity(i);
//        } else {
//            Intent i = new Intent(view.getContext(), AccessDenied.class);
//            i.setAction(Intent.ACTION_VIEW);
//            startActivity(i);
//        }
//    }
//
//    public static void updateStatus(int position, SQLiteDatabase myDb, Cursor c) {
//        c.moveToPosition(position);
//        myDb.execSQL("UPDATE " + Table.TABLE_NAME + " SET " + Table.Columns.FLAG + " = "
//                + "1 " + " WHERE " + Table.Columns.NAME + " = '"
//                + c.getString(c.getColumnIndex(Table.Columns.NAME)) + "' ;"
//        );
//
//        Log.d(TAG, "2.flag = " + c.getInt(c.getColumnIndex(Table.Columns.FLAG)));
//        image.setImageResource(c.getInt(c.getColumnIndex(Table.Columns.IMAGE)));
//    }
}
