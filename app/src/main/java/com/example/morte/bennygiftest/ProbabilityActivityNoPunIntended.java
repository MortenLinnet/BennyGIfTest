package com.example.morte.bennygiftest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class ProbabilityActivityNoPunIntended extends AppCompatActivity {

    private TextView CurrentNumber;
    private TextView HardTask;
    private TextView EasyTask;

    private int HardTaskProperbility;
    private int EasyTaskProperbility;
    private int currentNUMBER = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probability_no_pun_intended);

        CurrentNumber = findViewById(R.id.CurrentnumberText);
        HardTask = findViewById(R.id.HardTaskText);
        EasyTask = findViewById(R.id.EasyTaskText);

    }


    public void LetTheMagicHappen(View view) {
           Random r = new Random();
            int n = r.nextInt(100);
        CurrentNumber.setText("Det samlede antal klik er nu oppe på;" + currentNUMBER++);
            if (n <= 40) //HardTask;
            {
             HardTaskProperbility++;
             HardTask.setText("De svære opgaver er nu oppe på: " + HardTaskProperbility );
            }

            if (n > 40) //EzTask
            {
                EasyTaskProperbility++;
                EasyTask.setText("De nemme opgaver er nu oppe på: " + EasyTaskProperbility);
            }





    }


}
