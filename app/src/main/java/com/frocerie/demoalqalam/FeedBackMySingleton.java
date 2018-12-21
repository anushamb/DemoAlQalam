package com.frocerie.demoalqalam;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by avocet on 21/07/17.
 */

public class FeedBackMySingleton {

    private static FeedBackMySingleton mInstance;

    //Creating the variables for Request queue.....

    private RequestQueue requestQueue;
    private static Context mContext;


    //Need Constructor for this class..

    private FeedBackMySingleton(Context context){

        mContext = context;
        requestQueue = getFeedBackRequest();
    }

    //method to return an Instance of this class....
    public static synchronized FeedBackMySingleton getInstance(Context context){

       if (mInstance == null){

           mInstance = new FeedBackMySingleton(context);
       }

       return mInstance;

    }



    //method to returning the requestqueue....

    public RequestQueue getFeedBackRequest(){

        if (requestQueue == null){

            requestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }

       return requestQueue;

    }


    //Method adding the Request to the requestQueue...
    public <T>void addToRequestQueue(Request<T> request ){

      requestQueue.add(request);
    }



}
