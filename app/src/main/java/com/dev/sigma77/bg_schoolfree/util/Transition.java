package com.dev.sigma77.bg_schoolfree.util;

import android.os.Handler;

import com.dev.sigma77.bg_schoolfree.ButtonActivity;
import com.dev.sigma77.bg_schoolfree.ClockActivity;
import com.dev.sigma77.bg_schoolfree.CountActivity;
import com.dev.sigma77.bg_schoolfree.CroppedPicActivity;
import com.dev.sigma77.bg_schoolfree.FindCorrectPic;
import com.dev.sigma77.bg_schoolfree.MainActivity;
import com.dev.sigma77.bg_schoolfree.MethodsFor10AnswersActivitys;
import com.dev.sigma77.bg_schoolfree.NextTestScene;
import com.dev.sigma77.bg_schoolfree.R;
import com.dev.sigma77.bg_schoolfree.ShowResults;

/**
 * Created by user on 20.3.2016 г..
 */
public class Transition {

    public static void toNextActivity(TransitionParams transitionParams) {
        int exerciseNumber = 1;
        int testNumber = transitionParams.getTestNumber();
        int introTextId = 0;
        int introPicId = 0;
        int introTalkId = 0;
        boolean isNextExerciseExisting = true;
        if (MainActivity.isTest == true) {
            Class currentActivity=transitionParams.getpActivity().getClass();
            if (testNumber == 1) {

                if (currentActivity == MethodsFor10AnswersActivitys.class
                        && ((MethodsFor10AnswersActivitys) transitionParams.getpActivity()).getGameName().equals("Fingers"))
 {
                    introTextId = R.string.Intro1Text3;
                    introPicId = R.drawable.needless_pic_intro;
                    introTalkId = R.raw.zvukpravilno;
                    exerciseNumber = 2;
                } else if (currentActivity == FindCorrectPic.class
                        && ((FindCorrectPic) transitionParams.getpActivity()).getSceneNum() == 1
                && ((FindCorrectPic) transitionParams.getpActivity()).getSceneName().equals("ShadowPic")){
                    introTextId = R.string.Intro1Text1;
                    introPicId = R.drawable.count_on_fingers_05;
                    introTalkId = R.raw.zvukpravilno;
                    exerciseNumber = 1;
                } else if (currentActivity == FindCorrectPic.class
                        && ((FindCorrectPic) transitionParams.getpActivity()).getSceneNum() == 1
                && ((FindCorrectPic) transitionParams.getpActivity()).getSceneName().equals("NeedlessPic")){
                    introTextId = R.string.Intro1Text5;
                    introPicId = R.drawable.pear_main;
                    introTalkId = R.raw.zvukpravilno;
                    exerciseNumber = 5;
                } else if (currentActivity == CroppedPicActivity.class) {
                    introTextId = R.string.Intro1Text4;
                    introPicId = R.drawable.buttons_example;
                    introTalkId = R.raw.zvukpravilno;
                    exerciseNumber = 4;
                } else {
                    isNextExerciseExisting = false;
                }
            }

               else if (testNumber == 2) {
                    if (currentActivity == ClockActivity.class) {
//                            FindCorrectPic.class
//                            && ((FindCorrectPic) transitionParams.getpActivity()).getSceneName().equals("ShadowPic")

                    introTextId = R.string.Intro1Text16;
                    introPicId = R.drawable.digit_example;
                    introTalkId = R.raw.zvukpravilno;
                    exerciseNumber = 16;
                    } else if (currentActivity == MethodsFor10AnswersActivitys.class
                            && ((MethodsFor10AnswersActivitys) transitionParams.getpActivity()).getGameName().equals("Digit")) {
                        introTextId = R.string.Intro1Text4;
                        introPicId = R.drawable.buttons_example;
                        introTalkId = R.raw.zvukpravilno;
                        exerciseNumber = 9;
                    }  else if (currentActivity == ButtonActivity.class ){
                        introTextId = R.string.Intro1Text3;
                        introPicId =  R.drawable.needless_pic_intro;
                        introTalkId = R.raw.zvukpravilno;
                        exerciseNumber = 11;
                    } else if (currentActivity == FindCorrectPic.class
                            && ((FindCorrectPic) transitionParams.getpActivity()).getSceneName().equals("NeedlessPic")) {
                        introTextId = R.string.Intro1Text12;
                        introPicId = R.drawable.cutted_boy_main;
                        introTalkId = R.raw.zvukpravilno;
                        exerciseNumber = 12;
                    }else
                    {
                        isNextExerciseExisting = false;
                    }
                }

            if(isNextExerciseExisting) {
                new Handler().postDelayed(new NextTestScene(transitionParams.getpActivity(), introTextId, introPicId, testNumber, exerciseNumber
                        , introTalkId), 1900);
            }

        }
        new Handler().postDelayed(new ShowResults(transitionParams.getpActivity(), transitionParams.getpCorrectAnswers(), transitionParams.getpCurrentGamePoints(), transitionParams.isEnd()), 2000);

    }
}
