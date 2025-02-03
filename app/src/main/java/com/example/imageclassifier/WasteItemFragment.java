package com.example.imageclassifier;

import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class WasteItemFragment extends Fragment {

    ImageView wasteIcon;
    TextView wasteItem, wasteCategory, introView, disposalView;
    SwitchCompat translateSwitch;

    String itemText, categoryText, introText, disposalText;
    int iconImage, backgroundType, categoryColor;

    public static WasteItemFragment newInstance(ItemsClass item) {
        WasteItemFragment fragment = new WasteItemFragment();
        Bundle args = new Bundle();
        args.putString("wasteItem", item.getItemTitle());
        args.putString("wasteCategory", item.getWasteType());
        args.putString("introView", item.getIntro());
        args.putString("disposalView", item.getDisposal());
        args.putInt("iconImage", item.getImageId());
        args.putInt("backgroundType", item.getBackgroundId());
        args.putInt("categoryCOlor", item.getColorId());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_waste_item, container, false);

        wasteIcon = view.findViewById(R.id.wasteIcon);
        wasteItem = view.findViewById(R.id.wasteItem);
        wasteCategory = view.findViewById(R.id.wasteCategory);
        introView = view.findViewById(R.id.introView);
        disposalView = view.findViewById(R.id.disposalView);
        translateSwitch = view.findViewById(R.id.translateLanguage);

        if (getArguments() != null) {
            itemText = getArguments().getString("wasteItem");
            categoryText = getArguments().getString("wasteCategory");
            introText = getArguments().getString("introView");
            disposalText = getArguments().getString("disposalView");
            iconImage = getArguments().getInt("iconImage");
            backgroundType = getArguments().getInt("backgroundType");
            categoryColor = getArguments().getInt("categoryColor");

            wasteItem.setText(itemText);
            wasteCategory.setText(categoryText);
            introView.setText(introText);
            disposalView.setText(disposalText);
            wasteIcon.setImageResource(iconImage);
            wasteIcon.setBackgroundResource(backgroundType);
            wasteCategory.setTextColor(categoryColor);
        }

        return view;
    }
}