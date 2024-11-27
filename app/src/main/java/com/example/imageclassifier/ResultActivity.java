package com.example.imageclassifier;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.imageclassifier.ml.ModelUnquant;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.IOException;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ResultActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView result;
    private int imageSize = 224; // adjust this based on your model's input size

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
                    byteBuffer.putFloat(((val >> 16) & 0xFF) * (1.f / 255.f));
                    byteBuffer.putFloat(((val >> 8) & 0xFF) * (1.f / 255.f));
                    byteBuffer.putFloat((val & 0xFF) * (1.f / 255.f));
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

            String[] classes = {"Plastic Cups", "Papers", "Batteries", "Fruits", "Flammable", "Wood", "Aluminum", "Animal", "EcoBag", "Plastic Bag", "Organic Waste", "Face Masks", "Chemicals", "Juice Packs", "Leaves", "Books", "Clothes"};
            String detectedObject = classes[maxPos];

            showBottomSheet(detectedObject, maxConfidence);

            model.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String classifyObject(String detectedObject) {
        // Classify the detected object into categories
        switch (detectedObject) {
            case "Plastic Cups":
            case "Plastic Bag":
            case "EcoBag":
            case "Aluminum":
            case "Juice Packs":
                return "Non-Biodegradable";
            case "Papers":
            case "Leaves":
            case "Fruits":
            case "Wood":
            case "Organic Waste":
                return "Biodegradable";
            case "Batteries":
            case "Chemicals":
            case "Face Masks":
                return "Hazardous";
            case "Books":
            case "Clothes":
                return "Non-Biodegradable";
            case "Animal":
                return "Non-Biodegradable";
            default:
                return "Unknown";
        }
    }

    private void showBottomSheet(String detectedObject, float confidence) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_dialog, null);

        TextView classifiedTextView = bottomSheetView.findViewById(R.id.classified);
        TextView disposeGuideTextView = bottomSheetView.findViewById(R.id.disposeGuide);
        TextView wasteTypeTextView = bottomSheetView.findViewById(R.id.wasteType);

        String wasteCategory = classifyObject(detectedObject);

        wasteTypeTextView.setText(wasteCategory);
        classifiedTextView.setText("This is: " + detectedObject);
        classifiedTextView.setText("This is: " + detectedObject);
        disposeGuideTextView.setText("To proper dispose of " + detectedObject + ", follow these steps:");

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

}
