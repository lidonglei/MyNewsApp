package com.example.administrator.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.example.administrator.mynewsapp.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ImageView iv_splashActivity_anima = (ImageView) findViewById(R.id.iv_splashActivity_anima);
        AnimationSet animationSet = new AnimationSet(false);
        RotateAnimation rotateAnimation = new RotateAnimation
                (0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);

        animationSet.setDuration(2000);
        iv_splashActivity_anima.setAnimation(animationSet);
        animationSet.start();

        //animationSet.setRepeatCount(-1);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this,GuideActivity.class));
                finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });






    }
}
