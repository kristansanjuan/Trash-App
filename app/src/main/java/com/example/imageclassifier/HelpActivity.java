package com.example.imageclassifier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.viewpager2.widget.ViewPager2;

import com.example.imageclassifier.help.HelpAdapter;
import com.example.imageclassifier.help.HelpFirst;
import com.example.imageclassifier.help.HelpSecond;
import com.example.imageclassifier.help.HelpThird;

public class HelpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityContent(R.layout.activity_help);

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        Button skipOnboarding2 = findViewById(R.id.skipOnboarding2);

        HelpAdapter adapter = new HelpAdapter(this);
        adapter.addFragment(new HelpFirst());
        adapter.addFragment(new HelpSecond());
        adapter.addFragment(new HelpThird());

        viewPager.setAdapter(adapter);

        }
    }

