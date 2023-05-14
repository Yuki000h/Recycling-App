package com.example.recyclingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        ImageView aiChat = findViewById(R.id.chat_button);
        aiChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, ChatFragment.class);
                startActivity(intent);
            }
        });

        CardView recyclableCard = findViewById(R.id.recyclable_card);
        recyclableCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, RecyclableActivity.class);
                startActivity(intent);
            }
        });

        CardView hazardousCard = findViewById(R.id.hazardous_card);
        hazardousCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, HazardousActivity.class);
                startActivity(intent);
            }
        });

        CardView medicalCard = findViewById(R.id.medical_card);
        medicalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, MedicalActivity.class);
                startActivity(intent);
            }
        });

        CardView electricalCard = findViewById(R.id.electrical_card);
        electricalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, ElectricalActivity.class);
                startActivity(intent);
            }
        });

        CardView constructionCard = findViewById(R.id.construction_card);
        constructionCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, ConstructionActivity.class);
                startActivity(intent);
            }
        });

        CardView greenwasteCard = findViewById(R.id.greenwaste_card);
        greenwasteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, GreenWasteActivity.class);
                startActivity(intent);
            }
        });
    }
}
