package com.frocerie.demoalqalam.audioactivity;

import android.text.TextUtils;

import com.frocerie.demoalqalam.audioactivity.audiomodel.AudioDetailsModel;
import com.google.gson.Gson;

/**
 * Created by avocet on 24/07/17.
 */

public class AudioResponseHandler {

    public static AudioDetailsModel getAudioDetails(String response){

        if (TextUtils.isEmpty(response)){
            return null;
        }
        try {

            return new Gson().fromJson(response,AudioDetailsModel.class);

        }catch (Throwable e){
            e.printStackTrace();
            return null;
        }
    }



}
