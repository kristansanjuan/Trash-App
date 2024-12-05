package com.example.imageclassifier;

import java.util.HashMap;
import java.util.Map;

public class DisposalGuideActivity {

    private boolean isTagalog = true; // Default language is Tagalog

    // Default guides for waste types
    private final Map<String, String[]> defaultGuides = new HashMap<>();

    // Initialize the disposal guides
    public DisposalGuideActivity() {
        initializeGuides();
    }

    private void initializeGuides() {
        defaultGuides.put("Food Waste", new String[]{
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
        });

        defaultGuides.put("Plastic Bottle", new String[]{
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
        });

        defaultGuides.put("Face Mask", new String[]{
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
        });

        defaultGuides.put("Plastic Utensil", new String[]{
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
        });

        defaultGuides.put("Syringe", new String[]{
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
        });
    }

    // Method to get the disposal guide
    public String getGuide(String wasteType) {
        if (defaultGuides.containsKey(wasteType)) {
            return isTagalog ? defaultGuides.get(wasteType)[1] : defaultGuides.get(wasteType)[0];
        }

        return "No disposal guide available for this waste type.";
    }

    // Method to toggle language
    public void toggleLanguage() {
        isTagalog = !isTagalog;
    }

}
