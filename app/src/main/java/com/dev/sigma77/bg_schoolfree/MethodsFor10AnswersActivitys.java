package com.dev.sigma77.bg_schoolfree;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.dev.sigma77.bg_schoolfree.R;
import com.dev.sigma77.bg_schoolfree.util.Transition;
import com.dev.sigma77.bg_schoolfree.util.TransitionParams;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by user on 25.5.2016 г..
 */
public class MethodsFor10AnswersActivitys extends AppCompatActivity implements View.OnClickListener{
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    SoundPool sp;

    static Map<Integer, Integer> intPicList = new HashMap<>();
    Map<Integer, Integer> buttonMap = new HashMap<>();
    Map<Integer, Integer> correctAnswerList = new HashMap<>();
    private static ImageView pic,picMain;
    private static int currentPic;
    private int correctSound;
    private int wrongSound;
    private int correctAnswers, currentGamePoints = 0;
    static int game = 1,numQuestons=10;
    private int testNum;
    String gameName;
    String layoutName;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent mIntent = getIntent();
        testNum = mIntent.getIntExtra("TestNum", 0);
    //    numQuestons = mIntent.getIntExtra("NumQustions", 0);
        gameName=mIntent.getStringExtra("GameName");
        layoutName=mIntent.getStringExtra("Layout");
        if(layoutName.equals("See digit")) {
            setContentView(R.layout.activity_see_digit);
        }
        else if(layoutName.equals("Count")){
            setContentView(R.layout.activity_count);
        }

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (MainActivity.isTest) {
            toolbar.setVisibility(View.INVISIBLE);
        }

        initiateButtons();
        setOnClickListeners();


        switch (gameName){
            case "Digit":{
                newPopulateButtonMap(0,R.drawable.digit1, R.drawable.digit2, R.drawable.digit3, R.drawable.digit4, R.drawable.digit5,
                        R.drawable.digit6, R.drawable.digit7, R.drawable.digit8, R.drawable.digit9, R.drawable.digit10);
                populatePicList(R.drawable.digit1, R.drawable.digit2, R.drawable.digit3, R.drawable.digit4, R.drawable.digit5,
                        R.drawable.digit6, R.drawable.digit7, R.drawable.digit8, R.drawable.digit9, R.drawable.digit10);

                break;
            }
            case "Fingers":{
                newPopulateButtonMap(0,R.drawable.count_on_fingers_01, R.drawable.count_on_fingers_02, R.drawable.count_on_fingers_03, R.drawable.count_on_fingers_04, R.drawable.count_on_fingers_05,
                        R.drawable.count_on_fingers_06, R.drawable.count_on_fingers_07, R.drawable.count_on_fingers_08, R.drawable.count_on_fingers_09, R.drawable.count_on_fingers_10);
                populatePicList(R.drawable.count_on_fingers_01, R.drawable.count_on_fingers_02, R.drawable.count_on_fingers_03, R.drawable.count_on_fingers_04, R.drawable.count_on_fingers_05,
                        R.drawable.count_on_fingers_06, R.drawable.count_on_fingers_07, R.drawable.count_on_fingers_08, R.drawable.count_on_fingers_09, R.drawable.count_on_fingers_10);

                break;
            }
            case "Squares":{
                newPopulateButtonMap(0,R.drawable.squares1, R.drawable.squares2, R.drawable.squares3, R.drawable.squares4, R.drawable.squares5,
                        R.drawable.squares6, R.drawable.squares7, R.drawable.squares8, R.drawable.squares9, R.drawable.squares10);
                populatePicList(R.drawable.squares1, R.drawable.squares2, R.drawable.squares3, R.drawable.squares4, R.drawable.squares5,
                        R.drawable.squares6, R.drawable.squares7, R.drawable.squares8, R.drawable.squares9, R.drawable.squares10);

                break;
            }
            case "NextDigit":{
                newPopulateButtonMap(0,R.drawable.next_digit1, R.drawable.next_digit2, R.drawable.next_digit3, R.drawable.next_digit4, R.drawable.next_digit5,
                        R.drawable.next_digit6, R.drawable.next_digit7, R.drawable.next_digit8, R.drawable.next_digit9, R.drawable.next_digit10);
                populatePicList(R.drawable.next_digit1, R.drawable.next_digit2, R.drawable.next_digit3, R.drawable.next_digit4, R.drawable.next_digit5,
                        R.drawable.next_digit6, R.drawable.next_digit7, R.drawable.next_digit8, R.drawable.next_digit9, R.drawable.next_digit10);

                break;
            }
            case "SimilarityAnimals":{
                numQuestons=5;
                newPopulateButtonMap(0,R.drawable.similarity_animal_1,0, 0, R.drawable.similarity_animal_4, R.drawable.similarity_animal_5,
                        R.drawable.similarity_animal_6,0, R.drawable.similarity_animal_8, 0, 0);
                populatePicList(R.drawable.similarity_animal_1,R.drawable.similarity_animal_5,R.drawable.similarity_animal_8,R.drawable.similarity_animal_4,R.drawable.similarity_animal_6,0,0,0,0,0);
                picMain = (ImageView) findViewById(R.id.imageView1);
                picMain.setImageResource(R.drawable.similarity_amals_main);

                break;
            }
            case "SimilarityThings":{
                numQuestons=5;
                newPopulateButtonMap(0,R.drawable.similarity_things_1,R.drawable.similarity_things_2, R.drawable.similarity_things_3, R.drawable.similarity_things_4, 0,
                        R.drawable.similarity_things_6,0, 0, 0, 0);
                populatePicList(R.drawable.similarity_things_1,R.drawable.similarity_things_2, R.drawable.similarity_things_3, R.drawable.similarity_things_4, R.drawable.similarity_things_6,0,0,0,0,0);
                picMain = (ImageView) findViewById(R.id.imageView1);
                picMain.setImageResource(R.drawable.similarity_things_main);

                break;
            }
            case "SimilarityLetters":{
                numQuestons=5;
                newPopulateButtonMap(0,R.drawable.letters_1,R.drawable.letters_2,0, R.drawable.letters_4,0, R.drawable.letters_6,0,0, R.drawable.letters_9,0
                       );
                populatePicList(R.drawable.letters_1,R.drawable.letters_2, R.drawable.letters_4, R.drawable.letters_6, R.drawable.letters_9,0,0,0,0,0);
                picMain = (ImageView) findViewById(R.id.imageView1);
                picMain.setImageResource(R.drawable.letters_main);

                break;
            }
            case "SimilarityLines":{
                numQuestons=5;
                newPopulateButtonMap(0,R.drawable.lines_1,R.drawable.lines_2,0, R.drawable.lines_4,0,00,0, R.drawable.lines_8, R.drawable.lines_9,0
                );
                populatePicList(R.drawable.lines_1,R.drawable.lines_2, R.drawable.lines_4, R.drawable.lines_8, R.drawable.lines_9,0,0,0,0,0);
                picMain = (ImageView) findViewById(R.id.imageView1);
                picMain.setImageResource(R.drawable.lines_main);

                break;
            }
            case "SimilarityHalfFigure":{
                numQuestons=5;
                newPopulateButtonMap(0,R.drawable.half_figure_1,R.drawable.half_figure_2, R.drawable.half_figure_3, R.drawable.half_figure_4,0,0,0, R.drawable.half_figure_8,0,0
                );
                populatePicList(R.drawable.half_figure_1,R.drawable.half_figure_2, R.drawable.half_figure_3, R.drawable.half_figure_4, R.drawable.half_figure_8,0,0,0,0,0);
                picMain = (ImageView) findViewById(R.id.imageView1);
                picMain.setImageResource(R.drawable.half_figure_main);

                break;
            }
            case "SimilarityArrows":{
                numQuestons=5;
                newPopulateButtonMap(0,0,R.drawable.arrow_2,R.drawable.arrow_3, R.drawable.arrow_4, R.drawable.arrow_5,0, R.drawable.arrow_7,0,0,0);
                populatePicList(R.drawable.arrow_2,R.drawable.arrow_3, R.drawable.arrow_4, R.drawable.arrow_5, R.drawable.arrow_7,0,0,0,0,0);
                picMain = (ImageView) findViewById(R.id.imageView1);
                picMain.setImageResource(R.drawable.arrows_main);

                break;
            }
            case "SimilarityCubes":{
                numQuestons=5;
                newPopulateButtonMap(0,0,0,R.drawable.similarity_cubes_3,R.drawable.similarity_cubes_4, R.drawable.similarity_cubes_5, R.drawable.similarity_cubes_6,0, R.drawable.similarity_cubes_8,0,0);
                populatePicList(R.drawable.similarity_cubes_3,R.drawable.similarity_cubes_4, R.drawable.similarity_cubes_5, R.drawable.similarity_cubes_6, R.drawable.similarity_cubes_8,0,0,0,0,0);
                picMain = (ImageView) findViewById(R.id.imageView1);
                picMain.setImageResource(R.drawable.similarity_cubes_main);

                break;
            }
            case "SimilarityDice":{
                numQuestons=5;
                newPopulateButtonMap(0,R.drawable.similarity_dice_1,0,R.drawable.similarity_dice_3,0,0, R.drawable.similarity_dice_6, R.drawable.similarity_dice_7, R.drawable.similarity_dice_8,0,0);
                populatePicList(R.drawable.similarity_dice_1,R.drawable.similarity_dice_3, R.drawable.similarity_dice_6, R.drawable.similarity_dice_7, R.drawable.similarity_dice_8,0,0,0,0,0);
                picMain = (ImageView) findViewById(R.id.imageView1);
                picMain.setImageResource(R.drawable.similarity_dice_main);

                break;
            }
            case "CubeBloks":{
                numQuestons=5;
                populateButtonMap();
                populatePicList(R.drawable.cube_bloks_1,R.drawable.cube_bloks_2, R.drawable.cube_bloks_3,R.drawable.cube_bloks_4,R.drawable.cube_bloks_5,0,0,0,0,0);
                populateCorrectAnswers(1,2 ,2,4,2,0,0,0,0,0);
                break;
            }
            case "CubesCount":{

                populateButtonMap();
                populatePicList(R.drawable.cubes_count_1,R.drawable.cubes_count_2, R.drawable.cubes_count_3,R.drawable.cubes_count_4,R.drawable.cubes_count_5,R.drawable.cubes_count_6,R.drawable.cubes_count_7,R.drawable.cubes_count_8,R.drawable.cubes_count_9,R.drawable.cubes_count_10);
                populateCorrectAnswers(3,5 ,6,7,8,5,6,6,7,9);
                break;
            }
        }





        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        correctSound = sp.load(this, R.raw.zvukpravilno, 1);
        wrongSound = sp.load(this, R.raw.zvukgreshka, 1);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);


        getRandomPic();
}

   public void populateButtonMap() {
        buttonMap.put(R.id.button0, 0);
        buttonMap.put(R.id.button1, 1);
        buttonMap.put(R.id.button2, 2);
        buttonMap.put(R.id.button3, 3);
        buttonMap.put(R.id.button4, 4);
        buttonMap.put(R.id.button5, 5);
        buttonMap.put(R.id.button6, 6);
        buttonMap.put(R.id.button7, 7);
        buttonMap.put(R.id.button8, 8);
        buttonMap.put(R.id.button9, 9);
        buttonMap.put(R.id.button10, 10);}
    public void newPopulateButtonMap(int pic0,int pic1,int pic2,int pic3,int pic4,int pic5,int pic6,int pic7,int pic8,int pic9,int pic10) {

        buttonMap.put(R.id.button0, pic0);
        buttonMap.put(R.id.button1, pic1);
        buttonMap.put(R.id.button2, pic2);
        buttonMap.put(R.id.button3, pic3);
        buttonMap.put(R.id.button4, pic4);
        buttonMap.put(R.id.button5, pic5);
        buttonMap.put(R.id.button6, pic6);
        buttonMap.put(R.id.button7, pic7);
        buttonMap.put(R.id.button8, pic8);
        buttonMap.put(R.id.button9, pic9);
        buttonMap.put(R.id.button10, pic10);
    }


    public void populatePicList(int pic1,int pic2,int pic3,int pic4,int pic5,int pic6,int pic7,int pic8,int pic9,int pic10
                                ) {
        if(numQuestons==10) {
            intPicList.put(1, pic1);
            intPicList.put(2, pic2);
            intPicList.put(3, pic3);
            intPicList.put(4, pic4);
            intPicList.put(5, pic5);
            intPicList.put(6, pic6);
            intPicList.put(7, pic7);
            intPicList.put(8, pic8);
            intPicList.put(9, pic9);
            intPicList.put(10, pic10);
        }
        else if(numQuestons==5) {

            intPicList.put(1, pic1);
            intPicList.put(2, pic2);
            intPicList.put(3, pic3);
            intPicList.put(4, pic4);
            intPicList.put(5, pic5);

        }

    }
    public void populateCorrectAnswers(int ans1,int ans2 ,int ans3,int ans4, int ans5,int ans6,int ans7 ,int ans8,int ans9, int ans10){
        if(numQuestons==10){
            correctAnswerList.put(intPicList.get(1), ans1);
            correctAnswerList.put(intPicList.get(2), ans2);
            correctAnswerList.put(intPicList.get(3), ans3);
            correctAnswerList.put(intPicList.get(4), ans4);
            correctAnswerList.put(intPicList.get(5), ans5);
            correctAnswerList.put(intPicList.get(6), ans6);
            correctAnswerList.put(intPicList.get(7), ans7);
            correctAnswerList.put(intPicList.get(8), ans8);
            correctAnswerList.put(intPicList.get(9), ans9);
            correctAnswerList.put(intPicList.get(10), ans10);

        }
        else if(numQuestons==5) {
            correctAnswerList.put(intPicList.get(1), ans1);
            correctAnswerList.put(intPicList.get(2), ans2);
            correctAnswerList.put(intPicList.get(3), ans3);
            correctAnswerList.put(intPicList.get(4), ans4);
            correctAnswerList.put(intPicList.get(5), ans5);
        }

    }

    public void setOnClickListeners() {
        btn0.setOnClickListener(this);
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
    }

    public void initiateButtons() {
        btn0 = (Button) findViewById(R.id.button0);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn10 = (Button) findViewById(R.id.button10);
        pic = (ImageView) findViewById(R.id.imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_count, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        int selectedButtonId = v.getId();
        int btnNumber = buttonMap.get(selectedButtonId);

       // checkAnswer(btnNumber);
         check(btnNumber);
    }
    public void check(int btn){
        int number = intPicList.get(currentPic);
        int answer=-1;
        if(!correctAnswerList.isEmpty()) {
             answer = correctAnswerList.get(number);
        }
        if(btn==number||btn==answer){

                correctAnswers++;
                sp.play(correctSound, 1, 1, 0, 0, 1);
            } else {
                sp.play(wrongSound, 1, 1, 0, 0, 1);
            }
            intPicList.remove(currentPic);
            if (intPicList.size() <= 0) {
                boolean isEnd = true;
                btn1.setClickable(false);
                btn2.setClickable(false);
                btn3.setClickable(false);
                btn4.setClickable(false);
                btn5.setClickable(false);
                btn6.setClickable(false);
                btn7.setClickable(false);
                btn8.setClickable(false);
                btn9.setClickable(false);
                btn10.setClickable(false);
                if (correctAnswers == numQuestons) {
                    currentGamePoints = 1;
                }

                TransitionParams transitionParams = new TransitionParams();
                transitionParams.setIsEnd(isEnd);
                transitionParams.setpActivity(this);
                transitionParams.setTestNumber(testNum);
                transitionParams.setpCorrectAnswers(correctAnswers);
                transitionParams.setpCurrentGamePoints(currentGamePoints);
                Transition.toNextActivity(transitionParams);

            } else {
                getRandomPic();
            }


        }

    public  void changePic(int picNum) {
        int number = intPicList.get(picNum);
        pic.setImageResource(number);

        currentPic = picNum;
    }
    public void checkAnswer(int answerNum) {
        int answer = answerNum;
        if (game == 2) {

            if (currentPic < 6) {
                answer = 5 - answer;
            } else if (currentPic == 5 && answerNum == 0) {
                answer = 5;
            } else if (currentPic == 10 && answerNum == 0) {
                answer = 10;
            } else {
                answer = 10 - answer;
            }

        }


        if (currentPic == answer) {
            correctAnswers++;
            sp.play(correctSound, 1, 1, 0, 0, 1);
        } else {
            sp.play(wrongSound, 1, 1, 0, 0, 1);
        }
        intPicList.remove(currentPic);
        if (intPicList.size() <= 0) {
            boolean isEnd = true;
            btn1.setClickable(false);
            btn2.setClickable(false);
            btn3.setClickable(false);
            btn4.setClickable(false);
            btn5.setClickable(false);
            btn6.setClickable(false);
            btn7.setClickable(false);
            btn8.setClickable(false);
            btn9.setClickable(false);
            btn10.setClickable(false);
            if (correctAnswers == numQuestons) {
                currentGamePoints = 1;
            }

            TransitionParams transitionParams = new TransitionParams();
            transitionParams.setIsEnd(isEnd);
            transitionParams.setpActivity(this);
            transitionParams.setTestNumber(testNum);
            transitionParams.setpCorrectAnswers(correctAnswers);
            transitionParams.setpCurrentGamePoints(currentGamePoints);
            Transition.toNextActivity(transitionParams);

        } else {
            getRandomPic();
        }


    }
    public   void getRandomPic() {
        Random rnd = new Random();
        int randomPicPos = rnd.nextInt(numQuestons) + 1;
        while (!intPicList.containsKey(randomPicPos)) {
            randomPicPos = rnd.nextInt(numQuestons) + 1;
        }
        // int randomPic = intPicList.get(randomPicPos);
        changePic(randomPicPos);
    }
    public String getGameName() {
        return gameName;
    }
}
