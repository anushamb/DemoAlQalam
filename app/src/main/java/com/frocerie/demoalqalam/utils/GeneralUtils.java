package com.frocerie.demoalqalam.utils;

import android.app.Activity;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.text.TextUtils;
import android.util.Log;

import static com.frocerie.demoalqalam.MySingletonLog.TAG;

/**
 * Created by avocet on 05/07/17.
 */

public class GeneralUtils {

    public static void launchUrlUsingChromeTab(Activity activity, String url){

        if (TextUtils.isEmpty(url)){
            Log.e(TAG,"Url is empty");
            return;
        }

        try {
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(activity, Uri.parse(url));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
