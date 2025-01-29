package com.example.imageclassifier;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class BaseActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageButton openMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        // Set up the toolbar
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }


        drawerLayout = findViewById(R.id.baseLayout);
        openMenuButton = findViewById(R.id.openMenuButton);

        openMenuButton.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    protected void setActivityContent(int layoutId) {
        FrameLayout contentFrame = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(layoutId, contentFrame, true);
    }
}