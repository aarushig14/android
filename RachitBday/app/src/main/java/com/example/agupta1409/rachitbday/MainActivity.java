package com.example.agupta1409.rachitbday;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

import com.example.agupta1409.rachitbday.db.Table;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    ViewPagerAdapter mPageAdapter;
    SQLiteDatabase myDb;
    ViewPager pager ;
    Cursor c;
    String[] projection = {
            Table.Columns.IMAGE,
            Table.Columns.NAME,
            Table.Columns.FLAG,
            Table.Columns.MESSAGE
    };

    private List<myFragment> getFragments(SQLiteDatabase myDatabase,Cursor cursor){
        List<myFragment> list = new ArrayList<myFragment>();

        int i = 0,position = 0;
        while(i < 9 ){
            myFragment frg = myFragment.newInstance(position,myDatabase,cursor);
            list.add(frg);
            i++;
            position++;
        }
        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myDb = MyDbOpener.openWriteableDatabase(this);

        c = myDb.query(
                Table.TABLE_NAME,
                projection,
                null, null, null, null, null
        );

        pager = (ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter pAdapter = new ViewPagerAdapter(getSupportFragmentManager(),getFragments(myDb,c),this);
        pager.setAdapter(pAdapter);

    }



//    private void initiaisePaging() {
//        List<myFragment> fragments = new Vector<myFragment>();
//        int i = 1,position = 0;
//        Log.d("TAGS",c.getCount()+"");
//        c.moveToFirst();
//        while (i <= c.getCount()) {
//            myFragment frg = new myFragment();
//            frg.setLayout(position,myDb,c);
//            fragments.add(frg);
//            Log.d("TAGS","fragment added position = " + position + "cursor" + c.getPosition() + "fragmentPosition = " + frg.getPosition());
//            i++;
//            position++;
//        }
//        Log.d("TAG","InitialisePaging : fragments added");
//        mPageAdapter = new ViewPagerAdapter(getSupportFragmentManager(),fragments);
//        ViewPager pager = (ViewPager) findViewById(R.id.pager);
//        pager.setAdapter(mPageAdapter);
//    }
}
