package com.frocerie.demoalqalam;

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

import com.frocerie.demoalqalam.audioactivity.ListAudioActivity;
import com.frocerie.demoalqalam.service_pack.MyIntentService;
import com.frocerie.demoalqalam.service_pack.UserSharedPreference;
import com.frocerie.demoalqalam.videoactivity.VideoAudioActivity;

public class MaterialsActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView logo;

    ImageView quran,inter,hadeesh,nasheed;

    Button btnNasheed;
    UserSharedPreference up;
    Context ctx;

   // ImageButton quran,inter,hadeesh,nasheed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ctx = MaterialsActivity.this;
        up = new UserSharedPreference(ctx);

        intit();

        setNasheedBadge();

        LocalBroadcastManager.getInstance(MaterialsActivity.this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        },new IntentFilter(MyIntentService.ACTION_UPDATE_NASHEED));



    }

    private void setNasheedBadge() {

        if (up.getNasheedBadgeVal() > 0){

            btnNasheed.setVisibility(View.VISIBLE);
            btnNasheed.setText(String.valueOf(up.getNasheedBadgeVal()));
        }else
            btnNasheed.setVisibility(View.GONE);



    }

    private void intit() {

        logo = (ImageView) findViewById(R.id.logo);


        quran = (ImageView) findViewById(R.id.ivQuran);
        quran.setOnClickListener(MaterialsActivity.this);

        inter = (ImageView) findViewById(R.id.inter);
        inter.setOnClickListener(MaterialsActivity.this);

        hadeesh = (ImageView) findViewById(R.id.hadees);
        hadeesh.setOnClickListener(MaterialsActivity.this);

        nasheed = (ImageView) findViewById(R.id.nasheed);
        nasheed.setOnClickListener(MaterialsActivity.this);

        btnNasheed = (Button) findViewById(R.id.btn_badge_nasheed);



 /*       quran = (ImageButton) findViewById(R.id.ivQuran);
        quran.setOnClickListener(MaterialsActivity.this);

        inter = (ImageButton) findViewById(R.id.inter);
        inter.setOnClickListener(MaterialsActivity.this);

        hadeesh = (ImageButton) findViewById(R.id.hadees);
        hadeesh.setOnClickListener(MaterialsActivity.this);

        nasheed = (ImageButton) findViewById(R.id.nasheed);
        nasheed.setOnClickListener(MaterialsActivity.this);*/


    }

    @Override
    protected void onPause() {
        super.onPause();
        up.setCurrentActivity("MATERIALS");
    }

    @Override
    protected void onResume() {
        super.onResume();
        up.setCurrentActivity("MATERIALS");
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id){

            case R.id.ivQuran:

                startActivity(new Intent(MaterialsActivity.this,ListAudioActivity.class));

                //Toast.makeText(MaterialsActivity.this,"Get Mp3 files",Toast.LENGTH_SHORT).show();
            break;


            case R.id.inter :

                   //chmCallMethod();
                //startActivity(new Intent(MaterialsActivity.this,MatericalChmActivity.class));

                startActivity(new Intent(MaterialsActivity.this,MateriChmfileActivity.class));

                //Toast.makeText(MaterialsActivity.this,"Get .chm file",Toast.LENGTH_SHORT).show();
                break;

            case R.id.hadees :

                startActivity(new Intent(MaterialsActivity.this,MateriHadeesComeingActivity.class));
               break;

            case R.id.nasheed :

                up.setNasheedBadgeVal(0);
                btnNasheed.setVisibility(View.GONE);
                startActivity(new Intent(MaterialsActivity.this,VideoAudioActivity.class));

                break;

        }

    }

    //private void chmCallMethod() {
    //}


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        if(id == R.id.home){

            NavUtils.navigateUpFromSameTask(MaterialsActivity.this);

        }

        return super.onOptionsItemSelected(item);
    }
}
