package com.frocerie.demoalqalam.prayer;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.frocerie.demoalqalam.imagefetch.CommonClass;

import org.json.JSONObject;

/**
 * Created by avocet on 19/07/17.
 */

public class RequestClass {


    public static VolleyResponse volleyResponse;

    public static void callgetMethod(String url, Context context){
        volleyResponse=(VolleyResponse)context;
        CommonRequestClass.progressBarCall("Loading...",context);
        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        CommonRequestClass.closeProgressBar();
                        // the response is already constructed as a JSONObject!
                        try {
                              /*if (TextUtils.isEmpty((CharSequence) response)){

                                  return;
                              }*/

                            volleyResponse.success(response);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        CommonClass.closeProgressBar();
                        volleyResponse.error(error.getMessage());
                    }
                });

        Volley.newRequestQueue(context).add(jsonRequest);
    }





}
