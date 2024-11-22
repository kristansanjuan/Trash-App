package com.example.imageclassifier;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imageclassifier.ml.ModelUnquant;
import com.google.android.material.navigation.NavigationView;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /*TextView result, confidence;
    ImageView imageView;*/
    ImageButton picture;
    int imageSize = 224;
    DrawerLayout drawerLayout;
    ImageButton openMenu;
    NavigationView navigationView;
    ImageButton closeButton;
    TextView titleArea;
    TextView descriptionArea;
    ImageButton selectedButton = null;

    int[] oldIcon = {
            R.drawable.biodegradable1,
            R.drawable.infectious1,
            R.drawable.hazardous1,
            R.drawable.recyclable1,
            R.drawable.nonbiodegradable1
    };

    int[] buttonColors = {
            R.color.green,
            R.color.orange,
            R.color.red,
            R.color.blue,
            R.color.yellow
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*result = findViewById(R.id.result);
        confidence = findViewById(R.id.confidence);
        imageView = findViewById(R.id.imageView);*/
        picture = findViewById(R.id.cameraButton);
        drawerLayout = findViewById(R.id.mainLayout);
        openMenu = findViewById(R.id.openMenuButton);
        navigationView = findViewById(R.id.navMenu);
        titleArea = findViewById(R.id.titleArea);
        descriptionArea = findViewById(R.id.descriptionArea);

        ImageButton button1 = findViewById(R.id.biodegradableButton);
        ImageButton button2 = findViewById(R.id.infectiousButton);
        ImageButton button3 = findViewById(R.id.hazardousButton);
        ImageButton button4 = findViewById(R.id.recyclableButton);
        ImageButton button5 = findViewById(R.id.nonBiodegradableButton);

        button1.setOnClickListener(view -> onButtonClick(button1, R.drawable.biodegradable2, 0, R.string.biodegradableTitle, R.string.biodegradableDescription));
        button2.setOnClickListener(view -> onButtonClick(button2, R.drawable.infectious2, 1, R.string.infectiousTitle, R.string.infectiousDescription));
        button3.setOnClickListener(view -> onButtonClick(button3, R.drawable.hazardous2, 2, R.string.hazardousTitle, R.string.hazardousDescription));
        button4.setOnClickListener(view -> onButtonClick(button4, R.drawable.recyclable2, 3, R.string.recyclableTitle, R.string.recyclableDescription));
        button5.setOnClickListener(view -> onButtonClick(button5, R.drawable.nonbiodegradable2, 4, R.string.nonBiodegradableTitle, R.string.nonBiodegradableDescription));

        openMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.open();
            }
        });

        View headerView = navigationView.getHeaderView(0);
        closeButton = headerView.findViewById(R.id.closeMenuButton);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.close();
            }
        });

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch camera if we have permission
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, 1);
                } else {
                    //Request camera permission if we don't have it.
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);
                }
            }
        });

        List<ImageButton> wasteButtons = new ArrayList<>();
        wasteButtons.add(findViewById(R.id.biodegradableButton));
        wasteButtons.add(findViewById(R.id.infectiousButton));
        wasteButtons.add(findViewById(R.id.hazardousButton));
        wasteButtons.add(findViewById(R.id.recyclableButton));
        wasteButtons.add(findViewById(R.id.nonBiodegradableButton));

        startCircularAnimation(wasteButtons);
    }

    private void onButtonClick(ImageButton button, int newIcon, int index, int titleId, int descriptionId) {
        if (selectedButton != null && selectedButton != button) {
            revertButtonChanges(selectedButton);
        }
        button.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), buttonColors[index])));
        button.setImageResource(newIcon);
        selectedButton = button;

        displayInfo(titleId, descriptionId);
    }

    private void revertButtonChanges(ImageButton button) {
        int index = getButtonIndex(button);
        if (index != -1) {
            button.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.gray)));
            button.setImageResource(oldIcon[index]);
        }
    }

    private int getButtonIndex(ImageButton button) {
        if (button.getId() == R.id.biodegradableButton) {
            return 0;
        } else if (button.getId() == R.id.infectiousButton) {
            return 1;
        } else if (button.getId() == R.id.hazardousButton) {
            return 2;
        } else if (button.getId() == R.id.recyclableButton) {
            return 3;
        } else if (button.getId() == R.id.nonBiodegradableButton) {
            return 4;
        }
        return -1;
    }

    public void displayInfo(int titleId, int descriptionId) {
        titleArea.setText(getString(titleId));
        descriptionArea.setText(getString(descriptionId));

        titleArea.setVisibility(View.VISIBLE);
        descriptionArea.setVisibility(View.VISIBLE);
    }

    public void startCircularAnimation(List<ImageButton> buttons) {
        ValueAnimator animator = ValueAnimator.ofFloat(0f, 360f);
        animator.setDuration(10000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());

        animator.addUpdateListener(animation -> {
            float angle = (float) animation.getAnimatedValue();

            for (int i = 0; i < buttons.size(); i++) {
                ImageButton button = buttons.get(i);
                float newAngle = (i * 72 + angle) % 360;

                ConstraintLayout.LayoutParams params =
                        (ConstraintLayout.LayoutParams) button.getLayoutParams();
                params.circleAngle = newAngle;
                button.setLayoutParams(params);
            }
        });

        animator.start();
    }

    /*public void classifyImage(Bitmap image) {
        try {
            ModelUnquant model = ModelUnquant.newInstance(getApplicationContext());

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4*imageSize*imageSize*3);
            byteBuffer.order(ByteOrder.nativeOrder());

            int [] intValues = new int[imageSize*imageSize];
            image.getPixels(intValues,0,image.getWidth(),0,0,image.getWidth(),image.getHeight());
            int pixel = 0;
            for(int i = 0; i < imageSize; i++){
                for(int j = 0; j < imageSize; j++){
                    int val = intValues[pixel++]; // RGB
                    byteBuffer.putFloat(((val >> 16) & 0xFF)*(1.f/255.f));
                    byteBuffer.putFloat(((val >> 8) & 0xFF)*(1.f/255.f));
                    byteBuffer.putFloat((val & 0xFF)*(1.f/255.f));
                }
            }

            inputFeature0.loadBuffer(byteBuffer);

            // Runs model inference and gets result.
            ModelUnquant.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            float[] confidences = outputFeature0.getFloatArray();
            int maxPos = 0;
            float maxConfidence = 0;
            for(int i = 0; i < confidences.length; i++){
                if(confidences[i] > maxConfidence){
                    maxConfidence = confidences[i];
                    maxPos = i;
                }
            }

            String[] classes = {"Plastic Cups", "Papers", "Batteries", "Fruits", "Flammable", "Wood", "Aluminum", "Animal", "EcoBag", "Plastic Bag", "Organic Waste", "Face Masks", "Chemicals", "Juice Packs", "Leaves", "Books", "Clothes"};//Class 14 = Face Masks
            String detectedObject = classes[maxPos];
            result.setText(detectedObject);
            
            // Releases model resources if no longer used.
            model.close();
        } catch (IOException e) {
            // TODO Handle the exception
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            int dimension = Math.min(image.getWidth(),image.getHeight());
            image = ThumbnailUtils.extractThumbnail(image,dimension,dimension);
            imageView.setImageBitmap(image);

            image = Bitmap.createScaledBitmap(image,imageSize,imageSize,false);
            classifyImage(image);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }*/
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            int dimension = Math.min(image.getWidth(), image.getHeight());
            image = ThumbnailUtils.extractThumbnail(image, dimension, dimension);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            image.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("image", byteArray);
            startActivity(intent);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}