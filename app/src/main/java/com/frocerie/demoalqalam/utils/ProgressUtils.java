package com.frocerie.demoalqalam.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;

/**
 * Created by avocet on 05/07/17.
 */

public class ProgressUtils {

    private ProgressDialog progressDialog;
    private static ProgressUtils progressUtils;

    public static ProgressUtils getInstance(Context context){
        if (progressUtils==null){
            progressUtils=new ProgressUtils(context);
        }
        return progressUtils;
    }

    ProgressUtils(Context context){
        if (context==null){
            return;
        }
        if (progressDialog==null){
            progressDialog=new ProgressDialog(context);
        }
    }

    public void show(String message){
        try {
            if (TextUtils.isEmpty(message)){
                return;
            }
            if (progressDialog!=null){
                progressDialog.setMessage(message);
                progressDialog.show();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    public void cancel(){
        if (progressDialog!=null){
            progressDialog.cancel();
        }
    }
}
