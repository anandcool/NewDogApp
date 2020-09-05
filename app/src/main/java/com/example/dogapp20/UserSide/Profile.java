package com.example.dogapp20.UserSide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.dogapp20.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class Profile extends AppCompatActivity {
    CardView training,dogmart,youtubevideo,breedInfo,logout,dogacces,discusspanel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        training = findViewById(R.id.training);
        dogmart = findViewById(R.id.dogmart);
        youtubevideo = findViewById(R.id.youtubevideo);
        breedInfo = findViewById(R.id.breedinfo);
        logout=findViewById(R.id.logout);
        dogacces=findViewById(R.id.dogaccess);
        discusspanel = findViewById(R.id.discusspanel);
        getToken();
        discusspanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ScrollingActivity.class));
            }
        });
        dogacces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2= new Intent(getApplicationContext(),Shop.class);
                startActivity(in2);
            }
        });

        logout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent in1=new Intent(getApplicationContext(),LogOut.class);
                        startActivity(in1);
                    }
                });

        youtubevideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(),PlayVideo.class);
                startActivity(in);
            }
        });
        training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Training();
            }
        });
        dogmart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DogMart();
            }
        });
        breedInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(),BreedInfo.class);
                startActivity(in);
            }
        });
    }

    private void DogMart() {
        Intent in = new Intent(Profile.this, PetMart.class);
        startActivity(in);
    }

    private void Training() {
        Intent in = new Intent(Profile.this,TrainingPacks.class);
        startActivity(in);
    }
    private void getToken(){
        FirebaseMessaging.getInstance().subscribeToTopic("updates");
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                if(task.isSuccessful()){
                    String token = task.getResult().getToken();
                    Toast.makeText(Profile.this, "Token"+token, Toast.LENGTH_SHORT).show();
                    Log.d("21token",token);
                }else{
                    Toast.makeText(Profile.this, "Token not genereateed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

