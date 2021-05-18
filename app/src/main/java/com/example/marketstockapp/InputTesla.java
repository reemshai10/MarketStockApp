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


public class InputTesla extends AppCompatActivity {


    public  int n = 0;
    public int price = 0;
    public Button back,ButtonSend;
    public  TextView TextViewUser,GameMoneyText;
    public  EditText EditTextUser;
    public String UpdateMoney ;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference AmountRef = mRootRef.child("AmountTesla");
    DatabaseReference TeslaRefOne = mRootRef.child("tesla");
    DatabaseReference GameMoneyRef = mRootRef.child("GameMoney");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);


        EditTextUser = findViewById(R.id.editTextUser);
        ButtonSend = findViewById(R.id.buttonSend);
        TextViewUser = findViewById(R.id.textViewUser);
        back = findViewById(R.id.Back);
        GameMoneyText = findViewById(R.id.GameMoneyText);


    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"You Have 10,000 $ To invest . ",Toast.LENGTH_SHORT).show();

        GameMoneyRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Number = snapshot.getValue(String.class);
                UpdateMoney = Number;
                GameMoneyText.setText(Number + "$");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Hey", "Failed to read app Game Money value.", error.toException());
            }
        });
        AmountRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Number = snapshot.getValue(String.class);
                int num1 = Integer.parseInt(Number);
                n = num1;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Hey", "Failed to read app Amount value.", error.toException());
            }
        });
        TeslaRefOne.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Number = snapshot.getValue(String.class);
                Double num1 = Double.parseDouble(Number);
                int num2 = num1.intValue();
                price = num2;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Hey", "Failed to read app Amount value.", error.toException());
            }
        });



        ButtonSend.setOnClickListener(v -> {
            int EditTextStock = Integer.parseInt(EditTextUser.getText().toString());
            int Amount = EditTextStock*price;
            int Check = Integer.parseInt(UpdateMoney);
            if(Amount>Check){
                Toast.makeText(getApplicationContext(),"Cant Buy More Then 10,000 $ ",Toast.LENGTH_SHORT).show();
            }
            else {
                int sum = n + EditTextStock;

                String ValueOfUser = String.valueOf(sum);
                AmountRef.setValue(ValueOfUser);
                TextViewUser.setText("success to Buy " + EditTextStock + " " + "stocks");
                Update(Amount);
            }
        });

        back.setOnClickListener(v -> finish());



    }

    public void Update(int amount) {

        int temp = Integer.parseInt(UpdateMoney);
        temp = temp - amount;
        while (temp > 0) {
            String TempUpdate = String.valueOf(temp);
            GameMoneyRef.setValue(TempUpdate);
            break;
        }

        Toast.makeText(getApplicationContext(), "Cant Buy More Then 10,000 $ ", Toast.LENGTH_SHORT).show();

    }


}