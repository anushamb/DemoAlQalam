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

public class GroomActivity extends AppCompatActivity implements View.OnClickListener {

    Button tvGroom,tvGroomIn;
    Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groom);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvGroom = (Button) findViewById(R.id.tvGroom);
        tvGroom.setOnClickListener(GroomActivity.this);


        tvGroomIn = (Button) findViewById(R.id.tvGroomIn);
        tvGroomIn.setOnClickListener(GroomActivity.this);
        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(GroomActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tvGroom :

                startActivity(new Intent(GroomActivity.this,GrromDActivity.class));
                view.startAnimation(myAnimation);
            break;

            case R.id.tvGroomIn :
                startActivity(new Intent(GroomActivity.this,GroomInActivity.class));
                view.startAnimation(myAnimation);
                break;



        }




    }
}
