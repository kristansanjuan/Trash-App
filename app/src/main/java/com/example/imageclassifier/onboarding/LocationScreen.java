package com.example.imageclassifier.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.imageclassifier.MainActivity;
import com.example.imageclassifier.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocationScreen extends Fragment {

    private SearchView searchView;
    private ListView locationListView;
    private Button proceedButton;
    private TextView selectLocationText;

    private List<String> locationList;
    private LocationAdapter locationAdapter;
    private String selectedLocation = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location_screen, container, false);

        // Initialize views
        searchView = view.findViewById(R.id.searchView);
        locationListView = view.findViewById(R.id.locationListView);
        proceedButton = view.findViewById(R.id.proceedButton);
        selectLocationText = view.findViewById(R.id.selectLocationText);

        // location data
        locationList = new ArrayList<>(Arrays.asList(
                "Angat", "Balagtas", "Baliwag", "Bocaue", "Bulakan", "Bustos", "Calumpit", "Dona Remedios Trinidad", "Guiguinto", "Hagonoy", "Malolos", "Marilao", "Meycauayan", "Norzagaray", "Obando", "Pandi", "Paombong", "Plaridel", "Pulilan", "San Ildefonso", "San Jose Del Monte", "San Miguel", "San Rafael", "Santa Maria"
        ));

        locationAdapter = new LocationAdapter(getContext(), locationList);
        locationListView.setAdapter(locationAdapter);

        // Search filter
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                locationAdapter.filter(newText);
                return true;
            }
        });

        // Handle list item click
        locationListView.setOnItemClickListener((parent, view1, position, id) -> {
            selectedLocation = locationList.get(position);
            Toast.makeText(getContext(), "Selected: " + selectedLocation, Toast.LENGTH_SHORT).show();
        });

        // Proceed button click
        proceedButton.setOnClickListener(v -> {
            if (!selectedLocation.isEmpty()) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra("selectedLocation", selectedLocation);
                startActivity(intent);
                getActivity().finish();
            } else {
                Toast.makeText(getContext(), "Please select a location first!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
