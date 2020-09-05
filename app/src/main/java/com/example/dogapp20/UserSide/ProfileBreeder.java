package com.example.dogapp20.UserSide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dogapp20.R;

public class ProfileBreeder extends AppCompatActivity {

    CardView c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_breeder);
        c1 = findViewById(R.id.alldogshows);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ProfileBreeder.this,AllDogInfo.class);
                startActivity(in);
            }
        });
    }
}
