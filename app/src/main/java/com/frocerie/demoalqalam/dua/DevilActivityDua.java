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

public class DevilActivityDua extends AppCompatActivity implements View.OnClickListener {


    Button tvDevilAga,tvDevilAgai,tvDevilPlot;
    Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devil_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tvDevilAga = (Button) findViewById(R.id.tvDevilAga);
        tvDevilAga.setOnClickListener(DevilActivityDua.this);

        tvDevilAgai = (Button) findViewById(R.id.tvDevilAgai);
        tvDevilAgai.setOnClickListener(DevilActivityDua.this);


        tvDevilPlot = (Button) findViewById(R.id.tvDevilPlot);
        tvDevilPlot.setOnClickListener(DevilActivityDua.this);


        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(DevilActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tvDevilAga :
                startActivity(new Intent(DevilActivityDua.this,DevilAgaActivity.class));
                tvDevilAga.startAnimation(myAnimation);
                break;

            case R.id.tvDevilAgai :
                startActivity(new Intent(DevilActivityDua.this,DevilAgainActivity.class));
                tvDevilAgai.startAnimation(myAnimation);
                break;

            case R.id.tvDevilPlot :
                startActivity(new Intent(DevilActivityDua.this,DevilPlotActivity.class));
                tvDevilPlot.startAnimation(myAnimation);
                break;



        }

    }
}
