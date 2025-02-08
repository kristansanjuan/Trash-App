package com.example.imageclassifier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class BaseActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageButton openMenuButton;
    ImageButton closeMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

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

        NavigationView navigationView1 = findViewById(R.id.navMenu1);
        NavigationView navigationView2 = findViewById(R.id.navMenu2);

        View headerView = navigationView1.getHeaderView(0);
        closeMenuButton = headerView.findViewById(R.id.closeMenuButton);

        closeMenuButton.setOnClickListener(view -> drawerLayout.closeDrawer(GravityCompat.START));

        navigationView1.setNavigationItemSelectedListener(item -> {

            if (item.getItemId() == R.id.navHome) {
                if(!(this instanceof MainActivity)){
                    startActivity(new Intent(this, MainActivity.class));
                }
            } else if (item.getItemId() == R.id.navKnowledge) {
                if(!(this instanceof KnowledgeActivity)){
                    startActivity(new Intent(this, KnowledgeActivity.class));
                }
            } else if (item.getItemId() == R.id.navHelp) {
                startActivity(new Intent(this, OnboardingActivity.class));
            } else {
                return false;
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
        
        navigationView2.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navAbout) {
                if(!(this instanceof AboutActivity)){
                    startActivity(new Intent(this, AboutActivity.class));
                }
            } else if (item.getItemId() == R.id.navExit) {
                finishAffinity();
                System.exit(0);
            } else {
                return false;
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

    }

    protected void setActivityContent(int layoutId) {
        FrameLayout contentFrame = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(layoutId, contentFrame, true);
    }
}