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

public class RainActivityDua extends AppCompatActivity implements View.OnClickListener {


   Button tvrainblow,tvRainThun,tvRainFor,tvRainWhen,tvRainAfter,tvRainWith;
    Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rain_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvrainblow = (Button) findViewById(R.id.tvrainblow);
        tvrainblow.setOnClickListener(RainActivityDua.this);

        tvRainThun = (Button) findViewById(R.id.tvRainThun);
        tvRainThun.setOnClickListener(RainActivityDua.this);

        tvRainFor = (Button) findViewById(R.id.tvRainFor);
        tvRainFor.setOnClickListener(RainActivityDua.this);

        tvRainAfter = (Button) findViewById(R.id.tvRainAfter);
        tvRainAfter.setOnClickListener(RainActivityDua.this);

        tvRainWhen = (Button) findViewById(R.id.tvRainWhen);
        tvRainWhen.setOnClickListener(RainActivityDua.this);

        tvRainWith = (Button) findViewById(R.id.tvRainWith);
        tvRainWith.setOnClickListener(RainActivityDua.this);

        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(RainActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){



            case R.id. tvrainblow :
            startActivity(new Intent(RainActivityDua.this,RainBlowActivity.class));
                tvrainblow.startAnimation(myAnimation);
            break;



            case R.id. tvRainThun :
                startActivity(new Intent(RainActivityDua.this,RainThunderActivity.class));
                tvRainThun.startAnimation(myAnimation);
                break;


            case R.id.tvRainFor :
                startActivity(new Intent(RainActivityDua.this,RainForActivity.class));
                tvRainFor.startAnimation(myAnimation);
                break;

            case R.id.tvRainWhen :
                startActivity(new Intent(RainActivityDua.this,RainWhenActivity.class));
                tvRainWhen.startAnimation(myAnimation);
                break;



            case R.id.tvRainAfter :
                startActivity(new Intent(RainActivityDua.this,RainAfterActivity.class));
                tvRainAfter.startAnimation(myAnimation);
                break;




            case R.id.tvRainWith :
                startActivity(new Intent(RainActivityDua.this,RainWithhoActivity.class));
                tvRainWith.startAnimation(myAnimation);
                break;



        }


    }
}
