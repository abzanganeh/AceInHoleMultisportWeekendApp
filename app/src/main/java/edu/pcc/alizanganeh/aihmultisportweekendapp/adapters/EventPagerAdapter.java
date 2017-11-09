package edu.pcc.alizanganeh.aihmultisportweekendapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import edu.pcc.alizanganeh.aihmultisportweekendapp.fragments.EventFragment;
import edu.pcc.alizanganeh.aihmultisportweekendapp.models.Event;

/**
 * Created by ABZanganeh on 11/8/17.
 */

public class EventPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Event> mEvents;

    public EventPagerAdapter(FragmentManager fm, ArrayList<Event> events) {
        super(fm);
        mEvents = events;
    }

    @Override
    public Fragment getItem(int position) {
        return EventFragment.newInstance(mEvents.get(position));
    }

    @Override
    public int getCount() {
        return mEvents.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mEvents.get(position).getName();
    }
}
