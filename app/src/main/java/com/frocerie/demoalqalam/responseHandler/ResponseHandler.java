package com.frocerie.demoalqalam.responseHandler;

import android.text.TextUtils;

import com.frocerie.demoalqalam.audioquran.audioquranmodel.AudioQuranModel;
import com.frocerie.demoalqalam.model.PDFModel;
import com.frocerie.demoalqalam.model.WeekListSubModel;
import com.frocerie.demoalqalam.model.WeeklyListModel;
import com.frocerie.demoalqalam.weekimage.WeekImageModel;
import com.google.gson.Gson;

/**
 * Created by avocet on 05/07/17.
 */

public class ResponseHandler {

    public static WeeklyListModel getWeekDetails(String response){

        if (TextUtils.isEmpty(response)) {
            return null;
        }
        try {
            return new Gson().fromJson(response, WeeklyListModel.class);

        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }


    public static PDFModel getPdfModel(String response){
        if (TextUtils.isEmpty(response)) {
            return null;
        }
        try {
            return new Gson().fromJson(response, PDFModel.class);

        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }


    public static WeekListSubModel weeklyListSubModel(String response){

        if (TextUtils.isEmpty(response)){
            return null;
        }

        try {
            return new Gson().fromJson(response, WeekListSubModel.class);

        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }


    }

    public static AudioQuranModel getAudioQuranDetails(String reponse){

        if (TextUtils.isEmpty(reponse)){
            return null;
        }
        try {
            {

                return new Gson().fromJson(reponse,AudioQuranModel.class);
            }
        }catch (Throwable e){
            e.printStackTrace();
            return null;
        }
    }


    public static WeekImageModel getWeekImageDetails(String reponse){

        if (TextUtils.isEmpty(reponse)){
            return null;
        }
        try {
            {

                return new Gson().fromJson(reponse,WeekImageModel.class);
            }
        }catch (Throwable e){
            e.printStackTrace();
            return null;
        }
    }






}
