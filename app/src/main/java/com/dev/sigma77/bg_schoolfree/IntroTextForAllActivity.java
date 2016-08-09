package com.dev.sigma77.bg_schoolfree;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;


public class IntroTextForAllActivity extends AppCompatActivity {
    public static TextView text;
    Button btnNext ;
    ImageButton btnSound;
    ImageView pic;
    private Toolbar toolbar;
    MediaPlayer mp;
    Locale myLocale;
    int textToSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_for_all_activitys);
        toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

//        if (!MainActivity.isTest) {
//            getSupportActionBar().setHomeButtonEnabled(true);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        }
        setTitle(R.string.title_activity_intro_text);
        Intent mIntent = getIntent();
          textToSet = mIntent.getIntExtra("IntroText",0);
        final int image = mIntent.getIntExtra("ImageToLoad", 0);
        final int exerciseNum = mIntent.getIntExtra("ExerciseNum", 0);
        final int testNum = mIntent.getIntExtra("TestNum", 0);
        final int introReading = mIntent.getIntExtra("IntroReading", 0);

        mp = MediaPlayer.create(IntroTextForAllActivity.this, introReading );
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        btnNext = (Button) findViewById(R.id.button);
     btnSound =(ImageButton) findViewById(R.id.imgSound);

        text = (TextView) findViewById(R.id.textView);
        text.setMovementMethod(new ScrollingMovementMethod());
        pic = (ImageView) findViewById(R.id.imageView);
        text.setText(textToSet);

        pic.setImageResource(image);


        View.OnClickListener oclBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.imageView:
                  case R.id.button:
                    {

                        startGame(exerciseNum, testNum);


                        finish();

                        break;
                    }
                    case R.id.imgSound:{
                        mp.start();

                        break;
                    }

                }

            }
        };
        btnNext.setOnClickListener(oclBtn);
        btnSound.setOnClickListener(oclBtn);
        pic.setOnClickListener(oclBtn);



    }

    private void startGame(int exerciseNum, int testNum) {
        switch (exerciseNum){
            case 1:{
                Intent in = new Intent(IntroTextForAllActivity.this, MethodsFor10AnswersActivitys.class);
                in.putExtra("TestNum", testNum);
                in.putExtra("GameName","Fingers");
                in.putExtra("Layout", "Count");
                startActivity(in);

                break;
            }
            case 2:{
                Intent in = new Intent(IntroTextForAllActivity.this, FindCorrectPic.class);
                in.putExtra("SceneNum", 1);
                in.putExtra("TestNum", testNum);
                in.putExtra("SceneName","NeedlessPic");
                startActivity(in);
                FindCorrectPic.currentGamePoints = 0;
                FindCorrectPic.correctAnswers = 0;

                break;
            }
            case 3:{
                Intent in = new Intent(IntroTextForAllActivity.this, FindCorrectPic.class);
                in.putExtra("SceneNum", 1);
                in.putExtra("TestNum", testNum);
                in.putExtra("SceneName","ShadowPic");
                startActivity(in);
                FindCorrectPic.currentGamePoints = 0;
                FindCorrectPic.correctAnswers = 0;

                break;
            }
            case 4:{
                Intent in = new Intent(IntroTextForAllActivity.this, ButtonActivity.class);
                in.putExtra("TestNum", testNum);
                startActivity(in);
                ButtonActivity.game =1;

                break;
            }
            case 5:{
                Intent in = new Intent(IntroTextForAllActivity.this, CroppedPicActivity.class);
                in.putExtra("TestNum", testNum);
                in.putExtra("SceneNum", 1);
                startActivity(in);

                break;
            }
            case 6:{
//                                Intent in = new Intent(IntroTextForAllActivity.this, FindUncorrectPic.class);
//                            in.putExtra("TestNum", testNum);
//                            startActivity(in);

                break;
            }

            case 7:{
                Intent in = new Intent(IntroTextForAllActivity.this, CountActivity.class);
                in.putExtra("TestNum", testNum);
                startActivity(in);
                CountActivity.game=2;

                break;
            }
            case 8:{

                break;
            }
            case 9:{
                Intent in = new Intent(IntroTextForAllActivity.this, ButtonActivity.class);
                in.putExtra("TestNum", testNum);
                startActivity(in);
                ButtonActivity.game =2;

                break;
            }
            case 10:{
                Intent in = new Intent(IntroTextForAllActivity.this, FindCorrectPic.class);
                in.putExtra("SceneNum", 2);
                in.putExtra("TestNum", testNum);
                in.putExtra("SceneName","ShadowPic");
                startActivity(in);
                FindCorrectPic.currentGamePoints = 0;
                FindCorrectPic.correctAnswers = 0;

                break;
            }
            case 11:{
                Intent in = new Intent(IntroTextForAllActivity.this, FindCorrectPic.class);
                in.putExtra("SceneNum", 2);
                in.putExtra("TestNum", testNum);
                in.putExtra("SceneName","NeedlessPic");
                startActivity(in);
                CroppedPicActivity.scene = 2;
                FindCorrectPic.currentGamePoints = 0;
                FindCorrectPic.correctAnswers = 0;

                break;
            }
            case 12:{
                Intent in = new Intent(IntroTextForAllActivity.this, CroppedPicActivity.class);
                in.putExtra("TestNum", testNum);
                in.putExtra("SceneNum", 2);
                startActivity(in);

                break;
            }
            case 13:{
                Intent in = new Intent(IntroTextForAllActivity.this, MemoryActivity.class);
                in.putExtra("TestNum", testNum);
                startActivity(in);

                break;
            }
            case 14:{
                Intent in = new Intent(IntroTextForAllActivity.this, ClockActivity.class);
                in.putExtra("TestNum", testNum);
                startActivity(in);

                break;
            }
            case 15:{
                Intent in = new Intent(IntroTextForAllActivity.this, SimilarityActivity.class);
                in.putExtra("TestNum", testNum);

                startActivity(in);

                break;
            }
            case 16:{
                Intent in = new Intent(IntroTextForAllActivity.this, MethodsFor10AnswersActivitys.class);
                in.putExtra("TestNum", testNum);
                in.putExtra("GameName","Digit");
                in.putExtra("Layout", "Count");
                startActivity(in);

                break;
            }
            case 17:{
                Intent in = new Intent(IntroTextForAllActivity.this, MethodsFor10AnswersActivitys.class);
                in.putExtra("TestNum", testNum);
                in.putExtra("GameName","Fingers");
                in.putExtra("Layout", "Count");
                startActivity(in);

                break;
            }case 18:{
                Intent in = new Intent(IntroTextForAllActivity.this, MethodsFor10AnswersActivitys.class);
                in.putExtra("TestNum", testNum);
                in.putExtra("GameName","Squares");
                in.putExtra("Layout", "Count");
                startActivity(in);

                break;
            }case 19:{
                Intent in = new Intent(IntroTextForAllActivity.this, MethodsFor10AnswersActivitys.class);
                in.putExtra("TestNum", testNum);
                in.putExtra("GameName","NextDigit");
                in.putExtra("Layout", "Count");
                startActivity(in);

                break;
            }
            case 20:{
                Intent in = new Intent(IntroTextForAllActivity.this, MethodsFor10AnswersActivitys.class);
                in.putExtra("TestNum", testNum);
                in.putExtra("Layout", "See digit");
                in.putExtra("GameName","SimilarityAnimals");
                startActivity(in);

                break;
            }
            case 21:{
                Intent in = new Intent(IntroTextForAllActivity.this, MethodsFor10AnswersActivitys.class);
                in.putExtra("TestNum", testNum);
                in.putExtra("Layout", "See digit");
                in.putExtra("GameName","SimilarityThings");
                startActivity(in);

                break;
            }
            case 22:{
                Intent in = new Intent(IntroTextForAllActivity.this, MethodsFor10AnswersActivitys.class);
                in.putExtra("TestNum", testNum);
                in.putExtra("Layout", "See digit");
                in.putExtra("GameName","SimilarityLetters");
                startActivity(in);

                break;
            }
            case 23:{
                Intent in = new Intent(IntroTextForAllActivity.this, MethodsFor10AnswersActivitys.class);
                in.putExtra("TestNum", testNum);
                in.putExtra("Layout", "See digit");
                in.putExtra("GameName","SimilarityLines");
                startActivity(in);

                break;
            }
            case 24:{
                Intent in = new Intent(IntroTextForAllActivity.this, MethodsFor10AnswersActivitys.class);
                in.putExtra("TestNum", testNum);
                in.putExtra("Layout", "See digit");
                in.putExtra("GameName","SimilarityHalfFigure");
                startActivity(in);

                break;
            }
            case 25:{
                Intent in = new Intent(IntroTextForAllActivity.this, MethodsFor10AnswersActivitys.class);
                in.putExtra("TestNum", testNum);
                in.putExtra("Layout", "See digit");
                in.putExtra("GameName","SimilarityArrows");
                startActivity(in);

                break;
            }
            case 26:{
                Intent in = new Intent(IntroTextForAllActivity.this, MethodsFor10AnswersActivitys.class);
                in.putExtra("TestNum", testNum);
                in.putExtra("Layout", "See digit");
                in.putExtra("GameName","SimilarityCubes");
                startActivity(in);

                break;
            }
            case 27:{
                Intent in = new Intent(IntroTextForAllActivity.this, MethodsFor10AnswersActivitys.class);
                in.putExtra("TestNum", testNum);
                in.putExtra("Layout", "See digit");
                in.putExtra("GameName","SimilarityDice");
                startActivity(in);

                break;
            }
            case 28:{
                Intent in = new Intent(IntroTextForAllActivity.this, MethodsFor10AnswersActivitys.class);
                in.putExtra("TestNum", testNum);
                in.putExtra("Layout", "Count");
                in.putExtra("GameName","CubeBloks");
                startActivity(in);

                break;
            }
            case 29:{
                Intent in = new Intent(IntroTextForAllActivity.this, MethodsFor10AnswersActivitys.class);
                in.putExtra("TestNum", testNum);
                in.putExtra("Layout", "Count");
                in.putExtra("GameName","CubesCount");
                startActivity(in);

                break;
            }
            case 30:{
                Intent in = new Intent(IntroTextForAllActivity.this, MIdleDigit.class);
                in.putExtra("TestNum", testNum);

                startActivity(in);

                break;
            }

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intro_text_for_all_activity, menu);
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
                selLocale("bg");
                break;
            case R.id.en:
                item.setChecked(true);
                selLocale("en");

                break;
            case R.id.ru:
                item.setChecked(true);
                selLocale("ru");
                break;
            case R.id.de:
                item.setChecked(true);
                selLocale("de");
                break;
            case R.id.action_settings:
                startActivity(new Intent(this, HelpActivity.class));


            default:
             //   selLocale("en");


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

        setTitle(R.string.title_activity_intro_text);
        text.setText(textToSet);
        super.onConfigurationChanged(newConfig);

    }
}
