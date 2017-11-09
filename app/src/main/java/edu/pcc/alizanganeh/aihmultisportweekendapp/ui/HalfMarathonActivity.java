package edu.pcc.alizanganeh.aihmultisportweekendapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.pcc.alizanganeh.aihmultisportweekendapp.utils.Constants;
import edu.pcc.alizanganeh.aihmultisportweekendapp.R;

public class HalfMarathonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_half_marathon);
    }

    public void onClickRegistration(View view) {

        Intent intent = new Intent(this, RegistrationActivity.class);
        intent.putExtra("event", Constants.HALF_MARATHON);
        startActivity(intent);

    }
}
