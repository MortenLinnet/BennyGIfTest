package com.example.morte.bennygiftest;

import android.net.Uri;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class BennyNewEyes extends AppCompatActivity {


    long StartRequestTimer = System.currentTimeMillis();
    long StartFeedbackTimer = System.currentTimeMillis();
    int lol =1 ;
    long RequestTimer;
    long FeedbackTimer;
    long trold;
    int nada= 0;
    boolean klovn = true;

    private static final long  START_TIME_IN_MILLIS = 10000;
    private CountDownTimer McountDownTimer;
    private boolean mTimerRunning;
    private long mLEFt_IN_MILLIS = START_TIME_IN_MILLIS;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benny_new_eyes);
  RequestTimer = StartRequestTimer;
  FeedbackTimer = StartFeedbackTimer;
lol();


        WindowManager.LayoutParams layout = getWindow().getAttributes();
        layout.screenBrightness = 1F; //https://developer.android.com/reference/android/view/WindowManager.LayoutParams#screenBrightness 1 er max value
        getWindow().setAttributes(layout);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);   // disable sleep også i manifest.
    }


 protected void  skiftbillede(int ValgAfOjne){

     VideoView BennyOjne = findViewById(R.id.GifView);

     String[] stringarray = getResources().getStringArray(R.array.BennyOjneArray);


BennyOjne.setAlpha(1);
    String pathKort = "android.resource://com.example.morte.bennygiftest/" +R.raw.ojnekort;

     Uri uriKort = Uri.parse(pathKort);

     String pathLang = "android.resource://com.example.morte.bennygiftest/" +R.raw.ojnelang;

     Uri uriLang =Uri.parse(pathLang);

     if (ValgAfOjne == 1){
    BennyOjne.setVideoURI(uriKort);
BennyOjne.start();
}
if (ValgAfOjne == 2){
         BennyOjne.setVideoURI(uriLang);
         BennyOjne.start();

}



}


    public void KlikPaaOjne(View view) {


if (klovn){

    Button mbutton = findViewById(R.id.SkiftOjne);
    Toast.makeText(this, "FeedBack", Toast.LENGTH_SHORT).show();

    klovn = false;
    mbutton.setEnabled(false);
    lol();
}
else{

    Toast.makeText(this, "Cooldown", Toast.LENGTH_SHORT).show();

}
        /*if (StartRequestTimer == FeedbackTimer || StartRequestTimer > trold + 5000 ){
trold = StartRequestTimer;
            //DoStuff
            if (Klodsindtaget == 1 ){
                Klodsindtaget++;
            }
            else if (Klodsindtaget== 2){
                Klodsindtaget--;
            }

            skiftbillede(Klodsindtaget);


            Toast.makeText(this, "RequestTimerReset  " + nada, Toast.LENGTH_SHORT).show();
            StartRequestTimer = System.currentTimeMillis();
        }
        else
            {
                Toast.makeText(this, "CoolDown", Toast.LENGTH_SHORT).show();
              trold = StartRequestTimer;
              StartRequestTimer=System.currentTimeMillis();
            }
        nada++;
    */}

public void provermedcountdowntimer(){

if (mTimerRunning && mLEFt_IN_MILLIS < 10000 ){
    mLEFt_IN_MILLIS = 50000;

    Toast.makeText(this, "FeedBack", Toast.LENGTH_SHORT).show();
}
else{
    Toast.makeText(this, "Cooldown", Toast.LENGTH_SHORT).show();
}
}

    private void lol (){
        McountDownTimer = new CountDownTimer(mLEFt_IN_MILLIS, 1000){

            @Override
            public void onTick(long millisUntilFinish) {
                mLEFt_IN_MILLIS = millisUntilFinish;

            }

            @Override
            public void onFinish() {
           klovn = true;
                Button mbutton = findViewById(R.id.SkiftOjne);
                mbutton.setEnabled(true);
            }
        }.start();
        mTimerRunning = true;


    }





public void metodeansvarligforaltmedtid(){



if (StartRequestTimer + 30000 > StartRequestTimer){

    //DoStuff


    Toast.makeText(this, "RequestTimerReset" + StartRequestTimer, Toast.LENGTH_SHORT).show();
    StartRequestTimer = System.currentTimeMillis();
}

if (StartFeedbackTimer + 3000 > StartFeedbackTimer){
            //DoStuff


            StartFeedbackTimer = System.currentTimeMillis();
            Toast.makeText(this, "FeedbackTimerReset" + StartFeedbackTimer, Toast.LENGTH_SHORT).show();
}



    }
}
