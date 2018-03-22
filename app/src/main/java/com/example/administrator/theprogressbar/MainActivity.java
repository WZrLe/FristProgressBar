package com.example.administrator.theprogressbar;

import android.animation.ObjectAnimator;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ProgressView mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressView = findViewById(R.id.progressView);
        mProgressView.setPaintSize(20);
        mProgressView.setPaintWidth(10);
        mProgressView.setProgress(20);
        startProgressAnim();
    }


    public void onClickButton(View view) {
        startProgressAnim();
    }

    private void startProgressAnim() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mProgressView, "progress", 0, 100);
        objectAnimator.setDuration(3000);
        objectAnimator.setInterpolator(new FastOutLinearInInterpolator());
        objectAnimator.start();
    }

}
