package com.frocerie.demoalqalam.videoactivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.utils.ProgressUtils;
import com.frocerie.demoalqalam.videoactivity.videomodel.VideoDetail;
import com.frocerie.demoalqalam.videoactivity.videomodel.VideoDetailsModel;
import com.frocerie.demoalqalam.videoactivity.videomodel.VideoResponseHandler;

import java.util.ArrayList;

public class ListVideoActivity extends AppCompatActivity  {

    private final String url_video = "http://alqalamtrust.com/nasheed/video";

    TextView tvVideoName;
    private RecyclerView recyclerView;
    private VideoListAdapter videoListAdapter;
    private ArrayList<VideoDetail> videoDetailsArrayList = new ArrayList<>();
    VideoView videoView;
    String videoURL;
    MediaController mediaController;
    private static final int RECOVERY_REQUEST = 1;

    Animation animationFade;

    // ProgressDialog mDialog;

    //ImageButton btnPlayPause;

    //String tag;
    //String videoURL = "http://alqalamtrust.com/image/nasheed/1499427629.mp4";









    private View.OnClickListener videoItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            int pos = 0;
            pos = (Integer) view.getTag(); //.toString();

            Log.d("Test","Video :"+pos);
            VideoDetail videoDetail = videoListAdapter.videoDetailArrayList.get(pos);

            if (videoDetail == null){
                return;
            }

            String videoName = videoDetail.getFileName();

            if (videoName.indexOf(".")>0)

                videoName = videoName.substring(0,videoName.lastIndexOf("."));



            tvVideoName.setText(videoName);
            tvVideoName.setAnimation(animationFade);
            videoURL = videoDetail.getFilePath();
            videoPlay(view);



            //videoURL  =   view.getTag().toString();





        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_video);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tvVideoName = (TextView) findViewById(R.id.tvVideoName);
        animationFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_animation);

        setVideo();


        setAdapter();

        loadRequestList();



    }



    private void setVideo() {

        videoView = (VideoView) findViewById(R.id.videoView1);

        mediaController = new MediaController(this);

        //btnPlayPause = (ImageButton) findViewById(R.id.btn_play_pause);
        //btnPlayPause.setOnClickListener(ListVideoActivity.this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        if(id == R.id.home){

            NavUtils.navigateUpFromSameTask(ListVideoActivity.this);

        }

        return super.onOptionsItemSelected(item);
    }


    private void loadRequestList() {

        if (isNetworkAvailable()) {

            ProgressUtils.getInstance(this).show("Loding Video List........");

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url_video, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        ProgressUtils.getInstance(ListVideoActivity.this).cancel();

                        if (TextUtils.isEmpty(response)) {
                            return;
                        }
                        VideoDetailsModel videoDetailsModel = VideoResponseHandler.getVideoListDetails(response);
                        // System.out.println("printing Data of video"+videoDetailsModel.getDetails());
                        if (videoDetailsModel == null) {

                            return;
                        }

                        if (videoDetailsModel.getDetails() == null || videoDetailsModel.getDetails().size()<=0) {

                            return;
                        }
                        //System.out.println("printing list3\n");

                        videoListAdapter.setVideoList((ArrayList<VideoDetail>) videoDetailsModel.getDetails());
                        //System.out.println("printing list video\n");

                    } catch (Throwable e) {
                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    ProgressUtils.getInstance(ListVideoActivity.this).cancel();
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG);


                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(ListVideoActivity.this);
            requestQueue.add(stringRequest);
        }else{

            builderDialog(ListVideoActivity.this).show();

        }
    }

    private AlertDialog.Builder builderDialog(ListVideoActivity listVideoActivity) {

        AlertDialog.Builder builder = new AlertDialog.Builder(listVideoActivity);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You Need To Have Mobile Data or Wifi to access this. Press OK to Exit");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startActivity(new Intent(ListVideoActivity.this,VideoAudioActivity.class));

                //finish();
            }
        });

        return builder;

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activityNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activityNetworkInfo != null && activityNetworkInfo.isConnected();
    }

    private void setAdapter() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerVideo);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        videoListAdapter = new VideoListAdapter(videoDetailsArrayList,videoItemClickListener);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(videoListAdapter);



    }


    //when the button is clicked logic to play a video

    public void videoPlay(View view){

        //videoURL  =   view.getTag().toString();

        Uri uri = Uri.parse(videoURL);
        videoView.setVideoURI(uri);

        //Useing MediaController for videoview
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();

    }







 /*   @Override
    public void onClick(View view) {

        parseUri();


    }*/

/*    private void parseUri() {

        mDialog = new ProgressDialog(ListVideoActivity.this);
        mDialog.setMessage("Loading.....");
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();
        try {

            if (!videoView.isPlaying()) {

                Uri uri = Uri.parse(videoURL);
                videoView.setVideoURI(uri);
                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {

                        btnPlayPause.setImageResource(R.drawable.ic_play);


                    }
                });


            } else {

                videoView.pause();
                btnPlayPause.setImageResource(R.drawable.ic_play);
            }


        } catch (Exception ex) {

        }


        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {

                mDialog.dismiss();
                mediaPlayer.setLooping(true);
                videoView.start();
                //btnPlayPause.setImageResource(R.drawable.ic_pause);

            }
        });





    }*/
}
