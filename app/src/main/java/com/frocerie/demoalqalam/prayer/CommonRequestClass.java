package com.frocerie.demoalqalam.prayer;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by avocet on 19/07/17.
 */

public class CommonRequestClass {

    public static ProgressDialog progressBar;
    public static void progressBarCall(String Msg,Context context){
        progressBar=new ProgressDialog(context);
        progressBar.setMessage(Msg);
        progressBar.setCanceledOnTouchOutside(true);
        progressBar.show();
    }

    public static void closeProgressBar(){
        if (progressBar!=null)
            progressBar.hide();
    }


}
