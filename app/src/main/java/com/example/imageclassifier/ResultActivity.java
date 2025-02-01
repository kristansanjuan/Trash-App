package com.example.imageclassifier;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.imageclassifier.ml.ModelUnquant;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.IOException;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;
import org.w3c.dom.Text;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import android.util.Log;

public class ResultActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView result;
    private int imageSize = 224;

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        imageView = findViewById(R.id.imageView);

        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap image = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        imageView.setImageBitmap(image);
        classifyImage(image);
    }

    public void classifyImage(Bitmap image) {
        try {
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

            String[] classes = {"Foods", "Plastic Bottle", "Face Masks", "Plastic Utensils", "Syringe"};
            //String[] classes = {"Plastic Cups", "Papers", "Batteries", "Fruits", "Flammable", "Wood", "Aluminum", "Animal", "EcoBag", "Plastic Bag", "Organic Waste", "Face Masks", "Chemicals", "Juice Packs", "Leaves", "Books", "Clothes"};
            String detectedObject = classes[maxPos];

            // Check if confidence is below 35%
            if (maxConfidence <= 0.55f) {
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

            model.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String classifyObject(String detectedObject, boolean isEnglish, ImageView wasteIcon) {
        // Classify the detected object into categories
        if (isEnglish){
            switch (detectedObject) {
                /*case "Glass":
                case "Plastic Type Waste":
                case "Sanitary Napkins":
                case "Styrofoam Type Waste"::*/
                case "Plastic Utensils":
                case "Plastic Bottle":
                    wasteIcon.setImageResource(R.drawable.nonbiodegradable1);
                    return "Non-Biodegradable";
                /*case "Environmental Waste":
                case "Leftover Foods":
                case "Organic Waste":*/
                case "Foods":
                    wasteIcon.setImageResource(R.drawable.biodegradable1);
                    return "Biodegradable";
                /*case "Packaging Boxes":
                case "Papers":
                case "Plastic Bottles":
                    return "Recyclable Waste";
                case "Batteries":
                case "Electronic Devices":
                case "Home Appliances":
                    return "E-Waste";*/
                case "Syringe":
                case "Face Masks":
                    return "Infectious";
                default:
                    return "Can't classify (Confidence too low)";
            }
        } else {
            switch (detectedObject) {
                /*case "Glass":
                case "Plastik na Basura":
                case "Sanitary Napkins":
                case "Styrofoam Type Waste"::*/
                case "Plastic Utensils":
                case "Plastic Bottle":
                    wasteIcon.setImageResource(R.drawable.nonbiodegradable1);
                    return "Hindi Nabubulok";
                /*case "Environmental Waste":
                case "Leftover Foods":
                case "Organic Waste":*/
                case "Foods":
                    wasteIcon.setImageResource(R.drawable.nonbiodegradable1);
                    return "Nabubulok";
                /*case "Packaging Boxes":
                case "Papers":
                case "Plastic Bottles":
                    return "Recyclable Waste";
                case "Baterya":
                case "Electronic Devices":
                case "Home Appliances":
                    return "E-Waste";*/
                case "Syringe":
                case "Face Masks":
                    return "Nakakahawa";
                default:
                    return "Hindi ma-klasipika";
            }
        }
    }

    private void showBottomSheet(String detectedObject, float confidence) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_dialog, null);

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

            if (isChecked) {
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
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(cameraIntent, 1);
                }
                bottomSheetDialog.dismiss(); // Close the Bottom Sheet dialog
            }
        });

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void updateLanguageUI(String detectedObject, boolean isEnglish, TextView wasteTypeTextView, ImageView wasteTypeImageView, TextView classifiedTextView, TextView disposalGuideTitleTextView, TextView disposalGuideContentsTextView, DisposalGuideActivity disposalGuideActivity) {
        String wasteCategory = classifyObject(detectedObject, isEnglish, wasteTypeImageView);
        String disposalGuide = disposalGuideActivity.getGuide(detectedObject);

        if ("Unknown".equals(detectedObject)) {
            // Update UI for unknown object
            if (isEnglish) {
                wasteTypeTextView.setText("Can't classify (Confidence too low)");
                classifiedTextView.setText("This is: " + detectedObject);
                disposalGuideTitleTextView.setText("");
                disposalGuideContentsTextView.setText("");
            } else {
                wasteTypeTextView.setText("Hindi ma-klasipika (Masyadong mababa ang kumpiyansa)");
                classifiedTextView.setText("Ito ay: " + detectedObject);
                disposalGuideTitleTextView.setText("");
                disposalGuideContentsTextView.setText("");
            }
        } else {
            // Update UI for classified object
            wasteTypeTextView.setText(wasteCategory);
            classifiedTextView.setText(isEnglish ? "This is: " + detectedObject : "Ito ay: " + detectedObject);
            disposalGuideTitleTextView.setText(isEnglish
                    ? "To properly dispose of " + detectedObject + ", follow these steps:"
                    : "Para sa tamang pagtatapon ng " + detectedObject + ", sundin ang mga steps na ito:");
            disposalGuideContentsTextView.setText(disposalGuide);
        }

        // Set the disposal guide contents (ensure it supports both languages)
        disposalGuideContentsTextView.setText(disposalGuide);
    }

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
    }

    // In ResultActivity.java

    @Override
    public void onBackPressed() {
        // Navigate to MainActivity (Home)
        super.onBackPressed();
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        // Finish the current activity
        finish();
    }

}
