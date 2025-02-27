package com.example.imageclassifier;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.imageclassifier.ml.ModelUnquant;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.IOException;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import android.util.Log;

public class ResultActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView result;
    private int imageSize = 224;
    private ImageView backButton;

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        imageView = findViewById(R.id.imageView);
        backButton = findViewById(R.id.backButton);

        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap image = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        imageView.setImageBitmap(image);
        classifyImage(image);

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        backButton.setOnClickListener(view -> getOnBackPressedDispatcher().onBackPressed());
    }

    /**private void goBack() {
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        finish();
    }**/

    public void classifyImage(Bitmap image) {
        try {
            Log.d("TAG", "classifyImage: ongoing");
            ModelUnquant model = ModelUnquant.newInstance(getApplicationContext());

            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * imageSize * imageSize * 3);
            byteBuffer.order(ByteOrder.nativeOrder());

            int[] intValues = new int[imageSize * imageSize];
            image.getPixels(intValues, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());

            int pixel = 0;
            for (int i = 0; i < imageSize; i++) {
                for (int j = 0; j < imageSize; j++) {
                    int val = intValues[pixel++];
                    byteBuffer.putFloat(((val >> 16) & 0xFF) * (1.f / 255.f));  // Red
                    byteBuffer.putFloat(((val >> 8) & 0xFF) * (1.f / 255.f));   // Green
                    byteBuffer.putFloat((val & 0xFF) * (1.f / 255.f));          // Blue
                }
            }

            inputFeature0.loadBuffer(byteBuffer);

            ModelUnquant.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            float[] confidences = outputFeature0.getFloatArray();
            int maxPos = 0;
            float maxConfidence = 0;
            for (int i = 0; i < confidences.length; i++) {
                if (confidences[i] > maxConfidence) {
                    maxConfidence = confidences[i];
                    maxPos = i;
                }
            }

            String[] classes = {"Organic Waste", "Environmental Waste", "Plastic Type Waste", "Glass Type Waste", "Packaging Boxes", "Batteries", "Electronic Devices", "Plastic Bottles", "Paper Type Waste" , "Aluminum Type Waste", "Unknown Object"} /**/;
            String detectedObject = classes[maxPos];

            // Check if confidence is below 93%
            if (maxConfidence <= 0.93f) {
                // Show a "Can't classify" message if confidence is low
                detectedObject = "Unknown";
            }

            showBottomSheet(detectedObject, maxConfidence);

            String s = "";
            for (int i = 0; i < classes.length; i++) {
                s += String.format("%s: %.1f%%\n", classes[i], confidences[i] * 100);
            }

            // Print the result to the console log
            Log.d("ClassificationResult", s);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String classifyObject(String detectedObject, boolean isEnglish, ImageView wasteIcon) {
        // Classify the detected object into categories
        if (!isEnglish){
            switch (detectedObject) {
                case "Glass Type Waste":
                case "Plastic Type Waste":
                    wasteIcon.setImageResource(R.drawable.icon_nonbiodegradable);
                    return "Non-Biodegradable";

                case "Environmental Waste":
                case "Organic Waste":
                    wasteIcon.setImageResource(R.drawable.icon_biodegradable);
                    return "Biodegradable";

                case "Packaging Boxes":
                case "Paper Type Waste":
                case "Plastic Bottles":
                case "Aluminum Type Waste":
                    wasteIcon.setImageResource(R.drawable.icon_recylable);
                    return "Recyclable Waste";

                case "Batteries":
                case "Electronic Devices":
                    wasteIcon.setImageResource(R.drawable.icon_ewaste);
                    return "E-Waste";
                case "Unknown Object":

                default:
                    return "Unknown object detected";
            }
        } else {
            switch (detectedObject) {
                case "Glass Type Waste":
                case "Plastic Type Waste":
                    wasteIcon.setImageResource(R.drawable.icon_nonbiodegradable);
                    return "Hindi Nabubulok";

                case "Environmental Waste":
                case "Organic Waste":
                    wasteIcon.setImageResource(R.drawable.icon_biodegradable);
                    return "Nabubulok";

                case "Packaging Boxes":
                case "Paper Type Waste":
                case "Plastic Bottles":
                case "Aluminum Type Waste":
                    wasteIcon.setImageResource(R.drawable.icon_recylable);
                    return "Recyclable Waste";

                case "Batteries":
                case "Electronic Devices":
                    wasteIcon.setImageResource(R.drawable.icon_ewaste);
                    return "E-Waste";

                case "Unknown Object":

                default:
                    return "Hindi ma-klasipika";
            }
        }
    }

    private String wasteName(String detectedObject, boolean isEnglish){
        if (!isEnglish){
            switch (detectedObject) {
                case "Glass Type Waste":
                    return "Glass Type Waste";
                case "Plastic Type Waste":
                    return "Plastic Type Waste";
                case "Environmental Waste":
                    return "Environmental Waste";
                case "Organic Waste":
                    return "Organic Waste";
                case "Packaging Boxes":
                    return "Packaging Boxes";
                case "Paper Type Waste":
                    return "Paper Type Waste";
                case "Plastic Bottles":
                    return "Plastic Bottles";
                case "Aluminum Type Waste":
                    return "Aluminum Type Waste";
                case "Batteries":
                    return "Batteries";
                case "Electronic Devices":
                    return "Electronic Devices";

                case "Unknown Object":
                default:
                    return "Unknown object detected";
            }
        } else {
            switch (detectedObject) {
            case "Glass Type Waste":
                return "Basurang Salamin";
            case "Plastic Type Waste":
                return "Basurang Plastik";
            case "Environmental Waste":
                return "Environmental Waste";
            case "Organic Waste":
                return "Organik na Basura";
            case "Packaging Boxes":
                return "Packaging Boxes";
            case "Paper Type Waste":
                return "Basurang Papel";
            case "Plastic Bottles":
                return "Plastik na Bote";
            case "Aluminum Type Waste":
                return "Basurang Aluminum";
            case "Batteries":
                return "Baterya";
            case "Electronic Devices":
                return "Electronic na Gamit";
            case "Unknown Object":
            default:
                return "Hindi kilala";
            }
        }
    }

    private void showBottomSheet(String detectedObject, float confidence) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_dialog, null);

        bottomSheetDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        DisposalGuideActivity disposalGuideActivity = new DisposalGuideActivity();

        TextView classifiedTextView = bottomSheetView.findViewById(R.id.classified);
        TextView disposalGuideTitleTextView = bottomSheetView.findViewById(R.id.disposalGuideTitle);
        TextView wasteTypeTextView = bottomSheetView.findViewById(R.id.wasteType);
        TextView disposalGuideContentsTextView = bottomSheetView.findViewById(R.id.disposalGuideContents);
        Button takeAnotherPictureButton = bottomSheetView.findViewById(R.id.takeAnotherPictureButton);
        SwitchCompat languageSwitch = bottomSheetView.findViewById(R.id.translateSwitch);
        ImageView wasteTypeIcon = bottomSheetView.findViewById(R.id.wasteTypeIcon);

        // Set initial text for the switch (when OFF - Tagalog, when ON - English)
        //languageSwitch.setText(languageSwitch.isChecked() ? "ENG" : "TAG");

        boolean isEnglish = languageSwitch.isChecked();

        // Function to update the UI based on language
        updateLanguageUI(detectedObject, isEnglish, wasteTypeTextView, wasteTypeIcon, classifiedTextView, disposalGuideTitleTextView, disposalGuideContentsTextView, disposalGuideActivity);

        // Set up language toggle functionality
        languageSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Update language setting in DisposalGuideActivity
            disposalGuideActivity.toggleLanguage();

            // Update the language preference
            updateLanguageUI(detectedObject, isChecked, wasteTypeTextView, wasteTypeIcon, classifiedTextView, disposalGuideTitleTextView, disposalGuideContentsTextView, disposalGuideActivity);

            // Update the switch's text
            //languageSwitch.setText(isChecked ? "ENG" : "TAG");

            if (!isChecked) {
                takeAnotherPictureButton.setText("Take Another Picture");
            } else {
                takeAnotherPictureButton.setText("Kumuha ng Isa Pang Litrato");
            }
        });

        // Set up click listener for the button
        takeAnotherPictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Relaunch the camera intent
                bottomSheetDialog.dismiss(); // Close the Bottom Sheet dialog
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                intent.putExtra("EXTRA_START_CAMERA", true);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void updateLanguageUI(String detectedObject, boolean isEnglish, TextView wasteTypeTextView, ImageView wasteTypeImageView, TextView classifiedTextView, TextView disposalGuideTitleTextView, TextView disposalGuideContentsTextView, DisposalGuideActivity disposalGuideActivity) {
        String wasteCategory = classifyObject(detectedObject, isEnglish, wasteTypeImageView);
        String disposalGuide = disposalGuideActivity.getGuide(detectedObject);
        String engtag_objectname = wasteName(detectedObject, isEnglish);

        if ("Unknown".equals(detectedObject) || "Unknown Object".equals(detectedObject)) {
            // Update UI for unknown object
            if (!isEnglish) {
                wasteTypeTextView.setText("Can't classify");
                classifiedTextView.setText(engtag_objectname);
                disposalGuideTitleTextView.setText("");
                disposalGuideContentsTextView.setText("");
            } else {
                wasteTypeTextView.setText("Hindi ma-klasipika");
                classifiedTextView.setText(engtag_objectname);
                disposalGuideTitleTextView.setText("");
                disposalGuideContentsTextView.setText("");
            }
        } else {
            // Update UI for classified object
            wasteTypeTextView.setText(wasteCategory);
            classifiedTextView.setText(!isEnglish ? "This is: " + engtag_objectname : "Ito ay: " + engtag_objectname);
            disposalGuideTitleTextView.setText(!isEnglish
                    ? "To properly dispose of " + engtag_objectname + ", follow these steps:"
                    : "Para sa tamang pagtatapon ng " + engtag_objectname + ", sundin ang mga steps na ito:");
            disposalGuideContentsTextView.setText(disposalGuide);
        }

        // Set the disposal guide contents (ensure it supports both languages)
        disposalGuideContentsTextView.setText(disposalGuide);
    }

    /*
    // Handle the result of the new picture taken
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data != null) {
            // Get the image from the camera
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            // Update the imageView to show the new picture
            imageView.setImageBitmap(imageBitmap);

            // Classify the new image
            classifyImage(imageBitmap);
        }
    }*/

    // In ResultActivity.java

    /**@Override
    public void onBackPressed() {
        // Navigate to MainActivity (Home)
        super.onBackPressed();
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        // Finish the current activity
        finish();
    }**/

}
