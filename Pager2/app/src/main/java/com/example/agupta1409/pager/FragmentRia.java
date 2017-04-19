package com.example.agupta1409.pager;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.agupta1409.pager.db.Table;

/**
 * Created by a.gupta1409 on 18-07-2016.
 */
public class FragmentRia extends Fragment {
    TextView tvName;
    ImageView image;
    TextView tv_msg;
    EditText et_name_entered;
    Button btnGuess;
    int position;
    View v;
    public static final String TAG = "TAGS";
    SQLiteDatabase myDb;
    Cursor c;
    String[] projection = {
            Table.Columns.IMAGE,
            Table.Columns.NAME,
            Table.Columns.FLAG,
            Table.Columns.MESSAGE
    };
    Context ctxt;

    public void setArgs(int pos,Context c){
        position = pos;
        ctxt =c;
    }

    public FragmentRia newInstance(int pos,Context context){
        FragmentRia frg = new FragmentRia();
        position = pos;
        ctxt = context;
        return  frg;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_my,container,false);
        et_name_entered = (EditText) v.findViewById(R.id.et_guess_name);
        btnGuess = (Button) v.findViewById(R.id.btn_guess_made);
        tv_msg = (TextView) v.findViewById(R.id.tv_birthday_message);
        image = (ImageView) v.findViewById(R.id.image_wisher);
        tvName = (TextView) v.findViewById(R.id.tv_name);

        myDb = MyDbOpener.openWriteableDatabase(ctxt);

        c = myDb .query(
                Table.TABLE_NAME,
                projection,
                null,null,null,null,null
        );

        setLayout(position);

        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameEntered = et_name_entered.getText().toString();
                if ((nameEntered.trim()).equalsIgnoreCase(c.getString(c.getColumnIndex(Table.Columns.NAME)))) {
                    updateStatus(position, myDb, c);
                    et_name_entered.setVisibility(View.INVISIBLE);
                    btnGuess.setVisibility(View.INVISIBLE);
                    tvName.setText(c.getString(c.getColumnIndex(Table.Columns.NAME)).toUpperCase());

                    Intent i = new Intent(ctxt, Congo.class);
                    i.setAction(Intent.ACTION_VIEW);
                    i.putExtra("Position", c.getInt(c.getColumnIndex(Table.Columns.IMAGE)));
                    i.putExtra("Name", c.getInt(c.getColumnIndex(Table.Columns.NAME)));
                    startActivity(i);
                } else {
                    Intent i = new Intent(ctxt, Shey.class);
                    i.setAction(Intent.ACTION_VIEW);
                    startActivity(i);
                }
            }
        });
        return v;
    }

    public void setLayout(final int position) {
        Log.d("TAGS","setLayout");
        et_name_entered = (EditText) v.findViewById(R.id.et_guess_name);
        btnGuess = (Button) v.findViewById(R.id.btn_guess_made);
        tv_msg = (TextView) v.findViewById(R.id.tv_birthday_message);
        image = (ImageView) v.findViewById(R.id.image_wisher);
        tvName = (TextView) v.findViewById(R.id.tv_name);

        c.moveToPosition(position);
        Log.d("TAGS",c.getPosition() + "cursor ki disha");
        tv_msg.setText(c.getString(c.getColumnIndex(Table.Columns.MESSAGE)));

        Log.d(TAG, "1.Flag" + c.getInt(c.getColumnIndex(Table.Columns.FLAG)));
        if (c.getInt(c.getColumnIndex(Table.Columns.FLAG)) == 1) {
            image.setImageResource(c.getInt(c.getColumnIndex(Table.Columns.IMAGE)));
            et_name_entered.setVisibility(View.INVISIBLE);
            btnGuess.setVisibility(View.INVISIBLE);
            tvName.setText(c.getString(c.getColumnIndex(Table.Columns.NAME)));
        } else {
            image.setImageResource(R.drawable.guesswhoimage);
        }

    }

//    public void checkAnswer(View view) {
//        et_name_entered = (EditText) view.findViewById(R.id.et_guess_name);
//        String nameEntered = et_name_entered.getText().toString();
//        if ((nameEntered.trim()).equalsIgnoreCase(c.getString(c.getColumnIndex(Table.Columns.NAME)))) {
//            updateStatus(position, myDb, c);
//            et_name_entered.setVisibility(View.INVISIBLE);
//            btnGuess.setVisibility(View.INVISIBLE);
//            tvName.setText(c.getString(c.getColumnIndex(Table.Columns.NAME)).toUpperCase());
//
//            Intent i = new Intent(ctxt, CorrectAnswer.class);
//            i.setAction(Intent.ACTION_VIEW);
//            i.putExtra("Position", c.getInt(c.getColumnIndex(Table.Columns.IMAGE)));
//            i.putExtra("Name", c.getInt(c.getColumnIndex(Table.Columns.NAME)));
//            startActivity(i);
//        } else {
//            Intent i = new Intent(ctxt, AccessDenied.class);
//            i.setAction(Intent.ACTION_VIEW);
//            startActivity(i);
//        }
//    }

    public void updateStatus(int position, SQLiteDatabase myDb, Cursor c) {
        c.moveToPosition(position);
        myDb.execSQL("UPDATE " + Table.TABLE_NAME + " SET " + Table.Columns.FLAG + " = "
                + "1 " + " WHERE " + Table.Columns.NAME + " = '"
                + c.getString(c.getColumnIndex(Table.Columns.NAME)) + "' ;"
        );

        Log.d(TAG, "2.flag = " + c.getInt(c.getColumnIndex(Table.Columns.FLAG)));
        image.setImageResource(c.getInt(c.getColumnIndex(Table.Columns.IMAGE)));
    }
}
