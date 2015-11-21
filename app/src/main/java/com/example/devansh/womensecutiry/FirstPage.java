package com.example.devansh.womensecutiry;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class FirstPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        Typeface tf = Typeface.createFromAsset(getAssets(), "Calibri.ttf");

        final TextView title=(TextView) findViewById(R.id.title_first);
        final EditText name=(EditText) findViewById(R.id.name);
        final EditText email=(EditText) findViewById(R.id.email);
        final EditText address=(EditText) findViewById(R.id.address);
        final EditText pass=(EditText) findViewById(R.id.password);
        ImageButton next=(ImageButton) findViewById(R.id.women_image);

        title.setTypeface(tf);
        name.setTypeface(tf);
        email.setTypeface(tf);
        address.setTypeface(tf);
        pass.setTypeface(tf);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().trim().equals("") || email.getText().toString().trim().equals("") || address.getText().toString().trim().equals("") || pass.getText().toString().trim().equals(""))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(FirstPage.this);
                    builder.setMessage("Please Enter All The Details!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //do things

                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
                else
                {
                    String names=name.getText().toString();
                    String emails=email.getText().toString();
                    String addresses=address.getText().toString();
                    String password=pass.getText().toString();
                    SharedPreferences.Editor editor= getSharedPreferences("info_details",MODE_PRIVATE).edit();
                    editor.putString("name",names);
                    editor.putString("email",emails);
                    editor.putString("address",addresses);
                    editor.putString("password",password);
                    editor.commit();

                    Intent i = new Intent(FirstPage.this, PageTwoReg.class);
                    startActivityForResult(i,1);
                }
            }
        });



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        finish();
    }

}
