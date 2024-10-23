package com.example.imageclassifier;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity{

    private boolean imageSwitched = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Animation popUpAnimation = AnimationUtils.loadAnimation(this, R.anim.pop_up_animation);

        ImageView logoImage = findViewById(R.id.logo);
        View rootLayout = findViewById(R.id.splashscreen_layout);

        ObjectAnimator rotate1 = ObjectAnimator.ofFloat(logoImage, "rotation", 0f, 120f);
        rotate1.setDuration(500);
        rotate1.setStartDelay(500);

        ObjectAnimator rotate2 = ObjectAnimator.ofFloat(logoImage, "rotation", 120f, 240f);
        rotate2.setDuration(500);
        rotate2.setStartDelay(300);

        ObjectAnimator rotate3 = ObjectAnimator.ofFloat(logoImage, "rotation", 240f, 360f);
        rotate3.setDuration(500);
        rotate3.setStartDelay(300);

        rotate3.addUpdateListener(animation -> {
            float rotationValue = (float) animation.getAnimatedValue();
            if (rotationValue >= 270f && !imageSwitched) {
                logoImage.setImageResource(R.drawable.ecosort_logo2);
                animateBackgroundColor(rootLayout, Color.BLACK, Color.parseColor("#247D7F"));
                imageSwitched = true;
            }
        });

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(rotate1, rotate2, rotate3);

        animatorSet.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000); // Delay for 3 seconds
    }
    private void animateBackgroundColor(View view, int startColor, int endColor) {
        ValueAnimator colorAnimation = ValueAnimator.ofArgb(startColor, endColor);
        colorAnimation.setDuration(500);
        colorAnimation.addUpdateListener(animator ->
                view.setBackgroundColor((int) animator.getAnimatedValue()));
        colorAnimation.start();
    }
}
