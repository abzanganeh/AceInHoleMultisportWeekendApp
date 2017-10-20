package edu.pcc.alizanganeh.aihmultisportweekendapp;

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
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsActivity extends AppCompatActivity{

    private Activity mContext;
    @BindView(R.id.events_list) Spinner mEventsList;
    @BindView(R.id.title) TextView mTitleEvent;
    private String[] eventNames = {"Please select:","Long Course", "Olympic", "10K", "Half Marathon", "Sprint", "Try-a-Tri", "Splash n Dash"};
    private static final String TAG = EventsActivity.class.getSimpleName();
    private String spinnerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        ButterKnife.bind(this);
        mContext = this;
        Event longCourse = new Event( "Long Course", "Saturday","7:00 AM",LongCourseActivity.class, 240);
        Event olympic = new Event("Olympic", "Saturday","7:30 AM", OlympicActivity.class, 110);
        Event tenK = new Event("10K", "Saturday","7:15 AM", TenKActivity.class, 50);
        Event halfMarathon = new Event("Half Marathon", "Saturday","7:15 AM", HalfMarathonActivity.class, 75);
        Event sprint = new Event("Sprint", "Sunday","8:00 AM", SprintActivity.class, 90);
        Event tryATri = new Event("Try-a-Tri", "Sunday","8:20 AM", TryATriActivity.class, 65);
        Event splashNDash = new Event("Splash n Dash", "Sunday","12:00 PM", SplashNDashActivity.class, 0);
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
                Toast.makeText(EventsActivity.this, event, Toast.LENGTH_LONG).show();
                for (Event e:events) {
                    if (event.equals(e.getName())) {
                        Log.d("activity name:  ------", event);
                        Intent intent;
                        intent = new Intent(EventsActivity.this, e.getActivityName());
                        startActivity(intent);
                        break;
                    } else {
                        Log.d("Icouldn't find -------", event);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

//        Intent intent = getIntent();
//        String event = intent.getStringExtra("event");
//        mTitleEvent.setText(event);
    }


}
