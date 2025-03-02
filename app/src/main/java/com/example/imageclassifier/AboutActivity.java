package com.example.imageclassifier;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AboutActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityContent(R.layout.activity_about);

        TextView aboutModel = findViewById(R.id.aboutModel);
        String description = "This waste classification model was trained using <a href=\"https://teachablemachine.withgoogle.com/\">Google Teachable Machine</a>. Developers collected images of different waste types such as biodegradable, non-biodegradable, recyclable, and e-waste to build a diversed dataset.\n" +
                "\n" +
                "        The model was trained using optimized settings like epochs, learning rate, and batch size to improve accuracy. A confusion matrix was used to evaluate performance and ensure correct classification.\n" +
                "\n" +
                "        Integrated into this app into a tensorflow lite format, the model helps users identify waste types instantly, promoting proper waste disposal. Future updates will improve accuracy and add more waste categories to enhance sustainability efforts.";
        aboutModel.setText(Html.fromHtml(description, Html.FROM_HTML_MODE_LEGACY));

        aboutModel.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
