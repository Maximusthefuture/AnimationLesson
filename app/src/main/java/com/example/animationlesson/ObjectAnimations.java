package com.example.animationlesson;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ObjectAnimations extends AppCompatActivity {
    private static final String ROTATION = "rotation";
    private static final String TRANSLATION_Y = "translationY";
    private static final String TRANSLATION_X = "translationX";
    private ImageView imageView;
    private ObjectAnimator rotateAnimator;
    private ObjectAnimator translationAnimation;
    private boolean mUsePropertyValuesHolder = false;
    private List<ObjectAnimator> mListAnimations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animations);
        float translationY = getResources().getDimension(R.dimen.translationY);
        imageView = findViewById(R.id.imageView);

//        if (mUsePropertyValuesHolder) {
            PropertyValuesHolder holderRotation = PropertyValuesHolder.ofFloat(ROTATION, 0f, 720f);
            PropertyValuesHolder holderTranslation = PropertyValuesHolder.ofFloat(TRANSLATION_Y, 0f, translationY);
            PropertyValuesHolder holderTranslationX = PropertyValuesHolder.ofFloat(TRANSLATION_X, 0f, translationY);
            ObjectAnimator holderAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, holderRotation, holderTranslation, holderTranslationX);
            holderAnimator.setDuration(2000);
            holderAnimator.setRepeatMode(ObjectAnimator.REVERSE);
            holderAnimator.setRepeatCount(ObjectAnimator.INFINITE);
            holderAnimator.addUpdateListener(new ObjectAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {

                }
            });
            mListAnimations.add(holderAnimator);

//        }
//        rotateAnimator = ObjectAnimator.ofFloat(imageView, "rotation", 0, 720.0f);
//        rotateAnimator  = ObjectAnimator.ofFloat(imageView, "translationY", 0f, translationY);
//        rotateAnimator.setRepeatCount(ObjectAnimator.INFINITE);
//        rotateAnimator.setRepeatMode(ObjectAnimator.REVERSE);
//        rotateAnimator.setDuration(1000);
//        rotateAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
//        mListAnimations.add(rotateAnimator);
//
//        translationAnimation = ObjectAnimator.ofFloat(imageView, "translationX",0f,  translationY);
//        translationAnimation.setRepeatCount(ObjectAnimator.INFINITE);
//        translationAnimation.setRepeatMode(ObjectAnimator.REVERSE);
//        translationAnimation.setDuration(2000);
//        mListAnimations.add(translationAnimation);
//
    }

    @Override
    protected void onStart() {
        super.onStart();
        for (ObjectAnimator animator : mListAnimations) {
            animator.start();
        }

    }


    @Override
    protected void onDestroy() {
        for (ObjectAnimator animator : mListAnimations) {
            animator.cancel();
        }
        super.onDestroy();
    }
}
