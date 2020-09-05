package com.example.dogapp20.UserSide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.dogapp20.R;

public class TrainingPacks extends AppCompatActivity {
    CardView basicpack,advancepack,protectionpack,trainingpack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_packs);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);// for shadow show in cardview
        basicpack = findViewById(R.id.basicpack);
        advancepack = findViewById(R.id.advancepack);
        protectionpack = findViewById(R.id.protectionpack);
        trainingpack = findViewById(R.id.trainingpack);
        trainingpack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TrainingPack();
            }
        });
        basicpack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasicPack();
            }
        });
        advancepack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdvanceLevelPack();
            }
        });
        protectionpack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProtectionPack();
            }
        });
    }

    private void TrainingPack() {
        Intent in = new Intent(TrainingPacks.this,ShowTrainingPack.class);
        startActivity(in);
    }

    private void ProtectionPack() {
        Intent in = new Intent(TrainingPacks.this,ProtectionPack.class);
        startActivity(in);
    }

    private void AdvanceLevelPack() {
        Intent in = new Intent(TrainingPacks.this,AdvancedPack.class);
        startActivity(in);
    }

    private void BasicPack() {
        Intent in = new Intent(TrainingPacks.this, BasicPack.class);
        startActivity(in);
    }
}
