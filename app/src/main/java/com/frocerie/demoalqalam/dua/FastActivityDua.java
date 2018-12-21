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

public class FastActivityDua extends AppCompatActivity implements View.OnClickListener {

    Button tvFastBrek,tvFastInvi,tvFastFood,tvFastSom;

    Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvFastBrek = (Button) findViewById(R.id.tvFastBrek);
        tvFastBrek.setOnClickListener(FastActivityDua.this);

        tvFastInvi = (Button) findViewById(R.id.tvFastInvi);
        tvFastInvi.setOnClickListener(FastActivityDua.this);


        tvFastFood = (Button) findViewById(R.id.tvFastFood);
        tvFastFood.setOnClickListener(FastActivityDua.this);

        tvFastSom = (Button) findViewById(R.id.tvFastSom);
        tvFastSom.setOnClickListener(FastActivityDua.this);
        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(FastActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tvFastBrek :

                startActivity(new Intent(FastActivityDua.this,FastBreakingActivity.class));
                tvFastBrek.startAnimation(myAnimation);
                break;

            case  R.id.tvFastInvi :
                startActivity(new Intent(FastActivityDua.this,FastIncitesActivity.class));
                tvFastInvi.startAnimation(myAnimation);
                break;

            case R.id.tvFastFood :

                startActivity(new Intent(FastActivityDua.this,FastOffersActivity.class));
                tvFastFood.startAnimation(myAnimation);
                break;

            case R.id.tvFastSom :

                startActivity(new Intent(FastActivityDua.this,FastSomeActivity.class));
                tvFastSom.startAnimation(myAnimation);
                break;





        }




    }
}
