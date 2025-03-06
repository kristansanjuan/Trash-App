package com.example.imageclassifier;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.imageclassifier.onboarding.FirstScreen;
import com.example.imageclassifier.onboarding.LocationScreen;
import com.example.imageclassifier.onboarding.OnboardingAdapter;
import com.example.imageclassifier.onboarding.SecondScreen;
import com.example.imageclassifier.onboarding.ThirdScreen;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class OnboardingActivity extends AppCompatActivity {

    LinearLayout dotsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        dotsContainer = findViewById(R.id.dotsContainer);

        ViewPager2 viewPager = findViewById(R.id.viewPager);

        OnboardingAdapter adapter = new OnboardingAdapter(this);

        adapter.addFragment(new FirstScreen());
        adapter.addFragment(new SecondScreen());
        adapter.addFragment(new ThirdScreen());
        //adapter.addFragment(new LocationScreen());

        viewPager.setAdapter(adapter);

        addDots(adapter.getItemCount());
        setCurrentDot(0);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentDot(position);
            }
        });

    }

    private void addDots(int count) {
        dotsContainer.removeAllViews();

        for (int i = 0; i < count; i++) {
            ImageView dot = new ImageView(this);
            dot.setImageResource(R.drawable.dot_inactive);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(8, 0, 8, 0);
            dot.setLayoutParams(params);
            dotsContainer.addView(dot);
        }
    }

    private void setCurrentDot(int index) {
        for (int i = 0; i < dotsContainer.getChildCount(); i++) {
            ImageView dot = (ImageView) dotsContainer.getChildAt(i);
            if (i == index) {
                dot.setImageResource(R.drawable.dot_active);
                dot.setAlpha(1f);
            } else {
                dot.setImageResource(R.drawable.dot_inactive);
                dot.setAlpha(0.3f);
            }
        }
    }

}
