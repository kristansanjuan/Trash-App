package com.example.imageclassifier;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.activity.OnBackPressedCallback;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeActivity extends BaseActivity {

    ListView listView;
    SearchView searchView;
    List<ItemsClass> wasteList;
    List<ItemsClass> wasteListTranslated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityContent(R.layout.activity_knowledge);

        searchView = findViewById(R.id.searchBar);
        listView = findViewById(R.id.listView);
        wasteList = new ArrayList<>();
        wasteListTranslated = new ArrayList<>();



        int searchEditTextId = searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        EditText searchEditText = searchView.findViewById(searchEditTextId);


        if (searchEditText != null) {
            searchEditText.setTextColor(Color.BLACK);
            searchEditText.setHintTextColor(Color.BLACK);
        }

        int searchIconId = searchView.getContext().getResources().getIdentifier("android:id/search_mag_icon", null, null);
        ImageView searchIcon = searchView.findViewById(searchIconId);

        if (searchIcon != null) {
            searchIcon.setColorFilter(Color.parseColor("#247D7F"), PorterDuff.Mode.SRC_IN);
        }

        String properWasteDisposal = "Proper Waste Disposal";
        String tagproperWasteDisposal = "Tamang Pagtatapon";

        wasteList.add(new ItemsClass("Organic Waste", "Biodegradable",
                "Organic waste includes biodegradable materials like vegetable and fruit scraps, eggshells, and rotten produce that decompose naturally.",
                properWasteDisposal,
                "1. Dispose in a green bin or compost\n" +
                        "2. Composting works best with dried leaves.\n" +
                        "3. Uncovered waste attracts pests.\n" +
                        "4. Dumping in canals causes pollution.\n",
                R.drawable.icon_biodegradable, ContextCompat.getColor(this, R.color.green)));

        wasteList.add(new ItemsClass("Environmental Waste", "Biodegradable",
                "Environmental waste includes branches, flowers, grass, and leaves.",
                properWasteDisposal,
                "1. Compost bins and green waste bins help in proper waste management.\n" +
                        "2. Mixing organic waste enhances composting and speeds up decomposition.\n" +
                        "3. Burning waste releases pollutants that harm air quality.\n" +
                        "4. Keeping waste covered helps prevent pests and maintain cleanliness.\n",
                R.drawable.icon_biodegradable, ContextCompat.getColor(this, R.color.green)));

        wasteList.add(new ItemsClass("Glass Type Waste", "Non-Biodegradable",
                "Glass waste includes discarded bottles, jars, windows, mirrors, and drinkware. It can be recycled, but broken or contaminated glass requires proper disposal to prevent hazards.",
                properWasteDisposal,
                "1. Recyclable glass, such as bottles and jars, belongs in the recycling bin.\n" +
                        "2. Wrapping broken glass securely helps prevent injuries\n" +
                        "3. Labeling as 'Broken Glass' ensures safe handling.\n" +
                        "4. Disposing of broken glass in the non-biodegradable bin keeps waste properly sorted.\n",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow)));

        wasteList.add(new ItemsClass("Plastic Type Waste", "Non-Biodegradable",
                "Plastic waste consists of discarded non-biodegradable materials like PET bottles, HDPE containers, and PVC packaging. Proper management helps reduce pollution.",
                properWasteDisposal,
                "1. Leftover residues can impact the recyclability of materials.\n" +
                        "2. Non-recyclable parts make processing less efficient.\n" +
                        "3. Recycling works best when guidelines are followed.\n" +
                        "4. Proper disposal in designated recycling bins ensures effective waste management.\n",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow)));

        wasteList.add(new ItemsClass("Aluminum Cans", "Non-Biodegradable",
                "Lightweight, recyclable containers used for packaging drinks and food, made from corrosion-resistant aluminum.",
                properWasteDisposal,
                "1. Aluminum cans are best kept separate from plastic or glass, and labels can be removed if possible.\n" +
                        "2. Crushing cans or folding foil helps save space during disposal.\n" +
                        "3. Placing aluminum cans in their designated recycling bin ensures proper recycling.",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow)));

        wasteList.add(new ItemsClass("Packaging Boxes", "Recyclable",
                "Containers made of cardboard, corrugated fiberboard, or plastic, used for storing, protecting, and transporting goods.",
                properWasteDisposal,
                "1. Flattening packaging boxes helps save space for disposal.\n" +
                        "2. Non-recyclable items like plastic liners or tape should be removed.\n" +
                        "3. Recycling bins are the best place for flattened, clean packaging boxes.\n" +
                        "4. Boxes contaminated with food or liquid belong in non-recyclable waste.\n" +
                        "5. Keeping packaging boxes separate from non-recyclable materials ensures proper recycling.",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteList.add(new ItemsClass("Paper Type Waste", "Recyclable",
                "Discarded paper materials such as newspapers, magazines, office documents, cardboard, and packaging. Highly recyclable, it can be repurposed into new paper products to reduce waste and environmental impact.",
                properWasteDisposal,
                "1. Keeping paper waste separate helps ensure proper recycling.\n" +
                        "2. Flattening paper items like boxes saves space for disposal.\n" +
                        "3. Food-soaked or wet paper is non-recyclable and should be disposed of separately.\n" +
                        "4. Clean, dry paper belongs in the recycling bin for reuse.\n" +
                        "5. Mixing paper with plastic or metal must be avoid to maintain recycling efficiency.",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteList.add(new ItemsClass("Plastic Bottles", "Recyclable",
                " Lightweight, durable containers made from polymers like PET or HDPE, commonly used for storing liquids such as water, soda, and household products. While cost-effective and versatile, they contribute to plastic waste and pollution. Recycling and reusing plastic bottles help minimize environmental impact.",
                properWasteDisposal,
                "1. Emptying and rinsing plastic bottles helps maintain recycling quality.\n" +
                        "2. Caps and labels should be removed before disposal.\n" +
                        "3. Clean plastic bottles belong in the recycling bin.\n" +
                        "4. Contaminated bottles with food or hazardous liquids should go in non-recyclable waste.\n" +
                        "5. Avoid crushing bottles before recycling, as it may affect processing efficiency.",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteList.add(new ItemsClass("Batteries", "E-Waste",
                "Devices that store and convert chemical energy into electrical energy to power electronics and machinery. They consist of electrochemical cells with positive (cathode) and negative (anode) terminals, allowing electric current flow. Batteries come in rechargeable (e.g., lithium-ion) and non-rechargeable (e.g., alkaline) types, playing a key role in energy storage and modern technology.",
                properWasteDisposal,
                "1. Household trash and curbside recycling bins are not suitable for battery disposal.\n" +
                        "2. Battery collection sites or hazardous waste facilities ensure safe disposal.\n" +
                        "3. Identifying the battery type helps determine proper recycling methods\n" +
                        "4. Fully discharging rechargeable batteries before disposal enhances safety.\n" +
                        "5. Covering battery terminals with tape or plastic caps prevents short circuits.\n" +
                        "6. Storing batteries in a cool, dry place keeps them safe from heat exposure.\n" +
                        "7. Keeping batteries separate from other waste improves recycling efficiency.\n",
                R.drawable.icon_ewaste, ContextCompat.getColor(this, R.color.red)));

        wasteList.add(new ItemsClass("Electronic Devices", "E-Waste",
                "Gadgets that use electrical circuits to process, transmit, or store information. These include smartphones, computers, televisions, and sensors, which rely on semiconductor components like transistors and integrated circuits. They are essential in communication, entertainment, healthcare, and industrial automation.",
                properWasteDisposal,
                "1. Resetting devices helps remove personal data before disposal.\n" +
                        "2. Detachable components, like batteries, should be removed safely.\n" +
                        "3. Secure packaging prevents damage during transport.\n" +
                        "4. SM E-waste collection bins and other disposal sites accept electronic waste.\n" +
                        "5. E-waste recyclers like E-waste Management Philippines and E-waste Project UP provide disposal options.\n" +
                        "6. Regular trash bins and open dumping are not suitable for electronic waste disposal.",
                R.drawable.icon_ewaste, ContextCompat.getColor(this, R.color.red)));

        //Tagalog//
        wasteListTranslated.add(new ItemsClass("Organik na Basura", "Nabubulok",
                "Mga nabubulok na bagay tulad ng balat ng gulay at prutas, balat ng itlog, at mga sirang pagkain.",
                tagproperWasteDisposal,
                "1. Itapon sa berdeng basurahan o compost bin.\n" +
                        "2. Ang paghalo ng tuyong dahon ay nakakatulong sa composting.\n" +
                        "3. Iwasang iwanang bukas ang basura upang hindi makapagdulot ng peste.\n" +
                        "4. Ang pagtatapon sa kanal ay nagdudulot ng polusyon.\n",
                R.drawable.icon_biodegradable, ContextCompat.getColor(this, R.color.green)));

        wasteListTranslated.add(new ItemsClass("Environmental Waste", "Nabubulok",
                "Mga basura mula sa halaman tulad ng sanga, bulaklak, damo, at dahon.",
                tagproperWasteDisposal,
                "1. Itapon sa compost bin o green waste bin.\n" +
                        "2. Paghahalo ng organic waste ay nakakatulong sa mabilisang pagkabulok.\n" +
                        "3. Ang pagsusunog ng basura ay naglalabas ng nakakasamang polusyon sa hangin.\n" +
                        "4. Kung magko-kompost, ihalo ang mga ito sa ibang nabubulok na basura para mapabilis ang pagkabulok.\n",
                R.drawable.icon_biodegradable, ContextCompat.getColor(this, R.color.green)));

        wasteListTranslated.add(new ItemsClass("Basurang Salamin", "Hindi Nabubulok",
                "Mga basurang babasagin katulad ng bote, garapon, bintana, salamin, at baso.",
                tagproperWasteDisposal,
                "1. Ang mga boteng baso at garapon ay dapat ilagay sa recycling bin.\n" +
                        "2. Balutin nang maayos ang basag na salamin upang maiwasan ang pinsala.\n" +
                        "3. Lagyan ng label na “Basag na Salamin” upang mapanatili ang kaligtasan.\n" +
                        "4. Itapon ang basag na salamin sa tamang non-biodegradable bin.\n",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow)));

        wasteListTranslated.add(new ItemsClass("Basurang Plastik", "Hindi Nabubulok",
                "Mga plastik tulad ng PET bottles, HDPE containers, at PVC packaging.",
                tagproperWasteDisposal,
                "1. Siguraduhing malinis at walang tira-tirang laman bago itapon.\n" +
                        "2. Ang hindi nare-recycle na bahagi ay nagpapahirap sa pagpoproseso.\n"+
                        "3. Sumunod sa tamang patakaran ng recycling upang maging epektibo ito.\n" +
                        "4. Itapon sa tamang recycling bin.\n",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow)));

        wasteListTranslated.add(new ItemsClass("Latang Aluminum", "Hindi Nabubulok",
                "Magagaan, madaling i-recycle na lalagyan para sa inumin at pagkain.",
                tagproperWasteDisposal,
                "1. Hiwalayin ito mula sa plastik at salamin.\n" +
                        "2. Durugin o tupiin ang lata upang makatipid sa espasyo.\n" +
                        "3. Itapon sa tamang recycling bin para sa aluminyo.",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow)));

        wasteListTranslated.add(new ItemsClass("Packaging Boxes", "Recyclable",
                "Mga kahon mula sa karton, corrugated fiberboard, o plastik.",
                tagproperWasteDisposal,
                "1. Tupiin ang mga kahon upang makatipid ng espasyo.\n" +
                        "2. Alisin ang hindi nare-recycle na bagay tulad ng plastik na balot o tape.\n" +
                        "3. Ilagay sa recycling bin ang malinis na packaging boxes.\n" +
                        "4. Ang mga kahong marumi sa pagkain o likido ay hindi na maaaring i-recycle.\n",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteListTranslated.add(new ItemsClass("Basurang Papel", "Recyclable",
                "Mga papel tulad ng diyaryo, magasin, dokumento, at packaging.",
                tagproperWasteDisposal,
                "1. Panatilihing tuyo at malinis ang papel para sa maayos na pag-recycle.\n" +
                        "2. Iwasang itapon ang basang papel sa recycling bin.\n" +
                        "3. Ilagay ang papel sa recycling bin upang muling magamit.\n" +
                        "4. Huwag ihalo ang papel sa plastik o metal upang mapanatili ang kalidad ng recycling.\n",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteListTranslated.add(new ItemsClass("Boteng Plastik", "Recyclable",
                "Mga lalagyan ng tubig, soda, at iba pang likido.",
                tagproperWasteDisposal,
                "1. Banlawan at alisin ang takip at label bago itapon.\n" +
                        "2. Itapon ang malilinis na bote sa recycling bin.\n" +
                        "3. Ang maruming bote na may tira-tirang pagkain ay hindi maaaring i-recycle.\n" +
                        "4. Iwasang durugin ang bote bago itapon upang hindi maapektuhan ang pagpoproseso.\n",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteListTranslated.add(new ItemsClass("Baterya", "E-Waste",
                "Mga gamit na baterya mula sa cellphone, laptop, remote, at iba pa.",
                tagproperWasteDisposal,
                "1. Huwag itapon sa ordinaryong basurahan o recycling bin.\n" +
                        "2. Dalhin sa mga collection site o hazardous waste facility.\n" +
                        "3. Siguraduhing walang karga ang rechargeable batteries bago itapon.\n" +
                        "4. Takpan ang terminal ng baterya ng tape o plastik upang maiwasan ang short circuit.\n",
                R.drawable.icon_ewaste, ContextCompat.getColor(this, R.color.red)));

        wasteListTranslated.add(new ItemsClass("Electronik na Gamit", "E-Waste",
                "Mga gadget tulad ng smartphone, computer, TV, at sensor.",
                tagproperWasteDisposal,
                "1. I-reset ang device upang tanggalin ang personal na data bago itapon.\n" +
                        "2. Alisin nang ligtas ang baterya at iba pang natatanggal na bahagi.\n" +
                        "3. Balutin nang maayos upang hindi masira sa transportasyon.\n" +
                        "4. Dalhin sa SM E-waste collection bins o iba pang accredited E-waste collector.\n" +
                        "5. Huwag itapon sa regular na basurahan o iwanan kung saan lamang.\n",
                R.drawable.icon_ewaste, ContextCompat.getColor(this, R.color.red)));

        ItemsAdapter adapter = new ItemsAdapter(this, wasteList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            ItemsClass selectedItem = (ItemsClass) parent.getItemAtPosition(position);
            int originalIndex = wasteList.indexOf(selectedItem);
            ItemsClass translatedItem = wasteListTranslated.get(originalIndex);
            WasteItemFragment fragment = WasteItemFragment.newInstance(selectedItem, translatedItem);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .addToBackStack(null)
                    .commit();

            findViewById(R.id.knowledgeTitle).setVisibility(View.GONE);
            findViewById(R.id.cardContainer).setVisibility(View.GONE);
            findViewById(R.id.fragmentContainer).setVisibility(View.VISIBLE);
            //findViewById(R.id.segregationTitle).setVisibility(View.GONE);
            //findViewById(R.id.segregationDesc).setVisibility(View.GONE);
        });

        /*listView.setOnItemClickListener((parent, view, position, id) -> {
            ItemsClass selectedItem = (ItemsClass) parent.getItemAtPosition(position);
            ItemsClass translatedItem = wasteListTranslated.get(position);
            WasteItemFragment fragment = WasteItemFragment.newInstance(selectedItem, translatedItem);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .addToBackStack(null)
                    .commit();

            findViewById(R.id.knowledgeTitle).setVisibility(View.GONE);
            findViewById(R.id.cardContainer).setVisibility(View.GONE);
            findViewById(R.id.fragmentContainer).setVisibility(View.VISIBLE);
            findViewById(R.id.segregationTitle).setVisibility(View.GONE);
            findViewById(R.id.segregationDesc).setVisibility(View.GONE);
        });*/

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);

                if (fragment != null) {
                    getSupportFragmentManager().popBackStack();
                    findViewById(R.id.knowledgeTitle).setVisibility(View.VISIBLE);
                    findViewById(R.id.cardContainer).setVisibility(View.VISIBLE);
                    //findViewById(R.id.segregationTitle).setVisibility(View.VISIBLE);
                    //findViewById(R.id.segregationDesc).setVisibility(View.VISIBLE);
                    findViewById(R.id.fragmentContainer).setVisibility(View.GONE);
                } else {
                    setEnabled(false);
                    getOnBackPressedDispatcher().onBackPressed();
                }
            }
        });

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

    /**@Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);

        if (fragment != null) {
            getSupportFragmentManager().popBackStack();
            findViewById(R.id.knowledgeTitle).setVisibility(View.VISIBLE);
            findViewById(R.id.cardContainer).setVisibility(View.VISIBLE);
            findViewById(R.id.fragmentContainer).setVisibility(View.GONE);
        }
    }**/

}
