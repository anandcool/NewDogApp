package com.example.dogapp20.UserSide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dogapp20.R;

public class BreedInfo extends AppCompatActivity {

    Button breedinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_info);
        breedinfo = findViewById(R.id.bulldog);
        breedinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(),DogInformation.class);
                startActivity(in);
            }
        });
    }
}
