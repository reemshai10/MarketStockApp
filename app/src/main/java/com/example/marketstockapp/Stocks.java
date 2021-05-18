package com.example.marketstockapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Stocks extends AppCompatActivity {
    ListView listView;
    String[] StocksArray= {"Apple Stock","Amazon Stock", "Google Stock","Tesla Stock"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks);

        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,StocksArray);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = (String) (listView.getItemAtPosition(position));
                Intent intent = new Intent(getApplicationContext(), StockShow.class);
                intent.putExtra("Stock",value);
                startActivity(intent);
            }


        });
    }
}



