package com.example.imageclassifier;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TextView textView = findViewById(R.id.textView);

        Animation popUpAnimation = AnimationUtils.loadAnimation(this, R.anim.pop_up_animation);

        textView.startAnimation(popUpAnimation);

        ImageView logoImage = findViewById(R.id.imageView3);

        Animation rotationAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation);

        logoImage.startAnimation(rotationAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3500); // Delay for 3 seconds
    }
}
