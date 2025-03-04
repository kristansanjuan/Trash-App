package com.example.imageclassifier;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.imageclassifier.help.HelpAdapter;
import com.example.imageclassifier.help.HelpFirst;
import com.example.imageclassifier.help.HelpSecond;
import com.example.imageclassifier.help.HelpThird;
import com.example.imageclassifier.onboarding.FirstScreen;
import com.example.imageclassifier.onboarding.OnboardingAdapter;
import com.example.imageclassifier.onboarding.SecondScreen;
import com.example.imageclassifier.onboarding.ThirdScreen;

public class HelpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityContent(R.layout.activity_help);

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        HelpAdapter adapter = new HelpAdapter(this);

        adapter.addFragment(new HelpFirst());
        adapter.addFragment(new HelpSecond());
        adapter.addFragment(new HelpThird());
        //adapter.addFragment(new LocationScreen());

        viewPager.setAdapter(adapter);
    }

}
