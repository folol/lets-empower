package com.example.devansh.womensecutiry;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.Timer;

public class ActionActivity extends AppCompatActivity {

    GPSTracker gps;
    double latitude;
    double longitude;
    MediaRecorder mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);



       // sendPickupMessage();

        Intent i =new Intent(ActionActivity.this,CameraView.class);
        startActivityForResult(i, 1);


    }

    public void recordAudio() {
        mp = new MediaRecorder();
        //Log.i("Its working", "adadasdad");
        //Toast.makeText(getApplicationContext(),"place 1",Toast.LENGTH_LONG).show();
        mp.setAudioSource(MediaRecorder.AudioSource.MIC);
        mp.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
        mp.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
        //ContextWrapper cw=new ContextWrapper(getApplicationContext());
        //Toast.makeText(getApplicationContext(),"place 2",Toast.LENGTH_LONG).show();
        //mp.setOutputFile(cw.getDir("VoiceDir", Context.MODE_PRIVATE).getPath()+"/voice1.aac");
        /*File f=new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.aac");
        try
        {
            f.createNewFile();
        }catch(Exception e)
        {

        }*/
       String outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.aac";
        mp.setOutputFile(outputFile);
        mp.setMaxDuration(60000);
        try {
            mp.prepare();

            Toast.makeText(getApplicationContext(),"Start Recording",Toast.LENGTH_LONG).show();
            mp.start();

           // Toast.makeText(getApplicationContext(), "Stop Recording", Toast.LENGTH_LONG).show();
            //mp.stop();
            //mp.release();
        }catch(Exception e)
        {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Exception", Toast.LENGTH_LONG).show();
        }
    }

    public void playAudio() {
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        File directory = cw.getDir("VoiceDir", Context.MODE_PRIVATE);
        File myPath = new File(directory, "voice1.aac");
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(myPath.getPath());
            Toast.makeText(getApplicationContext(), "Start Playing", Toast.LENGTH_LONG).show();
            mediaPlayer.start();
        }catch (Exception e)
        {

        }
        finally {

            mediaPlayer.release();

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){

        sendMessage();
        recordAudio();
       //playAudio();
       finish();
    }

    public void getLocation() {
        gps = new GPSTracker(ActionActivity.this);


        // check if GPS enabled
        if (gps.canGetLocation()) {

            latitude = gps.getLatitude();
            longitude = gps.getLongitude();

            // \n is for new line
            Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
        } else {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }

    }

    //@TargetApi(21)
    public void sendMessage() {

        getLocation();
        SharedPreferences pref=getSharedPreferences("info_details", Context.MODE_PRIVATE);
        String emerg1=pref.getString("EMER_CONTACT_ONE", "100");
        String emerg2=pref.getString("EMER_CONATCT_TWO", "100");
        String emerg3=pref.getString("EMER_CONTACT_THREE","100");
        String message=pref.getString("MESSAGE", "Help Me! Please Come And Pick Me UP!!");
        message=message+" at Latitude: "+latitude+" and Longitude: "+longitude;
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(emerg1, null, message, null, null);
        smsManager.sendTextMessage(emerg2, null, message, null, null);
        smsManager.sendTextMessage(emerg3, null, message, null, null);
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        File myPath = new File(directory,"profile.jpg");
        Uri uri=Uri.parse(myPath.getAbsolutePath());
       // smsManager.sendMultimediaMessage(getApplicationContext(),uri,null,null,null);
    }

    public void sendPickupMessage() {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("+918527760646", null, "Pick up sms message", null, null);
    }
}

