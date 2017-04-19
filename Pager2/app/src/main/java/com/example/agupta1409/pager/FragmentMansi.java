package com.example.agupta1409.pager;

import android.content.Context;
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
public class FragmentMansi extends Fragment {
    TextView tvName;
    ImageView image;
    TextView tv_msg;
    EditText et_name_entered;
    Button btnGuess;
    static int position;
    View view;
    public static final String TAG = "TAGS";
    SQLiteDatabase myDb;
    Cursor c;
    String[] projection = {
            Table.Columns.IMAGE,
            Table.Columns.NAME,
            Table.Columns.FLAG,
            Table.Columns.MESSAGE
    };
    static Context ctxt;

    public static FragmentMansi newInstance(int pos, Context context){
        FragmentMansi frg = new FragmentMansi();
        position = pos;
        ctxt = context;
        return  frg;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my,container,false);
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
        return v;
    }

    public void setLayout(final int position) {
        Log.d("TAGS","setLayout");
        et_name_entered = (EditText) view.findViewById(R.id.et_guess_name);
        btnGuess = (Button) view.findViewById(R.id.btn_guess_made);
        tv_msg = (TextView) view.findViewById(R.id.tv_birthday_message);
        image = (ImageView) view.findViewById(R.id.image_wisher);
        tvName = (TextView) view.findViewById(R.id.tv_name);

        c.moveToPosition(position);
        Log.d("TAGS",c.getPosition() + "cursor ki disha");
        tv_msg.setText(c.getString(c.getColumnIndex(Table.Columns.MESSAGE)));

        Log.d(TAG, "1.Flag" + c.getInt(c.getColumnIndex(Table.Columns.FLAG)));
        if (c.getInt(c.getColumnIndex(Table.Columns.FLAG)) == 1) {
            image.setImageResource(c.getInt(c.getColumnIndex(Table.Columns.IMAGE)));
        } else {
            image.setImageResource(R.drawable.guesswhoimage);
        }

    }
}
