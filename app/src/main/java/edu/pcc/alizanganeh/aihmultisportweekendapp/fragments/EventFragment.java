package edu.pcc.alizanganeh.aihmultisportweekendapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.pcc.alizanganeh.aihmultisportweekendapp.R;
import edu.pcc.alizanganeh.aihmultisportweekendapp.models.Event;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {

    @BindView(R.id.title) TextView mName;
    @BindView(R.id.day_text) TextView mDay;
    @BindView(R.id.date_text) TextView mTime;
    @BindView(R.id.content_cost) TextView mCost;
    @BindView(R.id.content_swim) TextView mSwim;
    @BindView(R.id.content_bike) TextView mBike;
    @BindView(R.id.content_run) TextView mRun;
    @BindView(R.id.title_bike) TextView mTitleBike;
    @BindView(R.id.title_swim) TextView mTitleSwim;
    @BindView(R.id.run_content) LinearLayout mRunContent;

    private Event mEvent;


    public EventFragment() {
        // Required empty public constructor
    }


    public static EventFragment newInstance(Event event) {
        EventFragment eventFragment = new EventFragment();
        Bundle args = new Bundle();
        args.putParcelable("event", Parcels.wrap(event));
        eventFragment.setArguments(args);
        return eventFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEvent = Parcels.unwrap(getArguments().getParcelable("event"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        ButterKnife.bind(this, view);

        mName.setText(mEvent.getName());
        mDay.setText(mEvent.getDay());
        mTime.setText(mEvent.getTime());
        mCost.setText(String.valueOf(mEvent.getPrice()));
        mSwim.setText(mEvent.getSwim());
        if (mEvent.getSwim().equals("")) {
            Log.d("Swim is", "empty ----------------");
            mTitleSwim.setVisibility(View.INVISIBLE);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mRunContent.getLayoutParams();
            params.addRule(RelativeLayout.BELOW, R.id.cost_content);
            mRunContent.setLayoutParams(params);

        }
        mBike.setText(mEvent.getBike());
        if (mEvent.getBike().equals("")) {
            Log.d("Bike is", "empty ----------------");
            mTitleBike.setVisibility(View.INVISIBLE);

        }
        mRun.setText(mEvent.getRun());

        return view;
    }

}
