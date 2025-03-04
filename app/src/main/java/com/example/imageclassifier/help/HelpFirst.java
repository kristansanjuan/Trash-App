package com.example.imageclassifier.help;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.imageclassifier.R;

public class HelpFirst extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_help1, container, false);

        Button nextButton1 = view.findViewById(R.id.nextButton1);

        nextButton1.setOnClickListener(v -> {
            ViewPager2 viewPager = getActivity().findViewById(R.id.viewPager);
            viewPager.setCurrentItem(1);
        });

        return view;
    }
}