package com.example.recyclingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.recyclingapp.Aerosol;
import com.example.recyclingapp.Batteries;
import com.example.recyclingapp.Gasoline;


public class HazardousActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hazardous);



        CardView gasolineCard = findViewById(R.id.gasoline_card);
        gasolineCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HazardousActivity.this, Gasoline.class);
                startActivity(intent);
            }
        });

        CardView batteryCard = findViewById(R.id.battery_card);
        batteryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HazardousActivity.this, Batteries.class);
                startActivity(intent);
            }
        });

        CardView aerosolCard = findViewById(R.id.aerosol_card);
        aerosolCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HazardousActivity.this, Aerosol.class);
                startActivity(intent);
            }
        });
    }
}