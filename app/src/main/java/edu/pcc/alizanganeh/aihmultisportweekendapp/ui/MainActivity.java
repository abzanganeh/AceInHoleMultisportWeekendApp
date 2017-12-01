package edu.pcc.alizanganeh.aihmultisportweekendapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.pcc.alizanganeh.aihmultisportweekendapp.R;
import edu.pcc.alizanganeh.aihmultisportweekendapp.models.Event;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.ace_name) TextView mAceName;
    @BindView(R.id.ace_sndpart_name) TextView mAceSndpartName;
    @BindView(R.id.saturday) TextView mSaturday;
    @BindView(R.id.sunday) TextView mSunday;
    @BindView(R.id.long_course) TextView mLongCourse;
    @BindView(R.id.half_marathon) TextView mHalfMarathon;
    @BindView(R.id.ten_k) TextView mTenK;
    @BindView(R.id.olympic) TextView mOlympic;
    @BindView(R.id.sprint) TextView mSprint;
    @BindView(R.id.try_a_tri) TextView mTryATri;

    private Activity mContext;
    final ArrayList<Event> events = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        mContext = this;
        Typeface octinFont = Typeface.createFromAsset(getAssets(), "octin_sports_free.ttf");
//        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "ostrich_regular.ttf");
        mAceName.setTypeface(octinFont);
        mAceSndpartName.setTypeface(octinFont);
//        mSaturday.setTypeface(ostrichFont);
//        mSunday.setTypeface(ostrichFont);

        Event longCourse = new Event( "Long Course", "Sat 7/16/2017","7:00 AM",
                240, getResources().getString(R.string.long_course_swim_text), getResources().getString(R.string.long_course_bike_text),
                getResources().getString(R.string.long_course_run_text) );
        Event olympic = new Event("Olympic", "Sat 7/16/2017","7:30 AM", 110,
                getResources().getString(R.string.olympic_swim_text), getResources().getString(R.string.olympic_bike_text),
                getResources().getString(R.string.olympic_run_text) );
        Event tenK = new Event("10K", "Sat 7/16/2017","7:15 AM", 50,
                "", "",
                getResources().getString(R.string.tenk_k_run_text) );
        Event halfMarathon = new Event("Half Marathon", "Sat 7/16/2017","7:15 AM", 75, "", "",
                getResources().getString(R.string.half_marathon_text) );
        Event sprint = new Event("Sprint", "Sun 7/17/2017","8:00 AM", 90,
                getResources().getString(R.string.sprint_swim_text), getResources().getString(R.string.sprint_bike_text),
                getResources().getString(R.string.sprint_run_text) );
        Event tryATri = new Event("Try-a-Tri", "Sun 7/17/2017","8:20 AM", 65,
                getResources().getString(R.string.try_a_tri_swim_text), getResources().getString(R.string.try_a_tri_bike_text),
                getResources().getString(R.string.try_a_tri_run_text));

        events.add(longCourse);
        events.add(olympic);
        events.add(tenK);
        events.add(halfMarathon);
        events.add(sprint);
        events.add(tryATri);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void clickBeginEvents( View view) {
        Intent intent = new Intent(this, FirstPageActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.long_course) {
            int itemPosition = 0;
            Intent intent = new Intent(MainActivity.this, EventViewHolderActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("events", Parcels.wrap(events));
            mContext.startActivity(intent);

        } else if (id == R.id.olympic) {
            int itemPosition = 1;
            Intent intent = new Intent(MainActivity.this, EventViewHolderActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("events", Parcels.wrap(events));
            mContext.startActivity(intent);

        } else if (id == R.id.ten_k) {
            int itemPosition = 2;
            Intent intent = new Intent(MainActivity.this, EventViewHolderActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("events", Parcels.wrap(events));
            mContext.startActivity(intent);
        } else if (id == R.id.half_marathon) {
            int itemPosition = 3;
            Intent intent = new Intent(MainActivity.this, EventViewHolderActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("events", Parcels.wrap(events));
            mContext.startActivity(intent);

        } else if (id == R.id.sprint) {
            int itemPosition = 4;
            Intent intent = new Intent(MainActivity.this, EventViewHolderActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("events", Parcels.wrap(events));
            mContext.startActivity(intent);

        } else if (id == R.id.try_a_tri) {
            int itemPosition = 5;
            Intent intent = new Intent(MainActivity.this, EventViewHolderActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("events", Parcels.wrap(events));
            mContext.startActivity(intent);

        } else if (id == R.id.what_to_bring) {
            Intent intent = new Intent(this, WhatToBringActivity.class);
            startActivity(intent);

        } else if (id == R.id.registration) {
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivity(intent);

        } else if (id == R.id.faq) {
            Intent intent = new Intent(this, FAQActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
