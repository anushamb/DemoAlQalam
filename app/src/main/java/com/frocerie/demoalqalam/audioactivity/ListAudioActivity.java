package com.frocerie.demoalqalam.audioactivity;

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
import com.frocerie.demoalqalam.MaterialsActivity;
import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.audioactivity.audiomodel.AudioDetail;
import com.frocerie.demoalqalam.audioactivity.audiomodel.AudioDetailsModel;
import com.frocerie.demoalqalam.utils.ProgressUtils;

import java.io.IOException;
import java.util.ArrayList;

public class ListAudioActivity extends AppCompatActivity {

    private final String url_quran = "http://alqalamtrust.com/quran";

    TextView tv_audio_name;

    int pause;

    String new_audio_name;
    String audio_name;

    private RecyclerView recyclerView;
    private AudioListAdapter audioListAdapter;
    private ArrayList<AudioDetail> audioDetailsArrayList = new ArrayList<>();

    ImageView btPlay,btPause,btRewind,btForward;

    MediaPlayer mediaPlayer;
    Animation animationFade;

    String audio_url;

    private View.OnClickListener audioItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int pos = 0;
            pos = (Integer)v.getTag();//.toString();

            Log.d("testK","Audio33 :" + pos);

            AudioDetail audioDetail = audioListAdapter.audioDetailArrayList.get(pos);

            if (audioDetail == null){
                return;
            }

            audio_name = audioDetail.getSurahName();

            new_audio_name =  audio_name.replaceAll("[0-9]","");
            tv_audio_name.setText(new_audio_name);

            //tv_audio_name.setText(audioDetail.getSurahName().substring(1));
            tv_audio_name.setAnimation(animationFade);
            audio_url = audioDetail.getPath();

            //audio_url = v.getTag().toString();

            if (btPause.getVisibility()==View.VISIBLE){

                btPause.setVisibility(View.GONE);
                btPlay.setVisibility(View.VISIBLE);

                if (mediaPlayer != null){

                    mediaPlayer.stop();
                    mediaPlayer = null;
                }

            }


            if (btPlay.getVisibility() == View.GONE) {

                btPlay.setVisibility(View.VISIBLE);
                btPause.setVisibility(View.GONE);


            }else {

                final ProgressDialog progressDialo = new ProgressDialog(ListAudioActivity.this);
                progressDialo.setMessage("Wait For Few Second's.");
                progressDialo.show();
                progressDialo.setCanceledOnTouchOutside(false);


                // Toast.makeText(getApplicationContext(),"It will take few seconds to play",Toast.LENGTH_SHORT).show();
                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(audio_url);
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {


                            if (!mediaPlayer.isPlaying()) {
                                progressDialo.dismiss();

                            }

                            mediaPlayer.start();
                            btPlay.setVisibility(View.GONE);
                            btPause.setVisibility(View.VISIBLE);


                        }
                    });
                    mediaPlayer.prepareAsync();
                    //mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //mediaPlayer.start();
                //btPlay.setVisibility(View.GONE);
                //btPause.setVisibility(View.VISIBLE);

                settingAudio();
                Log.d("testK", "Audio11 :" + audio_url);
                System.out.println("Audio :" + audio_url);

            }
            //System.out.println("Audio :" + audio_url);


            // method after end of the audio the visibality is changing
            if (!mediaPlayer.isPlaying()){

                btPlay.setVisibility(View.VISIBLE);
                btPause.setVisibility(View.GONE);

            }

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null){
            mediaPlayer.release();
        }



    }

    private void settingAudio() {


        /*
        * IF Button Play is Clicked we setting the audio_url
        * and starting the audio
        * making play button as Gone and Puase as Visible.*/

        btPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (mediaPlayer == null){
                            mediaPlayer = new MediaPlayer();

                            try {
                                mediaPlayer.setDataSource(audio_url);
                                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                    @Override
                                    public void onPrepared(MediaPlayer mediaPlayer) {

                                        mediaPlayer.start();
                                    }
                                });
                                mediaPlayer.prepareAsync();
                                //mediaPlayer.prepare();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            //mediaPlayer.start();
                            btPlay.setVisibility(View.GONE);
                            btPause.setVisibility(View.VISIBLE);



                        }else if (!mediaPlayer.isPlaying()){

                            mediaPlayer.seekTo(pause);
                            mediaPlayer.start();

                            btPlay.setVisibility(View.GONE);
                            btPause.setVisibility(View.VISIBLE);


                        }




                        //Toast.makeText(getApplicationContext(),"It will take few seconds to play",Toast.LENGTH_SHORT).show();
                      /*Changed to above code..  mediaPlayer = new MediaPlayer();
                        try {
                            mediaPlayer.setDataSource(audio_url);
                            mediaPlayer.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        mediaPlayer.start();
                        btPlay.setVisibility(View.GONE);
                        btPause.setVisibility(View.VISIBLE);*/

                      /*  if (mediaPlayer != null){
                            btPlay.setVisibility(View.VISIBLE);
                            btPause.setVisibility(View.GONE);

                        }*/

                    }

                });

        /*Logic for Pause If pause is clicked the prayer will stop
         * Making mediaPlayer as stop
          * setting play button as Visible and pause as Gone*/

                btPause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mediaPlayer.pause();
                        pause = mediaPlayer.getCurrentPosition();

                        //mediaPlayer.stop();
                        btPause.setVisibility(View.GONE);
                        btPlay.setVisibility(View.VISIBLE);

                    }
                });

  /*If forward Button is clicked considering one boolean variable and assigning fals as value
        * getting path from the audioQuranListAdapter.audioQuranDetailArrayList and placing it in to in AudioQuranDetail audioQuranDetail
         * the checking the condition if audioQuranDetail.getFilePath() is equlae to pressent url then the boolean value will becom true
          * and if it is true change the url means go to next url and start the mediaPlayer*/


        btForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean currentAudioFileReached = false;
                for(AudioDetail audioDetail: audioListAdapter.audioDetailArrayList) {
                    if (audioDetail.getPath() == audio_url) {
                        currentAudioFileReached = true;
                        continue;
                    }
                    if (currentAudioFileReached) {
                        audio_url = audioDetail.getPath();

                        String audioNameNew= audioDetail.getSurahName();

                        String sAudioNew = audioNameNew.replaceAll("[0-9]","");


                        tv_audio_name.setText(sAudioNew);
                        tv_audio_name.setAnimation(animationFade);


                        break;
                    }
                }
                try {
                    Log.d("hereeeeeeeeee",audio_url);
                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
                        mediaPlayer = null;
                    }

                    final ProgressDialog progressDial = new ProgressDialog(ListAudioActivity.this);
                    progressDial.setMessage("Wait For Few Second's.");
                    progressDial.show();
                    progressDial.setCanceledOnTouchOutside(false);

                    //Toast.makeText(getApplicationContext(),"It will take few seconds to play",Toast.LENGTH_SHORT).show();
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(audio_url);
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
                    //mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
               // mediaPlayer.start();
            }
        });


          /*
        * If Rewind bUtton is Clicked looping the path from start to end
        * check if looping path and the present  path is equle break the condition
        * and Logic for if the path is first audio then make the i value as -1 back or reverse
        * the checking if mediaPlayer is not null stop the mediaPlayer
        * If it is Null set the url and start the audio
        * */


        btRewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i;
                for (i=0; i<audioListAdapter.audioDetailArrayList.size(); i++) {
                    if(audioListAdapter.audioDetailArrayList.get(i).getPath() == audio_url) {
                        break;
                    }
                }
                if(i != 0) {
                    audio_url = audioListAdapter.audioDetailArrayList.get(i-1).getPath();

                    String audioName= audioListAdapter.audioDetailArrayList.get(i-1).getSurahName();

                    String sAudio = audioName.replaceAll("[0-9]","");


                    tv_audio_name.setText(sAudio);
                    tv_audio_name.setAnimation(animationFade);
                }
                try {
                    Log.d("hereeeeeeeeee",audio_url);
                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
                        mediaPlayer = null;
                    }

                    final ProgressDialog progressdialog = new ProgressDialog(ListAudioActivity.this);
                    progressdialog.setMessage("Wait For Few Second's.");
                    progressdialog.show();
                    progressdialog.setCanceledOnTouchOutside(false);

                    //Toast.makeText(getApplicationContext(),"It will take few seconds to play",Toast.LENGTH_SHORT).show();
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(audio_url);
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
                   // mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //mediaPlayer.start();
            }
        });



        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {


                if (mediaPlayer.isPlaying() == true){

                    return;



                }else{

                    btPause.setVisibility(View.GONE);
                    btPlay.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_audio);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btPlay = (ImageView) findViewById(R.id.bt_play);
        btPause = (ImageView) findViewById(R.id.bt_pause);

        btRewind = (ImageView) findViewById(R.id.rewind);
        btForward = (ImageView) findViewById(R.id.forward);

        tv_audio_name = (TextView) findViewById(R.id.tvAudioName);
        animationFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_animation);







        setRecyclerAdapter();

        loadAudioRequest();
        
        
    }



    private void setRecyclerAdapter() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerAudioList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(ListAudioActivity.this);
        audioListAdapter = new AudioListAdapter(audioDetailsArrayList,audioItemClickListener);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(audioListAdapter);

    }


    private void loadAudioRequest() {

        if (isNetworkAvailable()) {

            ProgressUtils.getInstance(ListAudioActivity.this).show("Loding Audio List,....");

            StringRequest str = new StringRequest(Request.Method.GET, url_quran, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {

                        ProgressUtils.getInstance(ListAudioActivity.this).cancel();

                        if (TextUtils.isEmpty(response)) {

                            return;
                        }

                        AudioDetailsModel audioDeatailsModel = AudioResponseHandler.getAudioDetails(response);

                        if (audioDeatailsModel == null) {
                            return;
                        }


                        if (audioDeatailsModel.getDetails() == null || audioDeatailsModel.getDetails().size()<=0) {
                            return;
                        }

                        audioListAdapter.setAudioList((ArrayList<AudioDetail>) audioDeatailsModel.getDetails());
                    } catch (Throwable e) {

                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    ProgressUtils.getInstance(ListAudioActivity.this).cancel();
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG);

                }
            });

            RequestQueue rq = Volley.newRequestQueue(ListAudioActivity.this);
            rq.add(str);

        }else{

            builderDialog(ListAudioActivity.this).show();
        }

    }

    private AlertDialog.Builder builderDialog(ListAudioActivity listAudioActivity) {


        AlertDialog.Builder builder = new AlertDialog.Builder(listAudioActivity);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You Need To Have Mobile Data or Wifi to access this. Press OK to Exit");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startActivity(new Intent(ListAudioActivity.this,MaterialsActivity.class));

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



        if(id == R.id.home){

            NavUtils.navigateUpFromSameTask(ListAudioActivity.this);

        }

        return super.onOptionsItemSelected(item);
    }

      /*Overriden method or Built in method to check If we go back og this activity to it's parent activity
    *It will stop the mediaPlayer */

    @Override
    public void onBackPressed() {
        super.onBackPressed();

//        Toast.makeText(getApplicationContext(),"It will take time to stop",Toast.LENGTH_LONG).show();


        if(mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }
}
