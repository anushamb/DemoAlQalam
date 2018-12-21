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

public class HomeActivityDua extends AppCompatActivity implements View.OnClickListener {

    Button tvLev,tvEnt;
    Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvLev = (Button) findViewById(R.id.tvLev);
        tvLev.setOnClickListener(HomeActivityDua.this);

        tvEnt = (Button) findViewById(R.id.tvEnt);
        tvEnt.setOnClickListener(HomeActivityDua.this);
        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(HomeActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tvLev :

                startActivity(new Intent(HomeActivityDua.this,HomeLeavActivity.class));
                view.startAnimation(myAnimation);
                break;

            case R.id.tvEnt:

                startActivity(new Intent(HomeActivityDua.this,HomeEnterActivity.class));
                view.startAnimation(myAnimation);
                break;



        }
    }
}
