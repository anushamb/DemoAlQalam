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

import static com.frocerie.demoalqalam.R.id.tvCrow;
import static com.frocerie.demoalqalam.R.id.tvDog;

public class AnimalActivity extends AppCompatActivity implements View.OnClickListener {

    Button tvC,tvD,tvS;

    Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        tvC = (Button) findViewById(tvCrow);
        tvC.setOnClickListener(AnimalActivity.this);

        tvD = (Button) findViewById(tvDog);
        tvD.setOnClickListener(AnimalActivity.this);

        tvS = (Button) findViewById(R.id.tvSay);
        tvS.setOnClickListener(AnimalActivity.this);

        animation = AnimationUtils.loadAnimation(this,R.anim.text_animation);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){


            case R.id.tvCrow :


            startActivity(new Intent(AnimalActivity.this,CockActivity.class));
            view.setAnimation(animation);


            break;

            case R.id.tvDog :

                startActivity(new Intent(AnimalActivity.this,DogActivity.class));
                view.setAnimation(animation);
                break;

            case R.id.tvSay :
                startActivity(new Intent(AnimalActivity.this,SayActivity.class));
                view.setAnimation(animation);
                break;


        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(AnimalActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }
}
