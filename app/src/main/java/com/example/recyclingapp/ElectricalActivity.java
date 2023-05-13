package com.example.recyclingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.recyclingapp.DVDs;
import com.example.recyclingapp.HardDrive;
import com.example.recyclingapp.Syringes;

public class ElectricalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrical);

        CardView dvdsCard = findViewById(R.id.dvd_card);
        dvdsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ElectricalActivity.this, DVDs.class);
                startActivity(intent);
            }
        });

        CardView harddrivesCard = findViewById(R.id.harddrives_card);
        harddrivesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ElectricalActivity.this, HardDrive.class);
                startActivity(intent);
            }
        });

        CardView cordCard = findViewById(R.id.cords_card);
        cordCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ElectricalActivity.this, Cords.class);
                startActivity(intent);
            }
        });
    }
}