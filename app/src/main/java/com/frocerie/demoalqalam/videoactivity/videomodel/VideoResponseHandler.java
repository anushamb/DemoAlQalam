package com.frocerie.demoalqalam.videoactivity.videomodel;

import android.text.TextUtils;

import com.frocerie.demoalqalam.gall_youtube.YouTubeDetailsModel;
import com.google.gson.Gson;

/**
 * Created by avocet on 24/07/17.
 */

public class VideoResponseHandler {


    public static VideoDetailsModel getVideoListDetails(String response){


        if (TextUtils.isEmpty(response)){
            return null;
        }
        try {
            return new Gson().fromJson(response,VideoDetailsModel.class);
        }catch (Throwable e){
            e.printStackTrace();
            return null;
        }
    }


    public static YouTubeDetailsModel getYouTubeListDetails(String response){


        if (TextUtils.isEmpty(response)){
            return null;
        }
        try {
            return new Gson().fromJson(response,YouTubeDetailsModel.class);
        }catch (Throwable e){
            e.printStackTrace();
            return null;
        }
    }



}
