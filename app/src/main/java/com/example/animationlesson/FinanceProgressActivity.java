package com.example.animationlesson;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class FinanceProgressActivity extends AppCompatActivity {

    private FinanceProgressView mFinanceProgressView;
    ObjectAnimator animator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_progress_view);
        mFinanceProgressView = findViewById(R.id.finance_progress);
        SeekBar seekBar = findViewById(R.id.seek);
        seekBar.setMax(FinanceProgressView.MAX_PROGRESS);

//        animator = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.progress_animator);
//        animator.setTarget(mFinanceProgressView);
//        animator.start();
//
        ObjectAnimator progressAnimator = ObjectAnimator.ofFloat(mFinanceProgressView, "progress", 0, 101);
        progressAnimator.setDuration(2000);
        progressAnimator.setRepeatCount(ValueAnimator.INFINITE);
        progressAnimator.setRepeatMode(ValueAnimator.REVERSE);
        progressAnimator.start();

        seekBar.setOnSeekBarChangeListener(new BaseOnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mFinanceProgressView.setProgress(progress);
            }

        });
    }

    private static abstract class BaseOnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}
