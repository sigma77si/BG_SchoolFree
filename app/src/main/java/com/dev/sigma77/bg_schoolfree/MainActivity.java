package com.dev.sigma77.bg_schoolfree;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static boolean isTest = false;

   static Button practice;
    static Button test;
    static Button btnPro;
    Locale myLocale;
    SoundPool sp;
    MediaPlayer mp;
    boolean callMain;
    int introSound, bipSound, clickAnswerSound;

    public static List<String> correctAnswersList = new ArrayList<>();
    public static List<String> gamePointsList = new ArrayList<>();
    private Toolbar toolbar;
    static View appbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // myLocale = java.util.Locale.getDefault().getLanguage();
        Intent mIntent = getIntent();
        callMain= mIntent.getBooleanExtra("CallMain",false);
        setContentView(R.layout.activity_main);

        practice = (Button) findViewById(R.id.btnPractice);
        test = (Button) findViewById(R.id.btnTest);

         appbar=findViewById(R.id.app_bar);
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
//
        switch (item.getItemId()) {
//            case R.id.bg:
//                item.setChecked(true);
//                selLocale("bg");
//                break;
//            case R.id.en:
//                item.setChecked(true);
//                selLocale("en");
//
//                break;
//            case R.id.ru:
//                item.setChecked(true);
//                selLocale("ru");
//                break;
//            case R.id.de:
//                item.setChecked(true);
//                selLocale("de");
//                break;
            case R.id.action_settings:
                startActivity(new Intent(this, HelpActivity.class));


            default:
              //  selLocale("en");


        }
        return true;
    }

    private void selLocale(String language) {
        myLocale =new Locale(language);
        Resources res=getResources();
        DisplayMetrics dm =res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale= myLocale;
        res.updateConfiguration(conf,dm);
   //     Intent intent=new Intent(this,MainActivity.class);
//        finish();
//        startActivity(intent);
        onConfigurationChanged(conf);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        practice.setText(R.string.preparation);
        test.setText(R.string.test);
        setTitle(R.string.app_name);

        super.onConfigurationChanged(newConfig);

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
            case R.id.btnTest: {
                isTest = true;
                Intent in = new Intent(this, TestActivity.class);

                startActivity(in);

                break;
            }
            case R.id.btnPractice: {

                Intent in = new Intent(this, PracticeActivity.class);

                startActivity(in);

                break;
            }
        }

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        setTitle(R.string.app_name);
        practice.setText(R.string.preparation);
        test.setText(R.string.test);
    }
}
