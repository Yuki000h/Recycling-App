package com.example.recyclingapp;

import
        androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.recyclingapp.MetalCans;
import com.example.recyclingapp.Paper;
import com.example.recyclingapp.PlasticBottles;

public class RecyclableActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclable);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        CardView recyclableCard = findViewById(R.id.plasticbttl_card);
        recyclableCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclableActivity.this, PlasticBottles.class);
                startActivity(intent);
            }
        });

        CardView metalcanCard = findViewById(R.id.metalcans_card);
        metalcanCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclableActivity.this, MetalCans.class);
                startActivity(intent);
            }
        });

        CardView paperCard = findViewById(R.id.paper_card);
        paperCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclableActivity.this, Paper.class);
                startActivity(intent);
            }
        });

        CardView glassjarCard = findViewById(R.id.glassjars_card);
        glassjarCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclableActivity.this, GlassJar.class);
                startActivity(intent);
            }
        });

        CardView papercardboardCard = findViewById(R.id.papercardboard_card);
        papercardboardCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclableActivity.this, PaperCardboards.class);
                startActivity(intent);
            }
        });



    }
}