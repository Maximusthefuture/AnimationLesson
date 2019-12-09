package com.example.animationlesson;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

import androidx.appcompat.app.AppCompatActivity;

public class AnimationsActivity extends AppCompatActivity {

    private View mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);

        mImageView = findViewById(R.id.imageView);

        RotateAnimation rotate = new RotateAnimation(0.0f, 360f);

        rotate.setDuration(500L);
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setRepeatMode(Animation.REVERSE);


        Animation scale = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f, 300, 300);

        scale.setDuration(500L);
        scale.setRepeatCount(Animation.INFINITE);
        scale.setRepeatMode(Animation.REVERSE);
        AnimationSet animation = new AnimationSet(false);

         animation.addAnimation(rotate);
         animation.addAnimation(scale);
        mImageView.startAnimation(animation);
    }


    @Override
    protected void onDestroy() {
        mImageView.clearAnimation();
        super.onDestroy();
    }
}
