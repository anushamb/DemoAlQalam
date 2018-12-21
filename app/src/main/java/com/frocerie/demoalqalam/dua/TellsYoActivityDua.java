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

public class TellsYoActivityDua extends AppCompatActivity implements View.OnClickListener {

    Button tvLov,tvForg,tvBles;
    Animation myAnimation;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tells_yo_dua);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tvLov = (Button) findViewById(R.id.tvLov);
        tvLov.setOnClickListener(TellsYoActivityDua.this);


        tvForg = (Button) findViewById(R.id.tvForg);
        tvForg.setOnClickListener(TellsYoActivityDua.this);

        tvBles = (Button) findViewById(R.id.tvBles);
        tvBles.setOnClickListener(TellsYoActivityDua.this);

        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(TellsYoActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tvLov :

                startActivity(new Intent(TellsYoActivityDua.this,TellsLoveActivity.class));
                view.startAnimation(myAnimation);
                break;


            case R.id.tvForg :

                startActivity(new Intent(TellsYoActivityDua.this,TellsForgiveActivity.class));
                view.startAnimation(myAnimation);
                break;


            case R.id. tvBles :

                startActivity(new Intent(TellsYoActivityDua.this,TellsBlessActivity.class));
                view.startAnimation(myAnimation);
                break;




        }



    }
}
