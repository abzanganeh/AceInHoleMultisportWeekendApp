package edu.pcc.alizanganeh.aihmultisportweekendapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.pcc.alizanganeh.aihmultisportweekendapp.R;
import edu.pcc.alizanganeh.aihmultisportweekendapp.models.Event;

public class FirstPageActivity extends AppCompatActivity{

    private Activity mContext;
    @BindView(R.id.events_list) Spinner mEventsList;
    @BindView(R.id.title) TextView mTitleEvent;
//    @BindView(R.id.empty_view) TextView mEmptyView;
    private String[] eventNames = {"","Long Course", "Olympic", "10K", "Half Marathon", "Sprint", "Try-a-Tri", "Splash n Dash"};
    private static final String TAG = FirstPageActivity.class.getSimpleName();
    private String spinnerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        ButterKnife.bind(this);
        mContext = this;


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
        Event splashNDash = new Event("Splash n Dash", "Sun 7/17/2017","12:00 PM", 15,
                getResources().getString(R.string.splash_n_dash_swim_text), "",
                getResources().getString(R.string.splash_n_dash_run_text));

        final ArrayList<Event> events = new ArrayList<>();
        events.add(longCourse);
        events.add(olympic);
        events.add(tenK);
        events.add(halfMarathon);
        events.add(sprint);
        events.add(tryATri);
        events.add(splashNDash);


        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.spinner_item, eventNames);
        mEventsList.setAdapter(adapter);
        mEventsList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String event = ((TextView)view).getText().toString();
//                Toast.makeText(FirstPageActivity.this, event, Toast.LENGTH_LONG).show();
                for (Event e:events) {
                    int j = 0;
                    if (event.equals(e.getName())) {
                        Log.d("activity name:  ------", event);
                        int itemPosition = i;
                        Intent intent = new Intent(FirstPageActivity.this, EventViewHolderActivity.class);
                        intent.putExtra("position", itemPosition);
                        intent.putExtra("events", Parcels.wrap(events));
                        mContext.startActivity(intent);
                        break;
                    } else {
                        Log.d("Icouldn't find -------", event);
                    }
                    i++;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

    }

    public void onClickWhatToBring(View view){
        Intent intent = new Intent(this, WhatToBringActivity.class);
        startActivity(intent);
    }

    public void onClickRegistration(View view){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void onClickFAQ(View view){
        Intent intent = new Intent(this, FAQActivity.class);
        startActivity(intent);
    }

    public void onClickThingsToKnow(View view){
        Intent intent = new Intent(this, MoreInfoActivity.class);
        startActivity(intent);
    }

}
