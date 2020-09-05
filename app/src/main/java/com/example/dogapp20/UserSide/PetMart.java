package com.example.dogapp20.UserSide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dogapp20.R;

public class PetMart extends AppCompatActivity {

    CardView registerbreeder,skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_mart);
        registerbreeder = findViewById(R.id.registerbreeder);
        skip = findViewById(R.id.skip);
        registerbreeder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BreederRegister();
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SkipAllPart();
            }
        });
    }

    private void SkipAllPart() {
        Intent in = new Intent(PetMart.this,ProfileBreeder.class);
        startActivity(in);
    }

    private void BreederRegister() {
        Intent in = new Intent(PetMart.this,BreederRegistration.class);
        startActivity(in);
    }
}
