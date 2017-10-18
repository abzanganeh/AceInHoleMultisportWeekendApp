package edu.pcc.alizanganeh.aihmultisportweekendapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        Typeface octinFont = Typeface.createFromAsset(getAssets(), "octin_sports_free.ttf");
        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "ostrich_regular.ttf");
        mAceName.setTypeface(octinFont);
        mAceSndpartName.setTypeface(octinFont);
        mSaturday.setTypeface(ostrichFont);
        mSunday.setTypeface(ostrichFont);

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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.long_course) {

        } else if (id == R.id.olympic) {

        } else if (id == R.id.ten_k) {

        } else if (id == R.id.half_marathon) {

        } else if (id == R.id.sprint) {

        } else if (id == R.id.try_a_tri) {

        } else if (id == R.id.splash_n_dash) {

        } else if (id == R.id.what_to_bring) {

        } else if (id == R.id.registration) {

        } else if (id == R.id.faq) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
