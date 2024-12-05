package com.example.imageclassifier.onboarding;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class OnboardingAdapter extends FragmentStateAdapter {

    public OnboardingAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new FirstScreen();
            case 1:
                return new SecondScreen();
            case 2:
                return new ThirdScreen();
            default:
                return new FirstScreen();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
