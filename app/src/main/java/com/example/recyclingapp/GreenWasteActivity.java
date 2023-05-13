package com.example.recyclingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.recyclingapp.Eggshells;
import com.example.recyclingapp.Fruits;
import com.example.recyclingapp.NailClippings;

public class GreenWasteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_waste);

        CardView nailclippingsCard = findViewById(R.id.nail_card);
        nailclippingsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GreenWasteActivity.this, NailClippings.class);
                startActivity(intent);
            }
        });

        CardView eggshellsCard = findViewById(R.id.eggshells_card);
        eggshellsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GreenWasteActivity.this, Eggshells.class);
                startActivity(intent);
            }
        });

        CardView fruitsCard = findViewById(R.id.fruits_card);
        fruitsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GreenWasteActivity.this, Fruits.class);
                startActivity(intent);
            }
        });
    }
}