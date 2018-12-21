package com.frocerie.demoalqalam.examhut;

import android.text.TextUtils;

import com.frocerie.demoalqalam.examhut.model.ExamHuModel;
import com.google.gson.Gson;

/**
 * Created by avocet on 14/07/17.
 */

public class ResponseHand {


    public static ExamHuModel getExamModel(String response){

        if (TextUtils.isEmpty(response)){
            return null;
        }
        try{

            return new Gson().fromJson(response,ExamHuModel.class);
        }catch (Throwable e){
            e.printStackTrace();
            return null;
        }

    }



}
