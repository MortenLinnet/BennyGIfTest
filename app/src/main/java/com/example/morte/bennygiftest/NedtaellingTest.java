package com.example.morte.bennygiftest;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.w3c.dom.Text;

import java.util.Locale;

public class NedtaellingTest extends AppCompatActivity {

private static long Start_time_in_milis2 = 40000;
    private static long Start_time_in_milis = 25000;

    private TextView mtextview;
    private Button myButton;
    private CountDownTimer mCountdownTimer;
    private boolean mTiemrRunning;
    private long timeleftinmillis = Start_time_in_milis;


    private TextView mtextview2;
    private CountDownTimer mCountdownTimer2;
    private boolean mTiemrRunning2;
    private long timeleftinmillis2 = Start_time_in_milis2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nedtaelling_test);
mtextview= findViewById(R.id.TestTextView);

mtextview2= findViewById(R.id.Testtextview2);
myButton = findViewById(R.id.WOWbutton);

starttimer2();

    }


    private void starttimer(){
        mCountdownTimer = new CountDownTimer(timeleftinmillis, 1000) {


            @Override
            public void onTick(long millisuntillfinish) {
            timeleftinmillis = millisuntillfinish;
            updatecountdowntext();
            }

            @Override
            public void onFinish() {
            mTiemrRunning= false;
            }
        }.start();
            mTiemrRunning = true;
    }

    private void starttimer2(){
        mCountdownTimer2 = new CountDownTimer(timeleftinmillis2, 1000) {

            @Override
            public void onTick(long millisuntillfinish2) {
                timeleftinmillis2 = millisuntillfinish2;
                updatecountdowntext2();
            }

            @Override
            public void onFinish() {
                mTiemrRunning2= false;
            }
        }.start();
        mTiemrRunning2 = true;
    }


    private void updatecountdowntext() {
int min = (int)(timeleftinmillis/1000) / 60;
        int secs = (int)(timeleftinmillis/1000) % 60;

        String TimeleftFormatted = String.format(Locale.getDefault(),"%02d:%02d", min, secs);
mtextview.setText(TimeleftFormatted);

if (timeleftinmillis < 20000){
    resettimer();

}

    }

    private void updatecountdowntext2() {
        int min = (int)(timeleftinmillis2/1000) / 60;
        int secs = (int)(timeleftinmillis2/1000) % 60;

        String TimeleftFormatted = String.format(Locale.getDefault(),"%02d:%02d", min, secs);
        mtextview2.setText(TimeleftFormatted);

    }

    private void resettimer(){
        timeleftinmillis = Start_time_in_milis;
        updatecountdowntext();
mCountdownTimer.cancel();

myButton.setEnabled(true);
myButton.setVisibility(View.VISIBLE);


    }

    public void lol(View view) {
        starttimer();
        myButton.setEnabled(false);
        myButton.setVisibility(View.INVISIBLE);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wowowenwilson);
        mediaPlayer.start();
    }
}
