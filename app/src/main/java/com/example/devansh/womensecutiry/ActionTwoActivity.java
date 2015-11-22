package com.example.devansh.womensecutiry;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;

public class ActionTwoActivity extends AppCompatActivity {
GPSTracker gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_two);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gps=new GPSTracker(ActionTwoActivity.this);
        SharedPreferences pref=getSharedPreferences("info_details", Context.MODE_PRIVATE);
        String emerg1=pref.getString("EMER_CONTACT_ONE", "100");
        String emerg2=pref.getString("EMER_CONATCT_TWO", "100");
        String emerg3=pref.getString("EMER_CONTACT_THREE","100");
        //String message=pref.getString("MESSAGE","Help Me! Please Come And Pick Me UP!!");
        String message="I need Help! Please Pick Me Up"+" at Latitude: "+gps.getLatitude()+" and Longitude: "+gps.getLongitude();
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(emerg1, null, message, null, null);
        smsManager.sendTextMessage(emerg2, null, message, null, null);
        smsManager.sendTextMessage(emerg3, null, message, null, null);
    }

}
