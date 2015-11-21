package com.example.devansh.womensecutiry;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class PageTwoReg extends AppCompatActivity {

    EditText msg,pol_num,emer_contact_one,emer_contact_two,emer_contact_three;
    ImageButton contact_picker_one,contact_picker_two,contact_picker_three,next_button;
    SharedPreferences settings;
    final String INFO_DETAILS = "info_details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two_reg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        msg = (EditText) findViewById(R.id.msg_urgent);
        pol_num = (EditText)findViewById(R.id.pol_num);
        emer_contact_one = (EditText)findViewById(R.id.emer_contact_one);
        emer_contact_two = (EditText)findViewById(R.id.emer_contact_two);
        emer_contact_three = (EditText)findViewById(R.id.emer_contact_three);
        contact_picker_one = (ImageButton)findViewById(R.id.imageButton_one);
        contact_picker_two = (ImageButton)findViewById(R.id.imageButton_two);
        contact_picker_three = (ImageButton)findViewById(R.id.imageButton_three);
        next_button = (ImageButton)findViewById(R.id.imageButton_four);


        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = msg.getText().toString().trim();
                String police_num = pol_num.getText().toString().trim();
                String emergency_contact_one= emer_contact_one.getText().toString().trim();
                String emergency_contact_two = emer_contact_two.getText().toString().trim();
                String emergency_contact_three = emer_contact_three.getText().toString().trim();

                Log.i("WS","Data"+message+" "+police_num);
                if(message.equals("") || police_num.equals("") || emergency_contact_one.equals("") || emergency_contact_two.equals("") || emergency_contact_three.equals("")) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(PageTwoReg.this);
                    dialog.setTitle("Data is not valid");
                    Log.i("WS","dialog chala");
                    dialog.show();
                }
                else{
                    settings = getSharedPreferences(INFO_DETAILS,0);
                    settings.edit().putString("MESSAGE",message).apply();
                    settings.edit().putString("POLICE_NUMBER", police_num).apply();
                    settings.edit().putString("EMER_CONTACT_ONE",emergency_contact_one).apply();
                    settings.edit().putString("EMER_CONTACT_TWO",emergency_contact_two).apply();
                    settings.edit().putString("EMER_CONTACT_THREE",emergency_contact_three).apply();
                    finish();

                }
            }
        });

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
