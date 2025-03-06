package com.example.imageclassifier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.viewpager2.widget.ViewPager2;

import com.example.imageclassifier.help.HelpAdapter;
import com.example.imageclassifier.help.HelpFirst;
import com.example.imageclassifier.help.HelpSecond;
import com.example.imageclassifier.help.HelpThird;

public class HelpActivity extends BaseActivity {

    LinearLayout dotsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityContent(R.layout.activity_help);

        dotsContainer = findViewById(R.id.dotsContainer);
        ViewPager2 viewPager = findViewById(R.id.viewPager);
        Button skipOnboarding2 = findViewById(R.id.skipOnboarding2);

        HelpAdapter adapter = new HelpAdapter(this);
        adapter.addFragment(new HelpFirst());
        adapter.addFragment(new HelpSecond());
        adapter.addFragment(new HelpThird());

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

