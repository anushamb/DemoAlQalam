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

public class ClothesActivityDua extends AppCompatActivity implements View.OnClickListener {


    Button tvWear,tvRe,tvNew,tvPut;

    Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvWear = (Button) findViewById(R.id.tvWear);
        tvWear.setOnClickListener(ClothesActivityDua.this);

        tvRe = (Button) findViewById(R.id.tvRe);
        tvRe.setOnClickListener(ClothesActivityDua.this);

        tvNew = (Button) findViewById(R.id.tvNew);
        tvNew.setOnClickListener(ClothesActivityDua.this);

        tvPut = (Button) findViewById(R.id.tvPut);
        tvPut.setOnClickListener(ClothesActivityDua.this);

        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);




    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tvWear :
                startActivity(new Intent(ClothesActivityDua.this,ClothesWeaActivity.class));
                tvWear.startAnimation(myAnimation);
                break;

            case R.id.tvRe:
                startActivity(new Intent(ClothesActivityDua.this,ClothesRemActivity.class));
                tvRe.startAnimation(myAnimation);
                break;

            case R.id.tvNew :

                startActivity(new Intent(ClothesActivityDua.this,ClothesNewActivity.class));
                tvNew.startAnimation(myAnimation);
                break;

            case R.id.tvPut :

                startActivity(new Intent(ClothesActivityDua.this,ClothesPutActivity.class));
                tvPut.startAnimation(myAnimation);
                break;




        }




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(ClothesActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }
}
