package com.example.marketstockapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class InputSell extends AppCompatActivity {
    public  int price =0;
    public  int n = 0;
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference AmountRef = mRootRef.child("AmountApple");
    DatabaseReference GameMoneyRef = mRootRef.child("GameMoney");
    DatabaseReference AppleRefOne = mRootRef.child("apple");
    public String UpdateMoney ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_sell);

        EditText EditTextUser = (EditText) findViewById(R.id.editTextUser);
        Button ButtonSend = (Button) findViewById(R.id.buttonSend);
        TextView TextViewUser = (TextView) findViewById(R.id.textViewUser);
        Button back = (Button)  findViewById(R.id.Back);
        TextView MyStock = (TextView) findViewById(R.id.MyStocks);



        AmountRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Number = snapshot.getValue(String.class);
                int num1 = Integer.parseInt(Number);
                n = num1;
                MyStock.setText(Number + " " + "stocks");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Hey", "Failed to read app Amount value.", error.toException());
            }
        });

        GameMoneyRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Number = snapshot.getValue(String.class);
                UpdateMoney = Number;

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Hey", "Failed to read app Game Money value.", error.toException());
            }
        });

        AppleRefOne.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Number = snapshot.getValue(String.class);
                Double num1 = Double.parseDouble(Number);
                int num2 = num1.intValue();
                price = num2;

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Hey", "Failed to read app Game Money value.", error.toException());
            }
        });


        ButtonSend.setOnClickListener(v -> {
            int num1 = Integer.parseInt(EditTextUser.getText().toString());
            if(n-num1<0){
                Toast.makeText(InputSell.this,"Cannot Sell More then " + n + " " + "Stocks!",Toast.LENGTH_LONG).show();
            }
            else {
                int sum = n - num1;
                int Amount = num1* price;
                int tempMoneyBack = Integer.parseInt(UpdateMoney);
                int cal = tempMoneyBack + Amount;
                 String num = String.valueOf(cal);
                String ValueOfUser = String.valueOf(sum);
                AmountRef.setValue(ValueOfUser);
                GameMoneyRef.setValue(num);
                TextViewUser.setText("success to Sell " + num1 + " " + "stocks");
                MyStock.setText(ValueOfUser);
            }

        });



        back.setOnClickListener(v -> finish());

    }


}