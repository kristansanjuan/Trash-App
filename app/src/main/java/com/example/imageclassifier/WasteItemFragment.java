package com.example.imageclassifier;

import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class WasteItemFragment extends Fragment {

    ImageView wasteIcon;
    TextView wasteItem, wasteCategory, descriptionView, introView, disposalView;
    SwitchCompat translateSwitch;

    String itemText, categoryText, descriptionText, introText, disposalText;
    String categoryTrans, descriptionTrans, introTrans, disposalTrans;
    int iconImage, backgroundType, categoryColor;

    public static WasteItemFragment newInstance(ItemsClass item, ItemsClass itemTranslated) {
        WasteItemFragment fragment = new WasteItemFragment();
        Bundle args = new Bundle();
        args.putString("wasteItem", item.getItemTitle());
        args.putString("wasteCategory", item.getWasteType());
        args.putString("descriptionView", item.getDescription());
        args.putString("introView", item.getIntro());
        args.putString("disposalView", item.getDisposal());

        args.putString("categoryTranslated", itemTranslated.getWasteType());
        args.putString("descriptionTranslated", itemTranslated.getDescription());
        args.putString("introTranslated", itemTranslated.getIntro());
        args.putString("disposalTranslated", itemTranslated.getDisposal());

        args.putInt("iconImage", item.getImageId());
        args.putInt("backgroundType", item.getBackgroundId());
        args.putInt("categoryColor", item.getColorId());
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
        descriptionView = view.findViewById(R.id.descriptionView);
        introView = view.findViewById(R.id.introView);
        disposalView = view.findViewById(R.id.disposalView);
        translateSwitch = view.findViewById(R.id.translateLanguage);

        if (getArguments() != null) {
            itemText = getArguments().getString("wasteItem");
            categoryText = getArguments().getString("wasteCategory");
            descriptionText = getArguments().getString("descriptionView");
            introText = getArguments().getString("introView");
            disposalText = getArguments().getString("disposalView");

            categoryTrans = getArguments().getString("categoryTranslated");
            descriptionTrans = getArguments().getString("descriptionTranslated");
            introTrans = getArguments().getString("introTranslated");
            disposalTrans = getArguments().getString("disposalTranslated");

            iconImage = getArguments().getInt("iconImage");
            backgroundType = getArguments().getInt("backgroundType");
            categoryColor = getArguments().getInt("categoryColor");

            wasteItem.setText(itemText);

            wasteIcon.setImageResource(iconImage);
            wasteIcon.setBackgroundResource(backgroundType);
            wasteCategory.setTextColor(categoryColor);

            translateText(false);
        }

        translateSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            translateText(isChecked);
        });

        return view;
    }

    private void translateText(boolean isTranslated) {
        if (isTranslated) {
            wasteCategory.setText(categoryTrans);
            descriptionView.setText(descriptionTrans);
            introView.setText(introTrans);
            disposalView.setText(disposalTrans);
        } else {
            wasteCategory.setText(categoryText);
            descriptionView.setText(descriptionText);
            introView.setText(introText);
            disposalView.setText(disposalText);
        }
    }
}