package com.example.animationlesson;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button animationDrawable;
    private Button viewAnimations;
    private Button objectAnimations;
    private Button customViewAnimations;
    private Button sceneAnimations;

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent;
            switch (view.getId()) {
                case R.id.animation_drawable:
                    intent = new Intent(MainActivity.this, ActivityAnimationDrawable.class);

                    break;
                case R.id.view_animations:
                    intent = new Intent(MainActivity.this, AnimationsActivity.class);

                    break;

                case R.id.value_animation:
                    intent = new Intent(MainActivity.this, ValueAnimationActivity.class);
                    break;

                case R.id.object_animations:
                    intent = new Intent(MainActivity.this, ObjectAnimator.class);
                    break;
                case R.id.custom_view_animations:
                    intent = null;
                    break;
                case R.id.scene_animations:
                    intent = null;
                    break;

                    default:
                        intent = null;



            }
            startActivity(intent);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            findViewById(R.id.animation_drawable).setOnClickListener(clickListener);
            findViewById(R.id.view_animations).setOnClickListener(clickListener);
            findViewById(R.id.value_animation).setOnClickListener(clickListener);
            findViewById(R.id.object_animations).setOnClickListener(clickListener);
            findViewById(R.id.custom_view_animations).setOnClickListener(clickListener);
            findViewById(R.id.scene_animations).setOnClickListener(clickListener);
    }
}
