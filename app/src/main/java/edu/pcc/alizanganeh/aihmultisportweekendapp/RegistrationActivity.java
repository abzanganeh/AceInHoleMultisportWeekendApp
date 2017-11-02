package edu.pcc.alizanganeh.aihmultisportweekendapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistrationActivity extends AppCompatActivity {
    private DatabaseReference mRegisterFirstNameReference;

    @BindView(R.id.radioGroup) RadioGroup mRadioGroup;
    @BindView(R.id.register) RadioButton mRegister;
    @BindView(R.id.volunteer) RadioButton mVolunteer;
    @BindView(R.id.comment_user_input) EditText mCommentUserInput;
    @BindView(R.id.comment_text) TextView mCommentText;
    @BindView(R.id.emergency_context) LinearLayout mEmergencyContext;
    @BindView(R.id.emergency_contact_context) TextView mEmergencyContactContext;
    @BindView(R.id.emergency_name_user_input) TextView mEmergencyNameUserInput;
    @BindView(R.id.emergency_number_user_input) TextView mEmergencyNumberUserInput;
    @BindView(R.id.phone_number_user_input) EditText mPhoneNumberUserInput;
    @BindView(R.id.first_name_user_input) EditText mFirstNameUserInput;
    @BindView(R.id.last_name_user_input) EditText mLastNameUserInput;
    @BindView(R.id.email_user_input) EditText mEmailUserInput;
    private boolean witchChecked = true;
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

                    String reg_firstname = mFirstNameUserInput.getText().toString();
                    saveFirstnameToFirebase(reg_firstname);
                    break;

            case R.id.volunteer:
                if (checked)
                    witchChecked = false;
                    mEmergencyContactContext.setVisibility(View.INVISIBLE);
                    mPhoneNumberUserInput.setVisibility(View.INVISIBLE);
                    mEmergencyContext.setVisibility(View.INVISIBLE);
                    mCommentText.setVisibility(View.VISIBLE);
                    mCommentUserInput.setVisibility(View.VISIBLE);

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

            RegisterMember mRegister = new RegisterMember(mFirstName, mLastName, mEmail
                    , mPhoneNumber, mEmergencyName, mEmergencyNumber);
            DatabaseReference registerRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_REGISTERS);
            registerRef.push().setValue(mRegister);
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
}
