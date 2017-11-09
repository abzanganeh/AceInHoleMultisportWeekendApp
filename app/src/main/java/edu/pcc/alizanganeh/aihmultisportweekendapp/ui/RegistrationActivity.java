package edu.pcc.alizanganeh.aihmultisportweekendapp.ui;

import android.content.Context;
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
import edu.pcc.alizanganeh.aihmultisportweekendapp.utils.Constants;
import edu.pcc.alizanganeh.aihmultisportweekendapp.R;
import edu.pcc.alizanganeh.aihmultisportweekendapp.models.RegisterMember;
import edu.pcc.alizanganeh.aihmultisportweekendapp.models.VolunteerMember;

public class RegistrationActivity extends AppCompatActivity {
    private DatabaseReference mRegisterFirstNameReference;

    @BindView(R.id.radioGroup) RadioGroup mRadioGroup;
    @BindView(R.id.register) RadioButton mRegister;
    @BindView(R.id.volunteer) RadioButton mVolunteer;
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
    @BindView(R.id.olympic_checkBox) CheckBox mOlympicCheckBox;
    @BindView(R.id.olympic_cost) TextView mOlympicCost;
    @BindView(R.id.sprint_checkBox) CheckBox mSprintCheckBox;
    @BindView(R.id.sprint_cost) TextView mSprintCost;
    @BindView(R.id.try_a_tri_checkBox) CheckBox mTryATriCheckBox;
    @BindView(R.id.try_a_tri_cost) TextView mTryATriCost;
    @BindView(R.id.half_marathon_checkBox) CheckBox mHalfMarathonCheckBox;
    @BindView(R.id.half_marathon_cost) TextView mHalfMarathonCost;
    @BindView(R.id.ten_k_checkBox) CheckBox mTenKCheckBox;
    @BindView(R.id.ten_k_cost) TextView mTenKCost;
    @BindView(R.id.total_cost_text) TextView mTotalCostText;
    @BindView(R.id.total_cost) LinearLayout mTotalCost;
    @BindView(R.id.events_chosen) TextView mEventsChosen;
    @BindView(R.id.events_check_list) LinearLayout mEventsCheckList;
//    define a boolean variable to check if volunteer is checked or register
    private boolean witchChecked = true;
    private Set<String> eventsChosen = new HashSet<>();



    private Context mContext;
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
            }
        });

        mOlympicCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mTotalCostText.setText(String.valueOf(countTotalCost()));
                mEventsChosen.setText(eventsChosen.toString());
        }
        });

        mTenKCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mTotalCostText.setText(String.valueOf(countTotalCost()));
                mEventsChosen.setText(eventsChosen.toString());
            }
        });

        mTryATriCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mTotalCostText.setText(String.valueOf(countTotalCost()));
                mEventsChosen.setText(eventsChosen.toString());
            }
        });

        mSprintCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mTotalCostText.setText(String.valueOf(countTotalCost()));
                mEventsChosen.setText(eventsChosen.toString());
            }
        });

        mHalfMarathonCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mTotalCostText.setText(String.valueOf(countTotalCost()));
                mEventsChosen.setText(eventsChosen.toString());
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
                    saveFirstnameToFirebase(reg_firstname);

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
            Toast.makeText(RegistrationActivity.this, "The form is Sent to FireBase DB", Toast.LENGTH_LONG).show();
            Log.i("register-------", "sent");
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
            Log.i("volunteer-------", "sent");
        }
    }

    public void saveFirstnameToFirebase(String firstname) {
        mRegisterFirstNameReference.push().setValue(firstname);
    }



    public String checkForEvent(Set<String> events, String event) {

            for (String e : events)
                if (e.equals(event)) {
                    return event;
                }

        return "";
    }

}
