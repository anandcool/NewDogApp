package com.example.dogapp20.UserSide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dogapp20.AdapterClasses.AllDogInfoAdapter;
import com.example.dogapp20.R;

public class AllDogInfo extends AppCompatActivity {

    RecyclerView rv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_dog_info);
        rv1 = findViewById(R.id.rv1);
        rv1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        String[] content={"Pomeranian","Bulldog","German Shepherd","Greyhound","Poodle"};
        rv1.setAdapter(new AllDogInfoAdapter(content));
    }

    }
