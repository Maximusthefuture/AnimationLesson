package com.example.animationlesson;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CustomAnimationTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_animation_transition);


    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            overridePendingTransition(R.anim.enter_from_bottom, R.anim.exit_top);
        }
    }
}
