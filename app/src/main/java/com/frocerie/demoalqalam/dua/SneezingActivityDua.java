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

public class SneezingActivityDua extends AppCompatActivity implements View.OnClickListener {


    Button tvSneePro,tvSneeDis;
    Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sneezing_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvSneePro = (Button) findViewById(R.id.tvSneePro);
        tvSneePro.setOnClickListener(SneezingActivityDua.this);

        tvSneeDis = (Button) findViewById(R.id.tvSneeDis);
        tvSneeDis.setOnClickListener(SneezingActivityDua.this);
        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);





    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(SneezingActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tvSneePro :

                startActivity(new Intent(SneezingActivityDua.this,SneezingProAcrivity.class));
                tvSneePro.startAnimation(myAnimation);
                break;

            case R.id.tvSneeDis :

                startActivity(new Intent(SneezingActivityDua.this,SneezingDisActivity.class));
                tvSneeDis.startAnimation(myAnimation);
                break;






        }




    }
}
