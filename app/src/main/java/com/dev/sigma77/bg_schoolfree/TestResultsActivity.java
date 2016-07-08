package com.dev.sigma77.bg_schoolfree;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class TestResultsActivity extends ActionBarActivity implements View.OnClickListener{

   public static TextView correct1, points1,
            correct2, points2,
            correct3, points3,
            correct4, points4,
            correct5, points5,
             allPoints;
    Button ok;
    ImageView imgStar1, imgStar2, imgStar3, imgStar4, imgStar5;
    MediaPlayer mp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_results);
        correct1= (TextView) findViewById(R.id.correct1);
        correct2= (TextView) findViewById(R.id.correct2);
        correct3= (TextView) findViewById(R.id.correct3);
        correct4= (TextView) findViewById(R.id.correct4);
        correct5= (TextView) findViewById(R.id.correct5);
        points1= (TextView) findViewById(R.id.points1);
        points2= (TextView) findViewById(R.id.points2);
        points3= (TextView) findViewById(R.id.points3);
        points4= (TextView) findViewById(R.id.points4);
        points5= (TextView) findViewById(R.id.points5);
        allPoints= (TextView) findViewById(R.id.allPoints);
        imgStar1= (ImageView) findViewById(R.id.imgStar1);
        imgStar2= (ImageView) findViewById(R.id.imgStar2);
        imgStar3= (ImageView) findViewById(R.id.imgStar3);
        imgStar4= (ImageView) findViewById(R.id.imgStar4);
        imgStar5= (ImageView) findViewById(R.id.imgStar5);
        ImageView[]stars={imgStar1,imgStar2,imgStar3,imgStar4,imgStar5};
        ok= (Button) findViewById(R.id.btnOk);
        ok.setOnClickListener(this);
        TextView[]answers={correct1,correct2,correct3,correct4,correct5};
        TextView[]points={points1,points2,points3,points4,points5};

        mp = MediaPlayer.create(TestResultsActivity.this, R.raw.intro_one);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        Intent mIntent = getIntent();
        ArrayList<String> gamesCorrectAnswers = mIntent.getStringArrayListExtra("GamesCorrectAnswers");
        ArrayList<String> gamesPoints = mIntent.getStringArrayListExtra("GamesPoints");
        int allGamesPoints=mIntent.getIntExtra("AllPoints", 0);
        String stringAllGamePoints= String.valueOf(allGamesPoints);
        allPoints.setText( stringAllGamePoints);
        for(int i=0; i<gamesCorrectAnswers.size(); i++){

            answers[i].setText(gamesCorrectAnswers.get(i));
            points[i].setText(gamesPoints.get(i));

        }
        for(int i=0; i < allGamesPoints;i++){
            stars[i].setImageResource(R.drawable.gold_star);
        }

        if(allGamesPoints==5){
            mp = MediaPlayer.create(TestResultsActivity.this, R.raw.end_test_win);
            mp.start();

        }
        else {
            mp = MediaPlayer.create(TestResultsActivity.this, R.raw.end_test_loose);
            mp.start();

        }
    }




    @Override
    protected void onStop()
    {
        ResultActivity.isLastTest=false;
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
        ResultActivity.isLastTest=false;
//

        if (mp != null) {

            mp.release();
            mp = null;
        }

    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnOk) {
            finish();


                 return;
        }


    }
}
