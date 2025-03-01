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

        wasteList.add(new ItemsClass("Organic Waste", "Biodegradable",
                "Organic waste consists of biodegradable materials such as vegetable and fruit scraps, eggshell, and rotten vegetable and fruit scraps that decompose naturally. As of now, EcoSort is designed to classify only these as organic waste and will not classify other objects.",
                "To Properly Dispose:",
                "1. Gather vegetable peels, fruit peels, eggshells, and similar organic waste in a separate container.\n" +
                        "2. Avoid mixing organic waste with plastics, paper, glass, or other non-biodegradable materials.\n" +
                        "3. Place the organic waste in a biodegradable bag or a green bin labeled for organic waste.\n" +
                        "4. If you have space, use the organic waste to create compost by placing it in a compost bin or pile and adding dry materials like dried leaves.\n" +
                        "5. Do not throw organic waste into canals, rivers, or open areas to prevent pollution and flooding.\n" +
                        "6. Ensure the organic waste is properly stored in covered bins to avoid attracting pests.\n" +
                        "7. Coordinate with your local waste management service to have the organic waste collected on designated days.\n" +
                        "8. If composting is not possible and collection services are unavailable, contact the local government for proper disposal instructions.",
                R.drawable.icon_biodegradable, ContextCompat.getColor(this, R.color.green)));

        /*wasteList.add(new ItemsClass("Food Waste", "Biodegradable",
                "Refers to discarded edible food that is lost at various stages of production, distribution, and consumption, contributing to environmental and economic challenges. It includes uneaten leftovers, spoiled produce, and excess food from farms, stores, and households. Reducing food waste involves better storage, mindful consumption, and sustainable food management practices to minimize resource depletion and greenhouse gas emissions.",
                "To Properly dispose:",
                "1. Separate leftover food from other types of waste such as plastics, bottles, and paper. Leftover food should be disposed of as biodegradable waste.\n" +
                        "2. Place the leftover food in the bin labeled for biodegradable waste. These bins are usually green or marked \"Biodegradable.\"\n" +
                        "3. If space allows, leftover food can be used to create compost, which is beneficial for soil and plants.\n" +
                        "4. Do not throw leftover food into drains or rivers as this can cause flooding and pollution.\n" +
                        "5. Ensure that leftover food waste is collected by the local government or waste collectors on the designated collection days.",
                R.drawable.icon_biodegradable, ContextCompat.getColor(this, R.color.green)));*/

        wasteList.add(new ItemsClass("Environmental Waste", "Biodegradable",
                "Environmental waste includes items like branches, flowers, grass, and leaves. As of now, EcoSort is designed to classify only these as environmental waste and will not classify other objects.",
                "To Properly Dispose:",
                "1. Gather dry leaves, grass clippings, small branches, and similar organic waste.\n" +
                        "2. Avoid mixing with non-biodegradable waste like plastics or metals.\n" +
                        "3. Place in a compost bin or green waste bin if available.\n" +
                        "4. For composting, mix with other organic waste for faster decomposition.\n" +
                        "5. If composting isn’t an option, contact local authorities for disposal.\n" +
                        "6. Do not burn, as it harms health and air quality.\n" +
                        "7. Ensure it's stored in a covered bin to avoid pests.\n" +
                        "8. Confirm collection with local waste management.",
                R.drawable.icon_biodegradable, ContextCompat.getColor(this, R.color.green)));

        wasteList.add(new ItemsClass("Glass Type Waste", "Non-Biodegradable",
                "Glass waste refers to discarded glass materials such as bottles, jars, windows, mirrors, and drinkware. It can be recycled into new glass products, but broken or contaminated glass should be disposed of properly to prevent hazards.",
                "To Properly Dispose:",
                "1. If the glass is unbroken (bottles, jars), rinse and place it in the recycling bin.\n" +
                        "2. For broken glass, wear gloves and carefully collect the shards.\n" +
                        "3. Wrap the broken glass in newspaper or place it inside a sturdy cardboard box.\n" +
                        "4. Label the package as 'Broken Glass' to alert waste collectors.\n" +
                        "5. Dispose of broken glass in the regular trash, not in recycling.\n",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow)));

        wasteList.add(new ItemsClass("Plastic Type Waste", "Non-Biodegradable",
                "Refers to discarded plastic materials that accumulate in the environment, posing significant ecological risks due to their non-biodegradable nature. It includes various types, such as PET (polyethylene terephthalate) used in bottles, HDPE (high-density polyethylene) found in containers, and PVC (polyvinyl chloride) used in pipes and packaging. Managing plastic waste effectively requires recycling, reducing single-use plastics, and adopting sustainable alternatives to mitigate pollution.",
                "To Properly Dispose:",
                "1. Separate plastics by type (e.g., PET, HDPE).\n" +
                        "2. Rinse off food and liquid residues.\n" +
                        "3. Remove non-recyclable parts such as caps and labels.\n" +
                        "4. Check for recycling symbols or instructions.\n" +
                        "5. Place in the designated recycling bin or drop-off center.",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow)));

        wasteList.add(new ItemsClass("Aluminum Cans", "Non-Biodegradable",
                "Aluminum waste consists of discarded aluminum cans, including industrial scrap, consumer products, and manufacturing by-products. It is highly recyclable, making it valuable for both economic and environmental sustainability. ",
                "To Properly Dispose:",
                "1. Keep aluminum can separate from other materials like plastic or glass, remove the label if possible.\n" +
                        "2. If possible, crush the cans or fold the foil to save space.\n" +
                        "3. Then, place the aluminum can in its designated recycling bin.",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow)));

        wasteList.add(new ItemsClass("Packaging Boxes", "Recyclable",
                "Packaging Boxes are containers made from materials like cardboard, corrugated fiberboard, or plastic, designed to store, protect, and transport goods. It serves both functional and branding purposes, ensuring product safety while often featuring custom designs for marketing. Packaging boxes come in various types, including folding cartons, rigid boxes, and corrugated boxes, depending on durability and usage needs.",
                "To Properly Dispose:",
                "1. Flatten packaging boxes to save space.\n" +
                        "2. Remove any non-recyclable items such as plastic liners or tape.\n" +
                        "3. Place the flattened boxes in the appropriate recycling bin.\n" +
                        "4. If the box is contaminated with food or liquid, dispose of it in the non-recyclable waste bin.\n" +
                        "5. Avoid mixing packaging boxes with non-recyclable materials.",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteList.add(new ItemsClass("Paper Type Waste", "Recyclable",
                "Refers to discarded paper materials that are no longer useful, including newspapers, magazines, office documents, cardboard, and packaging. It is one of the most recyclable waste types and can be repurposed into new paper products to reduce environmental impact. Proper paper waste management involves recycling, reducing paper usage, and opting for digital alternatives to minimize deforestation and waste accumulation.",
                "To Properly Dispose:",
                "1. Separate paper waste from other trash.\n" +
                        "2. Flatten any paper items like boxes or cardboard.\n" +
                        "3. Remove any food or liquid-soaked paper and dispose of it in the non-recyclable waste bin.\n" +
                        "4. Place the clean, dry paper in the recycling bin.\n" +
                        "5. Avoid mixing paper with plastic or metal materials.",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteList.add(new ItemsClass("Plastic Bottle", "Recyclable",
                "Is a lightweight, durable container made primarily from polymers like PET (polyethylene terephthalate) or HDPE (high-density polyethylene), commonly used for storing liquids such as water, soda, and household products. These bottles are widely produced due to their cost-effectiveness and versatility but contribute significantly to plastic waste and pollution. Recycling and reusing plastic bottles help reduce environmental impact and promote sustainable waste management.",
                "To Properly Dispose:",
                "1. Empty the plastic bottle and rinse it if necessary.\n" +
                        "2. Remove any caps or labels.\n" +
                        "3. Place the plastic bottle in the recycling bin.\n" +
                        "4. If the bottle is contaminated with food or hazardous liquids, dispose of it in the non-recyclable waste bin.\n" +
                        "5. Avoid crushing plastic bottles before recycling, as it can affect the recycling process.",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteList.add(new ItemsClass("Batteries", "E-Waste",
                "Are devices that stores and converts chemical energy into electrical energy to power electronic devices and machinery. It consists of one or more electrochemical cells with positive (cathode) and negative (anode) terminals, allowing the flow of electric current. Batteries come in various types, including rechargeable (e.g., lithium-ion) and non-rechargeable (e.g., alkaline), playing a crucial role in modern technology and energy storage.",
                "To Properly Dispose:",
                "1. Do not place them in household trash or curbside recycling bins.\n" +
                        "2. Take them to battery collection sites or household hazardous waste collection facilities.\n" +
                        "3. Identify the type of battery (rechargeable or single use).\n" +
                        "4. Discharge rechargeable batteries completely before disposal.\n" +
                        "5. Cover battery terminals with electrical tape or plastic caps.\n" +
                        "6. Store batteries in a cool, dry place away from heat sources and sunlight.\n" +
                        "7. Keep them separate from other waste and batteries.\n",
                R.drawable.icon_ewaste, ContextCompat.getColor(this, R.color.red)));

        wasteList.add(new ItemsClass("Electronic Devices", "E-Waste",
                "Are gadgets that operate using electrical circuits to process, transmit, or store information. These devices include smartphones, computers, televisions, and sensors, which rely on semiconductor components like transistors and integrated circuits. They play a crucial role in modern communication, entertainment, healthcare, and industrial automation.",
                "To Properly Dispose:",
                "1. Reset the device to remove all personal data.\n" +
                        "2. Safely remove any batteries and other detachable components.\n" +
                        "3. Pack the device securely to avoid damage during transport.\n" +
                        "4. Bring the device to SM E-waste collection bins or any other e-waste disposal collector.\n" +
                        "5. If SM is not available, there are others like E-waste Management Philippines, E-waste Project UP or look for any accredited E-waste recycler or inquire with your LGU about collection points.\n" +
                        "6. Avoid disposing of the device in regular trash bins or dumping it in open areas.",
                R.drawable.icon_ewaste, ContextCompat.getColor(this, R.color.red)));

        /*wasteList.add(new ItemsClass("Home Appliance", "E-Waste",
                "Refers to a household device designed to perform specific tasks that improve comfort, convenience, and efficiency in daily life. These appliances include cooking devices (like ovens and microwaves), cleaning equipment (such as washing machines and vacuums), and other tools (like refrigerators and air conditioners) that utilize electricity or gas to operate. Home appliances are essential in modern homes for simplifying routine chores and maintaining a ",
                "To Properly Dispose:",
                "1. Unplug the appliance and clean it thoroughly.\n" +
                        "2. Safely remove any hazardous parts, such as batteries or fluids, if applicable.\n" +
                        "3. Separate any recyclable components, like metal or plastic parts, if possible.\n" +
                        "4. Transport the appliance to SM collection bins for E-waste or accredited recycling centers. \n" +
                        "5. If SM is unavailable, coordinate with your LGU for proper disposal services.\n" +
                        "6. Do not burn, bury, or dispose of appliances in landfills.\n" +
                        "7. You can trade them, put for sale or either scrap them for additional money.",
                R.drawable.icon_ewaste, ContextCompat.getColor(this, R.color.red)));*/

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

        /*wasteListTranslated.add(new ItemsClass("Food Waste", "Nabubulok",
                "Kasama sa mga basura sa kapaligiran ang mga bagay tulad ng mga sanga, bulaklak, damo, at dahon. Sa ngayon, ang EcoSort ay idinisenyo upang uriin lamang ang mga ito bilang mga basura sa kapaligiran at hindi mag-uuri ng iba pang mga bagay.",
                "Para sa tamang pagtatapon:",
                "1. Ihiwalay ang mga tira-tirang pagkain sa ibang uri ng basura tulad ng plastik, bote, at papel. Ang mga tirang pagkain ay itapon bilang nabubulok o biodegradable.\n" +
                        "2. Ilagay ang mga tirang pagkain sa lalagyan na para sa mga nabubulok. Karaniwan itong kulay berde o nakalabel na \"Biodegradable.\"\n" +
                        "3. Kung may bakuran, maaari ring gamitin ang mga tirang pagkain para sa paggawa ng kompost na makakatulong sa lupa at mga halaman.\n" +
                        "4. Huwag itapon ang mga tirang pagkain sa kanal o ilog dahil maaaring magdulot ito ng pagbaha at polusyon.\n" +
                        "5. Siguraduhing ang mga tira-tirang pagkain ay kukunin ng lokal na pamahalaan o tagapag-kolekta ng basura sa tamang araw ng koleksyon.",
                R.drawable.icon_biodegradable, ContextCompat.getColor(this, R.color.green)));*/

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

        /*wasteListTranslated.add(new ItemsClass("Home Appliance", "E-Waste",
                "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.",
                "Para sa tamang pagtatapon:",
                "I-unplug ang appliance at linisin itong mabuti.\n" +
                        "Tanggalin nang maayos ang mga mapanganib na bahagi tulad ng baterya o likido, kung mayroon.\n" +
                        "Paghiwalayin ang mga recyclable na bahagi tulad ng metal o plastik kung posible.\n" +
                        "Dalhin ang appliance sa SM collection bins para sa E-waste o sa mga accredited recycling centers.\n" +
                        "Kung walang SM, makipag-ugnayan sa LGU para sa tamang disposal services.\n" +
                        "Huwag sunugin, ibaon, o itapon ang appliance sa mga landfill.\n" +
                        "Puwede mo itong ipangpalit sa iba, ibenta, o ibenta ang mga bahagi para sa dagdag pera.",
                R.drawable.icon_ewaste, ContextCompat.getColor(this, R.color.red)));*/

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
