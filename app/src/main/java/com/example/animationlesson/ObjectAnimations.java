package com.example.animationlesson;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ObjectAnimations extends AppCompatActivity {
    private ImageView imageView;
    ObjectAnimator objectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animations);
        imageView = findViewById(R.id.imageView);
        objectAnimator = ObjectAnimator.ofFloat(imageView, "rotation", 0, 360.0f);
        objectAnimator.setRepeatCount(10);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    @Override
    protected void onStart() {
        super.onStart();
        objectAnimator.start();
    }
}
