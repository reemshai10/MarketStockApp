package com.example.marketstockapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StockShow extends AppCompatActivity {
    TextView tv;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference AppleAmountRef = mRootRef.child("AmountApple");
    DatabaseReference AmazonAmountRef = mRootRef.child("AmountAmazon");
    DatabaseReference GoogleAmountRef = mRootRef.child("AmountGoogle");
    DatabaseReference TeslaAmountRef = mRootRef.child("AmountTesla");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_show);

        TextView txtProduct = (TextView) findViewById(R.id.textView);


        // getting attached intent data
        String value = getIntent().getStringExtra("Stock");
        switch (value) {
            case "Apple Stock":
                AppleAmountRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String text = snapshot.getValue(String.class);
                        txtProduct.setText("Apple Stock  " + ":" + " " + text);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.e("Hey", "Failed to read app amount value.", error.toException());
                    }
                });
                break;
            case "Amazon Stock":
                AmazonAmountRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String text = snapshot.getValue(String.class);
                        txtProduct.setText("Amazon Stock  " + ":" + " " + text);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.e("Hey", "Failed to read app amount value.", error.toException());
                    }
                });
                break;
            case "Google Stock":
                GoogleAmountRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String text = snapshot.getValue(String.class);
                        txtProduct.setText("Google Stock  " + ":" + " " + text);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.e("Hey", "Failed to read app amount value.", error.toException());
                    }
                });
                break;
            case "Tesla Stock":
               TeslaAmountRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String text = snapshot.getValue(String.class);
                        txtProduct.setText("Tesla Stock  " + ":" + " " + text);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.e("Hey", "Failed to read app amount value.", error.toException());
                    }
                });
                break;


        }
    }
}