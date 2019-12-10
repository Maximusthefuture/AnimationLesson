package com.example.animationlesson;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

public class MainActivity extends AppCompatActivity {


    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            Intent intent;
            switch (view.getId()) {
                case R.id.animation_drawable:
                    intent = new Intent(MainActivity.this, ActivityAnimationDrawable.class);
                    startActivity(intent);
                    break;

                case R.id.view_animations:
                    intent = new Intent(MainActivity.this, AnimationsActivity.class);
                    startActivity(intent);
                    break;

                case R.id.value_animation:
                    intent = new Intent(MainActivity.this, ValueAnimationActivity.class);
                    startActivity(intent);
                    break;

                case R.id.object_animations:
                    intent = new Intent(MainActivity.this, ObjectAnimations.class);
                    break;

                case R.id.custom_view_animations:
                    intent = new Intent(MainActivity.this, FinanceProgressActivity.class);
                    startActivity(intent);
                    break;

                case R.id.scene_animations:
                    intent = new Intent(MainActivity.this, SceneAnimationActivity.class);
                    startActivity(intent);
                    break;

                case R.id.shared_element_transition:
                    View view1 = findViewById(R.id.shared_element_transition);
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, view, getString(R.string.button_transition));
                    intent = new Intent(MainActivity.this, SharedElementTransitionActivity.class);
//                    startActivity(intent,
//                            ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                    startActivity(intent, options.toBundle());
                    break;

                case R.id.custom_animation_transition:
//                    ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(MainActivity.this, R.anim.enter_from_bottom, R.anim.exit_top);
//                    View view2 = findViewById(R.id.text);
                    ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeClipRevealAnimation(view, view.getScrollX() * 2, view.getScrollY() * 2 , view.getWidth() / 2, view.getHeight() / 2);
                    intent = new Intent(MainActivity.this, CustomAnimationTransitionActivity.class);
                    startActivity(intent, optionsCompat.toBundle());



                default:
                    intent = null;


            }
//            startActivity(intent);
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
        findViewById(R.id.shared_element_transition).setOnClickListener(clickListener);
        findViewById(R.id.custom_animation_transition).setOnClickListener(clickListener);

    }



}
