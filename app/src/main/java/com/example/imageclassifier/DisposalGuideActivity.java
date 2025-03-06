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

        defaultGuides.put("Organic Waste", new String[]{
                // English
                "1. Dispose in a green bin or compost\n" +
                        "2. Composting works best with dried leaves.\n" +
                        "3. Uncovered waste attracts pests.\n" +
                        "4. Dumping in canals causes pollution.\n",

                // Tagalog
                "1. Itapon sa berdeng basurahan bin.\n" +
                        "2. Ang paghalo ng tuyong dahon ay nakakatulong sa pag-compost.\n" +
                        "3. Iwasang iwanang bukas ang basurahan upang hindi pamahayan ng mga peste.\n" +
                        "4. Ang pagtatapon sa kanal ay nagdudulot ng polusyon.\n",
        });

        defaultGuides.put("Environmental Waste", new String[] {
                // English
                "1. Dispose in a green bin or compost\n" +
                        "2. Mixing organic waste enhances composting and speeds up decomposition.\n" +
                        "3. Burning waste releases pollutants that harm air quality.\n" +
                        "4. Keeping waste covered helps prevent pests and maintain cleanliness.\n",

                // Tagalog
                "1. Itapon sa berdeng basurahan bin.\n" +
                        "2. Paghahalo ng organik na basura ay nakakatulong sa mabilisang pagkabulok.\n" +
                        "3. Ang pagsusunog ng basura ay naglalabas ng nakakasamang polusyon sa hangin.\n" +
                        "4. Panatiliing nakasara o may takip ang basurahan upang hindi pamahayan ng mga peste.\n",
        });

        defaultGuides.put("Plastic Type Waste", new String[] {
                // English
                "1. Leftover residues can impact the recyclability of materials.\n" +
                        "2. Non-recyclable parts make processing less efficient.\n" +
                        "3. Recycling works best when guidelines are followed.\n" +
                        "4. Proper disposal in designated recycling bins ensures effective waste management.\n",

                // Tagalog
                "1. Siguraduhing malinis at walang tira-tirang laman bago itapon.\n" +
                        "2. Ang hindi nare-recycle na bahagi ay nagpapahirap sa pagpoproseso.\n"+
                        "3. Sumunod sa tamang patakaran ng recycling upang maging epektibo ito.\n" +
                        "4. Itapon sa tamang recycling bin.\n",
        });

        defaultGuides.put("Glass Type Waste", new String[] {
                // English
                "1. Recyclable glass, such as bottles and jars, belongs in the recycling bin.\n" +
                        "2. Wrapping broken glass securely helps prevent injuries\n" +
                        "3. Labeling as 'Broken Glass' ensures safe handling.\n" +
                        "4. Disposing of broken glass in the non-biodegradable bin keeps waste properly sorted.\n",

                // Tagalog
                "1. Ang mga boteng baso at garapon ay dapat ilagay sa recycling bin.\n" +
                        "2. Balutin nang maayos ang basag na salamin upang maiwasan ang sakuna.\n" +
                        "3. Lagyan ng label na “Basag na Salamin” upang mapanatili ang kaligtasan.\n" +
                        "4. Itapon ang basag na salamin sa hindi nabubulok na basurahan.\n",
        });

        defaultGuides.put("Aluminum Cans", new String[] {
                // English
                "1. Aluminum cans are best kept separate from plastic or glass, and labels can be removed if possible.\n" +
                        "2. Crushing cans or folding foil helps save space during disposal.\n" +
                        "3. Placing aluminum cans in their designated recycling bin ensures proper recycling.\n",

                // Tagalog
                "1. Hiwalayin ito mula sa ibang basura at tangalin ang label nito kung maaari.\n" +
                        "2. Durugin o tupiin ang lata upang makatipid sa espasyo.\n" +
                        "3. Itapon sa tamang recycling bin.\n",
        });

        defaultGuides.put("Packaging Boxes", new String[] {
                // English
                "1. Flattening packaging boxes helps save space for disposal.\n" +
                        "2. Non-recyclable items like plastic liners or tape should be removed.\n" +
                        "3. Recycling bins are the best place for flattened, clean packaging boxes.\n" +
                        "4. Boxes contaminated with food or liquid belong in non-recyclable waste.\n" +
                        "5. Keeping packaging boxes separate from non-recyclable materials ensures proper recycling.\n",

                // Tagalog
                "1. Tupiin ang mga kahon upang makatipid ng espasyo.\n" +
                        "2. Alisin ang hindi nare-recycle na bagay tulad ng plastik na balot o tape.\n" +
                        "3. Ilagay sa recycling bin ang malinis at nakatuping packaging boxes.\n" +
                        "4. Ang mga kahong marumi na may pagkain o likido ay hindi na maaaring i-recycle.\n" +
                        "5. Panatilihing nakahiwalay ang packaging boxes sa ibang uri ng basura para sa tamang pagrerecycle.\n",
        });

        defaultGuides.put("Paper Type Waste", new String[] {
                // English
                "1. Keeping the paper waste clean and dry to ensure proper recycling.\n" +
                        "2. Wet paper waste must not dispose in recycling bin.\n" +
                        "3. Dispose the paper waste in recycling bin  to be repurpose.\n" +
                        "4. Mixing paper with other waste must be avoid to maintain recycling efficiency.\n",

                // Tagalog
                "1. Panatilihing tuyo at malinis ang papel para sa maayos na pag-recycle.\n" +
                        "2. Iwasang itapon ang basang papel sa recycling bin.\n" +
                        "3. Ilagay ang papel sa recycling bin upang muling magamit.\n" +
                        "4. Huwag ihalo ang papel sa plastik o metal upang mapanatili ang kalidad ng recycling.\n",
        });

        defaultGuides.put("Plastic Bottles", new String[] {
                // English
                "1. Emptying and rinsing plastic bottles helps maintain recycling quality.\n" +
                        "2. Caps and labels should be removed before disposal.\n" +
                        "3. Clean plastic bottles belong in the recycling bin.\n" +
                        "4. Contaminated bottles with food or hazardous liquids should go in non-recyclable waste.\n" +
                        "5. Avoid crushing bottles before recycling, as it may affect processing efficiency.\n",

                // Tagalog
                "1. Banlawan at alisin ang laman bago itapon upang ito ay mai-recycle.\n" +
                        "2. Tangalin ang takip at label bago itapon sa recycling bin.\n" +
                        "3. Ang malinis na bote ay dapat itapon sa recling bin.\n" +
                        "4. Ang maruming bote na may tira-tirang pagkain ay hindi maaaring i-recycle.\n" +
                        "5. Iwasang durugin ang bote bago itapon upang hindi maapektuhan ang pagpoproseso.\n",
        });

        defaultGuides.put("Batteries", new String[]{
                // English
                "1. Household trash bin or recycling bins are not suitable for battery disposal.\n" +
                        "2. Battery collection sites or hazardous waste facilities ensure safe disposal.\n" +
                        "3. Identifying the battery type helps determine proper recycling methods\n" +
                        "4. Fully discharging rechargeable batteries before disposal enhances safety.\n" +
                        "5. Covering battery terminals with tape or plastic caps prevents short circuits.\n" +
                        "6. Storing batteries in a cool, dry place keeps them safe from heat exposure.\n" +
                        "7. Keeping batteries separate from other waste improves recycling efficiency.\n",
                // Tagalog
                "1. Huwag itapon sa ordinaryong basurahan o recycling bin are baterya.\n" +
                        "2. Dalhin sa mga collection site o hazardous waste facility para masigurado ang kaligtasan.\n" +
                        "3. Tignan kung anong uri ng baterya upang malaman kung pano ito itapon.\n" +
                        "4. Siguraduhing walang karga ang  baterya bago itapon.\n" +
                        "5. Takpan ang terminal ng baterya ng tape o plastik upang maiwasan ang short circuit.\n" +
                        "6. Itago sa malamig at tuyong lugar upang hindi sila maexpose sa init.\n" +
                        "7. Panatilihing nakahiwalay ang baterya sa iba pang mga basura.\n",
        });

        defaultGuides.put("Electronic Devices", new String[]{
                // English
                "1. Resetting devices helps remove personal data before disposal.\n" +
                        "2. Detachable components, like batteries, should be removed safely.\n" +
                        "3. Secure packaging prevents damage during transport.\n" +
                        "4. SM E-waste collection bins and other disposal sites accept electronic waste.\n" +
                        "5. E-waste recyclers like E-waste Management Philippines and E-waste Project UP provide disposal options.\n" +
                        "6. Regular trash bins and open dumping are not suitable for electronic waste disposal.\n",

                // Tagalog
                "1. I-reset ang device upang mawala ang mga personal na data bago itapon.\n" +
                        "2. Alisin nang ligtas ang baterya at iba pang natatanggal na bahagi.\n" +
                        "3. Balutin nang maayos upang hindi masira sa transportasyon.\n" +
                        "4. Dalhin sa SM E-waste collection bins o iba pang accredited E-waste collector.\n" +
                        "5. Huwag itapon sa regular na basurahan o iwanan kung saan lamang ang basurang ito.\n",
        });
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