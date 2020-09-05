package com.example.dogapp20.UserSide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dogapp20.AdapterClasses.YoutubeAdapterClass;
import com.example.dogapp20.R;
import com.example.dogapp20.userClasses.YoutubeVideos;

import java.util.ArrayList;

public class PlayVideo extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<YoutubeVideos> youtubeVideos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        recyclerView = findViewById(R.id.youtubevideorecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        youtubeVideos.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/YPsDlN7nHwM\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/fjJsoSx4r6A\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/vS1WBB_CErw\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/KxLD1ql135o\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/kLahNSwXvfE\" frameborder=\"0\" allowfullscreen></iframe>"));
        YoutubeAdapterClass YoutubeAdapter = new YoutubeAdapterClass(youtubeVideos);
        recyclerView.setAdapter(YoutubeAdapter);
    }
}
