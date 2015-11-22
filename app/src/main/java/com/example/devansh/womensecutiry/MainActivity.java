package com.example.devansh.womensecutiry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SharedPreferences settings;
    ViewPagerAdapter adapter;
    final String INFO_DETAILS = "info_details";
    private boolean firstTime;
    private int isSuccess = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewPager viewPager = (ViewPager) findViewById(R.id.mainviewpager);

        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.maintabs);

        tabLayout.setupWithViewPager(viewPager);
       settings = getSharedPreferences(INFO_DETAILS, 0);
        firstTime = settings.getBoolean("first_time",true);
        if(firstTime){
            Intent i = new Intent(MainActivity.this,FirstPage.class);
            startActivityForResult(i,isSuccess);
            settings.edit().putBoolean("first_time",false).apply();
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new InfoFragment(), "Information");
        adapter.addFragment(new FeedFragment(), "Activities");
        //adapter.addFragment(new FriendsFragment(), "Friends");
        /*
        adapter.addFragment(new FeedFragment(), "Album");
        adapter.addFragment(new ArtistFragment(), "Artist");
        adapter.addFragment(new GenreFragment(),"Genre");
        */
        viewPager.setAdapter(adapter);
    }

}
