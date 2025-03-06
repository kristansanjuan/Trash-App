package com.example.imageclassifier.onboarding;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.imageclassifier.MainActivity;
import com.example.imageclassifier.R;

public class FirstScreen extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first_screen, container, false);

        Button nextButton1 = view.findViewById(R.id.nextButton1);
        Button skipOnboarding = view.findViewById(R.id.skipOnboarding);


        nextButton1.setOnClickListener(v -> {
            v.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).withEndAction(() -> {
                v.animate().scaleX(1f).scaleY(1f).setDuration(100).withEndAction(() -> {
                    ViewPager2 viewPager = getActivity().findViewById(R.id.viewPager);
                    viewPager.setCurrentItem(1);
                }).start();
            }).start();
        });

        skipOnboarding.setOnClickListener(v -> {
            v.animate().scaleX(0.9f).scaleY(0.9f).setDuration(70).withEndAction(() ->
                    v.animate().scaleX(1f).scaleY(1f).setDuration(70).start()
            ).start();

            startActivity(new Intent(getContext(), MainActivity.class));
            if (getActivity() != null) getActivity().finish();
        });


        return view;
    }
}