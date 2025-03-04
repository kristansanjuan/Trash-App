package com.example.imageclassifier.help;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.imageclassifier.R;

public class HelpSecond extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_help2, container, false);

        Button nextButton2 = view.findViewById(R.id.nextButton2);

        nextButton2.setOnClickListener(v -> {
            ViewPager2 viewPager = getActivity().findViewById(R.id.viewPager);
            viewPager.setCurrentItem(2);
        });

        return view;
    }
}