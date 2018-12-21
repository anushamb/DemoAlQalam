package com.frocerie.demoalqalam.gall_youtube;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.frocerie.demoalqalam.PlayerConfig;
import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.main_activity.FrontPage;
import com.frocerie.demoalqalam.utils.ProgressUtils;
import com.frocerie.demoalqalam.videoactivity.videomodel.VideoResponseHandler;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class GallYouTubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {


    //private final String  url_YouTube= "http://alqalamtrust.com/nasheed/video";

    private final String  url_YouTube= "http://alqalamtrust.com/youtube_url";

    RecyclerView recyclerView;
    YouTubePlayer youTubePlayer;

    private TextView videoHead;

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubevie;

    String youTubeURL;

    Animation animationFade;

    private YouTubeListAdapter gallYouTubeAdapter;
    private ArrayList<YouTubeDetails> youTubeDeatailsArrayList = new ArrayList<>();



    //...Animation animation = AnimationUtils.loadAnimation(GallYouTubeActivity.this,R.anim.move_animation);


    private View.OnClickListener youTubeItenClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            int pos = 0;
            pos = (Integer)view.getTag();

            YouTubeDetails youTubeDetails = gallYouTubeAdapter.youTubeDetailsArrayList.get(pos);
            if (youTubeDetails == null){

                return;
            }
            videoHead.setText(youTubeDetails.getTitle());
            videoHead.setAnimation(animationFade);
            //..working.long text..videoHead.setSelected(true);
            //.......videoHead.startAnimation(animation);
            youTubeURL = youTubeDetails.getLink();

            setYouTubeUrl();




           // youTubeURL = view.getTag().toString();

           // setYouTubeUrl();




        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gall_you_tube);

        videoHead = (TextView) findViewById(R.id.videoHead);
        animationFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_animation);

        //videoHead.setEllipsize(TextUtils.TruncateAt.MARQUEE);

        //videoHead.startAnimation(animation);

        setRecyclerView();

        loadYouTubeData();

        initYouTube();



    }



    private void initYouTube() {


        youTubevie = (YouTubePlayerView) findViewById(R.id.youtube_view);

        youTubevie.initialize(PlayerConfig.API_KEY,GallYouTubeActivity.this);


    }

    private void setRecyclerView() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler_gall);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(GallYouTubeActivity.this);
        gallYouTubeAdapter = new YouTubeListAdapter(youTubeDeatailsArrayList,youTubeItenClickListener);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(gallYouTubeAdapter);
    }


    private void loadYouTubeData() {

        if (isNetworkAvailable()){

            ProgressUtils.getInstance(GallYouTubeActivity.this).show("Loading YouTube File Name....");

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_YouTube, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    ProgressUtils.getInstance(GallYouTubeActivity.this).cancel();

                    if (TextUtils.isEmpty(response)) {
                        return;
                    }

                    YouTubeDetailsModel youTubeDeatailModel = VideoResponseHandler.getYouTubeListDetails(response);

                    if (youTubeDeatailModel == null) {
                        return;
                    }

                    /*if (youTubeDeatailModel.getDetails() == null ){*/

                    if (youTubeDeatailModel.getDetails() == null || youTubeDeatailModel.getDetails().size()<=0) {
                        return;
                    }

                    gallYouTubeAdapter.setYouTubeList((ArrayList<YouTubeDetails>) youTubeDeatailModel.getDetails());


                } catch (Throwable e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                ProgressUtils.getInstance(GallYouTubeActivity.this).cancel();
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });

        RequestQueue rq = Volley.newRequestQueue(GallYouTubeActivity.this);
        rq.add(stringRequest);


    }else{

            builderDialog(GallYouTubeActivity.this).show();
        }
    }

    private AlertDialog.Builder builderDialog(GallYouTubeActivity gallYouTubeActivity) {

        AlertDialog.Builder builder = new AlertDialog.Builder(gallYouTubeActivity);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You Need To Have Mobile Data Or WIFI To Access .Pess OK To Exit");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startActivity(new Intent(GallYouTubeActivity.this, FrontPage.class));

            }
        });

        return builder;


    }

    private boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        
        return networkInfo != null && networkInfo.isConnected();
        
        
        
        
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        this.youTubePlayer = youTubePlayer;

        if(!b) {


            setYouTubeUrl();
        }




    }


    private void setYouTubeUrl() {


              //youTubePlayer.cueVideo("POvG2jlDBPA");

        youTubePlayer.cueVideo(youTubeURL);
//POvG2jlDBPA
        }





    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {

        if(errorReason.isUserRecoverableError()){

            errorReason.getErrorDialog(GallYouTubeActivity.this,RECOVERY_REQUEST).show();

        }else{

            //String error = String.format(getString(R.string.player_error),errorReason.toString());
            //Toast.makeText(Main2Activity.this,error,Toast.LENGTH_SHORT).show();

        }

    }
}
