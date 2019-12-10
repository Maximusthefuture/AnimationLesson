package com.example.animationlesson;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SceneAnimationActivity extends AppCompatActivity {

    final TransitionSet transitionSet = new TransitionSet();
    Scene sceneOne;
    Scene sceneTwo;
    private Button button;

    //    private Button buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_animation);

        ViewGroup sceneRoot = findViewById(R.id.scene_root);
        button = findViewById(R.id.button);
        transitionSet.addTransition(new Fade());
        transitionSet.addTransition(new ChangeBounds());
        sceneOne = Scene.getSceneForLayout(sceneRoot, R.layout.scene_a, this);
        sceneTwo = Scene.getSceneForLayout(sceneRoot, R.layout.another_scene, this);

        setSceneEnterAction(sceneTwo, sceneOne);

        setSceneEnterAction(sceneOne, sceneTwo);

        buttonClickListener(sceneTwo);
    }

    public void buttonClickListener(final Scene scene) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transitionSet.setOrdering(TransitionSet.ORDERING_TOGETHER);
                transitionSet.setDuration(500);
                transitionSet.setInterpolator(new AccelerateInterpolator());
                TransitionManager.go(scene, transitionSet);

            }
        });
    }

    public Scene setSceneEnterAction(final Scene fromScene, final Scene toScene) {
        fromScene.setEnterAction(new Runnable() {
            @Override
            public void run() {
                button = findViewById(R.id.button);
                Toast.makeText(SceneAnimationActivity.this, "Scene2 Enter", Toast.LENGTH_SHORT).show();
                buttonClickListener(toScene);
            }
        });

        return fromScene;
    }
}
