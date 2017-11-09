package edu.pcc.alizanganeh.aihmultisportweekendapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.pcc.alizanganeh.aihmultisportweekendapp.utils.Constants;
import edu.pcc.alizanganeh.aihmultisportweekendapp.R;

public class TryATriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_atri);
    }

    public void onClickRegistration(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        intent.putExtra("event", Constants.TEN_K);
        startActivity(intent);

    }
}
