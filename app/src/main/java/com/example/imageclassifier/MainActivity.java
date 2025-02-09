package com.example.imageclassifier;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
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
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.animation.ObjectAnimator;
import android.animation.AnimatorSet;


public class MainActivity extends BaseActivity {

    ImageButton picture;
    DrawerLayout drawerLayout;
    ImageButton openMenu;
    NavigationView navigationView1;
    NavigationView navigationView2;
    ImageButton closeButton;
    TextView titleArea;
    TextView descriptionArea;
    ImageButton selectedButton = null;

    int[] oldIcon = {
            R.drawable.grey_biodegradable,
            R.drawable.grey_recylable,
            R.drawable.grey_ewaste,
            R.drawable.grey_nonbiodegradable
            //R.drawable.infectious1


    };

    /**int[] buttonColors = {
            R.color.green,
            R.color.orange,
            R.color.red,
            R.color.blue,
            R.color.yellow
    };**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityContent(R.layout.activity_main);

        //setContentView(R.layout.activity_main);

        //Toolbar toolbar = findViewById(R.id.toolBar);
        //setSupportActionBar(toolbar);

        picture = findViewById(R.id.cameraButton);
        //drawerLayout = findViewById(R.id.mainLayout);
        //openMenu = findViewById(R.id.openMenuButton);
        //navigationView1 = findViewById(R.id.navMenu1);
        titleArea = findViewById(R.id.titleArea);
        descriptionArea = findViewById(R.id.descriptionArea);
        //navigationView2 = findViewById(R.id.navMenu2);

        ImageButton button1 = findViewById(R.id.biodegradableButton);
        ImageButton button2 = findViewById(R.id.recyclableButton);
        ImageButton button3 = findViewById(R.id.ewasteButton);
        ImageButton button4 = findViewById(R.id.nonBiodegradableButton);
        //ImageButton button2 = findViewById(R.id.infectiousButton);

        button1.setOnClickListener(view -> onButtonClick(button1, R.drawable.color_biodegradable,  R.string.biodegradableTitle, R.string.biodegradableDescription));
        button2.setOnClickListener(view -> onButtonClick(button2, R.drawable.color_recyclable,  R.string.recyclableTitle, R.string.recyclableDescription));
        button3.setOnClickListener(view -> onButtonClick(button3, R.drawable.color_ewaste,  R.string.ewasteTitle, R.string.ewasteDescription));
        button4.setOnClickListener(view -> onButtonClick(button4, R.drawable.color_nonbiodegradable,  R.string.nonBiodegradableTitle, R.string.nonBiodegradableDescription));

        //button2.setOnClickListener(view -> onButtonClick(button2, R.drawable.infectious2, 1, R.string.infectiousTitle, R.string.infectiousDescription));

        //View headerView = navigationView1.getHeaderView(0);
        //closeButton = headerView.findViewById(R.id.closeMenuButton);

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
        wasteButtons.add(findViewById(R.id.recyclableButton));
        wasteButtons.add(findViewById(R.id.ewasteButton));
        wasteButtons.add(findViewById(R.id.nonBiodegradableButton));
        //wasteButtons.add(findViewById(R.id.infectiousButton));


        startCircularAnimation(wasteButtons);
    }

    private void onButtonClick(ImageButton button, int newIcon, int titleId, int descriptionId) {
        if (selectedButton != null && selectedButton != button) {
            revertButtonChanges(selectedButton);
        }
        animateButtonScale(button, 1.10f);

        //button.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), buttonColors[index])));
        button.setImageResource(newIcon);
        selectedButton = button;

        displayInfo(titleId, descriptionId);
    }

    private void revertButtonChanges(ImageButton button) {
        int index = getButtonIndex(button);
        if (index != -1) {
            //button.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.gray)));
            button.setImageResource(oldIcon[index]);
            animateButtonScale(button, 1.0f);
        }
    }

    private void animateButtonScale(View view, float scale) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", scale);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", scale);
        scaleX.setDuration(200);
        scaleY.setDuration(200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleX, scaleY);
        animatorSet.start();
    }

    private int getButtonIndex(ImageButton button) {
        if (button.getId() == R.id.biodegradableButton) {
            return 0;
        } else if (button.getId() == R.id.recyclableButton) {
            return 1;
        } else if (button.getId() == R.id.ewasteButton) {
            return 2;
        } else if (button.getId() == R.id.nonBiodegradableButton) {
            return 3;
        }
        //} else if (button.getId() == R.id.infectiousButton) {
        //    return 1;
        return -1;
    }

    public void displayInfo(int titleId, int descriptionId) {
        String newTitle = getString(titleId);
        String newDescription = getString(descriptionId);

        // Check if the text is already set to prevent re-animating
        if (!titleArea.getText().toString().equals(newTitle)) {
            titleArea.setText(newTitle);
            animateText(titleArea);
        }

        if (!descriptionArea.getText().toString().equals(newDescription)) {
            descriptionArea.setText(newDescription);
            animateText(descriptionArea);
        }

        titleArea.setVisibility(View.VISIBLE);
        descriptionArea.setVisibility(View.VISIBLE);
    }


    private void animateText(View view) {
        view.setAlpha(0f);
        view.setTranslationY(20f);

        view.animate()
                .alpha(1f)
                .translationY(0f)
                .setDuration(500)
                .setInterpolator(new LinearInterpolator())
                .start();
    }


    public void startCircularAnimation(List<ImageButton> buttons) {
        ValueAnimator animator = ValueAnimator.ofFloat(0f, 360f);
        animator.setDuration(18000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());

        animator.addUpdateListener(animation -> {
            float angle = (float) animation.getAnimatedValue();
            float separationAngle = 360f / buttons.size();

            for (int i = 0; i < buttons.size(); i++) {
                ImageButton button = buttons.get(i);
                float newAngle = (i * separationAngle + angle) % 360;

                ConstraintLayout.LayoutParams params =
                        (ConstraintLayout.LayoutParams) button.getLayoutParams();
                params.circleAngle = newAngle;
                button.setLayoutParams(params);
            }
        });

        animator.start();
    }

    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getExtras() != null) {
            // Retrieve the captured image as a Bitmap
            Bitmap image = (Bitmap) data.getExtras().get("data");

            if (image != null) {
                // Resize the image to match the input size expected by the model (224x224)

                int dimension = Math.min(image.getWidth(), image.getHeight());

                // Crop the image to a square
                image = ThumbnailUtils.extractThumbnail(image, dimension, dimension);

                // Resize the cropped image to the input size expected by the model (e.g., 224x224)
                image = Bitmap.createScaledBitmap(image, 224, 224, false);

                // Compress the resized image into a ByteArray for passing to the next activity
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                image.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                // Pass the resized image to ResultActivity
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("image", byteArray);

                // Use FLAG_ACTIVITY_CLEAR_TOP to clear the previous instances of ResultActivity
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish(); // Close the current instance of ResultActivity to avoid stacking
            } else {
                // Handle the case where the image could not be captured
                showError("Failed to capture image. Please try again.");
            }
        } else {
            // Handle other cases where the operation failed or was cancelled
            showError("No image captured or operation cancelled.");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, you can now use the camera
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 1);
            } else {
                // Permission denied, show a message
                Toast.makeText(this, "Camera permission is required to capture image", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.navHelp) {

            Intent intent = new Intent(MainActivity.this, OnboardingActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}