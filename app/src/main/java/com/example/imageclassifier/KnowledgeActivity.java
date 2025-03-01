package com.example.imageclassifier;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
                "Ang mga organik na basura ay binubuo ng mga nabubulok na materyales tulad ng mga tirang gulay at prutas, balat ng itlog, at mga bulok na gulay at prutas na natural na nabubulok. Sa ngayon, ang EcoSort ay idinisenyo upang tukuyin lamang ang mga ito bilang mga organikong basura at hindi tutukoy pa ng iba pang mga bagay.",
                "Para sa tamang pagtatapon:",
                "1. Ipunin ang balat ng gulay, balat ng prutas, balat ng itlog, at iba pang katulad na nabubulok na basura sa hiwalay na lalagyan.\n" +
                        "2. Iwasang paghaluin ang nabubulok na basura sa plastik, papel, bote, o iba pang hindi nabubulok na materyales.\n" +
                        "3. Ilagay ang mga nabubulok na basura sa biodegradable na supot o sa berde na basurahan na may label na para sa nabubulok.\n" +
                        "4. Kung may espasyo, gamitin ang mga nabubulok na basura para makagawa ng kompost sa pamamagitan ng paglalagay nito sa compost bin o compost pile at pagdagdag ng tuyong dahon.\n" +
                        "5. Huwag itapon ang mga nabubulok na basura sa kanal, ilog, o bakanteng lugar upang maiwasan ang polusyon at pagbaha.\n" +
                        "6. Siguraduhing maayos ang imbakan ng nabubulok na basura sa mga nakatakip na lalagyan upang hindi makaakit ng peste.\n" +
                        "7. Makipag-ugnayan sa lokal na serbisyo ng pamamahala ng basura upang makolekta ang mga nabubulok na basura sa tamang araw ng koleksyon.\n" +
                        "8. Kung hindi posible ang pag-kompost at walang koleksyon ng basura, humingi ng payo sa lokal na pamahalaan para sa tamang pagtapon ng basura.",
                R.drawable.icon_biodegradable, ContextCompat.getColor(this, R.color.green)));

        wasteListTranslated.add(new ItemsClass("Environmental Waste", "Nabubulok",
                "Kasama sa mga basura sa kapaligiran ang mga bagay tulad ng mga sanga, bulaklak, damo, at dahon. Sa ngayon, ang EcoSort ay idinisenyo upang uriin lamang ang mga ito bilang mga basura sa kapaligiran at hindi mag-uuri ng iba pang mga bagay.",
                "Para sa tamang pagtatapon:",
                "1. Ipunin ang mga tuyong dahon, damo, maliit na sanga, at katulad na nabubulok na basura sa isang lalagyan.\n" +
                        "2. Iwasang paghaluin ito sa hindi nabubulok na basura tulad ng plastik o metal.\n" +
                        "3. Ilagay sa compost bin o green waste bin kung mayroon.\n" +
                        "4. Kung magko-kompost, ihalo ang mga ito sa ibang nabubulok na basura para mapabilis ang pagkabulok.\n" +
                        "5. Kung walang composting, makipag-ugnayan sa lokal na pamahalaan para sa tamang pagtapon.\n" +
                        "6. Huwag sunugin ang mga ito dahil nakakasama sa kalusugan at sa hangin.\n" +
                        "7. Siguraduhing nakatago sa basurahan upang hindi makaakit ng peste.\n" +
                        "8. I-verify ang koleksyon mula sa lokal na pamamahala ng basura.",
                R.drawable.icon_biodegradable, ContextCompat.getColor(this, R.color.green)));

        wasteListTranslated.add(new ItemsClass("Basurang Salamin", "Hindi Nabubulok",
                "Ang basurang salamin ay tumutukoy sa mga itinapon na materyales na salamin tulad ng mga bote, garapon, bintana, salamin, at inumin. Maaari itong i-recycle sa mga bagong produktong salamin, ngunit ang basag o kontaminadong salamin ay dapat na itapon nang maayos upang maiwasan ang mga panganib.",
                "Para sa tamang pagtatapon:",
                "1. Kung buo pa ang salamin (bote, garapon), hugasan at ilagay sa recycling bin.\n" +
                        "2. Kung basag ang salamin, magsuot ng guwantes at maingat na tipunin ang mga piraso.\n" +
                        "3. Balutin ang basag na salamin sa diyaryo o ilagay sa matibay na kahon.\n" +
                        "4. Lagyan ng label na 'Basag na Salamin' upang malaman ng mga tagakolekta ng basura.\n" +
                        "5. Itapon ang basag na salamin sa regular na basura, hindi sa recycling bin.\n",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow)));


        wasteListTranslated.add(new ItemsClass("Basurang Plastik", "Hindi Nabubulok",
                "Tumutukoy ito sa mga itinatapong plastik na naiipon sa kapaligiran at nagdudulot ng matinding panganib dahil hindi ito madaling nabubulok. Kasama rito ang iba’t ibang uri ng plastik gaya ng PET na ginagamit sa bote, HDPE na makikita sa mga lalagyan, at PVC na karaniwang ginagamit sa tubo at balot ng produkto. Para mabawasan ang polusyon mula sa plastik, kailangang pagtuunan ng pansin ang pag-recycle, pagbawas sa paggamit ng single-use plastics, at paghahanap ng mas eco-friendly na alternatibo.",
                "Para sa tamang pagtatapon:",
                "1. Ihiwalay ang mga plastik ayon sa uri (hal. PET, HDPE).\n" +
                        "2. Banlawan ang mga tira-tirang pagkain at likido.\n"+
                        "3. Alisin ang mga hindi pwedeng i-recycle tulad ng takip at label.\n" +
                        "4. Suriin ang mga simbolo ng pag-recycle o mga tagubilin.\n" +
                        "5. Ilagay sa tamang basurahan o lugar ng pag-iipon ng mga recyclable.",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow)));

        wasteListTranslated.add(new ItemsClass("Latang Aluminum", "Hindi Nabubulok",
                "Ito ay tumutukoy sa mga latang aluminum, kabilang ang industrial scrap, mga produktong consumer, at mga by-product mula sa pagmamanupaktura. Madali itong i-recycle, kaya’t mahalaga ito hindi lang sa ekonomiya kundi pati na rin sa pangangalaga ng kalikasan. ",
                "Para sa tamang pagtatapon:",
                "1. Ihiwalay ang basura na lata mula sa iba pang mga materyales tulad ng plastik o salamin, alisin ang label kung maaari. \n" +
                        "2. Kung maaari, durugin ang lata upang makatipid sa espasyo. \n" +
                        "3. Pagkatapos, ilagay ang latang aluminum sa recycling bin. ",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow)));

        wasteListTranslated.add(new ItemsClass("Packaging Boxes", "Recyclable",
                "Ito ay lalagyan na gawa sa mga materyales tulad ng karton, corrugated fiberboard, o plastik, na ginagamit para paglagyan ng mga produkto. Bukod sa pagiging praktikal, nagsisilbi rin ito bilang bahagi ng branding dahil madalas itong may custom na disenyo para sa marketing. May iba’t ibang uri ng packaging boxes, tulad ng folding cartons, rigid boxes, at corrugated boxes, depende sa tibay at gamit na kinakailangan.",
                "Para sa tamang pagtatapon:",
                "1. Tupiin ang mga kahon ng packaging para magtipid sa espasyo.\n" +
                        "2. Alisin ang mga hindi maaaring i-recycle tulad ng plastik o tape.\n" +
                        "3. Ilagay ang mga patag na kahon sa tamang recycling bin.\n" +
                        "4. Kung marumi ang kahon ng packaging, ilagay ito sa basurahan ng hindi nabubulok.\n" +
                        "5. Iwasang ihalo ang mga packaging boxes sa ibang hindi nabubulok na materyales.",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteListTranslated.add(new ItemsClass("Basurang Papel", "Recyclable",
                "Tumutukoy sa mga itinapon na papel o mga bagay na gawa sa papel na hindi na kapaki-pakinabang, kabilang ang mga pahayagan, magasin, dokumento sa opisina, karton, at packaging. Ito ay isa sa mga pinaka-nare-recycle na uri ng basura at maaaring gawing bagong mga produktong papel upang mabawasan ang epekto sa kapaligiran.",
                "Para sa tamang pagtatapon:",
                "1. Ihiwalay ang mga papel sa ibang basura.\n" +
                        "2. Patalasin ang mga kahon o karton na papel.\n" +
                        "3. Alisin ang mga papel na basang dahil sa pagkain o likido at itapon ito sa basurahan ng hindi nabubulok.\n" +
                        "4. Ilagay ang malinis at tuyong papel sa recycling bin.\n" +
                        "5. Iwasang ihalo ang papel sa plastik o metal.",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteListTranslated.add(new ItemsClass("Boteng Plastik", "Recyclable",
                "Ito ay isang magaan, matibay na lalagyan na pangunahing ginawa mula sa mga polymer tulad ng PET (polyethylene terephthalate) o HDPE (high-density polyethylene), na karaniwang ginagamit para sa pag-iimbak ng mga likido gaya ng tubig, soda, at mga produktong pambahay. Ang mga bote na ito ay malawakang ginawa dahil sa kanilang pagiging epektibo sa gastos at kakayahang magamit ngunit malaki ang kontribusyon sa mga basurang plastik at polusyon. Ang pag-recycle at muling paggamit ng mga plastik na bote ay nakakatulong na mabawasan ang epekto sa kapaligiran.",
                "Para sa tamang pagtatapon:",
                "1. Alisin ang laman ng plastik na bote at banlawan kung kinakailangan.\n" +
                        "2. Alisin ang takip at label ng bote.\n" +
                        "3. Ilagay ang plastik na bote sa tamang recycling bin.\n" +
                        "4. Kung kontaminado ang bote ng pagkain o mapanganib na likido, itapon ito sa basurahan ng hindi nabubulok.\n" +
                        "5. Iwasang durugin ang plastik na bote bago itapon sa recycling bin, dahil maaari nitong maka-apekto ang proseso ng pag-recycle.",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteListTranslated.add(new ItemsClass("Baterya", "E-Waste",
                "Gamit na nag-iimbak at nagko-convert ng kemikal na enerhiya sa elektrikal na enerhiya upang mapagana ang mga elektronikong kagamitan at makinarya. Binubuo ito ng isa o higit pang mga electrochemical cell na may mga terminal na positibo (cathode) at negatibo (anode), na nagpapahintulot sa daloy ng electric current. Ang mga baterya ay may iba't ibang uri, kabilang ang rechargeable (hal., lithium-ion) at hindi rechargeable (hal., alkaline)",
                "Para sa tamang pagtatapon:",
                "1. Huwag itapon ang mga ito sa basurahan ng bahay o sa mga basurahan para sa pagre-recycle sa gilid ng daan.\n" +
                        "2. Dalhin ang mga ito sa mga lugar na tumatanggap ng baterya o sa mga pasilidad na tumatanggap ng mga mapanganib na basura sa bahay.\n" +
                        "3. Tukuyin kung anong uri ng baterya (rechargeable o single-use).\n" +
                        "4. Ganap na i-discharge ang mga rechargeable na baterya bago itapon.\n" +
                        "5. Takpan ang mga terminal ng baterya ng electrical tape o plastik na takip.\n" +
                        "6. Itabi ang mga baterya sa malamig, tuyong lugar, malayo sa init at sikat ng araw.\n" +
                        "7. Panatilihin silang hiwalay sa iba pang basura at mga baterya.",
                R.drawable.icon_ewaste, ContextCompat.getColor(this, R.color.red)));

        wasteListTranslated.add(new ItemsClass("Electronik na Gamit", "E-Waste",
                "Ang mga gadget na gumagana gamit ang mga de-koryenteng circuit upang magproseso, magpadala, o mag-imbak ng impormasyon. Kasama sa mga device na ito ang mga smartphone, computer, telebisyon, at sensor, na umaasa sa mga bahagi ng semiconductor tulad ng mga transistor at integrated circuit. Mahalaga ang papel nila sa modernong komunikasyon, kasiyahan, pangangalaga sa kalusugan, at pagpapabilis ng trabaho.",
                "Para sa tamang pagtatapon:",
                "1. I-reset ang device para mabura ang lahat ng personal na data.\n" +
                        "2. Tanggalin nang maayos ang mga baterya at iba pang naaalis na bahagi.\n" +
                        "3. Ibalot nang maayos ang device upang maiwasan ang pagkasira habang dinadala.\n" +
                        "4. Dalhin ang device sa E-waste collection bins ng SM.\n" +
                        "5. Kung walang SM, maghanap ng accredited E-waste recycler o magtanong sa LGU tungkol sa collection points.\n" +
                        "6. Iwasang itapon ang device sa karaniwang basurahan o sa mga bukas na lugar.",
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
            findViewById(R.id.segregationTitle).setVisibility(View.GONE);
            findViewById(R.id.segregationDesc).setVisibility(View.GONE);
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
                    findViewById(R.id.segregationTitle).setVisibility(View.VISIBLE);
                    findViewById(R.id.segregationDesc).setVisibility(View.VISIBLE);
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
