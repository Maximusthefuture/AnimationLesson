package com.example.animationlesson;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityAnimationDrawable extends AppCompatActivity {

    private AnimationDrawable mDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_drawable);


        ImageView imageView = findViewById(R.id.horse_image_view);
        mDrawable = (AnimationDrawable) imageView.getDrawable();

    }


    @Override
    protected void onStart() {
        super.onStart();
        mDrawable.start();
    }


    @Override
    protected void onStop() {
        mDrawable.stop();
        super.onStop();
    }


}
