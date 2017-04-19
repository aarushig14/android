package com.example.agupta1409.announcements;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.agupta1409.announcements.model.Announ;
import com.example.agupta1409.announcements.myDb.AnnTable;
import com.example.agupta1409.announcements.myDb.User_Table;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import layout.AnnouncementFragment;

public class Announcements extends AppCompatActivity {

    ListView list;
    SQLiteDatabase myDb;
    String[] projectionAnnTable = {
            AnnTable.Columns.MSG_ID,
            AnnTable.Columns.MSG,
            AnnTable.Columns.SEEN
//           , AnnTable.Columns.DATE,
//            AnnTable.Columns.TIME
    };
    String[] projectionUserTable = {
            User_Table.Columns.USER_ID,
            User_Table.Columns.PASSWORD,
            User_Table.Columns.SEEN,
            User_Table.Columns.COMMENT
    };
    Cursor c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);

        myDb = myDbOpener.openWriteableDatabase(this);
//        Calendar clndr = Calendar.getInstance();

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        String formattedDate = df.format(clndr.getTime());
//        Log.d("MainActivity",formattedDate + "---" + clndr.getTime());

        for (int i = 0; i < 10; i++) {
            Announ nMsg = new Announ(
                    "M" + i,
                    "Hello No Class on Tesday",
                    3+i
            );

            ContentValues values = new ContentValues();
            values.put(AnnTable.Columns.SEEN, nMsg.getSeen());
            values.put(AnnTable.Columns.MSG, nMsg.getMessage());
            values.put(AnnTable.Columns.MSG_ID, nMsg.getMsgId());
            myDb.insert(AnnTable.TABLE_NAME,null,values);
            Log.d("MainActivity","value added #" + nMsg.getMessage() + "-" + nMsg.getMsgId());
        }

//        values.put(AnnTable.Columns.DATE,nMsg.getDate());
//        values.put(AnnTable.Columns.TIME,nMsg.getTime());

        c = myDb.query(
                AnnTable.TABLE_NAME,
                projectionAnnTable,
                null,null,null,null,AnnTable.Columns.MSG_ID
        );

        ArrayList<AnnounceDetails> annDetailsList = setDetails();

        list = (android.widget.ListView) findViewById(R.id.list_announcement);
        ListViewAdapter adapter = new ListViewAdapter(annDetailsList);
        list.setAdapter(adapter);

    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    public class ListViewAdapter extends BaseAdapter {

        public class Holder {
//            TextView dateDay;
//            TextView time;
            TextView announcement;
            Button seen;
        }

        private ArrayList<AnnounceDetails> mAnnouncements;

        public ListViewAdapter(ArrayList<AnnounceDetails> mAnnouncements) {
            this.mAnnouncements = mAnnouncements;
        }

        @Override
        public int getCount() {
            return mAnnouncements.size();
        }

        @Override
        public Object getItem(int i) {
            return mAnnouncements.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater li = getLayoutInflater();
            Holder holder;

//            Log.d("MainActivity", "view : null");
            view = li.inflate(R.layout.fragment_blank, null);
            holder = new Holder();
//            holder.dateDay = (TextView) view.findViewById(R.id.tv_date);
//            holder.time = (TextView) view.findViewById(R.id.tv_time);
            holder.announcement = (TextView) view.findViewById(R.id.tv_announcement);
            holder.seen = (Button) view.findViewById(R.id.btn_seen);
            view.setTag(holder);

            AnnounceDetails details = mAnnouncements.get(i);
            holder.announcement.setText(details.announcement);
//            holder.dateDay.setText(details.dateDay);
//            holder.time.setText(details.time);
            holder.seen.setText("" + details.seen + " seen");
            holder.seen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   ContentValues values = new ContentValues();

                }
            });
            return view;
        }

    }
    public void incrementSeen(){
        c.moveToFirst();


    }

    public ArrayList<AnnounceDetails> setDetails() {
        ArrayList<AnnounceDetails> details = new ArrayList<>();
        c.moveToFirst();
            while(!c.isLast()) {
                AnnounceDetails d = new AnnounceDetails();
                d.announcement =c.getString(c.getColumnIndex(AnnTable.Columns.MSG));
//                d.dateDay = c.getString(c.getColumnIndex(AnnTable.Columns.DATE));
//                d.time = c.getString(c.getColumnIndex(AnnTable.Columns.TIME));
//                d.msg = c.getString(c.getColumnIndex(AnnTable.Columns.MSG));
                d.seen = c.getInt(c.getColumnIndex(AnnTable.Columns.SEEN));
                details.add(d);
                Log.d("MainActivity","Value got %");
                c.moveToNext();
            }

        return details;
    }
}
