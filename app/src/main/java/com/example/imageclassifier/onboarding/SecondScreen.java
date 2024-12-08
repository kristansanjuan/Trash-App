package com.example.imageclassifier.onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.imageclassifier.R;

public class SecondScreen extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second_screen, container, false);

        Button nextButton2 = view.findViewById(R.id.nextButton2);

        nextButton2.setOnClickListener(v -> {
            ViewPager2 viewPager = getActivity().findViewById(R.id.viewPager);
            viewPager.setCurrentItem(2);
        });

        return view;
    }
}