package com.frocerie.demoalqalam.dua;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.frocerie.demoalqalam.R;

public class SleepActivityDua extends AppCompatActivity implements View.OnClickListener {


    Button tvSleeBef,tvSleeWake,tvSleeNight,tvSleeDepr,tvSleenightm;
    Animation myAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvSleeBef = (Button) findViewById(R.id.tvSleeBef);
        tvSleeBef.setOnClickListener(SleepActivityDua.this);


        tvSleeWake = (Button) findViewById(R.id.tvSleeWake);
        tvSleeWake.setOnClickListener(SleepActivityDua.this);


        tvSleeNight = (Button) findViewById(R.id.tvSleeNight);
        tvSleeNight.setOnClickListener(SleepActivityDua.this);


        tvSleeDepr = (Button) findViewById(R.id.tvSleeDepr);
        tvSleeDepr.setOnClickListener(SleepActivityDua.this);

        tvSleenightm = (Button) findViewById(R.id.tvSleenightm);
        tvSleenightm.setOnClickListener(SleepActivityDua.this);


        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(SleepActivityDua.this);

        }




        return super.onOptionsItemSelected(item);




    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){



            case R.id. tvSleeBef :

                startActivity(new Intent(SleepActivityDua.this,SleepBeforeActvity.class));
                tvSleeBef.startAnimation(myAnimation);
                break;



            case R.id.tvSleeWake :

                startActivity(new Intent(SleepActivityDua.this,SleepWakeActvity.class));
                tvSleeWake.startAnimation(myAnimation);
                break;



            case R.id.tvSleeNight :

                startActivity(new Intent(SleepActivityDua.this,SleepNightActvity.class));
                tvSleeNight.startAnimation(myAnimation);
                break;



            case R.id.tvSleeDepr :

                startActivity(new Intent(SleepActivityDua.this,SleepDeprActvity.class));
                tvSleeDepr.startAnimation(myAnimation);
                break;



            case R.id.tvSleenightm :

                startActivity(new Intent(SleepActivityDua.this,SleepNightmareActvity.class));
                tvSleenightm.startAnimation(myAnimation);
                break;



        }

    }
}
