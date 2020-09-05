package com.example.dogapp20.UserSide;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.dogapp20.R;

import java.util.ArrayList;
import java.util.List;

public class Product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ImageSlider img = findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://image.shutterstock.com/image-photo/dog-collar-leather-pet-accessory-600w-1717150366.jpg", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://image.shutterstock.com/image-photo/belt-on-white-background-260nw-275237957.jpg",ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://www.dog-harness-store.com/images/large/3-rows-spiked-dog-collar-leather-dog-dog_LRG.jpg",ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://assets.petco.com/petco/image/upload/f_auto,q_auto,t_ProductDetail-large/2572002-center-2",ScaleTypes.CENTER_CROP));
        img.setImageList(slideModels,ScaleTypes.FIT);

    }
}