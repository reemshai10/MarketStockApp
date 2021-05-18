package com.example.marketstockapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;

import android.widget.Button;

import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    public TextView apn;
    public TextView an;
    public TextView gn;
    public TextView tn;
    public Button ib, apbb, StockButton, abb, gbb, tbb,about;
    public Button apsb, asb, gsb, tsb;


    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mAppleRef = mRootRef.child("apple");
    DatabaseReference mAmzonRef = mRootRef.child("amazon");
    DatabaseReference mGoogleRef = mRootRef.child("google");
    DatabaseReference mTeslaRef = mRootRef.child("tesla");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        apn = findViewById(R.id.apn);
        an = findViewById(R.id.an);
        gn = findViewById(R.id.gn);
        tn = findViewById(R.id.tn);
        ib = findViewById(R.id.ib);
        apbb = findViewById(R.id.apbb);
        abb = findViewById(R.id.abb);
        gbb = findViewById(R.id.gbb);
        tbb = findViewById(R.id.tbb);
        apsb = findViewById(R.id.apsb);
        asb = findViewById(R.id.asb);
        gsb = findViewById(R.id.gsb);
        tsb = findViewById(R.id.tsb);
        about = findViewById(R.id.AboutButton);
        StockButton = findViewById(R.id.StockButton);


    }

    @Override
    protected void onStart() {
        super.onStart();
        mAppleRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String text = snapshot.getValue(String.class);
                apn.setText(text + "$");


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Hey", "Failed to read app price value.", error.toException());
            }
        });

        mAmzonRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String text = snapshot.getValue(String.class);
                an.setText(text + "$");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Hey", "Failed to read app price value.", error.toException());
            }
        });

        mGoogleRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String text = snapshot.getValue(String.class);
                gn.setText(text + "$");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Hey", "Failed to read app price value.", error.toException());
            }
        });


        mTeslaRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String text = snapshot.getValue(String.class);
                tn.setText(text + "$");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Hey", "Failed to read app price value.", error.toException());
            }
        });


        ib.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InformationActivity.class);
            startActivity(intent);


        });

        apbb.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Input.class);
            startActivity(intent);
        });

        abb.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InputAmzon.class);
            startActivity(intent);
        });

        tbb.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InputTesla.class);
            startActivity(intent);
        });

        gbb.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InputGoogle.class);
            startActivity(intent);
        });

        apsb.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InputSell.class);
            startActivity(intent);
        });

        asb.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InputSellAmzon.class);
            startActivity(intent);
        });

        gsb.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InputSellGoogle.class);
            startActivity(intent);
        });

        tsb.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InputSellTesla.class);
            startActivity(intent);
        });




        StockButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Stocks.class);
            startActivity(intent);
        });

        about.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AboutApp.class);
            startActivity(intent);
        });
    }
}