package com.example.marketstockapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InformationActivity extends AppCompatActivity {
    Button ab,amb,gb,tb,back;
    View view;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        ab = findViewById(R.id.ab);
        amb = findViewById(R.id.amb);
        gb = findViewById(R.id.gb);
        tb = findViewById(R.id.tb);
        back = findViewById(R.id.back);
        view = findViewById(R.id.view);




        ab.setOnClickListener(v -> {
            view.setBackground(getResources().getDrawable(R.drawable.apple));
            Intent viewIntent = new Intent("android.intent.action.VIEW",Uri.parse("https://en.wikipedia.org/wiki/Apple_Inc."));
            startActivity(viewIntent);
        });


        amb.setOnClickListener(v -> {
            view.setBackground(getResources().getDrawable(R.drawable.amazon));
            Intent viewIntent = new Intent("android.intent.action.VIEW",Uri.parse("https://en.wikipedia.org/wiki/Amazon_(company)"));
            startActivity(viewIntent);
        });

        gb.setOnClickListener(v ->{
                view.setBackground(getResources().getDrawable(R.drawable.google));
            Intent viewIntent = new Intent("android.intent.action.VIEW",Uri.parse("https://en.wikipedia.org/wiki/Google"));
            startActivity(viewIntent);
        });


        tb.setOnClickListener(v -> {
            view.setBackground(getResources().getDrawable(R.drawable.tesla));
            Intent viewIntent = new Intent("android.intent.action.VIEW",Uri.parse("https://en.wikipedia.org/wiki/Tesla,_Inc."));
            startActivity(viewIntent);
//
        });



        back.setOnClickListener(v -> finish());



}

}