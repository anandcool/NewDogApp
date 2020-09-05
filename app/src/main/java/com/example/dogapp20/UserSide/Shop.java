package com.example.dogapp20.UserSide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.dogapp20.R;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AppCompatActivity {
LinearLayout dogcollar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        dogcollar = findViewById(R.id.dogcollar);
        ImageSlider img = findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1560743641-3914f2c45636?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=333&q=80",ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1510771463146-e89e6e86560e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=282&q=80",ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1524511751214-b0a384dd9afe?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=667&q=80",ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1507145569372-d69bae8bc9a0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=666&q=80",ScaleTypes.CENTER_CROP));
        img.setImageList(slideModels,ScaleTypes.FIT);
    dogcollar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent in = new Intent(getApplicationContext(),Product.class);
            startActivity(in);
        }
    });
    }
}