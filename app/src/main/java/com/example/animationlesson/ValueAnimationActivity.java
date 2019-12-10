package com.example.animationlesson;

import android.animation.AnimatorInflater;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class ValueAnimationActivity extends AppCompatActivity {

    private static final String TRANSLATE = "TRANSLATE";
    private static final String SCALE = "SCALE";
    private ValueAnimator mAnimator;
    private boolean mUsePropertyValueHolder = false;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animation);
        imageView = findViewById(R.id.imageView);
        if (mUsePropertyValueHolder) {
            PropertyValuesHolder holderTranslate = PropertyValuesHolder.ofInt(TRANSLATE, 0, 500);
            PropertyValuesHolder scaleHolder = PropertyValuesHolder.ofFloat(SCALE, 0.5f, 1.f);
            mAnimator = ValueAnimator.ofPropertyValuesHolder(holderTranslate, scaleHolder);
            mAnimator.setDuration(1000);
            mAnimator.setRepeatMode(ValueAnimator.RESTART);
            mAnimator.setRepeatCount(ValueAnimator.INFINITE);
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @RequiresApi(api = Build.VERSION_CODES.Q)
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int translate = (int) valueAnimator.getAnimatedValue(TRANSLATE);
                    int alpha = (int) valueAnimator.getAnimatedValue(SCALE);
                    imageView.setTranslationX(translate);
                    imageView.setTranslationY(translate);
                    imageView.setTransitionAlpha(alpha);
                }
            });
        } else {
            mAnimator =
                    (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.value_animation);
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float alpha = (float) mAnimator.getAnimatedValue();
                    imageView.setAlpha(alpha);
                }
            });
        }
//        mAnimator.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAnimator.start();
    }

    @Override
    protected void onDestroy() {
        mAnimator.cancel();
        super.onDestroy();
    }
}
