package com.example.marketstockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class AboutApp extends AppCompatActivity {
    public Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

        back = findViewById(R.id.button4);
        back.setOnClickListener(v -> finish());
    }
}