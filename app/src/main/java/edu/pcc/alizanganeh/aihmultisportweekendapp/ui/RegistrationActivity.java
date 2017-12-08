package edu.pcc.alizanganeh.aihmultisportweekendapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.pcc.alizanganeh.aihmultisportweekendapp.R;
import edu.pcc.alizanganeh.aihmultisportweekendapp.models.RegisterMember;
import edu.pcc.alizanganeh.aihmultisportweekendapp.models.VolunteerMember;
import edu.pcc.alizanganeh.aihmultisportweekendapp.utils.Constants;

public class RegistrationActivity extends AppCompatActivity {
    private DatabaseReference mRegisterFirstNameReference;

    @BindView(R.id.radioGroup) RadioGroup mRadioGroup;
    @BindView(R.id.register) RadioButton mRegister;
    @BindView(R.id.comment_user_input) EditText mCommentUserInput;
    @BindView(R.id.comment_text) TextView mCommentText;
    @BindView(R.id.emergency_context) LinearLayout mEmergencyContext;
    @BindView(R.id.name_context) LinearLayout mNameContext;
    @BindView(R.id.emergency_contact_context) TextView mEmergencyContactContext;
    @BindView(R.id.emergency_name_user_input) TextView mEmergencyNameUserInput;
    @BindView(R.id.emergency_number_user_input) TextView mEmergencyNumberUserInput;
    @BindView(R.id.phone_number_user_input) EditText mPhoneNumberUserInput;
    @BindView(R.id.first_name_user_input) EditText mFirstNameUserInput;
    @BindView(R.id.last_name_user_input) EditText mLastNameUserInput;
    @BindView(R.id.email_user_input) EditText mEmailUserInput;
    @BindView(R.id.long_course_checkBox) CheckBox mLongCourseCheckBox;
    @BindView(R.id.long_course_cost) TextView mLongCourseCost;
    @BindView(R.id.long_course_dollar_sign) TextView mLongCourseDollarSign;
    @BindView(R.id.olympic_checkBox) CheckBox mOlympicCheckBox;
    @BindView(R.id.olympic_cost) TextView mOlympicCost;
    @BindView(R.id.olympic_dollar_sign) TextView mOlympicDollarSign;
    @BindView(R.id.sprint_checkBox) CheckBox mSprintCheckBox;
    @BindView(R.id.sprint_cost) TextView mSprintCost;
    @BindView(R.id.sprint_dollar_sign) TextView mSprintDollarSign;
    @BindView(R.id.try_a_tri_checkBox) CheckBox mTryATriCheckBox;
    @BindView(R.id.try_a_tri_cost) TextView mTryATriCost;
    @BindView(R.id.try_a_tri_dollar_sign) TextView mTryATriDollarSign;
    @BindView(R.id.splash_n_dash_checkBox) CheckBox mSplashNDashCheckBox;
    @BindView(R.id.splash_n_dash_cost) TextView mSplashNDashCost;
    @BindView(R.id.splash_n_dash_dollar_sign) TextView mSplashNDashDollarSign;
    @BindView(R.id.splash_n_dash_free_checkBox) CheckBox mSplashNDashFreeCheckBox;
    @BindView(R.id.splash_n_dash_free_cost) TextView mSplashNDashFreeCost;
    @BindView(R.id.half_marathon_checkBox) CheckBox mHalfMarathonCheckBox;
    @BindView(R.id.half_marathon_cost) TextView mHalfMarathonCost;
    @BindView(R.id.half_marathon_dollar_sign) TextView mHalfMarathonDollarSign;
    @BindView(R.id.ten_k_checkBox) CheckBox mTenKCheckBox;
    @BindView(R.id.ten_k_cost) TextView mTenKCost;
    @BindView(R.id.ten_k_dollar_sign) TextView mTenKDollarSign;
    @BindView(R.id.total_cost_text) TextView mTotalCostText;
    @BindView(R.id.total_cost) LinearLayout mTotalCost;
    @BindView(R.id.events_chosen) TextView mEventsChosen;
    @BindView(R.id.events_check_list) LinearLayout mEventsCheckList;
//    define a boolean variable to check if volunteer is checked or register
    private boolean witchChecked = true;
    private Set<String> eventsChosen = new HashSet<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mRegisterFirstNameReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_REGISTER_CHILD_FIRSTNAME);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);

        mEmergencyContactContext.setVisibility(View.VISIBLE);
        mPhoneNumberUserInput.setVisibility(View.VISIBLE);
        mEmergencyContext.setVisibility(View.VISIBLE);
        mCommentText.setVisibility(View.INVISIBLE);
        mCommentUserInput.setVisibility(View.INVISIBLE);

        onCheckBoxClicked();

        eventsChosen.add("");

        Intent intent = getIntent();
        String eventSendFromIntent = intent.getStringExtra("event");

    }

    public int countTotalCost() {
        int total = 0;
        if (mLongCourseCheckBox.isChecked()) {
            total += Constants.LONG_COURSE_COST;
            if (!(checkForEvent(eventsChosen, "LongCourse").equals("LongCourse"))) {
                eventsChosen.add("LongCourse");
            }

        }else {

            if ( checkForEvent(eventsChosen, "LongCourse").equals("LongCourse")) {
                eventsChosen.remove("LongCourse");
            }
        }

        if (mOlympicCheckBox.isChecked()) {
            total += Constants.OLYMPIC_COST;
            if (!(checkForEvent(eventsChosen, "Olympic").equals("Olympic"))) {
                eventsChosen.add("Olympic");
            }

        }else {

            if ( checkForEvent(eventsChosen, "Olympic").equals("Olympic")) {
                eventsChosen.remove("Olympic");
            }
        }

        if (mTenKCheckBox.isChecked()) {
            total += Constants.TEN_K_COST;
            if (!(checkForEvent(eventsChosen, "10K").equals("10K"))) {
                eventsChosen.add("10K");
            }

        }else {

            if ( checkForEvent(eventsChosen, "10K").equals("10K")) {
                eventsChosen.remove("10K");
            }
        }

        if (mTryATriCheckBox.isChecked()) {
            total += Constants.TRY_A_TRI_COST;
            if (!(checkForEvent(eventsChosen, "TryATri").equals("TryATri"))) {
                eventsChosen.add("TryATri");
            }

        }else {

            if ( checkForEvent(eventsChosen, "TryATri").equals("TryATri")) {
                eventsChosen.remove("TryATri");
            }
        }
        if (mSplashNDashCheckBox.isChecked()) {
            total += Constants.SPLASH_N_DASH_COST;
            if (!(checkForEvent(eventsChosen, "SplashNDash").equals("SplashNDash"))) {
                eventsChosen.add("SplashNDash");
            }

        }else {

            if ( checkForEvent(eventsChosen, "SplashNDash").equals("SplashNDash")) {
                eventsChosen.remove("SplashNDash");
            }
        }
        if (mSplashNDashFreeCheckBox.isChecked()) {
            total += Constants.SPLASH_N_DASH_FREE_COST;
            if (!(checkForEvent(eventsChosen, "SplashNDashFree").equals("SplashNDashFree"))) {
                eventsChosen.add("SplashNDashFree");
            }

        }else {

            if ( checkForEvent(eventsChosen, "SplashNDashFree").equals("SplashNDashFree")) {
                eventsChosen.remove("SplashNDashFree");
            }
        }
        if (mSprintCheckBox.isChecked()) {
            total += Constants.SPRINT_COST;
            if (!(checkForEvent(eventsChosen, "Sprint").equals("Sprint"))) {
                eventsChosen.add("Sprint");
            }

        }else {

            if ( checkForEvent(eventsChosen, "Sprint").equals("Sprint")) {
                eventsChosen.remove("Sprint");
            }
        }

        if (mHalfMarathonCheckBox.isChecked()) {
            total += Constants.HALF_MARATHON_COST;
            if (!(checkForEvent(eventsChosen, "HalfMarathon").equals("HalfMarathon"))) {
                eventsChosen.add("HalfMarathon");
            }

        }else {

            if ( checkForEvent(eventsChosen, "HalfMarathon").equals("HalfMarathon")) {
                eventsChosen.remove("HalfMarathon");
            }
        }
        return total;
    }


    public void onCheckBoxClicked(){

        mLongCourseCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mTotalCostText.setText(String.valueOf(countTotalCost()));
                mEventsChosen.setText(eventsChosen.toString());
                mOlympicCheckBox.setVisibility(View.INVISIBLE);
                mOlympicCost.setVisibility(View.INVISIBLE);
                mOlympicDollarSign.setVisibility(View.INVISIBLE);
                mTenKCheckBox.setVisibility(View.INVISIBLE);
                mTenKCost.setVisibility(View.INVISIBLE);
                mTenKDollarSign.setVisibility(View.INVISIBLE);
                mHalfMarathonCheckBox.setVisibility(View.INVISIBLE);
                mHalfMarathonCost.setVisibility(View.INVISIBLE);
                mHalfMarathonDollarSign.setVisibility(View.INVISIBLE);

            }
        });

        mOlympicCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mTotalCostText.setText(String.valueOf(countTotalCost()));
                mEventsChosen.setText(eventsChosen.toString());
                mLongCourseCheckBox.setVisibility(View.INVISIBLE);
                mLongCourseCost.setVisibility(View.INVISIBLE);
                mLongCourseDollarSign.setVisibility(View.INVISIBLE);
                mTenKCheckBox.setVisibility(View.INVISIBLE);
                mTenKCost.setVisibility(View.INVISIBLE);
                mTenKDollarSign.setVisibility(View.INVISIBLE);
                mHalfMarathonCheckBox.setVisibility(View.INVISIBLE);
                mHalfMarathonCost.setVisibility(View.INVISIBLE);
                mHalfMarathonDollarSign.setVisibility(View.INVISIBLE);
        }
        });

        mTenKCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mTotalCostText.setText(String.valueOf(countTotalCost()));
                mEventsChosen.setText(eventsChosen.toString());
                mLongCourseCheckBox.setVisibility(View.INVISIBLE);
                mLongCourseCost.setVisibility(View.INVISIBLE);
                mLongCourseDollarSign.setVisibility(View.INVISIBLE);
                mOlympicCheckBox.setVisibility(View.INVISIBLE);
                mOlympicCost.setVisibility(View.INVISIBLE);
                mOlympicDollarSign.setVisibility(View.INVISIBLE);
                mHalfMarathonCheckBox.setVisibility(View.INVISIBLE);
                mHalfMarathonCost.setVisibility(View.INVISIBLE);
                mHalfMarathonDollarSign.setVisibility(View.INVISIBLE);
            }
        });
//ToDo: add splash n dash to the click listener and reset
        mSplashNDashCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mTotalCostText.setText(String.valueOf(countTotalCost()));
                mEventsChosen.setText(eventsChosen.toString());
                mSplashNDashFreeCheckBox.setVisibility(View.INVISIBLE);
                mSplashNDashFreeCost.setVisibility(View.INVISIBLE);
            }
        });

        mSplashNDashFreeCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mTotalCostText.setText(String.valueOf(countTotalCost()));
                mEventsChosen.setText(eventsChosen.toString());
                mSplashNDashCheckBox.setVisibility(View.INVISIBLE);
                mSplashNDashCost.setVisibility(View.INVISIBLE);
                mSplashNDashDollarSign.setVisibility(View.INVISIBLE);

            }
        });
        mTryATriCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mTotalCostText.setText(String.valueOf(countTotalCost()));
                mEventsChosen.setText(eventsChosen.toString());
                mSprintCheckBox.setVisibility(View.INVISIBLE);
                mSprintCost.setVisibility(View.INVISIBLE);
                mSprintDollarSign.setVisibility(View.INVISIBLE);

            }
        });

        mSprintCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mTotalCostText.setText(String.valueOf(countTotalCost()));
                mEventsChosen.setText(eventsChosen.toString());
                mTryATriCheckBox.setVisibility(View.INVISIBLE);
                mTryATriCost.setVisibility(View.INVISIBLE);
                mTryATriDollarSign.setVisibility(View.INVISIBLE);

            }
        });

        mHalfMarathonCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mTotalCostText.setText(String.valueOf(countTotalCost()));
                mEventsChosen.setText(eventsChosen.toString());
                mLongCourseCheckBox.setVisibility(View.INVISIBLE);
                mLongCourseCost.setVisibility(View.INVISIBLE);
                mLongCourseDollarSign.setVisibility(View.INVISIBLE);
                mOlympicCheckBox.setVisibility(View.INVISIBLE);
                mOlympicCost.setVisibility(View.INVISIBLE);
                mOlympicDollarSign.setVisibility(View.INVISIBLE);
                mTenKCheckBox.setVisibility(View.INVISIBLE);
                mTenKCost.setVisibility(View.INVISIBLE);
                mTenKDollarSign.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();


        switch(view.getId()) {

            case R.id.register:
                if (checked)
                    witchChecked = true;
                    mEmergencyContactContext.setVisibility(View.VISIBLE);
                    mPhoneNumberUserInput.setVisibility(View.VISIBLE);
                    mEmergencyContext.setVisibility(View.VISIBLE);
                    mCommentText.setVisibility(View.INVISIBLE);
                    mCommentUserInput.setVisibility(View.INVISIBLE);
                    mEventsCheckList.setVisibility(View.VISIBLE);
                    mTotalCost.setVisibility(View.VISIBLE);
                    mEventsChosen.setVisibility(View.VISIBLE);
                    String reg_firstname = mFirstNameUserInput.getText().toString();


                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mNameContext.getLayoutParams();
                    params.addRule(RelativeLayout.BELOW, R.id.events_chosen);
                    mNameContext.setLayoutParams(params);

                    break;

            case R.id.volunteer:
                if (checked)
                    witchChecked = false;
                    mEmergencyContactContext.setVisibility(View.INVISIBLE);
                    mPhoneNumberUserInput.setVisibility(View.INVISIBLE);
                    mEmergencyContext.setVisibility(View.INVISIBLE);
                    mCommentText.setVisibility(View.VISIBLE);
                    mCommentUserInput.setVisibility(View.VISIBLE);
                    mEventsCheckList.setVisibility(View.INVISIBLE);
                    mTotalCost.setVisibility(View.INVISIBLE);
                    mEventsChosen.setVisibility(View.INVISIBLE);

                    RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) mNameContext.getLayoutParams();
                    params2.addRule(RelativeLayout.BELOW, R.id.choose_register);
                    mNameContext.setLayoutParams(params2);

                    break;
        }
    }

    public void onSendRequestClicked (View view){
        Log.d("send request", " button clicked");
        if (witchChecked) {
            if( mFirstNameUserInput.getText().toString().trim().equals("")) {
                mFirstNameUserInput.setError("First name is required!");
                mFirstNameUserInput.setHint("please enter First name");
            }
            else if( mLastNameUserInput.getText().toString().trim().equals("")) {
                mLastNameUserInput.setError("Last name is required!");
                mLastNameUserInput.setHint("please enter Last name");
            }
            else if (mEmailUserInput.getText().toString().trim().equals("")) {
                mEmailUserInput.setError("Email is required!");
                mEmailUserInput.setHint("please enter Email");
            }
            else if (mPhoneNumberUserInput.getText().toString().trim().equals("")) {
                mPhoneNumberUserInput.setError("Phone Number is required!");
                mPhoneNumberUserInput.setHint("please enter Phone Number");

            }
            else if (mEmergencyNameUserInput.getText().toString().trim().equals("")) {
                mEmergencyNameUserInput.setError("Emergency Username is required!");
                mEmergencyNameUserInput.setHint("please enter Emergency Username");

            }
            else if (mEmergencyNumberUserInput.getText().toString().trim().equals("")) {
                mEmergencyNumberUserInput.setError("Emergency Number is required!");
                mEmergencyNumberUserInput.setHint("please enter Emergency Number");

            } else {
                String mFirstName = mFirstNameUserInput.getText().toString();
                String mLastName = mLastNameUserInput.getText().toString();
                String mEmail = mEmailUserInput.getText().toString();
                String mPhoneNumber = mPhoneNumberUserInput.getText().toString();
                String mEmergencyName = mEmergencyNameUserInput.getText().toString();
                String mEmergencyNumber = mEmergencyNumberUserInput.getText().toString();
                List<String> setList = new ArrayList<String>(eventsChosen);

                ArrayList<String> mEvents = (ArrayList<String>) setList;
                RegisterMember mRegister = new RegisterMember(mFirstName, mLastName, mEmail
                        , mPhoneNumber, mEmergencyName, mEmergencyNumber, mEvents);
                DatabaseReference registerRef = FirebaseDatabase
                        .getInstance()
                        .getReference(Constants.FIREBASE_CHILD_REGISTERS);
                registerRef.push().setValue(mRegister);
                Toast.makeText(RegistrationActivity.this, "Thank you for Registering! please read Notes bellow.", Toast.LENGTH_LONG).show();
                Log.i("register-------", "sent");
            }
        }
        else {
            String mFirstName = mFirstNameUserInput.getText().toString();
            String mLastName = mLastNameUserInput.getText().toString();
            String mEmail = mEmailUserInput.getText().toString();
            String mComment = mCommentUserInput.getText().toString();

            VolunteerMember mVolunteer = new VolunteerMember(mFirstName, mLastName
                    , mEmail, mComment);
            DatabaseReference volunteerRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_VOLUNTEER);
            volunteerRef.push().setValue(mVolunteer);
            Toast.makeText(RegistrationActivity.this, "Thank you for Volunteering! Your request is sent.", Toast.LENGTH_LONG).show();
            Log.i("volunteer-------", "sent");
        }
    }

    public String checkForEvent(Set<String> events, String event) {

            for (String e : events)
                if (e.equals(event)) {
                    return event;
                }

        return "";
    }

    public void reset(View view) {
        mLongCourseCheckBox.setVisibility(View.VISIBLE);
        mLongCourseCost.setVisibility(View.VISIBLE);
        mLongCourseDollarSign.setVisibility(View.VISIBLE);

        mTenKCheckBox.setVisibility(View.VISIBLE);
        mTenKCost.setVisibility(View.VISIBLE);
        mTenKDollarSign.setVisibility(View.VISIBLE);

        mHalfMarathonCheckBox.setVisibility(View.VISIBLE);
        mHalfMarathonCost.setVisibility(View.VISIBLE);
        mHalfMarathonDollarSign.setVisibility(View.VISIBLE);

        mTryATriCheckBox.setVisibility(View.VISIBLE);
        mTryATriCost.setVisibility(View.VISIBLE);
        mTryATriDollarSign.setVisibility(View.VISIBLE);

        mTryATriCheckBox.setVisibility(View.VISIBLE);
        mTryATriCost.setVisibility(View.VISIBLE);
        mTryATriDollarSign.setVisibility(View.VISIBLE);

        mSprintCheckBox.setVisibility(View.VISIBLE);
        mSprintCost.setVisibility(View.VISIBLE);
        mSprintDollarSign.setVisibility(View.VISIBLE);

        mOlympicCheckBox.setVisibility(View.VISIBLE);
        mOlympicCost.setVisibility(View.VISIBLE);
        mOlympicDollarSign.setVisibility(View.VISIBLE);

        mSplashNDashCheckBox.setVisibility(View.VISIBLE);
        mSplashNDashCost.setVisibility(View.VISIBLE);
        mSplashNDashDollarSign.setVisibility(View.VISIBLE);

        mSplashNDashFreeCheckBox.setVisibility(View.VISIBLE);
        mSplashNDashFreeCost.setVisibility(View.VISIBLE);

        mLongCourseCheckBox.setSelected(false);
        mLongCourseCheckBox.setChecked(false);
        mTenKCheckBox.setSelected(false);
        mTenKCheckBox.setChecked(false);
        mHalfMarathonCheckBox.setSelected(false);
        mHalfMarathonCheckBox.setChecked(false);
        mTryATriCheckBox.setSelected(false);
        mTryATriCheckBox.setChecked(false);
        mSprintCheckBox.setSelected(false);
        mSprintCheckBox.setChecked(false);
        mOlympicCheckBox.setSelected(false);
        mOlympicCheckBox.setChecked(false);
        mSplashNDashCheckBox.setSelected(false);
        mSplashNDashCheckBox.setChecked(false);
        mSplashNDashFreeCheckBox.setSelected(false);
        mSplashNDashFreeCheckBox.setChecked(false);

        eventsChosen.clear();
        mEventsChosen.setText(eventsChosen.toString());
    }
}

