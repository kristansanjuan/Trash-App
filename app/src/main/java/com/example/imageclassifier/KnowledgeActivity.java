package com.example.imageclassifier;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;


import java.util.ArrayList;


public class KnowledgeActivity extends BaseActivity {

    ListView listView;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityContent(R.layout.activity_knowledge);

        searchView = findViewById(R.id.searchBar);
        listView = findViewById(R.id.listView);

        ArrayList<String> wasteList = new ArrayList<>();
        wasteList.add("Organic Waste");
        wasteList.add("Food Waste");
        wasteList.add("Environmental Waste");
        wasteList.add("Plastic");
        wasteList.add("Styrofoam");
        wasteList.add("Packaging Boxes");
        wasteList.add("Paper");
        wasteList.add("1");
        wasteList.add("2");
        wasteList.add("3");
        wasteList.add("4");
        wasteList.add("5");
        wasteList.add("6");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.knowledge_items, wasteList);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

    }


}
