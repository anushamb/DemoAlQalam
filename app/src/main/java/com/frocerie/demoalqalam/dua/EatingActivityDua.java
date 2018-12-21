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

public class EatingActivityDua extends AppCompatActivity implements View.OnClickListener {

    Button tveatBefo,tvEatForg,tvEatFood,tvEatMilk,tvEatAfter,tvEatHost,tvEatDrink;

    Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eating_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tveatBefo = (Button) findViewById(R.id.tveatBefo);
        tveatBefo.setOnClickListener(EatingActivityDua.this);


        tvEatForg = (Button) findViewById(R.id.tvEatForg);
        tvEatForg.setOnClickListener(EatingActivityDua.this);

        tvEatFood = (Button) findViewById(R.id.tvEatFood);
        tvEatFood.setOnClickListener(EatingActivityDua.this);

        tvEatMilk = (Button) findViewById(R.id.tvEatMilk);
        tvEatMilk.setOnClickListener(EatingActivityDua.this);

        tvEatAfter= (Button) findViewById(R.id.tvEatAfter);
        tvEatAfter.setOnClickListener(EatingActivityDua.this);

        tvEatHost= (Button) findViewById(R.id.tvEatHost);
        tvEatHost.setOnClickListener(EatingActivityDua.this);

        tvEatDrink= (Button) findViewById(R.id.tvEatDrink);
        tvEatDrink.setOnClickListener(EatingActivityDua.this);

        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(EatingActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){

            case R.id.tveatBefo :
                 startActivity(new Intent(EatingActivityDua.this,EatingBeforeActivity.class));
                tveatBefo.startAnimation(myAnimation);
                break;

            case R.id.tvEatForg :
                startActivity(new Intent(EatingActivityDua.this,EatingForgetActivity.class));
                tvEatForg.startAnimation(myAnimation);
                break;


            case R.id.tvEatFood :
                startActivity(new Intent(EatingActivityDua.this,EatingFoddActivity.class));
                tvEatFood.startAnimation(myAnimation);
                break;

            case R.id.tvEatMilk:
                startActivity(new Intent(EatingActivityDua.this,EatingMilkActivity.class));
                tvEatMilk.startAnimation(myAnimation);
                break;

            case R.id.tvEatAfter:

                startActivity(new Intent(EatingActivityDua.this,EatingAfterActivity.class));
                tvEatAfter.startAnimation(myAnimation);
                break;

            case R.id.tvEatHost:
                startActivity(new Intent(EatingActivityDua.this,EatingHostActivity.class));
                tvEatHost.startAnimation(myAnimation);
                break;


            case R.id.tvEatDrink:
                startActivity(new Intent(EatingActivityDua.this,EatingDrinrActivity.class));
                tvEatDrink.startAnimation(myAnimation);
                break;





        }

    }
}
