package com.example.agupta1409.lectureten;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by a.gupta1409 on 05-07-2016.
 */
public class NetFetchTask extends AsyncTask<String,Void,String> {

//    private TextView dataToChange;
    private NetFetchTask.PostExecuteListener myListener;

    public interface  PostExecuteListener{
        public void postExecuteDone(String str);
    }

    public NetFetchTask (PostExecuteListener pel){
//        dataToChange=tv;
         myListener = pel;
    }

    @Override
    protected String doInBackground(String... params) {
        String returnString = "";
      //  int respCode = 0;
        try {
            URL url = new URL(params[0]);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setConnectTimeout(10000);
            urlConn.setReadTimeout(20000);

            urlConn.connect();

            if(urlConn.getResponseCode()==200){
                returnString = isToString(urlConn.getInputStream());
            }else{
                returnString = "Response is" + urlConn.getResponseCode();
            }
//            respCode = urlConn.getResponseCode();

           // InputStream is = urlConn.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        catch (MalformedURLException e) {
//            e.printStackTrace();
//        }  Subclass of IOException so



        return returnString;
    }


    @Override
    protected void onPostExecute(String res) {
        super.onPostExecute(res);
//        dataToChange.setText("");
        myListener.postExecuteDone(res);
    }

    public String isToString (InputStream is) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(is,"utf-8"));
        StringBuilder sb = new StringBuilder();
        String line = r.readLine();
        while(line != null && !line.isEmpty() ){
            sb.append(line);
            line=r.readLine();
        }
//        char[] buffer = new char[10];
//        r.read(buffer);

//        return new String(buffer);
        return sb.toString();
    }
}
