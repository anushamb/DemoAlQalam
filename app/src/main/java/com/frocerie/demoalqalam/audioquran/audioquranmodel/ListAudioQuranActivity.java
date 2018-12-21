package com.frocerie.demoalqalam.audioquran.audioquranmodel;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import android.widget.ImageView;
import android.widget.TextView;
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
import com.frocerie.demoalqalam.videoactivity.VideoAudioActivity;

import java.io.IOException;
import java.util.ArrayList;

public class ListAudioQuranActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AudioQuranListAdapter audioQuranListAdapter;
    private ArrayList<AudioQuranDetail> audioQuranDetailsArrayList = new ArrayList<>();

    ImageView playBtn, pauseBtn, rewindBtn, forwordBtn;
    private final String url_audio = "http://alqalamtrust.com/nasheed/audio";

    TextView tv_audio_name;

    int pause;

    String audio_path;

    MediaPlayer mediaPlayer;

    String new_audio_name,audio_name;

    String tagAudio;
    Animation animationFade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_audio_quran);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        playBtn = (ImageView) findViewById(R.id.bt_play);
        pauseBtn = (ImageView) findViewById(R.id.bt_pause);

        rewindBtn = (ImageView) findViewById(R.id.rewind);
        forwordBtn = (ImageView) findViewById(R.id.forward);

        tv_audio_name = (TextView) findViewById(R.id.tvAudioName);
        animationFade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_animation);


        setRecyclerView();
        loadAuideoNames();


    }


    private View.OnClickListener audioItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            // audio_path =view.getTag().toString();
            //audioPath.setText(audio_path);

            //Toast.makeText(getApplicationContext(), "It will take few seconds to play", Toast.LENGTH_SHORT).show();

            /*tagAudio = view.getTag().toString();*/

            int pos = 0;
            pos = (Integer) view.getTag();//.toString();

            Log.d("testK", "Audio33 :" + pos);

            AudioQuranDetail audioQuranDetail = audioQuranListAdapter.audioQuranDetailArrayList.get(pos);

            if (audioQuranDetail == null) {
                return;
            }

            audio_name = audioQuranDetail.getFileName();

            new_audio_name =  audio_name.replaceAll("[0-9]","");

            if (new_audio_name.indexOf(".")>0)

                new_audio_name = new_audio_name.substring(0,new_audio_name.lastIndexOf("."));



           //String   replace_new_audio_name = new_audio_name.replaceAll("",".mp3");



            System.out.println("name:"+new_audio_name);




            //tv_audio_name.setText(replace_new_audio_name);
            tv_audio_name.setText(new_audio_name);
            tv_audio_name.setAnimation(animationFade);
            tagAudio = audioQuranDetail.getFilePath();


            if (pauseBtn.getVisibility() == View.VISIBLE) {

                pauseBtn.setVisibility(View.GONE);
                playBtn.setVisibility(View.VISIBLE);

                if (mediaPlayer != null) {

                    mediaPlayer.stop();
                    mediaPlayer = null;
                }

            }

            if (playBtn.getVisibility() == View.GONE) {

                playBtn.setVisibility(View.VISIBLE);
                pauseBtn.setVisibility(View.GONE);

            } else {


                final ProgressDialog progressDialo = new ProgressDialog(ListAudioQuranActivity.this);
                progressDialo.setMessage("Wait For Few Second's..");
                progressDialo.show();
                progressDialo.setCanceledOnTouchOutside(false);


                //btPlay.setVisibility(View.VISIBLE);
                //Toast.makeText(getApplicationContext(), "It will take few seconds to play", Toast.LENGTH_SHORT).show();
                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(tagAudio);
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {

                            if (!mediaPlayer.isPlaying()) {

                                progressDialo.dismiss();

                            }

                            mediaPlayer.start();
                            playBtn.setVisibility(View.GONE);
                            pauseBtn.setVisibility(View.VISIBLE);

                        }
                    });

                    //mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.prepareAsync();
                //if (mediaPlayer.isPlaying())

                    //Toast.makeText(getApplicationContext(), "It will take few seconds to play", Toast.LENGTH_SHORT).show();
                    //mediaPlayer.start();
                    //playBtn.setVisibility(View.GONE);
                //pauseBtn.setVisibility(View.VISIBLE);
            }
            setAudio();
            Log.d("testK", "Audio11 :" + tagAudio);
            System.out.println("Audio :" + tagAudio);

            if(!mediaPlayer.isPlaying()){

                playBtn.setVisibility(View.VISIBLE);
                pauseBtn.setVisibility(View.GONE);
            }



        }
    };


    private void setRecyclerView() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerAudioList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(ListAudioQuranActivity.this);
        audioQuranListAdapter = new AudioQuranListAdapter(audioQuranDetailsArrayList, audioItemClickListener);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(audioQuranListAdapter);

    }




    private void loadAuideoNames() {
        if (isNetworkAvailable()) {

            ProgressUtils.getInstance(ListAudioQuranActivity.this).show("Loading Audio files....");

            StringRequest str = new StringRequest(Request.Method.GET, url_audio, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {

                        ProgressUtils.getInstance(ListAudioQuranActivity.this).cancel();

                        if (TextUtils.isEmpty(response)) {

                            return;
                        }

                        AudioQuranModel audioQuranModel = ResponseHandler.getAudioQuranDetails(response);
                        if (audioQuranModel == null) {
                            return;
                        }

                        if (audioQuranModel.getDetails() == null || audioQuranModel.getDetails().size()<=0) {
                            return;
                        }
                        audioQuranListAdapter.setAudioQuranList((ArrayList<AudioQuranDetail>) audioQuranModel.getDetails());

                    } catch (Throwable e) {
                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    ProgressUtils.getInstance(ListAudioQuranActivity.this).cancel();
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

            RequestQueue rq = Volley.newRequestQueue(ListAudioQuranActivity.this);
            rq.add(str);

        } else {
            builderDialog(ListAudioQuranActivity.this).show();

        }


    }







    private void setAudio() {

       /* * IF Button Play is Clicked we setting the audio_url
        * and starting the audio
        * making play button as Gone and Puase as Visible.*/

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mediaPlayer == null) {
                    mediaPlayer = new MediaPlayer();

                    try {
                        mediaPlayer.setDataSource(tagAudio);
                        //mediaPlayer.prepare();
                        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                mediaPlayer.start();

                                /*playBtn.setVisibility(View.GONE);
                                pauseBtn.setVisibility(View.VISIBLE);*/
                            }
                        });

                        mediaPlayer.prepareAsync();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    playBtn.setVisibility(View.GONE);
                    pauseBtn.setVisibility(View.VISIBLE);

                } else if (!mediaPlayer.isPlaying()) {

                    mediaPlayer.seekTo(pause);
                    mediaPlayer.start();
                    playBtn.setVisibility(View.GONE);
                    pauseBtn.setVisibility(View.VISIBLE);

                }



              /* Changed code to above code:: //Toast.makeText(getApplicationContext(),"It will take few seconds to play",Toast.LENGTH_SHORT).show();
                mediaPlayer = new MediaPlayer();

                try {
                    mediaPlayer.setDataSource(tagAudio);
                    mediaPlayer.prepare();


                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(),"It will take few seconds to play",Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                playBtn.setVisibility(View.GONE);
                pauseBtn.setVisibility(View.VISIBLE);*/


            }
        });

         /*Logic for Pause If pause is clicked the prayer will stop
         * Making mediaPlayer as stop
          * setting play button as Visible and pause as Gone*/


        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer.pause();
                pause = mediaPlayer.getCurrentPosition();

                //mediaPlayer.stop();
                pauseBtn.setVisibility(View.GONE);
                //pauseBtn.setVisibility(View.VISIBLE);
                playBtn.setVisibility(View.VISIBLE);

            }
        });

        /*If forward Button is clicked considering one boolean variable and assigning fals as value
        * getting path from the audioQuranListAdapter.audioQuranDetailArrayList and placing it in to in AudioQuranDetail audioQuranDetail
         * the checking the condition if audioQuranDetail.getFilePath() is equlae to pressent url then the boolean value will becom true
          * and if it is true change the url means go to next url and start the mediaPlayer*/


        forwordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean currentPlayingAudioPath = false;
                for (AudioQuranDetail audioQuranDetail : audioQuranListAdapter.audioQuranDetailArrayList) {

                    if (audioQuranDetail.getFilePath() == tagAudio) {
                        currentPlayingAudioPath = true;
                        continue;
                    }
                    if (currentPlayingAudioPath) {

                        tagAudio = audioQuranDetail.getFilePath();

                        String audioNameNew= audioQuranDetail.getFileName();

                        String sAudioNew = audioNameNew.replaceAll("[0-9]","");

                        if (sAudioNew.indexOf(".")>0)

                            sAudioNew = sAudioNew.substring(0,sAudioNew.lastIndexOf("."));


                        tv_audio_name.setText(sAudioNew);
                        tv_audio_name.setAnimation(animationFade);


                        break;
                    }
                }
                try {

                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
                        mediaPlayer = null;

                    }

                    final ProgressDialog progressDial = new ProgressDialog(ListAudioQuranActivity.this);
                    progressDial.setMessage("Wait For Few Second's..");
                    progressDial.show();
                    progressDial.setCanceledOnTouchOutside(false);
                    //Toast.makeText(getApplicationContext(), "It will take few seconds to play", Toast.LENGTH_SHORT).show();
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(tagAudio);
                    //mediaPlayer.prepare();
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (!mediaPlayer.isPlaying()){
                                progressDial.dismiss();

                            }


                            mediaPlayer.start();
                        }
                    });

                    mediaPlayer.prepareAsync();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //Toast.makeText(getApplicationContext(), "It will take few seconds to play", Toast.LENGTH_SHORT).show();
                //mediaPlayer.start();

            }
        });


        /*
        * If Rewind bUtton is Clicked looping the path from start to end
        * check if looping path and the present  path is equle break the condition
        * and Logic for if the path is first audio then make the i value as -1 back or reverse
        * the checking if mediaPlayer is not null stop the mediaPlayer
        * If it is Null set the url and start the audio
        * */


        rewindBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i;
                for (i = 0; i < audioQuranListAdapter.audioQuranDetailArrayList.size(); i++) {
                    if (audioQuranListAdapter.audioQuranDetailArrayList.get(i).getFilePath() == tagAudio) {

                        break;
                    }
                    if (i != 0) {
                        tagAudio = audioQuranListAdapter.audioQuranDetailArrayList.get(i - 1).getFilePath();

                        String audioName= audioQuranListAdapter.audioQuranDetailArrayList.get(i-1).getFileName();

                        String sAudio = audioName.replaceAll("[0-9]","");

                        if (sAudio.indexOf(".")>0)

                            sAudio = sAudio.substring(0,sAudio.lastIndexOf("."));


                        tv_audio_name.setText(sAudio);
                        tv_audio_name.setAnimation(animationFade);


                    }

                    try {

                        if (mediaPlayer != null) {
                            mediaPlayer.stop();
                            mediaPlayer = null;
                        }

                        final ProgressDialog progressdialog = new ProgressDialog(ListAudioQuranActivity.this);
                        progressdialog.setMessage("Wait For Few Second's..");
                        progressdialog.show();
                        progressdialog.setCanceledOnTouchOutside(false);

                        //Toast.makeText(getApplicationContext(), "It will take few seconds to play", Toast.LENGTH_SHORT).show();
                        mediaPlayer = new MediaPlayer();
                        mediaPlayer.setDataSource(tagAudio);
                        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                if (!mediaPlayer.isPlaying()){

                                    progressdialog.dismiss();
                                }


                                mediaPlayer.start();
                            }
                        });
                        mediaPlayer.prepareAsync();
                        //mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //Toast.makeText(getApplicationContext(), "It will take few seconds to play", Toast.LENGTH_SHORT).show();
                   // mediaPlayer.start();

                }

            }
        });


        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                if (mediaPlayer.isPlaying() == true){

                    return;



                }else{

                    pauseBtn.setVisibility(View.GONE);
                    playBtn.setVisibility(View.VISIBLE);
                }
            }
        });

    }




    private AlertDialog.Builder builderDialog(ListAudioQuranActivity listAudioQuranActivity) {

        AlertDialog.Builder builder = new AlertDialog.Builder(listAudioQuranActivity);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You Need To Have Mobile Data or Wifi to access this. Press OK to Exit");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startActivity(new Intent(ListAudioQuranActivity.this, VideoAudioActivity.class));

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.home) {

            NavUtils.navigateUpFromSameTask(ListAudioQuranActivity.this);

        }

        return super.onOptionsItemSelected(item);
    }

    /*Overriden method or Built in method to check If we go back og this activity to it's parent activity
    *It will stop the mediaPlayer */

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();

        }


    }
}
