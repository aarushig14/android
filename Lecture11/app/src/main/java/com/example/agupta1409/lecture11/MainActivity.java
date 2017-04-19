package com.example.agupta1409.lecture11;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    RequestQueue queue;
    String url;
    Button btn;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);
        et = (EditText) findViewById(R.id.et);
        btn = (Button) findViewById(R.id.button);
        tv1 = (TextView) findViewById(R.id.textView);
        url = new String("https://open-event.herokuapp.com/api/v2/events/");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int evId;
                try {
                    evId = Integer.valueOf(et.getText().toString());
                } catch (Exception e) {
                    evId = 4;
                }
                queue.add(stringReqBuilder(evId));
            }
        });
    }

    public StringRequest stringReqBuilder(int eventId){
        String eventUrl = url + eventId;
        StringRequest strReq = new StringRequest(Request.Method.GET, eventUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tv1.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error.getCause() != null) {
                    error.getCause().printStackTrace();
                }
                if (error.networkResponse != null) {
                    Toast.makeText(MainActivity.this, "Error = " + error.networkResponse.statusCode, Toast.LENGTH_SHORT).show();
                }
            }
        });
        return strReq;
    }

    //shared preferences : store info locally needs to be retrieved again
    protected void onPause(){

        SharedPreferences sPRef = getPreferences(MODE_PRIVATE);
     //   SharedPreferences sharedPreferences = getSharedPreferences("my_pref_doc",MODE_PRIVATE);
        SharedPreferences.Editor ed = sPRef.edit();
        int evId;
        try {
            evId = Integer.valueOf(et.getText().toString());
        } catch (Exception e) {
            evId = 4;
        }
        ed.putInt("event_id",evId);
        //ed.commit();  //commits immediately on same thread (synchronously) and the moves to next line hence return true or false
        ed.apply();  //apply deviates the work to some other thread and work slowly

        super.onPause();
    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        int evId = prefs.getInt("event_id",-1);

        tv1.setText("Refetching Data");
        queue.add(stringReqBuilder(evId));
    }
}
