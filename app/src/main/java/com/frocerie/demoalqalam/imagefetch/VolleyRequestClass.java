package com.frocerie.demoalqalam.imagefetch;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.frocerie.demoalqalam.prayer.VolleyResponse;

import org.json.JSONObject;

/**
 * Created by avocet on 06/07/17.
 */

public class VolleyRequestClass {

      public static String BaseUrl = "http://alqalamtrust.com/exam_hut/Time_table/";
      public static VolleyResponse volleyResponse;

      public static void callGetMethod(String url, Context context){

          volleyResponse = (VolleyResponse)context;
          CommonClass.progressBarcall("Loading.....",context);
          JsonObjectRequest jsonRequest = new JsonObjectRequest(
                  Request.Method.GET,
                  url, null,
                  new Response.Listener<JSONObject>() {
                      @Override
                      public void onResponse(JSONObject response) {

                          CommonClass.closeProgressBar();

                          try {

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
