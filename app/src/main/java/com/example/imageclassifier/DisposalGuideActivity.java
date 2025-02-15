package com.example.imageclassifier;

import java.util.HashMap;
import java.util.Map;

public class DisposalGuideActivity {

    private boolean isTagalog = false; // Default language is English

    // Default guides for waste types
    private final Map<String, String[]> defaultGuides = new HashMap<>();

    // Initialize the disposal guides
    public DisposalGuideActivity() {
        initializeGuides();
    }

    private void initializeGuides() {
        /*defaultGuides.put("Food Waste", new String[]{
                // English
                "1. Separate leftover food from other types of waste such as plastics, bottles, and paper. Leftover food should be disposed of as biodegradable waste.\n" +
                        "2. Place the leftover food in the bin labeled for biodegradable waste. These bins are usually green or marked \"Biodegradable\".\n" +
                        "3. If space allows, leftover food can be used to create compost, which is beneficial for soil and plants.\n" +
                        "4. Do not throw leftover food into drains or rivers as this can cause flooding and pollution.\n" +
                        "5. Ensure that the bin is collected by the local government or waste collectors on the designated collection days.\n",

                // Tagalog
                "1. Ihiwalay ang mga tira-tirang pagkain sa ibang uri ng basura tulad ng plastik, bote, at papel. Ang mga tirang pagkain ay itapon bilang nabubulok o biodegradable.\n" +
                        "2. Ilagay ang mga tirang pagkain sa lalagyan na para sa mga nabubulok. Karaniwan itong kulay berde o nakalabel na \"Biodegradable\".\n" +
                        "3. Kung may bakuran, maaari ring gamitin ang mga tirang pagkain para sa paggawa ng kompost na makakatulong sa lupa at mga halaman.\n" +
                        "4. Huwag itapon ang mga tirang pagkain sa kanal o ilog dahil maaaring magdulot ito ng pagbaha at polusyon.\n" +
                        "5. Siguraduhing ang basura ay kukunin ng lokal na pamahalaan o tagapag-kolekta ng basura sa tamang araw ng koleksyon.\n"
        });*/

        defaultGuides.put("Organic Waste", new String[]{
                // English
                "1. Gather vegetable peels, fruit peels, eggshells, and similar organic waste in a separate container.\n" +
                        "2. Avoid mixing organic waste with plastics, paper, glass, or other non-biodegradable materials.\n" +
                        "3. Place the organic waste in a biodegradable bag or a green bin labeled for organic waste.\n" +
                        "4. If you have space, use the organic waste to create compost by placing it in a compost bin or pile and adding dry materials like dried leaves.\n" +
                        "5. Do not throw organic waste into canals, rivers, or open areas to prevent pollution and flooding.\n" +
                        "6. Ensure the organic waste is properly stored in covered bins to avoid attracting pests.\n" +
                        "7. Coordinate with your local waste management service to have the organic waste collected on designated days.\n" +
                        "8. If composting is not possible and collection services are unavailable, contact the local government for proper disposal instructions.\n",

                // Tagalog
                "1. Ipunin ang balat ng gulay, balat ng prutas, balat ng itlog, at iba pang katulad na nabubulok na basura sa hiwalay na lalagyan.\n" +
                        "2. Iwasang paghaluin ang nabubulok na basura sa plastik, papel, bote, o iba pang hindi nabubulok na materyales.\n" +
                        "3. Ilagay ang mga nabubulok na basura sa biodegradable na supot o sa berde na basurahan na may label na para sa nabubulok.\n" +
                        "4. Kung may espasyo, gamitin ang mga nabubulok na basura para makagawa ng kompost sa pamamagitan ng paglalagay nito sa compost bin o compost pile at pagdagdag ng tuyong dahon.\n" +
                        "5. Huwag itapon ang mga nabubulok na basura sa kanal, ilog, o bakanteng lugar upang maiwasan ang polusyon at pagbaha.\n" +
                        "6. Siguraduhing maayos ang imbakan ng nabubulok na basura sa mga nakatakip na lalagyan upang hindi makaakit ng peste.\n" +
                        "7. Makipag-ugnayan sa lokal na serbisyo ng pamamahala ng basura upang makolekta ang mga nabubulok na basura sa tamang araw ng koleksyon.\n" +
                        "8. Kung hindi posible ang pag-kompost at walang koleksyon ng basura, humingi ng payo sa lokal na pamahalaan para sa tamang pagtapon ng basura.\n"
        });

        /*defaultGuides.put("Food Waste", new String[] {
                // English
                "1. Separate leftover food from other types of waste such as plastics, bottles, and paper. Leftover food should be disposed of as biodegradable waste.\n" +
                        "2. Place the leftover food in the bin labeled for biodegradable waste. These bins are usually green or marked \"Biodegradable.\"\n" +
                        "3. If space allows, leftover food can be used to create compost, which is beneficial for soil and plants.\n" +
                        "4. Do not throw leftover food into drains or rivers as this can cause flooding and pollution.\n" +
                        "5. Ensure that leftover food waste is collected by the local government or waste collectors on the designated collection days.\n",

                // Tagalog
                "1. Ihiwalay ang mga tira-tirang pagkain sa ibang uri ng basura tulad ng plastik, bote, at papel. Ang mga tirang pagkain ay itapon bilang nabubulok o biodegradable.\n" +
                        "2. Ilagay ang mga tirang pagkain sa lalagyan na para sa mga nabubulok. Karaniwan itong kulay berde o nakalabel na \"Biodegradable.\"\n" +
                        "3. Kung may bakuran, maaari ring gamitin ang mga tirang pagkain para sa paggawa ng kompost na makakatulong sa lupa at mga halaman.\n" +
                        "4. Huwag itapon ang mga tira-tirang pagkain sa kanal o ilog dahil maaaring magdulot ito ng pagbaha at polusyon.\n" +
                        "5. Siguraduhing ang mga tira-tirang pagkain ay kukunin ng lokal na pamahalaan o tagapag-kolekta ng basura sa tamang araw ng koleksyon.\n"
        });*/

        defaultGuides.put("Environmental Waste", new String[] {
                // English
                "1. Gather dry leaves, grass clippings, small branches, and similar organic waste.\n" +
                        "2. Avoid mixing with non-biodegradable waste like plastics or metals.\n" +
                        "3. Place in a compost bin or green waste bin if available.\n" +
                        "4. For composting, mix with other organic waste for faster decomposition.\n" +
                        "5. If composting isn’t an option, contact local authorities for disposal.\n" +
                        "6. Do not burn, as it harms health and air quality.\n" +
                        "7. Ensure it's stored in a covered bin to avoid pests.\n" +
                        "8. Confirm collection with local waste management.\n",

                // Tagalog
                "1. Ipunin ang mga tuyong dahon, damo, maliit na sanga, at katulad na nabubulok na basura sa isang lalagyan.\n" +
                        "2. Iwasang paghaluin ito sa hindi nabubulok na basura tulad ng plastik o metal.\n" +
                        "3. Ilagay sa compost bin o green waste bin kung mayroon.\n" +
                        "4. Kung magko-kompost, ihalo ang mga ito sa ibang nabubulok na basura para mapabilis ang pagkabulok.\n" +
                        "5. Kung walang composting, makipag-ugnayan sa lokal na pamahalaan para sa tamang pagtapon.\n" +
                        "6. Huwag sunugin ang mga ito dahil nakakasama sa kalusugan at sa hangin.\n" +
                        "7. Siguraduhing nakatago sa basurahan upang hindi makaakit ng peste.\n" +
                        "8. I-verify ang koleksyon mula sa lokal na pamamahala ng basura.\n"
        });

        defaultGuides.put("Plastic Type Waste", new String[] {
                // English
                "To properly dispose of plastic items, follow these steps:\n" +
                        "1. Separate plastics by type (e.g., PET, HDPE).\n" +
                        "2. Rinse off food and liquid residues.\n" +
                        "3. Remove non-recyclable parts such as caps and labels.\n" +
                        "4. Check for recycling symbols or instructions.\n" +
                        "5. Place in the designated recycling bin or drop-off center.\n",

                // Tagalog
                "1. Ihiwalay ang mga plastik ayon sa uri (hal. PET, HDPE).\n" +
                        "2. Banlawan ang mga tira-tirang pagkain at likido.\n" +
                        "3. Alisin ang mga hindi pwedeng i-recycle tulad ng takip at label.\n" +
                        "4. Suriin ang mga simbolo ng pag-recycle o mga tagubilin.\n" +
                        "5. Ilagay sa tamang basurahan o lugar ng pag-iipon ng mga recyclable.\n"
        });

        defaultGuides.put("Glass Type Waste", new String[] {
                // English
                "Should You Recycle or Trash Glass?\n" +
                        "Recycle: Glass bottles and jars—rinse them and place them in the recycling bin.\n" +
                        "Trash: Broken glass, windows, mirrors, and drinkware—wrap securely, label as 'Broken Glass,' and dispose of in regular trash.\n\n" +
                        "1. If the glass is unbroken (bottles, jars), rinse and place it in the recycling bin.\n" +
                        "2. For broken glass, wear gloves and carefully collect the shards.\n" +
                        "3. Wrap the broken glass in newspaper or place it inside a sturdy cardboard box.\n" +
                        "4. Label the package as 'Broken Glass' to alert waste collectors.\n" +
                        "5. Dispose of broken glass in the regular trash, not in recycling.\n",

                // Tagalog
                "Dapat Bang I-recycle o Itapon ang Salamin?\n" +
                        "Recycle: Ang mga bote at garapon ng salamin—hugasan at ilagay sa recycling bin.\n" +
                        "Trash: Ang basag na salamin, bintana, salamin sa dingding, at mga baso—balutin nang maayos, lagyan ng label na 'Basag na Salamin,' at itapon sa regular na basura.\n\n" +
                        "1. Kung buo pa ang salamin (bote, garapon), hugasan at ilagay sa recycling bin.\n" +
                        "2. Kung basag ang salamin, magsuot ng guwantes at maingat na tipunin ang mga piraso.\n" +
                        "3. Balutin ang basag na salamin sa diyaryo o ilagay sa matibay na kahon.\n" +
                        "4. Lagyan ng label na 'Basag na Salamin' upang malaman ng mga tagakolekta ng basura.\n" +
                        "5. Itapon ang basag na salamin sa regular na basura, hindi sa recycling bin.\n"
        });

        defaultGuides.put("Aluminum Type Waste", new String[] {
                // English
                "1. Keep aluminum waste separate from other materials like plastic or glass, remove the label if possible.\n" +
                        "2. If possible, crush the cans or fold the foil to save space. \n" +
                        "3. Then, place the aluminum waste in its designated recycling bin.\n",

                // Tagalog
                "1. Ihiwalay ang basura na aluminum mula sa iba pang mga materyales tulad ng plastik o salamin, alisin ang label kung maaari.\n" +
                        "2. Kung maaari, durugin ang lata o tiklupin ang foil upang makatipid sa espasyo.\n" +
                        "3. Pagkatapos, ilagay ang basura na aluminum sa recycling bin.\n"
        });

        defaultGuides.put("Packaging Boxes", new String[] {
                // English
                "1. Flatten packaging boxes to save space.\n" +
                        "2. Remove any non-recyclable items such as plastic liners or tape.\n" +
                        "3. Place the flattened boxes in the appropriate recycling bin.\n" +
                        "4. If the box is contaminated with food or liquid, dispose of it in the non-recyclable waste bin.\n" +
                        "5. Avoid mixing packaging boxes with non-recyclable materials.\n",

                // Tagalog
                "1. Tupiin ang mga kahon ng packaging para magtipid sa espasyo.\n" +
                        "2. Alisin ang mga hindi maaaring i-recycle tulad ng plastik o tape.\n" +
                        "3. Ilagay ang mga patag na kahon sa tamang recycling bin.\n" +
                        "4. Kung marumi ang kahon ng packaging, ilagay ito sa basurahan ng hindi nabubulok.\n" +
                        "5. Iwasang ihalo ang mga packaging boxes sa ibang hindi nabubulok na materyales.\n"
        });

        defaultGuides.put("Paper Type Waste", new String[] {
                // English
                "1. Separate paper waste from other trash.\n" +
                        "2. Flatten any paper items like boxes or cardboard.\n" +
                        "3. Remove any food or liquid-soaked paper and dispose of it in the non-recyclable waste bin.\n" +
                        "4. Place the clean, dry paper in the recycling bin.\n" +
                        "5. Avoid mixing paper with plastic or metal materials.\n",

                // Tagalog
                "1. Ihiwalay ang mga papel sa ibang basura.\n" +
                        "2. Patalasin ang mga kahon o karton na papel.\n" +
                        "3. Alisin ang mga papel na basang dahil sa pagkain o likido at itapon ito sa basurahan ng hindi nabubulok.\n" +
                        "4. Ilagay ang malinis at tuyong papel sa recycling bin.\n" +
                        "5. Iwasang ihalo ang papel sa plastik o metal.\n"
        });

        defaultGuides.put("Plastic Bottles", new String[] {
                // English
                "1. Empty the plastic bottle and rinse it if necessary.\n" +
                        "2. Remove any caps or labels.\n" +
                        "3. Place the plastic bottle in the recycling bin.\n" +
                        "4. If the bottle is contaminated with food or hazardous liquids, dispose of it in the non-recyclable waste bin.\n" +
                        "5. Avoid crushing plastic bottles before recycling, as it can affect the recycling process.\n",

                // Tagalog
                "1. Alisin ang laman ng plastik na bote at banlawan kung kinakailangan.\n" +
                        "2. Alisin ang takip at label ng bote.\n" +
                        "3. Ilagay ang plastik na bote sa tamang recycling bin.\n" +
                        "4. Kung kontaminado ang bote ng pagkain o mapanganib na likido, itapon ito sa basurahan ng hindi nabubulok.\n" +
                        "5. Iwasang durugin ang plastik na bote bago itapon sa recycling bin, dahil maaari nitong maka-apekto ang proseso ng pag-recycle.\n"
        });

        defaultGuides.put("Batteries", new String[]{
                // English
                "1. Do not place them in household trash or curbside recycling bins.\n" +
                        "2. Take them to battery collection sites or household hazardous waste collection facilities.\n" +
                        "3. Identify the type of battery (rechargeable or single use).\n" +
                        "4. Discharge rechargeable batteries completely before disposal.\n" +
                        "5. Cover battery terminals with electrical tape or plastic caps.\n" +
                        "6. Store batteries in a cool, dry place away from heat sources and sunlight.\n" +
                        "7. Keep them separate from other waste and batteries.\n",

                // Tagalog
                "1. Huwag itapon ang mga ito sa basurahan ng bahay o sa mga basurahan para sa pagre-recycle sa gilid ng daan.\n" +
                        "2. Dalhin ang mga ito sa mga lugar na tumatanggap ng baterya o sa mga pasilidad na tumatanggap ng mga mapanganib na basura sa bahay.\n" +
                        "3. Tukuyin kung anong uri ng baterya (rechargeable o single-use).\n" +
                        "4. Ganap na i-discharge ang mga rechargeable na baterya bago itapon.\n" +
                        "5. Takpan ang mga terminal ng baterya ng electrical tape o plastik na takip.\n" +
                        "6. Itabi ang mga baterya sa malamig, tuyong lugar, malayo sa init at sikat ng araw.\n" +
                        "7. Panatilihin silang hiwalay sa iba pang basura at mga baterya.\n"
        });

        defaultGuides.put("Electronic Devices", new String[]{
                // English
                "1. Reset the device to remove all personal data.\n" +
                        "2. Safely remove any batteries and other detachable components.\n" +
                        "3. Pack the device securely to avoid damage during transport.\n" +
                        "4. Bring the device to SM E-waste collection bins or any other e-waste disposal collector.\n" +
                        "5. If SM is not available, there are others like E-waste Management Philippines, E-waste Project UP or look for any accredited E-waste recycler or inquire with your LGU about collection points.\n" +
                        "6. Avoid disposing of the device in regular trash bins or dumping it in open areas.\n",

                // Tagalog
                "1. I-reset ang device para mabura ang lahat ng personal na data.\n" +
                        "2. Tanggalin nang maayos ang mga baterya at iba pang naaalis na bahagi.\n" +
                        "3. Ibalot nang maayos ang device upang maiwasan ang pagkasira habang dinadala.\n" +
                        "4. Dalhin ang device sa E-waste collection bins ng SM.\n" +
                        "5. Kung walang SM, maghanap ng accredited E-waste recycler o magtanong sa LGU tungkol sa collection points.\n" +
                        "6. Iwasang itapon ang device sa karaniwang basurahan o sa mga bukas na lugar.\n"
        });

        /*defaultGuides.put("Home Appliances", new String[]{
                // English
                "To properly dispose of home appliances, follow these steps:\n" +
                        "1. Unplug the appliance and clean it thoroughly.\n" +
                        "2. Safely remove any hazardous parts, such as batteries or fluids, if applicable.\n" +
                        "3. Separate any recyclable components, like metal or plastic parts, if possible.\n" +
                        "4. Transport the appliance to SM collection bins for E-waste or accredited recycling centers.\n" +
                        "5. If SM is unavailable, coordinate with your LGU for proper disposal services.\n" +
                        "6. Do not burn, bury, or dispose of appliances in landfills.\n" +
                        "7. You can trade them, put for sale or either scrap them for additional money.\n",

                // Tagalog
                "Para sa tamang pagtapon ng mga home appliances, sundin ang mga hakbang na ito:\n" +
                        "1. I-unplug ang appliance at linisin itong mabuti.\n" +
                        "2. Tanggalin nang maayos ang mga mapanganib na bahagi tulad ng baterya o likido, kung mayroon.\n" +
                        "3. Paghiwalayin ang mga recyclable na bahagi tulad ng metal o plastik kung posible.\n" +
                        "4. Dalhin ang appliance sa SM collection bins para sa E-waste o sa mga accredited recycling centers.\n" +
                        "5. Kung walang SM, makipag-ugnayan sa LGU para sa tamang disposal services.\n" +
                        "6. Huwag sunugin, ibaon, o itapon ang appliance sa mga landfill.\n" +
                        "7. Puwede mo itong ipangpalit sa iba, ibenta, o ibenta ang mga bahagi para sa dagdag pera.\n"
        });*/


        /*defaultGuides.put("Plastic Bottle", new String[]{
                // English
                "1. Pick-up the Plastic Bottle and find a trashbin.\n" +
                        "2. Look for the bin saying recyclable or .\n" +
                        "3. Place the bottle in the designated recycling bin.\n" +
                        "4. Avoid burning plastic as it releases harmful toxins.",

                // Tagalog
                "1. Pulutin ang Plastik na bote at humanap ng mapagtatapunan.\n" +
                        "2. Hanapin ang tapunan na nagsasabing recycle.\n" +
                        "3. Ilagay ang bote sa tamang recycling bin.\n" +
                        "4. Iwasang sunugin ang plastik dahil naglalabas ito ng mapanganib na mga kemikal."
        });/*

        /*defaultGuides.put("Face Masks", new String[]{
                // English
                "1. Get something you may use as a glove to pick up the mask.\n" +
                        "2. Place the used mask in a plastic bag or a sealed container.\n" +
                        "3. Dispose of it in the non-biodegradable waste bin.\n" +
                        "4. Wash your hands with soap and water immediately after disposal.",

                // Tagalog
                "1. Kumuha ng maaari mong gamitin bilang isang guwantes at kunin ang mask.\n" +
                        "2. Ilagay ang nagamit na mask sa isang plastic bag o sealed na lalagyan.\n" +
                        "3. Itapon ito sa basurahan para sa di-nabubulok na basura.\n" +
                        "4. Hugasan ang iyong mga kamay gamit ang sabon at tubig pagkatapos itapon ang mask."
        });*/

        /*defaultGuides.put("Plastic Utensils", new String[]{
                // English
                "1. Get something you may use as a glove to pick up the plastic utensil.\n" +
                        "2. Check if the utensils are recyclable (look for recycling symbols).\n" +
                        "3. If recyclable, place them in the recycling bin. Otherwise, dispose of them in the non-biodegradable bin.\n" +
                        "4. Avoid reusing disposable utensils for safety and hygiene.",

                // Tagalog
                "1. Kumuha ng maaari mong gamitin bilang isang guwantes at kunin ang plastik na kubyertos.\n" +
                        "2. Suriin kung ang kubyertos ay maaaring i-recycle (hanapin ang recycling symbol).\n" +
                        "3. Kung maaaring i-recycle, ilagay ito sa recycling bin. Kung hindi, itapon ito sa basurahan para sa di-nabubulok.\n" +
                        "4. Iwasang gamitin muli ang disposable na kubyertos para sa kaligtasan at kalinisan."
        });*/

        /*defaultGuides.put("Syringe", new String[]{
                // English
                "1. Use a puncture-resistant sharps container to store used syringes. If an FDA-approved container is unavailable, use a sturdy plastic jug.\n" +
                        "2. Do not attempt to recap the syringe to avoid accidental injury.\n" +
                        "3. Cut the needle off the syringe with needle clippers to reduce waste.\n" +
                        "4. Seal the container when it is full and label it as 'Sharps Waste.'\n" +
                        "5. Dispose of your sharps container in your community’s dropbox if available, or contact your local waste management service or hospital for safe disposal.\n" +
                        "6. Wash your hands thoroughly after handling syringes.",

                // Tagalog
                "1. Gumamit ng puncture-resistant sharps container upang paglagyan ng nagamit na syringe. Kung walang FDA-approved na lalagyan, gumamit ng matibay na plastik na bote.\n" +
                        "2. Huwag subukang ibalik ang takip ng syringe upang maiwasan ang aksidente.\n" +
                        "3. Putulin ang karayom ng syringe gamit ang needle clippers upang mabawasan ang basura.\n" +
                        "4. Selyuhan ang lalagyan kapag puno na at lagyan ng label na 'Sharps Waste.'\n" +
                        "5. Itapon ang iyong sharps container sa dropbox ng inyong komunidad kung mayroon, o makipag-ugnayan sa inyong lokal na serbisyo para sa pamamahala ng basura o ospital para sa ligtas na pagtatapon.\n" +
                        "6. Hugasan nang maigi ang iyong mga kamay pagkatapos hawakan ang syringe."
        });*/
    }

    // Method to get the disposal guide
    public String getGuide(String wasteType) {
        if (defaultGuides.containsKey(wasteType)) {
            return isTagalog ? defaultGuides.get(wasteType)[1] : defaultGuides.get(wasteType)[0];
        }

        boolean isTagalog1 = isTagalog;
        if (!isTagalog1)
            return "No disposal guide available for this waste type.";
        else
            return "Wala pang maibibigay na gabay para sa ganitong uri ng basura.";
    }

    // Method to toggle language
    public void toggleLanguage() {
        isTagalog = !isTagalog;
    }

}