package com.dev.sigma77.bg_schoolfree;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.dev.sigma77.bg_schoolfree.util.Transition;
import com.dev.sigma77.bg_schoolfree.util.TransitionParams;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MIdleDigit extends Activity implements View.OnClickListener {
    SoundPool sp;

    boolean isEnd;
    int numofAnswers, correctAnswers,currentGamePoints= 0,correctSound, wrongSound, endSound,clickAnswerSound;
   Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11,
            btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20,btn21,
    btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30,btn31,
    btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40,btn41,
    btn42, btn43, btn44, btn45, btn46, btn47, btn48, btn49, btn50,btn51,
    btn52, btn53, btn54, btn55, btn56, btn57, btn58, btn59, btn60,check;

    Map<Integer, Button> buttonMap = new HashMap<>();
    Set<Integer> correctAnswersSet = new HashSet<>();
    private int testNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midle_digit);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn10 = (Button) findViewById(R.id.btn10);
        btn11 = (Button) findViewById(R.id.btn11);
        btn12 = (Button) findViewById(R.id.btn12);
        btn13 = (Button) findViewById(R.id.btn13);
        btn14 = (Button) findViewById(R.id.btn14);
        btn15 = (Button) findViewById(R.id.btn15);
        btn16 = (Button) findViewById(R.id.btn16);
        btn17 = (Button) findViewById(R.id.btn17);
        btn18 = (Button) findViewById(R.id.btn18);
        btn19 = (Button) findViewById(R.id.btn19);
        btn20 = (Button) findViewById(R.id.btn20);
        btn21 = (Button) findViewById(R.id.btn21);
        btn22 = (Button) findViewById(R.id.btn22);
        btn23 = (Button) findViewById(R.id.btn23);
        btn24 = (Button) findViewById(R.id.btn24);
        btn25 = (Button) findViewById(R.id.btn25);
        btn26 = (Button) findViewById(R.id.btn26);
        btn27 = (Button) findViewById(R.id.btn27);
        btn28 = (Button) findViewById(R.id.btn28);
        btn29 = (Button) findViewById(R.id.btn29);
        btn30 = (Button) findViewById(R.id.btn30);
        btn31 = (Button) findViewById(R.id.btn31);
        btn32 = (Button) findViewById(R.id.btn32);
        btn33 = (Button) findViewById(R.id.btn33);
        btn34 = (Button) findViewById(R.id.btn34);
        btn35 = (Button) findViewById(R.id.btn35);
        btn36 = (Button) findViewById(R.id.btn36);
        btn37 = (Button) findViewById(R.id.btn37);
        btn38 = (Button) findViewById(R.id.btn38);
        btn39 = (Button) findViewById(R.id.btn39);
        btn40 = (Button) findViewById(R.id.btn40);
        btn41 = (Button) findViewById(R.id.btn41);
        btn42 = (Button) findViewById(R.id.btn42);
        btn43 = (Button) findViewById(R.id.btn43);
        btn44 = (Button) findViewById(R.id.btn44);
        btn45 = (Button) findViewById(R.id.btn45);
        btn46 = (Button) findViewById(R.id.btn46);
        btn47 = (Button) findViewById(R.id.btn47);
        btn48 = (Button) findViewById(R.id.btn48);
        btn49 = (Button) findViewById(R.id.btn49);
        btn50 = (Button) findViewById(R.id.btn50);
        btn51 = (Button) findViewById(R.id.btn51);
        btn52 = (Button) findViewById(R.id.btn52);
        btn53 = (Button) findViewById(R.id.btn53);
        btn54 = (Button) findViewById(R.id.btn54);
        btn55 = (Button) findViewById(R.id.btn55);
        btn56 = (Button) findViewById(R.id.btn56);
        btn57 = (Button) findViewById(R.id.btn57);
        btn58 = (Button) findViewById(R.id.btn58);
        btn59 = (Button) findViewById(R.id.btn59);
        btn60 = (Button) findViewById(R.id.btn60);
        check = (Button) findViewById(R.id.btnCheck);
        check.setOnClickListener(this);
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
        btn17.setOnClickListener(this);
        btn18.setOnClickListener(this);
        btn19.setOnClickListener(this);
        btn20.setOnClickListener(this);
        btn31.setOnClickListener(this);
        btn32.setOnClickListener(this);
        btn33.setOnClickListener(this);
        btn34.setOnClickListener(this);
        btn35.setOnClickListener(this);
        btn36.setOnClickListener(this);
        btn37.setOnClickListener(this);
        btn38.setOnClickListener(this);
        btn39.setOnClickListener(this);
        btn40.setOnClickListener(this);
        btn41.setOnClickListener(this);
        btn42.setOnClickListener(this);
        btn43.setOnClickListener(this);
        btn44.setOnClickListener(this);
        btn45.setOnClickListener(this);
        btn46.setOnClickListener(this);
        btn47.setOnClickListener(this);
        btn48.setOnClickListener(this);
        btn49.setOnClickListener(this);
        btn50.setOnClickListener(this);
        btn51.setOnClickListener(this);
        btn52.setOnClickListener(this);
        btn53.setOnClickListener(this);
        btn54.setOnClickListener(this);
        btn55.setOnClickListener(this);
        btn56.setOnClickListener(this);
        btn57.setOnClickListener(this);
        btn58.setOnClickListener(this);
        btn59.setOnClickListener(this);
        btn60.setOnClickListener(this);

        buttonMap.put(R.id.btn1, btn1);
        buttonMap.put(R.id.btn2, btn2);
        buttonMap.put(R.id.btn3, btn3);
        buttonMap.put(R.id.btn4, btn4);
        buttonMap.put(R.id.btn5, btn5);
        buttonMap.put(R.id.btn6, btn6);
        buttonMap.put(R.id.btn7, btn7);
        buttonMap.put(R.id.btn8, btn8);
        buttonMap.put(R.id.btn9, btn9);
        buttonMap.put(R.id.btn10, btn10);
        buttonMap.put(R.id.btn11, btn11);
        buttonMap.put(R.id.btn12, btn12);
        buttonMap.put(R.id.btn13, btn13);
        buttonMap.put(R.id.btn14, btn14);
        buttonMap.put(R.id.btn15, btn15);
        buttonMap.put(R.id.btn16, btn16);
        buttonMap.put(R.id.btn17, btn17);
        buttonMap.put(R.id.btn18, btn18);
        buttonMap.put(R.id.btn19, btn19);
        buttonMap.put(R.id.btn20, btn20);
        buttonMap.put(R.id.btn21, btn21);
        buttonMap.put(R.id.btn22, btn22);
        buttonMap.put(R.id.btn23, btn23);
        buttonMap.put(R.id.btn24, btn24);
        buttonMap.put(R.id.btn25, btn25);
        buttonMap.put(R.id.btn26, btn26);
        buttonMap.put(R.id.btn27, btn27);
        buttonMap.put(R.id.btn28, btn28);
        buttonMap.put(R.id.btn29, btn29);
        buttonMap.put(R.id.btn30, btn30);
        buttonMap.put(R.id.btn31, btn31);
        buttonMap.put(R.id.btn32, btn32);
        buttonMap.put(R.id.btn33, btn33);
        buttonMap.put(R.id.btn34, btn34);
        buttonMap.put(R.id.btn35, btn35);
        buttonMap.put(R.id.btn36, btn36);
        buttonMap.put(R.id.btn37, btn37);
        buttonMap.put(R.id.btn38, btn38);
        buttonMap.put(R.id.btn39, btn39);
        buttonMap.put(R.id.btn40, btn40);
        buttonMap.put(R.id.btn41, btn41);
        buttonMap.put(R.id.btn42, btn42);
        buttonMap.put(R.id.btn43, btn43);
        buttonMap.put(R.id.btn44, btn44);
        buttonMap.put(R.id.btn45, btn45);
        buttonMap.put(R.id.btn46, btn46);
        buttonMap.put(R.id.btn47, btn47);
        buttonMap.put(R.id.btn48, btn48);
        buttonMap.put(R.id.btn49, btn49);
        buttonMap.put(R.id.btn50, btn50);
        buttonMap.put(R.id.btn51, btn51);
        buttonMap.put(R.id.btn52, btn52);
        buttonMap.put(R.id.btn53, btn53);
        buttonMap.put(R.id.btn54, btn54);
        buttonMap.put(R.id.btn55, btn55);
        buttonMap.put(R.id.btn56, btn56);
        buttonMap.put(R.id.btn57, btn57);
        buttonMap.put(R.id.btn58, btn58);
        buttonMap.put(R.id.btn59, btn59);
        buttonMap.put(R.id.btn60, btn60);


        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        correctSound = sp.load(this, R.raw.zvukpravilno, 1);
        wrongSound = sp.load(this, R.raw.zvukgreshka, 1);
        endSound = sp.load(this, R.raw.endmussic, 1);
        clickAnswerSound= sp.load(this, R.raw.sound, 1);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        correctAnswersSet.add(R.id.btn1);
        correctAnswersSet.add(R.id.btn4);
        correctAnswersSet.add(R.id.btn5);
        correctAnswersSet.add(R.id.btn8);
        correctAnswersSet.add(R.id.btn9);
        correctAnswersSet.add(R.id.btn10);
        correctAnswersSet.add(R.id.btn15);
        correctAnswersSet.add(R.id.btn17);
        correctAnswersSet.add(R.id.btn18);
        correctAnswersSet.add(R.id.btn19);
        correctAnswersSet.add(R.id.btn22);
        correctAnswersSet.add(R.id.btn24);
        correctAnswersSet.add(R.id.btn25);
        correctAnswersSet.add(R.id.btn26);
        correctAnswersSet.add(R.id.btn27);
        correctAnswersSet.add(R.id.btn32);
        correctAnswersSet.add(R.id.btn34);
        correctAnswersSet.add(R.id.btn35);
        correctAnswersSet.add(R.id.btn38);
        correctAnswersSet.add(R.id.btn39);
        correctAnswersSet.add(R.id.btn40);
        correctAnswersSet.add(R.id.btn43);
        correctAnswersSet.add(R.id.btn47);
        correctAnswersSet.add(R.id.btn47);
        correctAnswersSet.add(R.id.btn50);
        correctAnswersSet.add(R.id.btn53);
        correctAnswersSet.add(R.id.btn54);
        correctAnswersSet.add(R.id.btn55);
        correctAnswersSet.add(R.id.btn57);
        correctAnswersSet.add(R.id.btn58);

        Intent mIntent = getIntent();
        testNum = mIntent.getIntExtra("TestNum", 0);

    }




//    public void onBackPressed() {
//
//    }


    @Override
    public void onClick(View v) {
        int selectedButtonId = v.getId();
        switch (selectedButtonId) {


//
            case R.id.btnCheck: {

                isEnd=true;
                if (correctAnswers == 30) {
                    currentGamePoints = 1;
                    sp.play(correctSound, 1, 1, 0, 0, 1);
                } else {
                    sp.play(wrongSound, 1, 1, 0, 0, 1);
                }
                setAnswerBgrColor();
                break;
            }

            default:{
                sp.play(clickAnswerSound, 1, 1, 0, 0, 1);
              Button selectedButton = buttonMap.get(selectedButtonId);
                selectedButton.setBackgroundColor(Color.GRAY);

                if(correctAnswersSet.contains(selectedButtonId)){
                    correctAnswers++;
                }
            }


        }

    }
    private void setAnswerBgrColor() {
        if (numofAnswers >= 20) {

            btn1.setBackgroundColor(Color.GREEN);
            btn4.setBackgroundColor(Color.GREEN);
            btn5.setBackgroundColor(Color.GREEN);
            btn8.setBackgroundColor(Color.GREEN);
            btn9.setBackgroundColor(Color.GREEN);
            btn10.setBackgroundColor(Color.GREEN);
            btn15.setBackgroundColor(Color.GREEN);
            btn17.setBackgroundColor(Color.GREEN);
            btn18.setBackgroundColor(Color.GREEN);
            btn19.setBackgroundColor(Color.GREEN);
            btn22.setBackgroundColor(Color.GREEN);
            btn24.setBackgroundColor(Color.GREEN);
            btn25.setBackgroundColor(Color.GREEN);
            btn26.setBackgroundColor(Color.GREEN);
            btn27.setBackgroundColor(Color.GREEN);
            btn32.setBackgroundColor(Color.GREEN);
            btn34.setBackgroundColor(Color.GREEN);
            btn35.setBackgroundColor(Color.GREEN);
            btn38.setBackgroundColor(Color.GREEN);
            btn39.setBackgroundColor(Color.GREEN);
            btn40.setBackgroundColor(Color.GREEN);
            btn43.setBackgroundColor(Color.GREEN);
            btn47.setBackgroundColor(Color.GREEN);
            btn47.setBackgroundColor(Color.GREEN);
            btn50.setBackgroundColor(Color.GREEN);
            btn53.setBackgroundColor(Color.GREEN);
            btn54.setBackgroundColor(Color.GREEN);
            btn55.setBackgroundColor(Color.GREEN);
            btn57.setBackgroundColor(Color.GREEN);
            btn58.setBackgroundColor(Color.GREEN);



            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 4700);

            if(MainActivity.isTest == true){
                isEnd=true;}

            TransitionParams transitionParams = new TransitionParams();
            transitionParams.setIsEnd(isEnd);
            transitionParams.setpActivity(this);
            transitionParams.setTestNumber(testNum);
            transitionParams.setpCorrectAnswers(correctAnswers);
            transitionParams.setpCurrentGamePoints(currentGamePoints);
            Transition.toNextActivity(transitionParams);
        }
    }
}
