package com.example.dogapp20.UserSide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.dogapp20.MainActivity;
import com.example.dogapp20.R;
import com.example.dogapp20.commonClasses.SharedData;

public class LogOut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedData sharedData = new SharedData(getApplicationContext());
        sharedData.clearSharedPreferences();
        Intent in = new Intent(LogOut.this, MainActivity.class);
        startActivity(in);
    }
}
