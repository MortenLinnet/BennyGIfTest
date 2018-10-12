package com.example.morte.bennygiftest;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class Forside extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forside);
       handleHeadphonesState(this);



    }



    public void handleHeadphonesState(Context context){
        AudioManager am = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);

        if(am.isWiredHeadsetOn()) {
            // handle headphones plugged in


        } else{

            final AlertDialog.Builder mBuilder = new AlertDialog.Builder(Forside.this);
            View mView = getLayoutInflater().inflate(R.layout.alertdialogbox, null);
            Button mOk = (Button) mView.findViewById(R.id.Alertbutton);
            mBuilder.setView(mView);
            final AlertDialog dialog = mBuilder.create();

            mOk.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {

dialog.dismiss();

                }
            });
dialog.show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    handleHeadphonesState(this);
    }

    public void OpenBennyEyes(View view) {
        Intent i = new Intent(this, BennyNewEyes.class); startActivity(i);

    }

    public void KlikpåLydTjek(View view) {

        Intent i = new Intent(this, lydactivity.class); startActivity(i);
    }

    public void importlyd(View view) {
        Intent i = new Intent(this, importlyd.class); startActivity(i);
    }

    public void startCountdownActivity(View view) {

        Intent i = new Intent(this, NedtallingMedTreTider.class); startActivity(i);
    }

    public void chancetid(View view) {
        Intent i = new Intent(this, ProbabilityActivityNoPunIntended.class); startActivity(i);
    }
}
