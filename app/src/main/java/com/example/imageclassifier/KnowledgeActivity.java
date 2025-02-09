package com.example.imageclassifier;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        wasteList.add(new ItemsClass("Organic Waste", "Biodegradable",
                "Refers to biodegradable materials that naturally decompose, such as food scraps, yard trimmings, and other plant-based materials. When these materials end up in landfills, they often cannot break down properly due to poor ventilation, temperature, and humidity, which can lead to the production of harmful gases like methane. Proper disposal or composting of organic waste helps recycle nutrients back into the environment and reduces environmental impact. ",
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

        wasteList.add(new ItemsClass("Food Waste", "Biodegradable",
                "Refers to discarded edible food that is lost at various stages of production, distribution, and consumption, contributing to environmental and economic challenges. It includes uneaten leftovers, spoiled produce, and excess food from farms, stores, and households. Reducing food waste involves better storage, mindful consumption, and sustainable food management practices to minimize resource depletion and greenhouse gas emissions.",
                "To Properly dispose:",
                "1. Separate leftover food from other types of waste such as plastics, bottles, and paper. Leftover food should be disposed of as biodegradable waste.\n" +
                        "2. Place the leftover food in the bin labeled for biodegradable waste. These bins are usually green or marked \"Biodegradable.\"\n" +
                        "3. If space allows, leftover food can be used to create compost, which is beneficial for soil and plants.\n" +
                        "4. Do not throw leftover food into drains or rivers as this can cause flooding and pollution.\n" +
                        "5. Ensure that leftover food waste is collected by the local government or waste collectors on the designated collection days.",
                R.drawable.icon_biodegradable, ContextCompat.getColor(this, R.color.green)));

        wasteList.add(new ItemsClass("Environmental Waste", "Biodegradable",
                "Refers to any waste material that negatively impacts the environment, including hazardous, industrial, chemical, and non-biodegradable waste. It encompasses pollutants from manufacturing, construction, and everyday human activities that contribute to land, air, and water contamination. Proper environmental waste management involves reducing, recycling, and safely disposing of waste to minimize ecological harm and promote sustainability.",
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

        wasteList.add(new ItemsClass("Plastic Type Waste", "Non-Biodegradable",
                "Refers to discarded plastic materials that accumulate in the environment, posing significant ecological risks due to their non-biodegradable nature. It includes various types, such as PET (polyethylene terephthalate) used in bottles, HDPE (high-density polyethylene) found in containers, and PVC (polyvinyl chloride) used in pipes and packaging. Managing plastic waste effectively requires recycling, reducing single-use plastics, and adopting sustainable alternatives to mitigate pollution.",
                "To Properly Dispose:",
                "1. Separate plastics by type (e.g., PET, HDPE).\n" +
                        "2. Rinse off food and liquid residues.\n" +
                        "3. Remove non-recyclable parts such as caps and labels.\n" +
                        "4. Check for recycling symbols or instructions.\n" +
                        "5. Place in the designated recycling bin or drop-off center.",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow)));

        wasteList.add(new ItemsClass("Styrofoam Type Waste", "Non-Biodegradable",
                "Refers to discarded products made from expanded polystyrene foam (EPS), commonly known as Styrofoam. These items include packaging materials, disposable food containers, and insulation products. Styrofoam is not biodegradable, is resistant to photo-oxidization, and is difficult to recycle, making it a significant environmental pollutant.",
                "To Properly Dispose:",
                "1. Check if the styrofoam is recyclable by looking for the recycling symbol. If not dispose it in Non-biodegradable bin.\n" +
                        "2. Clean the styrofoam, removing any tape or food residue.\n" +
                        "3. Find a local recycling center that accepts styrofoam.\n" +
                        "4. Consider reusing styrofoam for crafts, gardening, or insulation.\n" +
                        "5. Participate in community collection drives for proper disposal.\n" +
                        "6. Look for drop-off points for specialized styrofoam disposal.",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow)));

        wasteList.add(new ItemsClass("Packaging Boxes", "Recyclable",
                "Are containers made from materials like cardboard, corrugated fiberboard, or plastic, designed to store, protect, and transport goods. It serves both functional and branding purposes, ensuring product safety while often featuring custom designs for marketing. Packaging boxes come in various types, including folding cartons, rigid boxes, and corrugated boxes, depending on durability and usage needs.",
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

        wasteList.add(new ItemsClass("Home Appliance", "E-Waste",
                "Refers to a household device designed to perform specific tasks that improve comfort, convenience, and efficiency in daily life. These appliances include cooking devices (like ovens and microwaves), cleaning equipment (such as washing machines and vacuums), and other tools (like refrigerators and air conditioners) that utilize electricity or gas to operate. Home appliances are essential in modern homes for simplifying routine chores and maintaining a ",
                "To Properly Dispose:",
                "1. Unplug the appliance and clean it thoroughly.\n" +
                        "2. Safely remove any hazardous parts, such as batteries or fluids, if applicable.\n" +
                        "3. Separate any recyclable components, like metal or plastic parts, if possible.\n" +
                        "4. Transport the appliance to SM collection bins for E-waste or accredited recycling centers. \n" +
                        "5. If SM is unavailable, coordinate with your LGU for proper disposal services.\n" +
                        "6. Do not burn, bury, or dispose of appliances in landfills.\n" +
                        "7. You can trade them, put for sale or either scrap them for additional money.",
                R.drawable.icon_ewaste, ContextCompat.getColor(this, R.color.red)));

        wasteListTranslated.add(new ItemsClass("Organic Waste", "Nabubulok",
                "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.",
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

        wasteListTranslated.add(new ItemsClass("Food Waste", "Nabubulok",
                "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.",
                "Para sa tamang pagtatapon:",
                "1. Ihiwalay ang mga tira-tirang pagkain sa ibang uri ng basura tulad ng plastik, bote, at papel. Ang mga tirang pagkain ay itapon bilang nabubulok o biodegradable.\n" +
                        "2. Ilagay ang mga tirang pagkain sa lalagyan na para sa mga nabubulok. Karaniwan itong kulay berde o nakalabel na \"Biodegradable.\"\n" +
                        "3. Kung may bakuran, maaari ring gamitin ang mga tirang pagkain para sa paggawa ng kompost na makakatulong sa lupa at mga halaman.\n" +
                        "4. Huwag itapon ang mga tirang pagkain sa kanal o ilog dahil maaaring magdulot ito ng pagbaha at polusyon.\n" +
                        "5. Siguraduhing ang mga tira-tirang pagkain ay kukunin ng lokal na pamahalaan o tagapag-kolekta ng basura sa tamang araw ng koleksyon.",
                R.drawable.icon_biodegradable, ContextCompat.getColor(this, R.color.green)));

        wasteListTranslated.add(new ItemsClass("Environmental Waste", "Nabubulok",
                "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.",
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

        wasteListTranslated.add(new ItemsClass("Plastic Type Waste", "Hindi Nabubulok",
                "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.",
                "Para sa tamang pagtatapon:",
                "1. Ihiwalay ang mga plastik ayon sa uri (hal. PET, HDPE).\n" +
                        "2. Banlawan ang mga tira-tirang pagkain at likido.\n"+
                        "3. Alisin ang mga hindi pwedeng i-recycle tulad ng takip at label.\n" +
                        "4. Suriin ang mga simbolo ng pag-recycle o mga tagubilin.\n" +
                        "5. Ilagay sa tamang basurahan o lugar ng pag-iipon ng mga recyclable.",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow)));

        wasteListTranslated.add(new ItemsClass("Styrofoam Type Waste", "Hindi Nabubuok",
                "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.",
                "Para sa tamang pagtatapon:",
                "1. Suriin kung maaaring irecycle ang styrofoam sa pamamagitan ng simbolo ng recycling. Kung hindi itapon ito sa di nabubulok na basurahan.\n" +
                        "2. Linisin ang styrofoam at alisin ang mga tape o tira ng pagkain.\n" +
                        "3. Maghanap ng lokal na recycling center na tumatanggap ng styrofoam.\n" +
                        "4. Gamitin muli ang styrofoam para sa crafts, paghahardin, o insulation.\n" +
                        "5. Makilahok sa mga community collection drives para sa tamang pagtatapon.\n" +
                        "6. Hanapin ang mga drop-off points para sa espesyal na pagtatapon ng styrofoam.",
                R.drawable.icon_nonbiodegradable, ContextCompat.getColor(this, R.color.yellow)));

        wasteListTranslated.add(new ItemsClass("Packaging Boxes", "Recyclable",
                "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.",
                "Para sa tamang pagtatapon:",
                "1. Tupiin ang mga kahon ng packaging para magtipid sa espasyo.\n" +
                        "2. Alisin ang mga hindi maaaring i-recycle tulad ng plastik o tape.\n" +
                        "3. Ilagay ang mga patag na kahon sa tamang recycling bin.\n" +
                        "4. Kung marumi ang kahon ng packaging, ilagay ito sa basurahan ng hindi nabubulok.\n" +
                        "5. Iwasang ihalo ang mga packaging boxes sa ibang hindi nabubulok na materyales.",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteListTranslated.add(new ItemsClass("Paper Type Waste", "Recyclable",
                "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.",
                "Para sa tamang pagtatapon:",
                "1. Ihiwalay ang mga papel sa ibang basura.\n" +
                        "2. Patalasin ang mga kahon o karton na papel.\n" +
                        "3. Alisin ang mga papel na basang dahil sa pagkain o likido at itapon ito sa basurahan ng hindi nabubulok.\n" +
                        "4. Ilagay ang malinis at tuyong papel sa recycling bin.\n" +
                        "5. Iwasang ihalo ang papel sa plastik o metal.",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteListTranslated.add(new ItemsClass("Plastic Bottle", "Recyclable",
                "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.",
                "Para sa tamang pagtatapon:",
                "1. Alisin ang laman ng plastik na bote at banlawan kung kinakailangan.\n" +
                        "2. Alisin ang takip at label ng bote.\n" +
                        "3. Ilagay ang plastik na bote sa tamang recycling bin.\n" +
                        "4. Kung kontaminado ang bote ng pagkain o mapanganib na likido, itapon ito sa basurahan ng hindi nabubulok.\n" +
                        "5. Iwasang durugin ang plastik na bote bago itapon sa recycling bin, dahil maaari nitong maka-apekto ang proseso ng pag-recycle.",
                R.drawable.icon_recylable, ContextCompat.getColor(this, R.color.bluegreen)));

        wasteListTranslated.add(new ItemsClass("Batteries", "E-Waste",
                "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.",
                "Para sa tamang pagtatapon:",
                "1. Huwag itapon ang mga ito sa basurahan ng bahay o sa mga basurahan para sa pagre-recycle sa gilid ng daan.\n" +
                        "2. Dalhin ang mga ito sa mga lugar na tumatanggap ng baterya o sa mga pasilidad na tumatanggap ng mga mapanganib na basura sa bahay.\n" +
                        "3. Tukuyin kung anong uri ng baterya (rechargeable o single-use).\n" +
                        "4. Ganap na i-discharge ang mga rechargeable na baterya bago itapon.\n" +
                        "5. Takpan ang mga terminal ng baterya ng electrical tape o plastik na takip.\n" +
                        "6. Itabi ang mga baterya sa malamig, tuyong lugar, malayo sa init at sikat ng araw.\n" +
                        "7. Panatilihin silang hiwalay sa iba pang basura at mga baterya.",
                R.drawable.icon_ewaste, ContextCompat.getColor(this, R.color.red)));

        wasteListTranslated.add(new ItemsClass("Electronic Devices", "E-Waste",
                "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.\n" +
                        "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah.",
                "Para sa tamang pagtatapon:",
                "1. I-reset ang device para mabura ang lahat ng personal na data.\n" +
                        "2. Tanggalin nang maayos ang mga baterya at iba pang naaalis na bahagi.\n" +
                        "3. Ibalot nang maayos ang device upang maiwasan ang pagkasira habang dinadala.\n" +
                        "4. Dalhin ang device sa E-waste collection bins ng SM.\n" +
                        "5. Kung walang SM, maghanap ng accredited E-waste recycler o magtanong sa LGU tungkol sa collection points.\n" +
                        "6. Iwasang itapon ang device sa karaniwang basurahan o sa mga bukas na lugar.",
                R.drawable.icon_ewaste, ContextCompat.getColor(this, R.color.red)));

        wasteListTranslated.add(new ItemsClass("Home Appliance", "E-Waste",
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
                R.drawable.icon_ewaste, ContextCompat.getColor(this, R.color.red)));

        ItemsAdapter adapter = new ItemsAdapter(this, wasteList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
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
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);

                if (fragment != null) {
                    getSupportFragmentManager().popBackStack();
                    findViewById(R.id.knowledgeTitle).setVisibility(View.VISIBLE);
                    findViewById(R.id.cardContainer).setVisibility(View.VISIBLE);
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
