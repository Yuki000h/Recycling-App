package com.example.recyclingapp;

import android.app.Activity;
import android.os.Bundle;

public class Aerosol extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aerosol);

        getActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
