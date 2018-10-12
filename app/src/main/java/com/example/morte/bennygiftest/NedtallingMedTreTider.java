package com.example.morte.bennygiftest;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.Locale;

public class NedtallingMedTreTider extends AppCompatActivity {

    private Button KLodsIndputKnap;
    private boolean BrickDetected;



    private static long SuperRequestTid = 10000;
    private TextView SuperRequestTimeTextView;
    private CountDownTimer SuperRequestTidCountdownTimer;
    private boolean SuperRequestTidIsRunning;
    private long timeleftinmillisSuperRequestTime = SuperRequestTid;

    private static long RequestNotActiveTime = 25000;
    private TextView RequestNotActiveTextView;
    private CountDownTimer RequestNotActiveCountdownTimer;
    private boolean RequestNotActiveeIsRunning;
    private long timeleftinmillisRequestNotActive = RequestNotActiveTime;


    private static long FeedbackCooldown = 5000;
    private TextView FeedbackCDTextView;
    private CountDownTimer FeedbackCoolDownCountdowntimer;
    private boolean FeedBackCoolDownIsRunning;
    private long timeleftinmillisFeedbackCD = FeedbackCooldown;

    private  VideoView BennyOjne; //Loller bare lidt rundt
    MediaPlayer mediaPlayer;  //Til Idle øjne

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nedtaelling_test);
        SuperRequestTimeTextView = findViewById(R.id.TestTextView);
        FeedbackCDTextView = findViewById(R.id.Testtextview2);
        RequestNotActiveTextView = findViewById(R.id.TesttextView3);
        KLodsIndputKnap = findViewById(R.id.WOWbutton);

     //   BennyOjne = findViewById(R.id.GifView);
       // BennyOjne.start();


starttimer();
starttimer3();

/*if (mediaPlayer.isPlaying() == false){              Til Idle øjne
    PlayIdleMovies();
}
*/
    }


    private void starttimer(){
        SuperRequestTidCountdownTimer = new CountDownTimer(timeleftinmillisSuperRequestTime, 1000) {


            @Override
            public void onTick(long millisuntillfinish) {
                timeleftinmillisSuperRequestTime = millisuntillfinish;
                updatecountdowntext();
            }

            @Override
            public void onFinish() {
                SuperRequestTidIsRunning = false;
            }
        }.start();
        SuperRequestTidIsRunning = true;
    }

    private void updatecountdowntext() {
        int min = (int)(timeleftinmillisSuperRequestTime/1000) / 60;
        int secs = (int)(timeleftinmillisSuperRequestTime/1000) % 60;

        String TimeleftFormatted = String.format(Locale.getDefault(),"%02d:%02d", min, secs);
        SuperRequestTimeTextView.setText(TimeleftFormatted);

if (timeleftinmillisSuperRequestTime < 2000){

    resetetoveralltime();
    resettimer();

}
    }


    private void starttimer2(){
        FeedbackCoolDownCountdowntimer = new CountDownTimer(timeleftinmillisFeedbackCD, 1000) {

            @Override
            public void onTick(long millisuntillfinish2) {
                timeleftinmillisFeedbackCD = millisuntillfinish2;
                updatecountdowntext2();
            }

            @Override
            public void onFinish() {
                FeedBackCoolDownIsRunning = false;
            }
        }.start();
        FeedBackCoolDownIsRunning = true;
    }


    private void updatecountdowntext2() {
        int min = (int)(timeleftinmillisFeedbackCD /1000) / 60;
        int secs = (int)(timeleftinmillisFeedbackCD /1000) % 60;

        String TimeleftFormatted = String.format(Locale.getDefault(),"%02d:%02d", min, secs);
        FeedbackCDTextView.setText(TimeleftFormatted);

        if (timeleftinmillisFeedbackCD < 2000){
            resettimer();

        }

    }

    private void starttimer3(){
       RequestNotActiveCountdownTimer  = new CountDownTimer(RequestNotActiveTime, 1000) {

            @Override
            public void onTick(long millisuntillfinish2) {
                timeleftinmillisRequestNotActive = millisuntillfinish2;
                updatecountdowntext3();
            }

            @Override
            public void onFinish() {
                RequestNotActiveeIsRunning = false;
            }
        }.start();
        RequestNotActiveeIsRunning = true;
    }


    private void updatecountdowntext3() {
        int min = (int)(timeleftinmillisRequestNotActive /1000) / 60;
        int secs = (int)(timeleftinmillisRequestNotActive /1000) % 60;

        String TimeleftFormatted = String.format(Locale.getDefault(),"%02d:%02d", min, secs);
        RequestNotActiveTextView.setText(TimeleftFormatted);
if (BrickDetected == true){
    RequestNotActiveCountdownTimer.cancel();    // Super gay måde at løse problemet med at nulstille tiden men det virker, beklager fremtidige Morten.
    starttimer3();
    BrickDetected = false;
    Toast.makeText(this, "lol", Toast.LENGTH_SHORT).show();
}
    }


    private void resettimer(){
        timeleftinmillisFeedbackCD = FeedbackCooldown;
        updatecountdowntext2();
        FeedbackCoolDownCountdowntimer.cancel();

        KLodsIndputKnap.setEnabled(true);
        KLodsIndputKnap.setVisibility(View.VISIBLE);


    }

    private void resetetoveralltime(){
        timeleftinmillisSuperRequestTime = SuperRequestTid;
        updatecountdowntext();
        SuperRequestTidCountdownTimer.cancel();
        starttimer();
    }

    public void Klodsindtaget(View view) {
        starttimer2();
        BrickDetected = true;
        KLodsIndputKnap.setEnabled(false);
        KLodsIndputKnap.setVisibility(View.INVISIBLE);
       // StopAllIdleMovies();


        mediaPlayer = MediaPlayer.create(this, R.raw.wowowenwilson);
        mediaPlayer.start();

    }
/*
    private void StopAllIdleMovies() {
BennyOjne.stopPlayback();
    }

    private void PlayIdleMovies(){
        BennyOjne.start();
    }

*/
}
