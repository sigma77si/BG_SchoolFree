package com.dev.sigma77.bg_schoolfree;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static boolean isTest = false;

    Button practice;
    Button test;
    static Button btnPro;
    SoundPool sp;
    MediaPlayer mp;
    boolean callMain;
    int introSound, bipSound, clickAnswerSound;

    public static List<String> correctAnswersList = new ArrayList<>();
    public static List<String> gamePointsList = new ArrayList<>();
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent mIntent = getIntent();
        callMain= mIntent.getBooleanExtra("CallMain",false);
        setContentView(R.layout.activity_main);

        practice = (Button) findViewById(R.id.btnGame7);
        test = (Button) findViewById(R.id.btnGame8);


        toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        practice.setOnClickListener(this);
        test.setOnClickListener(this);

        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        introSound = sp.load(this, R.raw.intro_one, 1);
        bipSound = sp.load(this, R.raw.blub, 1);
        clickAnswerSound = sp.load(this, R.raw.sound, 1);
        mp = MediaPlayer.create(MainActivity.this, R.raw.intro_one);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
//            return true;
            //HelpActivity.text.setText(R.string.help);
            startActivity(new Intent(this, HelpActivity.class));

        }
//        if (id == R.id.navigate) {
//            startActivity(new Intent(this,HelpActivity.class));
//            new Handler().postDelayed(new Runnable() {
//
//                @Override
//                public void run() {
//
//                    HelpActivity.text.setText(R.string.about);
//                }
//            }, 4950);
//
//
//        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onPause() {
        super.onPause();
        ResultActivity.result = -1;

        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }

//        getPreferences(MODE_PRIVATE).edit().putInt("Result",0).commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {


//
            case R.id.btnGame7: {
                isTest = true;
                Intent in = new Intent(this, TestActivity.class);

                startActivity(in);

                break;
            }
            case R.id.btnGame8: {
                isTest = true;
                Intent in = new Intent(this, PracticeActivity.class);

                startActivity(in);

                break;
            }
        }

    }
}
