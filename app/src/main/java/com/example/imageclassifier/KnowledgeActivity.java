package com.example.imageclassifier;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;


import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;


public class KnowledgeActivity extends BaseActivity {

    ListView listView;
    SearchView searchView;
    List<ItemsClass> wasteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityContent(R.layout.activity_knowledge);

        //searchView = findViewById(R.id.searchBar);
        listView = findViewById(R.id.listView);
        wasteList = new ArrayList<>();

        wasteList.add(new ItemsClass("Organic Waste", "Biodegradable", "To Properly Dispose:",
                "1. Gather vegetable peels, fruit peels, eggshells, and similar organic waste in a separate container.\n" +
                        "2. Avoid mixing organic waste with plastics, paper, glass, or other non-biodegradable materials.\n" +
                        "3. Place the organic waste in a biodegradable bag or a green bin labeled for organic waste.\n" +
                        "4. If you have space, use the organic waste to create compost by placing it in a compost bin or pile and adding dry materials like dried leaves.\n" +
                        "5. Do not throw organic waste into canals, rivers, or open areas to prevent pollution and flooding.\n" +
                        "6. Ensure the organic waste is properly stored in covered bins to avoid attracting pests.\n" +
                        "7. Coordinate with your local waste management service to have the organic waste collected on designated days.\n" +
                        "8. If composting is not possible and collection services are unavailable, contact the local government for proper disposal instructions.",
                R.drawable.biodegradable2, R.drawable.biodegradable_bg, ContextCompat.getColor(this, R.color.green)));

        wasteList.add(new ItemsClass("Food Waste", "Biodegradable", "To Properly dispose:",
                "1. Separate leftover food from other types of waste such as plastics, bottles, and paper. Leftover food should be disposed of as biodegradable waste.\n" +
                        "2. Place the leftover food in the bin labeled for biodegradable waste. These bins are usually green or marked \"Biodegradable.\"\n" +
                        "3. If space allows, leftover food can be used to create compost, which is beneficial for soil and plants.\n" +
                        "4. Do not throw leftover food into drains or rivers as this can cause flooding and pollution.\n" +
                        "5. Ensure that leftover food waste is collected by the local government or waste collectors on the designated collection days.",
                R.drawable.biodegradable2, R.drawable.biodegradable_bg, ContextCompat.getColor(this, R.color.green)));

        wasteList.add(new ItemsClass("Environmental Waste", "Biodegradable", "To Properly Dispose:",
                "1. Gather dry leaves, grass clippings, small branches, and similar organic waste.\n" +
                        "2. Avoid mixing with non-biodegradable waste like plastics or metals.\n" +
                        "3. Place in a compost bin or green waste bin if available.\n" +
                        "4. For composting, mix with other organic waste for faster decomposition.\n" +
                        "5. If composting isn’t an option, contact local authorities for disposal.\n" +
                        "6. Do not burn, as it harms health and air quality.\n" +
                        "7. Ensure it's stored in a covered bin to avoid pests.\n" +
                        "8. Confirm collection with local waste management.",
                R.drawable.biodegradable2, R.drawable.biodegradable_bg, ContextCompat.getColor(this, R.color.green)));

        wasteList.add(new ItemsClass("Plastic Type Waste", "Non-Biodegradable", "To Properly Dispose:",
                "1. Separate plastics by type (e.g., PET, HDPE).\n" +
                        "2. Rinse off food and liquid residues.\n" +
                        "3. Remove non-recyclable parts such as caps and labels.\n" +
                        "4. Check for recycling symbols or instructions.\n" +
                        "5. Place in the designated recycling bin or drop-off center.",
                R.drawable.nonbiodegradable2, R.drawable.nonbiodegradable_bg, ContextCompat.getColor(this, R.color.yellow)));

        wasteList.add(new ItemsClass("Styrofoam Type Waste", "Non-Biodegradable", "To Properly Dispose:",
                "1. Check if the styrofoam is recyclable by looking for the recycling symbol. If not dispose it in Non-biodegrable bin \n" +
                        "2. Clean the styrofoam, removing any tape or food residue.\n" +
                        "3. Find a local recycling center that accepts styrofoam.\n" +
                        "4. Consider reusing styrofoam for crafts, gardening, or insulation.\n" +
                        "5. Participate in community collection drives for proper disposal.\n" +
                        "6. Look for drop-off points for specialized styrofoam disposal.",
                R.drawable.nonbiodegradable2, R.drawable.nonbiodegradable_bg, ContextCompat.getColor(this, R.color.yellow)));

        wasteList.add(new ItemsClass("Packaging Boxes", "Recyclable", "To Properly Dispose:",
                "1. Flatten packaging boxes to save space.\n" +
                        "2. Remove any non-recyclable items such as plastic liners or tape.\n" +
                        "3. Place the flattened boxes in the appropriate recycling bin.\n" +
                        "4. If the box is contaminated with food or liquid, dispose of it in the non-recyclable waste bin. \n" +
                        "5. Avoid mixing packaging boxes with non-recyclable materials.",
                R.drawable.recyclable2, R.drawable.recyclable_bg, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteList.add(new ItemsClass("Paper Type Waste", "Recyclable", "To Properly Dispose:",
                "1. Separate paper waste from other trash.\n" +
                        "2. Flatten any paper items like boxes or cardboard.\n" +
                        "3. Remove any food or liquid-soaked paper and dispose of it in the non-recyclable waste bin.\n" +
                        "4. Place the clean, dry paper in the recycling bin.\n" +
                        "5. Avoid mixing paper with plastic or metal materials.",
                R.drawable.recyclable2, R.drawable.recyclable_bg, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteList.add(new ItemsClass("Plastic Bottle", "Recyclable", "To Properly Dispose:",
                "1. Empty the plastic bottle and rinse it if necessary.\n" +
                        "2. Remove any caps or labels.\n" +
                        "3. Place the plastic bottle in the recycling bin.\n" +
                        "4. If the bottle is contaminated with food or hazardous liquids, dispose of it in the non-recyclable waste bin.\n" +
                        "5. Avoid crushing plastic bottles before recycling, as it can affect the recycling process.",
                R.drawable.recyclable2, R.drawable.recyclable_bg, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteList.add(new ItemsClass("Batteries", "E-Waste", "To Properly Dispose:",
                "1. Do not place them in household trash or curbside recycling bins.\n" +
                        "2. Take them to battery collection sites or household hazardous waste collection facilities.\n" +
                        "3. Identify the type of battery (rechargeable or single use).\n" +
                        "4. Discharge rechargeable batteries completely before disposal.\n" +
                        "5. Cover battery terminals with electrical tape or plastic caps.\n" +
                        "6. Store batteries in a cool, dry place away from heat sources and sunlight.\n" +
                        "7. Keep them separate from other waste and batteries.\n",
                R.drawable.e_waste2, R.drawable.electronic_waste_bg, ContextCompat.getColor(this, R.color.red)));

        wasteList.add(new ItemsClass("Electronic Devices", "E-Waste", "To Properly Dispose:",
                "Reset the device to remove all personal data. \n" +
                        "Safely remove any batteries and other detachable components.\n" +
                        "Pack the device securely to avoid damage during transport.\n" +
                        "Bring the device to SM E-waste collection bins or any other e-waste disposal collector.\n" +
                        "If SM is not available, there are others like E-waste Management Philippines, E-waste Project UP or look for any accredited E-waste recycler or inquire with your LGU about collection points.\n" +
                        "Avoid disposing of the device in regular trash bins or dumping it in open areas.",
                R.drawable.e_waste2, R.drawable.electronic_waste_bg, ContextCompat.getColor(this, R.color.red)));

        wasteList.add(new ItemsClass("Home Appliance", "E-Waste", "To Properly Dispose:",
                "Unplug the appliance and clean it thoroughly.\n" +
                        "Safely remove any hazardous parts, such as batteries or fluids, if applicable.\n" +
                        "Separate any recyclable components, like metal or plastic parts, if possible.\n" +
                        "Transport the appliance to SM collection bins for E-waste or accredited recycling centers. \n" +
                        "If SM is unavailable, coordinate with your LGU for proper disposal services.\n" +
                        "Do not burn, bury, or dispose of appliances in landfills.\n" +
                        "You can trade them, put for sale or either scrap them for additional money.",
                R.drawable.e_waste2, R.drawable.electronic_waste_bg, ContextCompat.getColor(this, R.color.red)));

        ItemsAdapter adapter = new ItemsAdapter(this, wasteList);
        listView.setAdapter(adapter);

        /**searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        });**/

    }

}
