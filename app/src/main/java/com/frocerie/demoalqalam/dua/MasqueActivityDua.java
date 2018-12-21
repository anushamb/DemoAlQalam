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
import android.widget.TextView;

import com.frocerie.demoalqalam.R;

public class MasqueActivityDua extends AppCompatActivity implements View.OnClickListener {


    Button tvMasjidGoi,tvMasjidEnt,tvMasjidLev;
    Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masque_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvMasjidGoi = (Button) findViewById(R.id.tvMasjidGoi);
        tvMasjidGoi.setOnClickListener(MasqueActivityDua.this);

        tvMasjidEnt = (Button) findViewById(R.id.tvMasjidEnt);
        tvMasjidEnt.setOnClickListener(MasqueActivityDua.this);


        tvMasjidLev = (Button) findViewById(R.id.tvMasjidLev);
        tvMasjidLev.setOnClickListener(MasqueActivityDua.this);
        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(MasqueActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tvMasjidGoi :

                startActivity(new Intent(MasqueActivityDua.this,MasqueGoingActivity.class));
                tvMasjidGoi.startAnimation(myAnimation);
                break;


            case R.id.tvMasjidEnt:

                startActivity(new Intent(MasqueActivityDua.this,MasqueEnterActivity.class));
                tvMasjidEnt.startAnimation(myAnimation);
                break;




            case R.id.tvMasjidLev :

               startActivity(new Intent(MasqueActivityDua.this,MasqueLevActivity.class));
                tvMasjidLev.startAnimation(myAnimation);
                break;



        }



    }
}
