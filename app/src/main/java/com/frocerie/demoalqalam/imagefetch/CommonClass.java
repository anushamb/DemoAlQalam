package com.frocerie.demoalqalam.imagefetch;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by avocet on 07/07/17.
 */

public class CommonClass {

    public static ProgressDialog progressBar;
    public static void progressBarcall(String Msg, Context context){

        progressBar = new ProgressDialog(context);
        progressBar.setMessage(Msg);
        progressBar.setCanceledOnTouchOutside(true);
        progressBar.show();


    }

    public static void closeProgressBar(){

        if (progressBar!=null){
            progressBar.hide();
        }


    }


}
