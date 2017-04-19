package com.example.agupta1409.network;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText et;
    Button btn;
    ArrayList<model> datalist = new ArrayList<>();;
    public static final String TAG = "MainActivity";
    ListAdapter adapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        adapter = new ListAdapter(datalist,MainActivity.this);
        list.setAdapter(adapter);

       // tv= (TextView) findViewById(R.id.tvData);
        et = (EditText) findViewById(R.id.etUrl);
        btn= (Button) findViewById(R.id.btnDwnload);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connMgr = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

                NetworkInfo[] networks = connMgr.getAllNetworkInfo();
                for(NetworkInfo netInfo : networks){
                 Log.d(TAG,"onClick : "+ netInfo.getTypeName());
                    Log.d(TAG,"onClick : "+ netInfo.getSubtypeName());
                    Log.d(TAG,"onClick : "+ netInfo.getExtraInfo());
                    Log.d(TAG,"onClick : "+ netInfo.getState());

                }

                NetworkInfo activeNetInfo = connMgr.getActiveNetworkInfo();
                if(activeNetInfo != null && activeNetInfo.getState() == NetworkInfo.State.CONNECTED) {
                    String url = et.getText().toString();
                    DownloadData dd = new DownloadData();
                    dd.execute(url);
                    Toast.makeText(MainActivity.this, url, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Not Connected to Network",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public class DownloadData extends AsyncTask<String,Void,ArrayList<model>> {
        @Override
        protected ArrayList<model> doInBackground(String... params) {
            ArrayList<model> al = new ArrayList<>();

            URL url = null;
            // Log.d("NetWork",params[0]);
            try {
                url = new URL("http://jsonplaceholder.typicode.com/posts");
            } catch (MalformedURLException e) { //check that URL object created is correct or not
                e.printStackTrace();
            }
            HttpURLConnection httpURLConnection = null;        //
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int respCode = -1;
            try {
                respCode = httpURLConnection.getResponseCode();
                InputStream is = httpURLConnection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String buffer;
                while ((buffer = reader.readLine()) != null) {
                    sb.append(buffer);
                }
                String json = sb.toString();
                al = getJSON(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            return String.valueOf(respCode);
            return al;
        }

        @Override
        protected void onPostExecute(ArrayList<model> models) {
            for(int i =0;i<models.size();i++){
                datalist.add(models.get(i));
            }
            adapter.notifyDataSetChanged();

            super.onPostExecute(models);
        }
    }

    public static ArrayList<model> getJSON(String s){
        ArrayList<model> jsonList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(s);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject thisJsonObj = jsonArray.getJSONObject(i);
                model model = new model(thisJsonObj.getInt("userId"),thisJsonObj.getInt("id"),
                        thisJsonObj.getString("title"),thisJsonObj.getString("body"));
                jsonList.add(model);
            }
        } catch (JSONException e) {           // if not json format with proper brackets
            e.printStackTrace();
        }

        return jsonList;
    }

}
