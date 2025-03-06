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
                        "2. Composting works best with dried \u2003leaves.\n" +
                        "3. Uncovered waste attracts pests.\n" +
                        "4. Dumping in canals causes pollution.\n",
                R.drawable.icon_biodegradable, ContextCompat.getColor(this, R.color.green), R.drawable.sample_organic));

        wasteList.add(new ItemsClass("Environmental Waste", "Biodegradable",
                "Environmental waste includes branches, flowers, grass, and leaves.",
                properWasteDisposal,
                "1. Dispose in a green bin or compost\n" +
                        "2. Mixing organic waste enhances \u2003composting and speeds up \u2003decomposition.\n" +
                        "3. Burning waste releases pollutants that \u2003harm air quality.\n" +
                        "4. Keeping waste covered helps prevent \u2003pests and maintain cleanliness.\n",
                R.drawable.icon_biodegradable, ContextCompat.getColor(this, R.color.green), R.drawable.sample_environmental));

        wasteList.add(new ItemsClass("Glass Type Waste", "Non-Biodegradable",
                "Glass waste includes discarded bottles, jars, windows, mirrors, and drinkware. It can be recycled, but broken or contaminated glass requires proper disposal to prevent hazards.",
                properWasteDisposal,
                "1. Recyclable glass, such as bottles and \u2003jars, belongs in the recycling bin.\n" +
                        "2. Wrapping broken glass securely helps \u2003prevent injuries\n" +
                        "3. Labeling as 'Broken Glass' ensures safe \u2003handling.\n" +
                        "4. Disposing of broken glass in the \u2003non-biodegradable bin keeps waste \u2003properly sorted.\n",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow), R.drawable.sample_glasstype));

        wasteList.add(new ItemsClass("Plastic Type Waste", "Non-Biodegradable",
                "Plastic waste consists of discarded non-biodegradable materials like PET bottles, HDPE containers, and PVC packaging. Proper management helps reduce pollution.",
                properWasteDisposal,
                "1. Leftover residues can impact the \u2003recyclability of materials.\n" +
                        "2. Non-recyclable parts make processing \u2003less efficient.\n" +
                        "3. Recycling works best when guidelines \u2003are followed.\n" +
                        "4. Proper disposal in designated \u2003recycling bins ensures effective waste \u2003management.\n",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow), R.drawable.sample_plastictype));

        wasteList.add(new ItemsClass("Aluminum Cans", "Non-Biodegradable",
                "Lightweight, recyclable containers used for packaging drinks and food, made from corrosion-resistant aluminum.",
                properWasteDisposal,
                "1. Aluminum cans are best kept separate \u2003from plastic or glass, and labels can be \u2003removed if possible.\n" +
                        "2. Crushing cans or folding foil helps save \u2003space during disposal.\n" +
                        "3. Placing aluminum cans in their \u2003designated recycling bin ensures proper \u2003recycling.",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow), R.drawable.sample_aluminumcans));

        wasteList.add(new ItemsClass("Packaging Boxes", "Recyclable",
                "Containers made of cardboard, corrugated fiberboard, or plastic, used for storing, protecting, and transporting goods.",
                properWasteDisposal,
                "1. Flattening packaging boxes helps save \u2003space for disposal.\n" +
                        "2. Non-recyclable items like plastic liners or \u2003tape should be removed.\n" +
                        "3. Recycling bins are the best place for \u2003flattened, clean packaging boxes.\n" +
                        "4. Boxes contaminated with food or liquid \u2003belong in non-recyclable waste.\n" +
                        "5. Keeping packaging boxes separate from \u2003non-recyclable materials ensures proper \u2003recycling.",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen), R.drawable.sample_packagingboxes));

        wasteList.add(new ItemsClass("Paper Type Waste", "Recyclable",
                "Discarded paper materials such as newspapers, magazines, office documents, cardboard, and packaging. Highly recyclable, it can be repurposed into new paper products to reduce waste and environmental impact.",
                properWasteDisposal,
                "1. Keeping the paper waste clean and dry to \u2003ensure proper recycling.\n" +
                        "2. Wet paper waste must not dispose \u2003in recycling bin.\n" +
                        "3. Dispose the paper waste in recycling bin \u2003 to be repurpose.\n" +
                        "4. Mixing paper with other waste must be avoid \u2003to maintain recycling efficiency.\n",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen), R.drawable.sample_papertype));

        wasteList.add(new ItemsClass("Plastic Bottles", "Recyclable",
                " Lightweight, durable containers made from polymers like PET or HDPE, commonly used for storing liquids such as water, soda, and household products. While cost-effective and versatile, they contribute to plastic waste and pollution. Recycling and reusing plastic bottles help minimize environmental impact.",
                properWasteDisposal,
                "1. Emptying and rinsing plastic bottles \u2003helps maintain recycling quality.\n" +
                        "2. Caps and labels should be removed \u2003before disposal.\n" +
                        "3. Clean plastic bottles belong in the \u2003recycling bin.\n" +
                        "4. Contaminated bottles with food \u2003or hazardous liquids should go in \u2003non-recyclable waste.\n" +
                        "5. Avoid crushing bottles before recycling, \u2003as it may affect processing efficiency.",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen),R.drawable.sample_plasticbottles));

        wasteList.add(new ItemsClass("Batteries", "E-Waste",
                "Devices that store and convert chemical energy into electrical energy to power electronics and machinery. They consist of electrochemical cells with positive (cathode) and negative (anode) terminals, allowing electric current flow. Batteries come in rechargeable (e.g., lithium-ion) and non-rechargeable (e.g., alkaline) types, playing a key role in energy storage and modern technology.",
                properWasteDisposal,
                "1. Household trash bin or recycling \u2003bins are not suitable for battery disposal.\n" +
                        "2. Battery collection sites or hazardous \u2003waste facilities ensure safe disposal.\n" +
                        "3. Identifying the battery type helps \u2003determine proper recycling methods\n" +
                        "4. Fully discharging rechargeable batteries \u2003before disposal enhances safety.\n" +
                        "5. Covering battery terminals with tape or \u2003plastic caps prevents short circuits.\n" +
                        "6. Storing batteries in a cool, dry place \u2003keeps them safe from heat exposure.\n" +
                        "7. Keeping batteries separate from other \u2003waste improves recycling efficiency.\n",
                R.drawable.icon_ewaste, ContextCompat.getColor(this, R.color.red), R.drawable.sample_batteries));

        wasteList.add(new ItemsClass("Electronic Devices", "E-Waste",
                "Gadgets that use electrical circuits to process, transmit, or store information. These include smartphones, computers, televisions, and sensors, which rely on semiconductor components like transistors and integrated circuits. They are essential in communication, entertainment, healthcare, and industrial automation.",
                properWasteDisposal,
                "1. Resetting devices helps remove personal \u2003data before disposal.\n" +
                        "2. Detachable components, like batteries, \u2003should be removed safely.\n" +
                        "3. Secure packaging prevents damage \u2003during transport.\n" +
                        "4. SM E-waste collection bins and other \u2003disposal sites accept electronic waste.\n" +
                        "5. E-waste recyclers like E-waste \u2003Management Philippines and E-waste \u2003Project UP provide disposal options.\n" +
                        "6. Regular trash bins and open dumping \u2003are not suitable for electronic waste \u2003disposal.",
                R.drawable.icon_ewaste, ContextCompat.getColor(this, R.color.red), R.drawable.sample_electronicdevices));

        //Tagalog//
        wasteListTranslated.add(new ItemsClass("Organik na Basura", "Nabubulok",
                "Mga nabubulok na bagay tulad ng balat ng gulay at prutas, balat ng itlog, at mga sirang pagkain.",
                tagproperWasteDisposal,
                "1. Itapon sa berdeng basurahan \u2003bin.\n" +
                        "2. Ang paghalo ng tuyong dahon ay \u2003nakakatulong sa pag-compost.\n" +
                        "3. Iwasang iwanang bukas ang basurahan \u2003upang hindi pamahayan ng mga peste.\n" +
                        "4. Ang pagtatapon sa kanal ay nagdudulot \u2003ng polusyon.\n",
                R.drawable.icon_biodegradable, ContextCompat.getColor(this, R.color.green), R.drawable.sample_organic));

        wasteListTranslated.add(new ItemsClass("Environmental Waste", "Nabubulok",
                "Mga basura mula sa halaman tulad ng sanga, bulaklak, damo, at dahon.",
                tagproperWasteDisposal,
                "1. Itapon sa berdeng basurahan \u2003bin.\n" +
                        "2. Paghahalo ng organik na basura ay \u2003nakakatulong sa mabilisang pagkabulok.\n" +
                        "3. Ang pagsusunog ng basura ay \u2003naglalabas ng nakakasamang polusyon \u2003sa hangin.\n" +
                        "4. Panatiliing nakasara o may takip \u2003ang basurahan upang hindi\u2003pamahayan ng mga peste.\n",
                R.drawable.icon_biodegradable, ContextCompat.getColor(this, R.color.green), R.drawable.sample_environmental));

        wasteListTranslated.add(new ItemsClass("Basurang Salamin", "Hindi Nabubulok",
                "Mga basurang babasagin katulad ng bote, garapon, bintana, salamin, at baso. Ito ay maaaring irecycle subalit ang basag at may likidong nakakapahamak ay kailangan ng tamang pagtatapon upang maiwasan ang sakuna.",
                tagproperWasteDisposal,
                "1. Ang mga boteng baso at garapon ay \u2003dapat ilagay sa recycling bin.\n" +
                        "2. Balutin nang maayos ang basag na \u2003salamin upang maiwasan ang sakuna.\n" +
                        "3. Lagyan ng label na “Basag na Salamin” \u2003upang mapanatili ang kaligtasan.\n" +
                        "4. Itapon ang basag na salamin sa hindi\u2003 nabubulok na basurahan.\n",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow), R.drawable.sample_glasstype));

        wasteListTranslated.add(new ItemsClass("Basurang Plastik", "Hindi Nabubulok",
                "Mga plastik tulad ng PET bottles, HDPE containers, at PVC packaging.",
                tagproperWasteDisposal,
                "1. Siguraduhing malinis at walang tira-tirang \u2003laman bago itapon.\n" +
                        "2. Ang hindi nare-recycle na bahagi ay \u2003nagpapahirap sa pagpoproseso.\n"+
                        "3. Sumunod sa tamang patakaran ng \u2003recycling upang maging epektibo ito.\n" +
                        "4. Itapon sa tamang recycling bin.\n",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow), R.drawable.sample_plastictype));

        wasteListTranslated.add(new ItemsClass("Latang Aluminum", "Hindi Nabubulok",
                "Magagaan, madaling i-recycle na lalagyan para sa inumin at pagkain na gawa sa aluminum.",
                tagproperWasteDisposal,
                "1. Hiwalayin ito mula sa ibang basura at tangalin ang label nito kung maaari.\n" +
                        "2. Durugin o tupiin ang lata upang \u2003makatipid sa espasyo.\n" +
                        "3. Itapon sa tamang recycling bin.",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow), R.drawable.sample_aluminumcans));

        wasteListTranslated.add(new ItemsClass("Packaging Boxes", "Recyclable",
                "Mga kahon mula sa karton, corrugated fiberboard, o plastik na ginagamit sa pagbabalot ng bagay.",
                tagproperWasteDisposal,
                "1. Tupiin ang mga kahon upang makatipid \u2003ng espasyo.\n" +
                        "2. Alisin ang hindi nare-recycle na bagay \u2003tulad ng plastik na balot o tape.\n" +
                        "3. Ilagay sa recycling bin ang malinis at nakatuping \u2003packaging boxes.\n" +
                        "4. Ang mga kahong marumi na may pagkain o \u2003likido ay hindi na maaaring i-recycle.\n" +
                        "5. Panatilihing nakahiwalay ang packaging boxes sa ibang uri ng basura para sa tamang pagrerecycle.",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen), R.drawable.sample_packagingboxes));

        wasteListTranslated.add(new ItemsClass("Basurang Papel", "Recyclable",
                "Mga papel tulad ng diyaryo, magasin, dokumento, at packaging. Ito ay maaaring marecycle at gamitin muli bilang papel upang mabawasan ang basura at impact nito sa kapaligiran.",
                tagproperWasteDisposal,
                "1. Panatilihing tuyo at malinis ang papel para \u2003sa maayos na pag-recycle.\n" +
                        "2. Iwasang itapon ang basang papel sa \u2003recycling bin.\n" +
                        "3. Ilagay ang papel sa recycling bin upang \u2003muling magamit.\n" +
                        "4. Huwag ihalo ang papel sa plastik o \u2003metal upang mapanatili ang kalidad ng \u2003recycling.\n",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen), R.drawable.sample_papertype));

        wasteListTranslated.add(new ItemsClass("Boteng Plastik", "Recyclable",
                "Mga lalagyan ng tubig, soda, at iba pang likido na gawa sa polymers like PET o HDPE. Ito ay isa sa mga sanhi sa waste pollution.",
                tagproperWasteDisposal,
                "1. Banlawan at alisin ang laman bago \u2003itapon upang ito ay mai-recycle.\n" +
                        "2. Tangalin ang takip at label \u2003bago itapon sa recycling bin.\n" +
                        "3. Ang malinis na bote ay dapat itapon \u2003sa recling bin.\n" +
                        "4. Ang maruming bote na may tira-tirang \u2003pagkain ay hindi maaaring i-recycle.\n" +
                        "5. Iwasang durugin ang bote bago \u2003itapon upang hindi maapektuhan ang \u2003pagpoproseso.\n",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen), R.drawable.sample_plasticbottles));

        wasteListTranslated.add(new ItemsClass("Baterya", "E-Waste",
                "Mga gamit na baterya mula sa cellphone, laptop, remote, at iba pa.",
                tagproperWasteDisposal,
                "1. Huwag itapon sa ordinaryong basurahan \u2003o recycling bin are baterya.\n" +
                        "2. Dalhin sa mga collection site o hazardous \u2003waste facility para masigurado ang kaligtasan.\n" +
                        "3. Tignan kung anong uri ng \u2003baterya upang malaman kung pano ito itapon.\n" +
                        "4. Siguraduhing walang karga ang \u2003 baterya bago itapon.\n" +
                        "5. Takpan ang terminal ng baterya ng tape \u2003o plastik upang maiwasan ang short \u2003circuit.\n" +
                        "6. Itago sa malamig at tuyong lugar \u2003upang hindi sila maexpose sa init.\n" +
                        "7. Panatilihing nakahiwalay ang baterya sa \u2003iba pang mga basura.\n",
                R.drawable.icon_ewaste, ContextCompat.getColor(this, R.color.red), R.drawable.sample_batteries));

        wasteListTranslated.add(new ItemsClass("Electronik na Gamit", "E-Waste",
                "Mga gadget tulad ng smartphone, computer, TV, at sensor na gumagamit ng electrical circuits para gumana, magbigay o mag-imbak ng impormasyon.",
                tagproperWasteDisposal,
                "1. I-reset ang device upang mawala ang mga\u2003personal na data bago itapon.\n" +
                        "2. Alisin nang ligtas ang baterya at iba pang \u2003natatanggal na bahagi.\n" +
                        "3. Balutin nang maayos upang hindi masira \u2003sa transportasyon.\n" +
                        "4. Dalhin sa SM E-waste collection bins o \u2003iba pang accredited E-waste collector.\n" +
                        "5. Huwag itapon sa regular na basurahan o \u2003iwanan kung saan lamang ang basurang ito.\n",
                R.drawable.icon_ewaste, ContextCompat.getColor(this, R.color.red), R.drawable.sample_electronicdevices));

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
