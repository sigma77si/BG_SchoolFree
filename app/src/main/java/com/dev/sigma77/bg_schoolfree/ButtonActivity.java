package com.dev.sigma77.bg_schoolfree;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.dev.sigma77.bg_schoolfree.util.Transition;
import com.dev.sigma77.bg_schoolfree.util.TransitionParams;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;


public class ButtonActivity extends AppCompatActivity implements View.OnClickListener {

    static int game=1;
    SoundPool sp;
    Button check;
    boolean isEnd;
    int numofAnswers, correctAnswers,currentGamePoints= 0,correctSound, wrongSound, endSound,clickAnswerSound;
    ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11,
            btn12, btn13, btn14, btn15, btn16;

    ImageButton[] buttonsArray;
    Map<Integer, ImageButton> buttonMap = new HashMap<>();
    Set<Integer> correctAnswersSet = new HashSet<>();
    private int testNum;
    private Toolbar toolbar;
    int maxGames=2;
    Locale  myLocale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        setTitle(R.string.d_viz_adapter_title);

        if (!MainActivity.isTest) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        btn1 = (ImageButton) findViewById(R.id.imageButton1);
        btn2 = (ImageButton) findViewById(R.id.imageButton2);
        btn3 = (ImageButton) findViewById(R.id.imageButton3);
        btn4 = (ImageButton) findViewById(R.id.imageButton4);
        btn5 = (ImageButton) findViewById(R.id.imageButton5);
        btn6 = (ImageButton) findViewById(R.id.imageButton6);
        btn7 = (ImageButton) findViewById(R.id.imageButton7);
        btn8 = (ImageButton) findViewById(R.id.imageButton8);
        btn9 = (ImageButton) findViewById(R.id.imageButton9);
        btn10 = (ImageButton) findViewById(R.id.imageButton10);
        btn11 = (ImageButton) findViewById(R.id.imageButton11);
        btn12 = (ImageButton) findViewById(R.id.imageButton12);
        btn13 = (ImageButton) findViewById(R.id.imageButton13);
        btn14 = (ImageButton) findViewById(R.id.imageButton14);
        btn15 = (ImageButton) findViewById(R.id.imageButton15);
        btn16 = (ImageButton) findViewById(R.id.imageButton16);
        check = (Button) findViewById(R.id.btnCheck);
        buttonsArray= new ImageButton[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11,
                btn12, btn13, btn14, btn15, btn16};

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);
        check.setOnClickListener(this);

        buttonMap.put(R.id.imageButton1, btn1);
        buttonMap.put(R.id.imageButton2, btn2);
        buttonMap.put(R.id.imageButton3, btn3);
        buttonMap.put(R.id.imageButton4, btn4);
        buttonMap.put(R.id.imageButton5, btn5);
        buttonMap.put(R.id.imageButton6, btn6);
        buttonMap.put(R.id.imageButton7, btn7);
        buttonMap.put(R.id.imageButton8, btn8);
        buttonMap.put(R.id.imageButton9, btn9);
        buttonMap.put(R.id.imageButton10, btn10);
        buttonMap.put(R.id.imageButton11, btn11);
        buttonMap.put(R.id.imageButton12, btn12);
        buttonMap.put(R.id.imageButton13, btn13);
        buttonMap.put(R.id.imageButton14, btn14);
        buttonMap.put(R.id.imageButton15, btn15);
        buttonMap.put(R.id.imageButton16, btn16);


        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        correctSound = sp.load(this, R.raw.zvukpravilno, 1);
        wrongSound = sp.load(this, R.raw.zvukgreshka, 1);
        endSound = sp.load(this, R.raw.endmussic, 1);
        clickAnswerSound= sp.load(this, R.raw.sound, 1);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        setCorrectAnswers();

        Intent mIntent = getIntent();
        testNum = mIntent.getIntExtra("TestNum", 0);

    }

    private void setCorrectAnswers() {
        if(game==1){
            correctAnswersSet.add(R.id.imageButton15);
            correctAnswersSet.add(R.id.imageButton9);
            correctAnswersSet.add(R.id.imageButton4);
        }
       else if(game==2){
            correctAnswersSet.add(R.id.imageButton2);
            correctAnswersSet.add(R.id.imageButton8);
            correctAnswersSet.add(R.id.imageButton14);

        }
        correctAnswers=0;
        currentGamePoints=0;
        numofAnswers=0;
        setGameCorrectAnswerImgs();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_button, menu);
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
//                setLocale("bg");
//                break;
//            case R.id.en:
//                item.setChecked(true);
//                setLocale("en");
//
//                break;
//            case R.id.ru:
//                item.setChecked(true);
//                setLocale("ru");
//                break;
//            case R.id.de:
//                item.setChecked(true);
//                setLocale("de");
//                break;
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

        setTitle(R.string.d_viz_adapter_title);
        check.setText(R.string.check);
        super.onConfigurationChanged(newConfig);




    }

    @Override
    public void onClick(View v) {
        int selectedButtonId = v.getId();

        switch (selectedButtonId) {


//
            case R.id.btnCheck: {
                check.setClickable(false);


                isEnd=true;
                setAnswerBgrColor();
                if (correctAnswers == 3) {
                    currentGamePoints = 1;
                    sp.play(correctSound, 1, 1, 0, 0, 1);
                } else {
                    sp.play(wrongSound, 1, 1, 0, 0, 1);
                }
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        setAllBtnsBgrWhite();
//                    }
//                },3500);

               toShowRessultActiv();
                break;
            }

            default:{
                if (numofAnswers==3) {
                    disableButtonsClick();

                } else {
                    sp.play(clickAnswerSound, 1, 1, 0, 0, 1);
                    ImageButton selectedButton = buttonMap.get(selectedButtonId);
                    setBgrGrey(selectedButton);
                    selectedButton.setClickable(false);
                    if(correctAnswersSet.contains(selectedButtonId)){
                        correctAnswers++;
                    }
                }
            }


        }

    }
    public void setGameCorrectAnswerImgs(){
        if(game==2){
            btn8.setImageResource(R.drawable.button2);
            btn4.setImageResource(R.drawable.button8);
            btn14.setImageResource(R.drawable.button2);

        }


    }

    private void setAnswerBgrColor() {
       // if (numofAnswers >= 3) {
            if (game==1){
                btn4.setBackgroundResource(R.drawable.shapes4);
                btn9.setBackgroundResource(R.drawable.shapes4);
                btn15.setBackgroundResource(R.drawable.shapes4);
            }
            else if(game==2){
                btn2.setBackgroundResource(R.drawable.shapes4);
                btn8.setBackgroundResource(R.drawable.shapes4);
                btn14.setBackgroundResource(R.drawable.shapes4);

            }

    }


    private void toShowRessultActiv() {
        if(MainActivity.isTest == true){
            isEnd=true;
            if(game==1){
                ResultActivity.isLastTest=true;

            }
            TransitionParams transitionParams = new TransitionParams();
            transitionParams.setIsEnd(isEnd);
            transitionParams.setpActivity(this);
            transitionParams.setTestNumber(testNum);
            transitionParams.setpCorrectAnswers(correctAnswers);
            transitionParams.setpCurrentGamePoints(currentGamePoints);
            Transition.toNextActivity(transitionParams);

        }else {
            if(game < maxGames) {


                isEnd=false;
                new Handler().postDelayed(new ShowResults(this, correctAnswers, currentGamePoints, isEnd), 1500);
                correctAnswersSet.clear();
                game++;

                setCorrectAnswers();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setAllBtnsBgrWhite();
                        unableButtonsClick();
                        check.setClickable(true);
                    }
                },3500);

            }

             else {
                new Handler().postDelayed(new ShowResults(this, correctAnswers, currentGamePoints, isEnd), 1500);
            }

            //   new Handler().postDelayed(new RunnableShowAnswers(this,MainActivity.class), 4700);
        }
        //btn15.setBackgroundColor(getResources().getColor(R.color.green));
    }
    private  void disableButtonsClick(){

        for (int i=0;i<buttonsArray.length;i++) {
            buttonsArray[i].setClickable(false);
        }

    }
    private  void unableButtonsClick(){

        for (int i=0;i<buttonsArray.length;i++) {
            buttonsArray[i].setClickable(true);
        }

    }

    private void setAllBtnsBgrWhite() {
        btn1.setBackgroundColor(Color.WHITE);
        btn2.setBackgroundColor(Color.WHITE);
        btn3.setBackgroundColor(Color.WHITE);
        btn4.setBackgroundColor(Color.WHITE);
        btn5.setBackgroundColor(Color.WHITE);
        btn6.setBackgroundColor(Color.WHITE);
        btn7.setBackgroundColor(Color.WHITE);
        btn8.setBackgroundColor(Color.WHITE);
        btn9.setBackgroundColor(Color.WHITE);
        btn10.setBackgroundColor(Color.WHITE);
        btn11.setBackgroundColor(Color.WHITE);
        btn12.setBackgroundColor(Color.WHITE);
        btn13.setBackgroundColor(Color.WHITE);
        btn14.setBackgroundColor(Color.WHITE);
        btn15.setBackgroundColor(Color.WHITE);
        btn16.setBackgroundColor(Color.WHITE);
    }

    public void setBgrGrey(ImageButton btn) {

            numofAnswers++;
            //btn.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_200));
            btn.setBackgroundResource(R.drawable.shapes2);


    }
}
