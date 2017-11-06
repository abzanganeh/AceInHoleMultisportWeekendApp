package edu.pcc.alizanganeh.aihmultisportweekendapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class SplashNDashActivity extends AppCompatActivity {

    private int mProgressValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_n_dash);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(Constants.MAX_PROGRESS_VALUE - Constants.MIN_PROGRESS_VALUE);
        mProgressValue = Constants.MIN_PROGRESS_VALUE + seekBar.getProgress();
        final TextView progressText = (TextView) findViewById(R.id.progressText);
        progressText.setText("" + mProgressValue);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mProgressValue = Constants.MIN_PROGRESS_VALUE + seekBar.getProgress();
                progressText.setText("" + mProgressValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
