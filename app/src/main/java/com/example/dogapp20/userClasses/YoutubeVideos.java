package com.example.dogapp20.userClasses;

public class YoutubeVideos {
    String videoUrl;
    public  YoutubeVideos(String videoUrl){

        this.videoUrl = videoUrl;
    }
    public String getVideoUrl()
    {
        return  this.videoUrl;
    }

    public void setVideoUrl(String videoUrl)
    {
        this.videoUrl = videoUrl;
    }
}
