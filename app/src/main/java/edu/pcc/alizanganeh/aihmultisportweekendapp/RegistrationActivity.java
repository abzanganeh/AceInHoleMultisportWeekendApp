package edu.pcc.alizanganeh.aihmultisportweekendapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistrationActivity extends AppCompatActivity {

    @BindView(R.id.radioGroup) RadioGroup mRadioGroup;
    @BindView(R.id.register) RadioButton mRegister;
    @BindView(R.id.volunteer) RadioButton mVolunteer;
    @BindView(R.id.comment_user_input) EditText mCommentUserInput;
    @BindView(R.id.comment_text) TextView mCommentText;
    @BindView(R.id.emergency_context) LinearLayout mEmergencyContext;
    @BindView(R.id.emergency_contact_context) TextView mEmergencyContactContext;
    @BindView(R.id.phone_number__user_input) EditText mPhoneNumberUserInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.register:
                if (checked)
                    mEmergencyContactContext.setVisibility(View.VISIBLE);
                    mPhoneNumberUserInput.setVisibility(View.VISIBLE);
                    mEmergencyContext.setVisibility(View.VISIBLE);
                    mCommentText.setVisibility(View.INVISIBLE);
                    mCommentUserInput.setVisibility(View.INVISIBLE);
                    // Pirates are the best
                    break;
            case R.id.volunteer:
                if (checked)
                    mEmergencyContactContext.setVisibility(View.INVISIBLE);
                    mPhoneNumberUserInput.setVisibility(View.INVISIBLE);
                    mEmergencyContext.setVisibility(View.INVISIBLE);
                    mCommentText.setVisibility(View.VISIBLE);
                    mCommentUserInput.setVisibility(View.VISIBLE);

                    break;
        }
    }

}
