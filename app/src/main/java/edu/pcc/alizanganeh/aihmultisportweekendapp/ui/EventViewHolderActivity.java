package edu.pcc.alizanganeh.aihmultisportweekendapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.pcc.alizanganeh.aihmultisportweekendapp.R;
import edu.pcc.alizanganeh.aihmultisportweekendapp.adapters.EventPagerAdapter;
import edu.pcc.alizanganeh.aihmultisportweekendapp.models.Event;

public class EventViewHolderActivity extends AppCompatActivity {

    @BindView(R.id.viewPager) ViewPager mViewPager;
    private EventPagerAdapter adapterViewPager;
    ArrayList<Event> mEvents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view_holder);
        ButterKnife.bind(this);

        mEvents = Parcels.unwrap(getIntent().getParcelableExtra("events"));
        int position = getIntent().getIntExtra("position", 0);

        adapterViewPager = new EventPagerAdapter(getSupportFragmentManager(),  mEvents);


        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(position);

    }

    public void onClickRegistration(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
}
