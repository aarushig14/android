package com.example.agupta1409.network;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by a.gupta1409 on 26-03-2017.
 */

public class ListAdapter extends BaseAdapter {
    ArrayList<model> al;
    Context ctx;

    public ListAdapter(ArrayList<model> al, Context ctx) {
        Log.d("Aarushi","LisAdapterConstructor: ");
        this.al = al;
        this.ctx = ctx;
    }

    class Holder{
        TextView userid;
        TextView id;
        TextView title;
        TextView body;
    }



    @Override
    public int getCount() {
        return al.size();
    }

    @Override
    public Object getItem(int position) {
        return al.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("Aarushi","LisAdapter: ");
        LayoutInflater li = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        model model = al.get(position);
        Holder holder;
        if(convertView==null){
            convertView = li.inflate(R.layout.activity_list,null);
            holder = new Holder();
            holder.userid = (TextView) convertView.findViewById(R.id.userid);
            holder.id = (TextView) convertView.findViewById(R.id.id);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.body = (TextView) convertView.findViewById(R.id.body);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }

        holder.userid.setText(model.getUserId()+"");
        holder.id.setText(model.getId()+"");
        holder.title.setText(model.getTitle());
        holder.body.setText(model.getBody());

        return convertView;
    }
}
