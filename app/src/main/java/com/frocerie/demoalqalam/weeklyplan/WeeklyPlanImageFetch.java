package com.frocerie.demoalqalam.weeklyplan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.responseHandler.ResponseHandler;
import com.frocerie.demoalqalam.utils.ProgressUtils;
import com.frocerie.demoalqalam.weekimage.WeekImageDetail;
import com.frocerie.demoalqalam.weekimage.WeekImageModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WeeklyPlanImageFetch extends AppCompatActivity {

    private String url = "http://alqalamtrust.com/lession_plan/";

    String tag;

    ImageView touchImageView;

    public static final String TAGGED_KEY="TAGGED_KEY";
    private String TAG="WeekImageActivity";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_plan_image_fetch);

        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        touchImageView = (ImageView) findViewById(R.id.ivWeekTouch);

        touchImageView.setVisibility(View.VISIBLE);

        tag=getIntent().getStringExtra(TAGGED_KEY);
        Log.e(TAG,"IMAGE TAG "+tag);


        imageFecth();




    }

    private void imageFecth() {

        ProgressUtils.getInstance(WeeklyPlanImageFetch.this).show("Loading image");




        StringRequest str = new StringRequest(Request.Method.GET, url+tag, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                Log.e(TAG,"URL"+url+tag);

                try {

                    ProgressUtils.getInstance(WeeklyPlanImageFetch.this).cancel();


                    if (TextUtils.isEmpty(response)) {

                        return;
                    }

                    WeekImageModel weekImageModel = ResponseHandler.getWeekImageDetails(response);

                    if (weekImageModel == null) {
                        return;
                    }

                    if (weekImageModel.getDetails() == null) {
                        return;
                    }

                    List<WeekImageDetail> weekImageDetailList = weekImageModel.getDetails();

                    // weekImageDetail.getImg();

                    if (weekImageDetailList == null && weekImageDetailList.size()>0){
                        return;
                    }

                    WeekImageDetail weekImageDetail=weekImageDetailList.get(0);

                    Picasso.with(WeeklyPlanImageFetch.this)
                            .load(weekImageDetail.getImg().replace("https","http"))
                            .into(touchImageView);

                   /* Picasso.with(WeeklyPlanImageFetch.this)
                            .load(weekImageDetail.getImg())
                            .placeholder(R.drawable.aaaq)
                            .into(new Target() {
                                @Override
                                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

                                    touchImageView.setImageBitmap(bitmap);
                                }

                                @Override
                                public void onBitmapFailed(Drawable errorDrawable) {

                                    Log.d(TAG,"Failed");

                                }

                                @Override
                                public void onPrepareLoad(Drawable placeHolderDrawable) {

                                    touchImageView.setImageDrawable(placeHolderDrawable);

                                }
                            });*/

                    // WeekImageDetail weekImageDetail = new WeekImageDetail().getImg().toString().replace("https","http");


                } catch (Throwable e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                ProgressUtils.getInstance(WeeklyPlanImageFetch.this).cancel();
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requQueue = Volley.newRequestQueue(WeeklyPlanImageFetch.this);
        requQueue.add(str);




    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.home) {

            NavUtils.navigateUpFromSameTask(WeeklyPlanImageFetch.this);

        }

        return super.onOptionsItemSelected(item);
    }*/


}
