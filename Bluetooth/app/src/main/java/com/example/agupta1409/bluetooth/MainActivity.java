package com.example.agupta1409.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    BluetoothAdapter ba;
    int ENABLE=1,DISCOVER=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ba=BluetoothAdapter.getDefaultAdapter();
        tv=(TextView)findViewById(R.id.textView);
        TelephonyManager tm=(TelephonyManager)getSystemService(Context.TELECOM_SERVICE);
        String details=tm.getSimSerialNumber()+"\n"+tm.getDeviceId()+"\n"+tm.getNetworkOperatorName()+"\n"+tm.getNetworkCountryIso();
        tv.setText(details);
    }

    public void enable(View v)
    {
        Intent i1=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivity(i1);
    }

    public void disable(View v)
    {
       ba.disable();
    }

    public void discover(View v)
    {
        Intent i2=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        i2.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,200);
        startActivity(i2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
        //noinspection SimplifiableIfStatement
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
