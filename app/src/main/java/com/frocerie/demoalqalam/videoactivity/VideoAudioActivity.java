package com.frocerie.demoalqalam.videoactivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.audioquran.audioquranmodel.ListAudioQuranActivity;
import com.frocerie.demoalqalam.service_pack.MyIntentService;
import com.frocerie.demoalqalam.service_pack.UserSharedPreference;

public class VideoAudioActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView ivLogo;

    Button video,audio;

    Button btnVideoBadge,btnAudioBadge;

    UserSharedPreference userP;
    Context con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_audio);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        con = VideoAudioActivity.this;
        userP =new  UserSharedPreference(con);

        initilize();
        
        setVideoAudioBadge();

        LocalBroadcastManager.getInstance(VideoAudioActivity.this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                setVideoAudioBadge();
            }
        }, new IntentFilter(MyIntentService.ACTION_UPDATE_VIDEO_AUDIO));

    }

    private void setVideoAudioBadge() {

        if (userP.getNasheedVideoBadgeVal() > 0){
            btnVideoBadge.setVisibility(View.VISIBLE);
            btnVideoBadge.setText(String.valueOf(userP.getNasheedVideoBadgeVal()));
        }else
            btnVideoBadge.setVisibility(View.GONE);

        if (userP.getNasheedAudioBadgeVal()> 0){
            btnAudioBadge.setVisibility(View.VISIBLE);
            btnAudioBadge.setText(String.valueOf(userP.getNasheedAudioBadgeVal()));
        }else
            btnAudioBadge.setVisibility(View.GONE);



    }

    private void initilize() {



        ivLogo = (ImageView) findViewById(R.id.ivLogo);

        video = (Button) findViewById(R.id.btVideo);
        video.setOnClickListener(VideoAudioActivity.this);


        audio = (Button) findViewById(R.id.btAudio);
        audio.setOnClickListener(VideoAudioActivity.this);

        btnVideoBadge = (Button) findViewById(R.id.btn_badge_video);
        btnAudioBadge = (Button) findViewById(R.id.btn_badge_audio);


    }

    @Override
    protected void onPause() {
        super.onPause();
        userP.setCurrentActivity("VIDEO_AUDIO");
    }

    @Override
    protected void onResume() {
        super.onResume();
        userP.setCurrentActivity("VIDEO_AUDIO");
    }

    @Override
    public void onClick(View view) {


        int id = view.getId();

        switch (id){


            case R.id.btVideo :

                userP.setNasheedVideoBadgeVal(0);
                btnVideoBadge.setVisibility(View.GONE);
                //Toast.makeText(VideoAudioActivity.this,"Connect to another  activity and get Audios from server",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(VideoAudioActivity.this,ListVideoActivity.class));
                break;
            case R.id.btAudio :


                userP.setNasheedAudioBadgeVal(0);
                btnAudioBadge.setVisibility(View.GONE);
                startActivity(new Intent(VideoAudioActivity.this,ListAudioQuranActivity.class));
              // Toast.makeText(VideoAudioActivity.this,"Connect to another  activity and get Audios from server", Toast.LENGTH_SHORT).show();
                break;





        }



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        if(id == R.id.home){

            NavUtils.navigateUpFromSameTask(VideoAudioActivity.this);

        }

        return super.onOptionsItemSelected(item);
    }
}
