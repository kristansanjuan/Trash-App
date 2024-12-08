package com.example.imageclassifier.onboarding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.imageclassifier.R;

public class LocationAdapter extends ArrayAdapter<String> {

    private List<String> originalList;
    private List<String> filteredList;
    private LayoutInflater inflater;

    public LocationAdapter(Context context, List<String> locations) {
        super(context, 0, locations);
        this.originalList = new ArrayList<>(locations);
        this.filteredList = new ArrayList<>(locations);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return filteredList.size();
    }

    @Override
    public String getItem(int position) {
        return filteredList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_location, parent, false);
        }

        TextView locationNameTextView = convertView.findViewById(R.id.locationName);
        locationNameTextView.setText(getItem(position)); // Bind the location name here

        return convertView;
    }

    public void filter(String query) {
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(originalList);
        } else {
            for (String location : originalList) {
                if (location.toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(location);
                }
            }
        }
        notifyDataSetChanged();
    }
}

