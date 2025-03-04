package com.example.imageclassifier;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseActivity extends AppCompatActivity {

    private static final String CURRENT_VERSION = "1.0.2";

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
        //NavigationView navigationView2 = findViewById(R.id.navMenu2);

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
                if(!(this instanceof KnowledgeActivity)){
                    startActivity(new Intent(this, HelpActivity.class));
                }
            } else if (item.getItemId() == R.id.navAbout) {
                if(!(this instanceof AboutActivity)){
                    startActivity(new Intent(this, AboutActivity.class));
                }
                //} else if (item.getItemId() == R.id.navUpdateApp) {
                //    checkForUpdate();
            } else if (item.getItemId() == R.id.navExit) {
                finishAffinity();
                System.exit(0);
            } else {
                return false;
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
        
        /*navigationView2.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navAbout) {
                if(!(this instanceof AboutActivity)){
                    startActivity(new Intent(this, AboutActivity.class));
                }
            //} else if (item.getItemId() == R.id.navUpdateApp) {
            //    checkForUpdate();
            } else if (item.getItemId() == R.id.navExit) {
                finishAffinity();
                System.exit(0);
            } else {
                return false;
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });*/
    }

    private void checkForUpdate() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kristansanjuan/")  // GitHub base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VersionAPI versionAPI = retrofit.create(VersionAPI.class);
        Call<VersionResponse> call = versionAPI.getVersion();

        call.enqueue(new Callback<VersionResponse>() {
            @Override
            public void onResponse(Call<VersionResponse> call, Response<VersionResponse> response) {
                if (response.isSuccessful()) {
                    VersionResponse versionResponse = response.body();
                    if (versionResponse != null && !versionResponse.getVersion().equals(CURRENT_VERSION)) {
                        showUpdateDialog(versionResponse.getUrl());
                    }
                }
            }

            @Override
            public void onFailure(Call<VersionResponse> call, Throwable t) {
                Toast.makeText(BaseActivity.this, "Failed to check for updates", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showUpdateDialog(String downloadUrl) {
        new AlertDialog.Builder(this)
                .setTitle("Update Available")
                .setMessage("A new version of the app is available. Do you want to update?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(downloadUrl));
                        startActivity(browserIntent);
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    protected void setActivityContent(int layoutId) {
        FrameLayout contentFrame = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(layoutId, contentFrame, true);
    }
}