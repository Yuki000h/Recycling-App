package com.example.recyclingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.recyclingapp.Asphalt;
import com.example.recyclingapp.Concrete;
import com.example.recyclingapp.Plaster;


public class ConstructionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_construction);


        CardView asphaltCard = findViewById(R.id.asphalt_card);
        asphaltCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConstructionActivity.this, Asphalt.class);
                startActivity(intent);
            }
        });

        CardView plasterCard = findViewById(R.id.plaster_card);
        plasterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConstructionActivity.this, Plaster.class);
                startActivity(intent);
            }
        });

        CardView concreteCard = findViewById(R.id.concrete_card);
        concreteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConstructionActivity.this, Concrete.class);
                startActivity(intent);
            }
        });


    }
}