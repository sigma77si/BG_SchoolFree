package com.dev.sigma77.bg_schoolfree;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.dev.sigma77.bg_schoolfree.util.Transition;
import com.dev.sigma77.bg_schoolfree.util.TransitionParams;

import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

public class ClockActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn1, btn2, btn3;
    ImageView clock;
    String[]btn3Time=new String[12];
    String[]btn2Time=new String[12];
    String[]btn1Time=new String[12];

    int[]imgClock=new int[12];
    int[]correctAnswerBtn=new int[12];
    int sceneNum,correctAnswer;
    SoundPool sp;
    private int testNum;
    int count=0;
    int correctSound, wrongSound, endSound,clickAnswerSound;
    Set passedScens=new HashSet();
    int randomScene;
     int currentGamePoints = 0, correctAnswers = 0;
    private Toolbar toolbar;
    Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);


        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        setTitle(R.string.h_viz_adapter_title);
        if (!MainActivity.isTest) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btn1= (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2);
        btn3= (Button) findViewById(R.id.btn3);
        clock= (ImageView) findViewById(R.id.imgClock);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        imgClock[0]=R.drawable.clock1;
        imgClock[1]=R.drawable.clock2;
        imgClock[2]=R.drawable.clock3;
        imgClock[3]=R.drawable.clock4;
        imgClock[4]=R.drawable.clock5;
        imgClock[5]=R.drawable.clock6;
        imgClock[6]=R.drawable.clock7;
        imgClock[7]=R.drawable.clock8;
        imgClock[8]=R.drawable.clock9;
        imgClock[9]=R.drawable.clock10;
        imgClock[10]=R.drawable.clock11;
        imgClock[11]=R.drawable.clock12;

        btn1Time[0]="2:00";
        btn1Time[1]="1:00";
        btn1Time[2]="9:00";
        btn1Time[3]="4:55";
        btn1Time[4]="5:00";
        btn1Time[5]="12:00";
        btn1Time[6]="9:15";
        btn1Time[7]="6:40";
        btn1Time[8]="4:05";
        btn1Time[9]="7:55";
        btn1Time[10]="3:45";
        btn1Time[11]="1:30";

        btn2Time[0]="1:00";
        btn2Time[1]="2:45";
        btn2Time[2]="12:45";
        btn2Time[3]="5:55";
        btn2Time[4]="5:05";
        btn2Time[5]="12:30";
        btn2Time[6]="9:40";
        btn2Time[7]="6:50";
        btn2Time[8]="5:10";
        btn2Time[9]="8:00";
        btn2Time[10]="9:15";
        btn2Time[11]="1:35";

        btn3Time[0]="12:00";
        btn3Time[1]="9:10";
        btn3Time[2]="9:15";
        btn3Time[3]="11:20";
        btn3Time[4]="4:05";
        btn3Time[5]="6:00";
        btn3Time[6]="8:45";
        btn3Time[7]="10:30";
        btn3Time[8]="10:20";
        btn3Time[9]="11:40";
        btn3Time[10]="2:45";
        btn3Time[11]="1:40";

        correctAnswerBtn[0]=R.id.btn1;
        correctAnswerBtn[1]=R.id.btn3;
        correctAnswerBtn[2]=R.id.btn2;
        correctAnswerBtn[3]=R.id.btn3;
        correctAnswerBtn[4]=R.id.btn2;
        correctAnswerBtn[5]=R.id.btn3;
        correctAnswerBtn[6]=R.id.btn3;
        correctAnswerBtn[7]=R.id.btn3;
        correctAnswerBtn[8]=R.id.btn2;
        correctAnswerBtn[9]=R.id.btn1;
        correctAnswerBtn[10]=R.id.btn1;
        correctAnswerBtn[11]=R.id.btn2;
        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        correctSound = sp.load(this, R.raw.zvukpravilno, 1);
        wrongSound = sp.load(this, R.raw.zvukgreshka, 1);
        endSound = sp.load(this, R.raw.endmussic, 1);
        clickAnswerSound= sp.load(this, R.raw.sound, 1);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        Intent mIntent = getIntent();
        testNum = mIntent.getIntExtra("TestNum", 0);
        generateRandomScene();

    }

    @Override
    public void onClick(View v) {
       int answer= v.getId();

        if (count==12) {
            btn1.setClickable(false);
            btn2.setClickable(false);
            btn3.setClickable(false);
        }
        checkAnswr(answer);

    }
    public void checkAnswr(int answer){
        if(answer==correctAnswer){
            sp.play(correctSound, 1, 1, 0, 0, 1);
            correctAnswers++;
        }
        else {
            sp.play(wrongSound, 1, 1, 0, 0, 1);

        }
        generateRandomScene();
    }
    public void setContent(){
        btn1.setText(btn1Time[randomScene]);
        btn2.setText(btn2Time[randomScene]);
        btn3.setText(btn3Time[randomScene]);
        clock.setImageResource(imgClock[randomScene]);
        correctAnswer=correctAnswerBtn[randomScene];

    }
    public void generateRandomScene(){

        passedScens.add(randomScene);

        if(count<12){
            Random rnd = new Random();
            randomScene = rnd.nextInt(12) ;
            while (passedScens.contains(randomScene)&&passedScens.size()<12) {
                randomScene = rnd.nextInt(12) ;
            }
            setContent();
            count++;
        }
        else {
            btn1.setClickable(false);
            btn2.setClickable(false);
            btn3.setClickable(false);
            boolean isEnd = true;
            if(correctAnswers==12){
                currentGamePoints=1;
            }
            TransitionParams transitionParams = new TransitionParams();
            transitionParams.setIsEnd(isEnd);
            transitionParams.setpActivity(this);
            transitionParams.setTestNumber(testNum);
            transitionParams.setpCorrectAnswers(correctAnswers);
            transitionParams.setpCurrentGamePoints(currentGamePoints);
            Transition.toNextActivity(transitionParams);
//            putExtraStartResultActivity();
//            finish();
        }
    }
    private void putExtraStartResultActivity() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("GamePoints", currentGamePoints);
        intent.putExtra("CorrectAnswers", correctAnswers);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_clock, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
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
        //        selLocale("en");


        }
        return super.onOptionsItemSelected(item);
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

        setTitle(R.string.h_viz_adapter_title);

        super.onConfigurationChanged(newConfig);

    }

}
