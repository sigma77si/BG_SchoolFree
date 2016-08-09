package com.dev.sigma77.bg_schoolfree;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;


public class ResultActivity extends ActionBarActivity implements View.OnClickListener {
    TextView textResults, textCorrect,textPoints, textTestResult, currentCorrectResult,points,textGamePoints;
    public static TextView testResultView;
    Button ok;
    ImageView star;
    private Toolbar toolbar;
   static LinearLayout testResultLayout;
   public static int result;
    public static boolean isLastTest;
    MediaPlayer mp;
    Locale myLocale;

  //  List<String> correctAnswersSet = new ArrayList<>();
   // List<String> gamePointsSet = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textResults = (TextView) findViewById(R.id.textResults);
        textCorrect = (TextView) findViewById(R.id.textCorrect);
        textPoints = (TextView) findViewById(R.id.textPoints);
        textGamePoints = (TextView) findViewById(R.id.textGamePoints);
        textTestResult = (TextView) findViewById(R.id.textTestResult);
        currentCorrectResult = (TextView) findViewById(R.id.currentCorrectResult);
        testResultView = (TextView) findViewById(R.id.testPoints);
        testResultLayout= (LinearLayout) findViewById(R.id.testResultLayout);
        points = (TextView) findViewById(R.id.points);
        ok= (Button) findViewById(R.id.btnOk);
        star= (ImageView) findViewById(R.id.imgStar);
        ok.setOnClickListener(this);
        toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        setTitle(R.string.title_activity_result);

        Intent mIntent = getIntent();
        if (!MainActivity.isTest) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
       int gamePoints = mIntent.getIntExtra("GamePoints", 0);
        int gameCorrectAnswers = mIntent.getIntExtra("CorrectAnswers", 0);
        MainActivity.correctAnswersList.add(String.valueOf(gameCorrectAnswers));
        MainActivity.gamePointsList.add(String.valueOf(gamePoints));

        if(result!=-1) {
            result = getPreferences(MODE_PRIVATE).getInt("Result", 0);
        }
        else{
            result=0;
        }
        setResults(gamePoints,gameCorrectAnswers);

//        new Handler().postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//
//                finish();
//            }
//        }, 4700);
        mp = MediaPlayer.create(ResultActivity.this, R.raw.intro_one);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        if (mp != null) {

            mp.release();
            mp = null;
        }

    }
    @Override
    protected void onStop()
    {
        super.onStop();
        if (mp != null) {

            mp.release();
            mp = null;
            finish();

        }

    }


    @Override
    protected void onPause() {


        super.onPause();
//
        getPreferences(MODE_PRIVATE).edit().putInt("Result", result).commit();
        if (mp != null) {

            mp.release();
            mp = null;
        }

    }

    private void setResults(int currentPoints,int gameCorrectAnswers) {
        result+= currentPoints;
        testResultView.setText(Integer.toString(result));
        currentCorrectResult.setText(Integer.toString(gameCorrectAnswers));
        String allPoints=Integer.toString(currentPoints);
                points.setText(allPoints);
        if(currentPoints==1){
            star.setImageResource(R.drawable.gold_star);
            mp = MediaPlayer.create(ResultActivity.this, R.raw.tada_sound);
            mp.start();

        }
        else{

            mp = MediaPlayer.create(ResultActivity.this, R.raw.wrong_anwer);
            mp.start();

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.bg:
                item.setChecked(true);
                setLocale("bg");
                break;
            case R.id.en:
                item.setChecked(true);
                setLocale("en");

                break;
            case R.id.ru:
                item.setChecked(true);
                setLocale("ru");
                break;
            case R.id.de:
                item.setChecked(true);
                setLocale("de");
                break;
            case R.id.action_settings:
                startActivity(new Intent(this, HelpActivity.class));


            default:
                //    setLocale("en");


        }
        return super.onOptionsItemSelected(item);
    }
    private void setLocale(String language) {
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

        setTitle(R.string.title_activity_result);
        textResults.setText(R.string.game_result);
        textCorrect.setText(R.string.correct);
        textPoints.setText(R.string.points);
        textTestResult.setText(R.string.final_result);
        textGamePoints.setText(R.string.points);
        ok.setText(R.string.ok);

        super.onConfigurationChanged(newConfig);





    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOk:{
                if(isLastTest==true){

                    Intent in = new Intent(this, TestResultsActivity.class);

                   in.putStringArrayListExtra("GamesCorrectAnswers",(ArrayList<String>)MainActivity.correctAnswersList);
                    in.putStringArrayListExtra("GamesPoints", (ArrayList<String>) MainActivity.gamePointsList);
                    in.putExtra("AllPoints",result);
                    startActivity(in);

                }
                this.finish();
                break;

            }

        }
    }
}
