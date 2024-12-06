package com.example.imageclassifier;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.imageclassifier.onboarding.FirstScreen;
import com.example.imageclassifier.onboarding.OnboardingAdapter;
import com.example.imageclassifier.onboarding.SecondScreen;
import com.example.imageclassifier.onboarding.ThirdScreen;

public class OnboardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        OnboardingAdapter adapter = new OnboardingAdapter(this);

        adapter.addFragment(new FirstScreen());
        adapter.addFragment(new SecondScreen());
        adapter.addFragment(new ThirdScreen());

        viewPager.setAdapter(adapter);
    }

}
