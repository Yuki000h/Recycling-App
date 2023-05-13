package com.example.recyclingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.recyclingapp.Bandages;
import com.example.recyclingapp.CultureDishes;
import com.example.recyclingapp.Syringes;

public class MedicalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CardView culturedishesCard = findViewById(R.id.culturedishes_card);
        culturedishesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicalActivity.this, CultureDishes.class);
                startActivity(intent);
            }
        });

        CardView syringesCard = findViewById(R.id.syringe_card);
        syringesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicalActivity.this, Syringes.class);
                startActivity(intent);
            }
        });

        CardView bandagesCard = findViewById(R.id.bandages_card);
        bandagesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicalActivity.this, Bandages.class);
                startActivity(intent);
            }
        });
    }
}