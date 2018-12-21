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


public class PleaseActivityDua extends AppCompatActivity implements View.OnClickListener {

    Button tvPleSm,tvPleDis,tvPleHapp;
    Animation myAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_please_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tvPleSm = (Button) findViewById(R.id.tvPleSm);
        tvPleSm.setOnClickListener(PleaseActivityDua.this);

        tvPleDis = (Button) findViewById(R.id.tvPleDis);
        tvPleDis.setOnClickListener(PleaseActivityDua.this);

        tvPleHapp  = (Button) findViewById(R.id.tvPleHapp);
        tvPleHapp.setOnClickListener(PleaseActivityDua.this);
        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(PleaseActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){


            case R.id.tvPleSm :

                startActivity(new Intent(PleaseActivityDua.this,PleaseSomActivity.class));
                tvPleSm.startAnimation(myAnimation);
                break;

            case R.id.tvPleDis :

                startActivity(new Intent(PleaseActivityDua.this,PleaseDisplActivity.class));
                tvPleDis.startAnimation(myAnimation);
                break;

            case R.id. tvPleHapp:

                startActivity(new Intent(PleaseActivityDua.this,PleaseHappeActivity.class));
                tvPleHapp.startAnimation(myAnimation);
                break;



        }




    }
}
