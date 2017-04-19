package com.example.agupta1409.rachitbday;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.agupta1409.rachitbday.db.Table;

/**
 * Created by a.gupta1409 on 18-07-2016.
 */
public class FragmentMansi extends Fragment {

    private static int friendID;
    EditText et_name_entered;
    Button btnGuess;
    TextView tv_msg, tvName;
    ImageView image;
    View view;
    static SQLiteDatabase myDb;
    static Cursor c;

    public static final String TAG = "TAG";

    public static myFragment newInstance(int position,SQLiteDatabase myDatabase,Cursor cursor) {
        myFragment fragment = new myFragment();
        Bundle instance = new Bundle();
        instance.putInt("friendId",position);
        friendID = position;
        myDb = myDatabase;
        c = cursor;
        fragment.setArguments(instance);
        return fragment;
    }


    public myFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("TAGS","OnCreate");
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("TAGS","onCreateView");
        view = inflater.inflate(R.layout.fragment_my, container, false);
        setLayout(friendID);
        return view;
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

        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameEntered = et_name_entered.getText().toString();
                if ((nameEntered.trim()).equalsIgnoreCase(c.getString(c.getColumnIndex(Table.Columns.NAME)))) {
                    updateStatus(position,myDb,c);
                    et_name_entered.setVisibility(View.INVISIBLE);
                    btnGuess.setVisibility(View.INVISIBLE);
                    tvName.setText(c.getString(c.getColumnIndex(Table.Columns.NAME)).toUpperCase());

                    Intent i = new Intent(view.getContext(), CorrectAnswer.class);
                    i.setAction(Intent.ACTION_VIEW);
                    i.putExtra("Position", c.getInt(c.getColumnIndex(Table.Columns.IMAGE)));
                    i.putExtra("Name", c.getInt(c.getColumnIndex(Table.Columns.NAME)));
                    startActivity(i);
                } else {
                    Intent i = new Intent(view.getContext(), AccessDenied.class);
                    i.setAction(Intent.ACTION_VIEW);
                    startActivity(i);
                }
            }
        });
    }

    public void updateStatus(int position,SQLiteDatabase myDb,Cursor c) {
        c.moveToPosition(position);
        myDb.execSQL("UPDATE " + Table.TABLE_NAME + " SET " + Table.Columns.FLAG + " = "
                + "1 " + " WHERE " + Table.Columns.NAME + " = '"
                + c.getString(c.getColumnIndex(Table.Columns.NAME)) + "' ;"
        );

        Log.d(TAG, "2.flag = " + c.getInt(c.getColumnIndex(Table.Columns.FLAG)));
        image.setImageResource(c.getInt(c.getColumnIndex(Table.Columns.IMAGE)));
    }

    public int getPosition(){
        return friendID;
    }
}
