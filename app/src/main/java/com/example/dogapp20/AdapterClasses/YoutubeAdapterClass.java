package com.example.dogapp20.AdapterClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogapp20.R;
import com.example.dogapp20.userClasses.YoutubeVideos;

import java.util.List;

public class YoutubeAdapterClass extends RecyclerView.Adapter<YoutubeAdapterClass.VideoViewHolder> {
    List<YoutubeVideos> youtubeVideosList;

    public YoutubeAdapterClass(List<YoutubeVideos> youtubeVideosList){
        this.youtubeVideosList = youtubeVideosList;
    }

    @NonNull
    @Override
    public YoutubeAdapterClass.VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.youtube_video,parent,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeAdapterClass.VideoViewHolder holder, int position) {
        holder.videoweb.loadData(youtubeVideosList.get(position).getVideoUrl(),"text/html","utf-8");
    }

    @Override
    public int getItemCount() {
        return youtubeVideosList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        WebView videoweb;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoweb = itemView.findViewById(R.id.videowebview);
            videoweb.getSettings().setJavaScriptEnabled(true);
            videoweb.setWebChromeClient(new WebChromeClient(){});
        }
    }
}