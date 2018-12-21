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

public class SickActivityDua extends AppCompatActivity implements View.OnClickListener {


    Button tvSickVi,tvSickRe ;
    Animation myAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sick_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvSickVi = (Button) findViewById(R.id.tvSickVi);
        tvSickVi.setOnClickListener(SickActivityDua.this);

        tvSickRe = (Button) findViewById(R.id.tvSickRe);
        tvSickRe.setOnClickListener(SickActivityDua.this);
        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(SickActivityDua.this);

        }




        return super.onOptionsItemSelected(item);




    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tvSickVi :

                startActivity(new Intent(SickActivityDua.this,SickVisiActivity.class));
                tvSickVi.startAnimation(myAnimation);
                break;

            case R.id.tvSickRe :
                startActivity(new Intent(SickActivityDua.this,SickRewActivity.class));
                tvSickRe.startAnimation(myAnimation);
                break;





        }





    }
}
