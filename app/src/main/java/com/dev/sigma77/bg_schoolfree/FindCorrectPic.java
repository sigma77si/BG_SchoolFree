package com.dev.sigma77.bg_schoolfree;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.dev.sigma77.bg_schoolfree.util.Transition;
import com.dev.sigma77.bg_schoolfree.util.TransitionParams;

import java.util.Arrays;


public class FindCorrectPic extends AppCompatActivity implements View.OnClickListener {
    public static int currentGamePoints = 0, correctAnswers = 0;

    private Button btn1, btn2, btn3, btn4,
            btn5, btn6, btn7, btn8,
            btn9, btn10, btn11, btn12,
            btn13, btn14, btn15, btn16,
            btn17, btn18, btn19, btn20;
    private View layout1;
    private View layout2;
    private View layout3;
    private View layout4;
    private View layout5;
    private Button pressedBtn = null;
    private int numOfAnswers = 0;
    private Button[] correctAnswerBtns = new Button[5];
    private SoundPool sp;
    private int correctSound, wrongSound, endSound;
    private int sceneNum = 1;
    boolean isEnd = false;
    private int testNum;
    String gameNameString;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_correct_pic);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        setTitle(R.string.title_activity_see_digit);
        if (!MainActivity.isTest) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Intent mIntent = getIntent();
        testNum = mIntent.getIntExtra("TestNum", 0);
        sceneNum = mIntent.getIntExtra("SceneNum", 0);
        gameNameString = mIntent.getStringExtra("SceneName");

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
        layout1 = findViewById(R.id.Layout1);
        layout2 = findViewById(R.id.Layout2);
        layout3 = findViewById(R.id.Layout3);
        layout4 = findViewById(R.id.Layout4);
        layout5 = findViewById(R.id.Layout5);


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

        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        correctSound = sp.load(this, R.raw.zvukpravilno, 1);
        wrongSound = sp.load(this, R.raw.zvukgreshka, 1);
        endSound = sp.load(this, R.raw.endmussic, 1);
        setCorrectAnswerBtns(gameNameString,sceneNum);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_find_correct_pic, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {


        int btnIndex = 1;

        switch (v.getId()) {

            case R.id.btn1: {
                pressedBtn = btn1;
                btnIndex = 1;

                break;
            }
            case R.id.btn2: {
                pressedBtn = btn2;
                btnIndex = 2;
                break;
            }
            case R.id.btn3: {
                pressedBtn = btn3;
                btnIndex = 3;
                break;
            }
            case R.id.btn4: {
                pressedBtn = btn4;
                btnIndex = 4;
                break;
            }
            case R.id.btn5: {
                pressedBtn = btn5;
                btnIndex = 5;
                break;
            }
            case R.id.btn6: {
                pressedBtn = btn6;
                btnIndex = 6;
                break;
            }
            case R.id.btn7: {
                pressedBtn = btn7;
                btnIndex = 7;
                break;
            }
            case R.id.btn8: {
                pressedBtn = btn8;
                btnIndex = 8;
                break;
            }
            case R.id.btn9: {
                pressedBtn = btn9;
                btnIndex = 9;
                break;
            }
            case R.id.btn10: {
                pressedBtn = btn10;
                btnIndex = 10;
                break;
            }
            case R.id.btn11: {
                pressedBtn = btn11;
                btnIndex = 11;
                break;
            }

            case R.id.btn12: {
                pressedBtn = btn12;
                btnIndex = 12;
                break;
            }
            case R.id.btn13: {
                pressedBtn = btn13;
                btnIndex = 13;
                break;
            }
            case R.id.btn14: {
                pressedBtn = btn14;
                btnIndex = 14;
                break;
            }
            case R.id.btn15: {
                pressedBtn = btn15;
                btnIndex = 15;
                break;
            }
            case R.id.btn16: {
                pressedBtn = btn16;
                btnIndex = 16;
                break;
            }
            case R.id.btn17: {
                pressedBtn = btn17;
                btnIndex = 17;
                break;
            }
            case R.id.btn18: {
                pressedBtn = btn18;
                btnIndex = 18;
                break;
            }
            case R.id.btn19: {
                pressedBtn = btn19;
                btnIndex = 19;
                break;
            }
            case R.id.btn20: {
                pressedBtn = btn20;
                btnIndex = 20;
                break;
            }


        }
        numOfAnswers++;
        checkAnswer(pressedBtn, btnIndex);
        blockBtnLine(btnIndex);
    }

    public void setLayoutColor(View layoutNum, Boolean ifCorrect) {

        if (ifCorrect) {
            layoutNum.setBackgroundColor(Color.GREEN);
        } else {
            // layoutNum.setBackgroundColor(getResources().getColor(R.color.green));
            layoutNum.setBackgroundColor(Color.RED);
        }
    }

    private void changeLayoutColor(Boolean ifCorrect, int btnPosition) {

        if (btnPosition < 5) {
            setLayoutColor(layout1, ifCorrect);
        } else if (btnPosition > 4 && btnPosition < 9) {

            setLayoutColor(layout2, ifCorrect);
        } else if (btnPosition > 8 && btnPosition < 13) {
            setLayoutColor(layout3, ifCorrect);
        } else if (btnPosition > 12 && btnPosition < 17) {
            setLayoutColor(layout4, ifCorrect);
        } else if (btnPosition > 16 && btnPosition < 21) {
            setLayoutColor(layout5, ifCorrect);
        }


    }

    private void startNextScene() {
        if (correctAnswers == 5) {
            currentGamePoints = 1;

        }

        putExtraStartResultActivity();


        if ((gameNameString.equals("ShadowPic") && sceneNum == 2) || (gameNameString.equals("NeedlessPic") && sceneNum == 2)) {

            finish();

        } else {
            sceneNum++;
            numOfAnswers = 0;
            correctAnswers = 0;
            currentGamePoints = 0;
            setCorrectAnswerBtns(gameNameString,sceneNum);
            View[] layouts = {layout1, layout2, layout3, layout4, layout5};
            for (int i = 0; i < layouts.length; i++) {
                layouts[i].setBackgroundColor(Color.GRAY);
            }
            Button allButtons[] = {btn1, btn2, btn3, btn4,
                    btn5, btn6, btn7, btn8,
                    btn9, btn10, btn11, btn12,
                    btn13, btn14, btn15, btn16,
                    btn17, btn18, btn19, btn20};
            for (int i = 0; i < allButtons.length; i++) {
                allButtons[i].setText("");
                allButtons[i].setClickable(true);
            }
        }
    }

    private void putExtraStartResultActivity() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("GamePoints", currentGamePoints);
       intent.putExtra("CorrectAnswers", correctAnswers);
        startActivity(intent);
    }

    private void startNextTestScene() {
        if (correctAnswers == 5) {
            currentGamePoints = 1;


        }

        isEnd=true;
        TransitionParams transitionParams = new TransitionParams();
        transitionParams.setIsEnd(isEnd);
        transitionParams.setpActivity(this);
        transitionParams.setTestNumber(testNum);
        transitionParams.setpCorrectAnswers(correctAnswers);
        transitionParams.setpCurrentGamePoints(currentGamePoints);
        Transition.toNextActivity(transitionParams);
    }

    private void blockBtnLine(int btnPosition) {
        if (btnPosition < 5) {
            btn1.setClickable(false);
            btn2.setClickable(false);
            btn3.setClickable(false);
            btn4.setClickable(false);
        } else if (btnPosition > 4 && btnPosition < 9) {
            btn5.setClickable(false);
            btn6.setClickable(false);
            btn7.setClickable(false);
            btn8.setClickable(false);
        } else if (btnPosition > 8 && btnPosition < 13) {
            btn9.setClickable(false);
            btn10.setClickable(false);
            btn11.setClickable(false);
            btn12.setClickable(false);
        } else if (btnPosition > 12 && btnPosition < 17) {
            btn13.setClickable(false);
            btn14.setClickable(false);
            btn15.setClickable(false);
            btn16.setClickable(false);
        } else if (btnPosition > 16 && btnPosition < 21) {
            btn17.setClickable(false);
            btn18.setClickable(false);
            btn19.setClickable(false);
            btn20.setClickable(false);
        }
    }

    public void setCorrectAnswerBtns(String gameNum,int sceneNum) {

        if(gameNum.equals("ShadowPic")){
            switch (sceneNum){
                case 1:{
                    setButtons(btn2, btn7, btn12, btn15, btn18);
                    break;
                }
                case 2:{
                    setButtons(btn2, btn8, btn11, btn14, btn19);
                    break;
                }
                case 3:{
                    setButtons(btn4, btn7, btn10, btn16, btn20);
                    break;
                }
                case 4:{
                    setButtons(btn4, btn8, btn10, btn15, btn19);
                    break;
                }
                case 5:{
                    setButtons(btn4, btn6, btn11, btn14, btn18);
                    break;
                }

            }

        }
        else if(gameNum.equals("NeedlessPic")){
            switch (sceneNum) {
                case 1: {
                    setButtons(btn3, btn5, btn11, btn14, btn17);
                    break;
                }
                case 2: {
                    setButtons(btn2, btn8, btn10, btn15, btn17);
                    break;
                }
                case 3: {
                    setButtons(btn4, btn6, btn11, btn14, btn17);
                    break;
                }
            }

        }
        setBgrResource(gameNameString, sceneNum);
    }

    public void setButtons(Button btn1, Button btn2, Button btn3, Button btn4, Button btn5) {
        correctAnswerBtns[0] = btn1;
        correctAnswerBtns[1] = btn2;
        correctAnswerBtns[2] = btn3;
        correctAnswerBtns[3] = btn4;
        correctAnswerBtns[4] = btn5;

    }

    public void setBgrResource(String gameName,int sceneNum) {

        if(gameName.equals("ShadowPic")) {

            switch (sceneNum) {
                case 1: {
                    int[] bgrResource1 = {R.drawable.mushroom1, R.drawable.mushroom2, R.drawable.mushroom3, R.drawable.mushroom4,
                            R.drawable.tren1, R.drawable.tren2, R.drawable.tren3, R.drawable.tren4, R.drawable.tree1,
                            R.drawable.tree2, R.drawable.tree3, R.drawable.tree4, R.drawable.flower1,
                            R.drawable.flower2, R.drawable.flower3, R.drawable.flower4, R.drawable.duck1, R.drawable.duck2,
                            R.drawable.duck3, R.drawable.duck4};
                    changeBtnBgr(bgrResource1);

                    break;
                }
                case 2: {
                    int[] bgrResource2 = {R.drawable.kettle1, R.drawable.kettle2, R.drawable.kettle3, R.drawable.kettle4,
                            R.drawable.plane1, R.drawable.plane2, R.drawable.plane3, R.drawable.plane4, R.drawable.suitcase1,
                            R.drawable.suitcase2, R.drawable.suitcase3, R.drawable.suitcase4, R.drawable.taddy_bear1, R.drawable.taddy_bear2,
                            R.drawable.taddy_bear3, R.drawable.taddy_bear4, R.drawable.snail1, R.drawable.snail2, R.drawable.snail3, R.drawable.snail4};
                    changeBtnBgr(bgrResource2);

                    break;
                }
                case 3: {
                    int[] bgrResource3 = {R.drawable.hat1, R.drawable.hat2, R.drawable.hat3, R.drawable.hat4, R.drawable.turtle1, R.drawable.turtle2,
                            R.drawable.turtle3, R.drawable.turtle4, R.drawable.vase1, R.drawable.vase2, R.drawable.vase3, R.drawable.vase4,
                            R.drawable.baloon1, R.drawable.baloon2, R.drawable.baloon3, R.drawable.baloon4, R.drawable.doll1, R.drawable.doll2,
                            R.drawable.doll3, R.drawable.doll4,};
                    changeBtnBgr(bgrResource3);

                    break;
                }
                case 4: {
                    int[] bgrResource4 = {R.drawable.mouse1, R.drawable.mouse2, R.drawable.mouse3, R.drawable.mouse4, R.drawable.rooster1,
                            R.drawable.rooster2, R.drawable.rooster3, R.drawable.rooster4, R.drawable.cat1, R.drawable.cat2, R.drawable.cat3,
                            R.drawable.cat4, R.drawable.rabbit1, R.drawable.rabbit2, R.drawable.rabbit3, R.drawable.rabbit4, R.drawable.doll11,
                            R.drawable.doll22, R.drawable.doll33, R.drawable.doll44,};
                    changeBtnBgr(bgrResource4);

                    break;
                }
                case 5: {
                    int[] bgrResource5 = {R.drawable.crocodile1, R.drawable.crocodile2, R.drawable.crocodile3, R.drawable.crocodile4,
                            R.drawable.elephant1, R.drawable.elephant2, R.drawable.elephant3, R.drawable.elephant4, R.drawable.hippo1, R.drawable.hippo2,
                            R.drawable.hippo3, R.drawable.hippo4, R.drawable.penguin1, R.drawable.penguin2, R.drawable.penguin3, R.drawable.penguin4,
                            R.drawable.bear1, R.drawable.bear2, R.drawable.bear3, R.drawable.bear4};
                    changeBtnBgr(bgrResource5);

                    break;
                }

            }
        }
        else if(gameName.equals("NeedlessPic")) {
            switch (sceneNum){
                case 1:{
                    int[] bgrResource6 = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7,
                            R.drawable.a8, R.drawable.a9, R.drawable.a10, R.drawable.a11, R.drawable.a12, R.drawable.a13, R.drawable.a14, R.drawable.a15,
                            R.drawable.a16, R.drawable.a17, R.drawable.a18, R.drawable.a19, R.drawable.a20};
                    changeBtnBgr(bgrResource6);

                    break;
                }
                case 2:{
                    int[] bgrResource7 = {R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5, R.drawable.b6, R.drawable.b7,
                            R.drawable.b8, R.drawable.b9, R.drawable.b10, R.drawable.b11, R.drawable.b12, R.drawable.b13, R.drawable.b14, R.drawable.b15,
                            R.drawable.b16, R.drawable.b17, R.drawable.b18, R.drawable.b19, R.drawable.b20};
                    changeBtnBgr(bgrResource7);

                    break;
                }
                case 3:{
                    int[] bgrResource8 = {R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5, R.drawable.c6, R.drawable.c7,
                            R.drawable.c8, R.drawable.c9, R.drawable.c10, R.drawable.c11, R.drawable.c12, R.drawable.c13, R.drawable.c14, R.drawable.c15,
                            R.drawable.c16, R.drawable.c17, R.drawable.c18, R.drawable.c19, R.drawable.c20};
                    changeBtnBgr(bgrResource8);


                    break;
                }
            }


        }


    }

    public void changeBtnBgr(int[] bgrResource) {

        Button[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6, btn7,
                btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16,
                btn17, btn18, btn19, btn20};

        for (int i = 0, j = 19; i < bgrResource.length; i++, j--) {
            buttons[i].setBackgroundResource(bgrResource[i]);

        }

    }

    public void checkAnswer(Button pressedBtn, int btnNum) {

        boolean isCorrect;
        if (!Arrays.asList(correctAnswerBtns).contains(pressedBtn)) {
            pressedBtn.setText("x");
            pressedBtn.setTextColor(Color.RED);
            sp.play(wrongSound, 1, 1, 0, 0, 1);
            isCorrect = false;
        } else {
            pressedBtn.setText("v");
            pressedBtn.setTextColor(getResources().getColor(R.color.green));
            sp.play(correctSound, 1, 1, 0, 0, 1);
            isCorrect = true;
            correctAnswers++;

        }
        changeLayoutColor(isCorrect, btnNum);

        if (numOfAnswers == 5) {

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    if (MainActivity.isTest) {
                        startNextTestScene();

                    } else {

                        startNextScene();
                    }


                }
            }, 2000);


        }


    }

    public int getSceneNum() {
        return sceneNum;
    }
    public String getSceneName() {
        return gameNameString;
    }
}
