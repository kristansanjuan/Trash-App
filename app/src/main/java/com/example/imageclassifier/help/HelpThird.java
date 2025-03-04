package com.example.imageclassifier.help;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

import com.example.imageclassifier.MainActivity;
import com.example.imageclassifier.R;

public class HelpThird extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_help3, container, false);

        Button skipButton = view.findViewById(R.id.skipButton);

        skipButton.setOnClickListener(v -> {
            //ViewPager2 viewPager = getActivity().findViewById(R.id.viewPager);
            //viewPager.setCurrentItem(3);
            Intent intent = new Intent(getContext(), MainActivity.class);
            startActivity(intent);
            getActivity().finish();
        });

        VideoView videoView = view.findViewById(R.id.videoWalkthrough);
        Uri videoUri = Uri.parse("android.resource://" + requireContext().getPackageName() + "/" + R.raw.ecosort_walkthrough1);
        videoView.setVideoURI(videoUri);

        videoView.setOnPreparedListener(mp -> {
            videoView.start();
        });

        MediaController mediaController = new MediaController(requireContext());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        //videoView.start();

        return view;
    }
}