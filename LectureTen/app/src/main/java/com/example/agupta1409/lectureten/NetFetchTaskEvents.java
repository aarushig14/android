package com.example.agupta1409.lectureten;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by a.gupta1409 on 05-07-2016.
 */
public class NetFetchTaskEvents extends AsyncTask<String,Void,Events> {
    private NetFetchTaskEvents.PostExecuteListener myListener;

    public interface  PostExecuteListener{
        public void postExecuteDone(Events ev);
    }

    public NetFetchTaskEvents(PostExecuteListener myListener) {
        this.myListener = myListener;
    }

    @Override
    protected Events doInBackground(String... params) {
        Events myEV = null;
        try {
            URL url = new URL(params[0]);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setConnectTimeout(10000);
            urlConn.setReadTimeout(20000);

            urlConn.connect();

            if(urlConn.getResponseCode()==200){
                String res = isToString(urlConn.getInputStream());
                myEV = getEventFromResponse(res);
            }

        } catch (IOException|JSONException e) {
            e.printStackTrace();
        }


        return myEV;
    }


    @Override
    protected void onPostExecute(Events ev) {
        super.onPostExecute(ev);
        myListener.postExecuteDone(ev);
//        dataToChange.setText("");

    }

    public String isToString (InputStream is) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(is,"utf-8"));
        StringBuilder sb = new StringBuilder();
        String line = r.readLine();
        while(line != null && !line.isEmpty() ){
            sb.append(line);
            line = r.readLine();
        }
//        char[] buffer = new char[10];
//        r.read(buffer);

//        return new String(buffer);
        return sb.toString();
    }

    public Events getEventFromResponse(String resp) throws JSONException {
        Log.d("TAG",resp);
        JSONObject jObj = new JSONObject(resp);
        Events events = new Events(
                jObj.getString("name"),
                jObj.getString("location_name"),
                jObj.getString("type"),
                jObj.getString("topic")
                );

        //--------------------
//        JSONArray jArr = new JSONArray(resp);
//        int len = jArr.length();
//        ArrayList<Events> event = new ArrayList<>();
//        for(int i =0;i<len;i++){
//            JSONObject singleObject = jArr.getJSONObject(i);
//            event.add(new Events(
//
//            ));
//        }


        return events;
    }
}
