package com.example.morte.bennygiftest;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class importlyd extends AppCompatActivity {

    private static final int MY_PERMISSION_REQUEST = 1;
    ArrayList<String> arrayList;
    ArrayList<String> arrayList2;
    ListView listview;
    ListView listview2;
    public MediaPlayer Mediaaaaa;
    ArrayAdapter<String> adapter;
    MediaPlayer mediaPlayer = new MediaPlayer();
    ArrayAdapter<String> adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_importlyd);

    if (ContextCompat.checkSelfPermission(importlyd.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
    {
        if (ActivityCompat.shouldShowRequestPermissionRationale(importlyd.this, Manifest.permission.READ_EXTERNAL_STORAGE)){
            ActivityCompat.requestPermissions(importlyd.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST);

        }
        else {
            ActivityCompat.requestPermissions(importlyd.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST);

        }

        }
        else{
        doStuff();

    }

    }

    public void doStuff (){

        listview = (ListView) findViewById(R.id.listview);
        listview2= (ListView) findViewById(R.id.listview2);
        arrayList = new ArrayList<>();
        arrayList2= new ArrayList<>();
        getMusic();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listview.setAdapter(adapter);
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList2);
        listview2.setAdapter(adapter2);

       Random r = new Random();
       int pjat = arrayList.size();
       int nyrandom = r.nextInt((pjat - 0)+1)+0;
       String lol = arrayList.get(nyrandom);
       yolo (lol);


    }

public void yolo (String lol){
    Uri myUri = Uri.parse(lol); // initialize Uri here

    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    try {
        mediaPlayer.setDataSource(getApplicationContext(),myUri);
    } catch (IOException e) {
        e.printStackTrace();
    }
    try {
        mediaPlayer.prepare();
    } catch (IOException e) {
        e.printStackTrace();
    }
    mediaPlayer.start();

}

    @Override
    protected void onStop() {
        super.onStop();
mediaPlayer.stop();
    }

    @Override
    protected void onPause() {
        super.onPause();
mediaPlayer.stop();
}

    public void getMusic(){

    ContentResolver contentResolver = getContentResolver();
    Uri songUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    Cursor songCurser = contentResolver.query(songUri,null  ,null,null,null);
    if (songCurser != null && songCurser.moveToFirst()){
       //int songtitel = songCurser.getColumnIndex(MediaStore.Audio.Media.TITLE);
        //int songartist = songCurser.getColumnIndex(MediaStore.Audio.Media.ARTIST);
        int songtitel = songCurser.getColumnIndex(MediaStore.Audio.Media.DATA);


        do {
            String currentTitle = songCurser.getString(songtitel);
        //    String currentartist = songCurser.getString(songartist);
            String DataPath = songCurser.getString(songtitel);

           // arrayList.add(currentTitle + "\n" + currentartist);
            char placeholder = currentTitle.charAt(0);

if (placeholder == 'G'){
  //  arrayList.add(currentTitle + "\n" + currentartist);

    arrayList.add(DataPath);

}
else {

//    arrayList2.add(currentTitle + "\n" + currentartist);

    arrayList.add(currentTitle);
}
        } while (songCurser.moveToNext());
    }

}

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,  int[] grantResults) {
       switch (requestCode){
           case MY_PERMISSION_REQUEST: {
               if (grantResults.length> 0 && grantResults[0] ==  PackageManager.PERMISSION_GRANTED){

                   if (ContextCompat.checkSelfPermission(importlyd.this,
                           Manifest.permission.READ_EXTERNAL_STORAGE) ==  PackageManager.PERMISSION_GRANTED) {
                       Toast.makeText(this, "Permssion granted buddy", Toast.LENGTH_LONG).show();

                       doStuff();
                   }
               } else  {
                   Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
                   finish();
               }
return;
           }
       }

    }
}
// https://www.youtube.com/watch?v=kf2fxYLOiSo

