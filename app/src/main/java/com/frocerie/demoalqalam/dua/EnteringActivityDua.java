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

public class EnteringActivityDua extends AppCompatActivity implements View.OnClickListener {

  Button tvEnterT,tvLevT;
    Animation myAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entering_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvEnterT = (Button) findViewById(R.id.tvEnterT);
        tvEnterT.setOnClickListener(EnteringActivityDua.this);

        tvLevT = (Button) findViewById(R.id.tvLevT);
        tvLevT.setOnClickListener(EnteringActivityDua.this);

        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(EnteringActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){


            case R.id.tvEnterT :

                startActivity(new Intent(EnteringActivityDua.this,EnteringToActivity.class));
                tvEnterT.startAnimation(myAnimation);
                break;

            case R.id.tvLevT :
                startActivity(new Intent(EnteringActivityDua.this,LeavingToAvtivity.class));
                tvLevT.startAnimation(myAnimation);
              break;



        }
    }
}
