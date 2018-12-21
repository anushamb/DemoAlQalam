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

public class RulerActivityDua extends AppCompatActivity implements View.OnClickListener {

    Button tvRuMeet,tvRuAgai;
    Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruler_dua);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tvRuMeet = (Button) findViewById(R.id.tvRuMeet);
        tvRuMeet.setOnClickListener(RulerActivityDua.this);


        tvRuAgai = (Button) findViewById(R.id.tvRuAgai);
        tvRuAgai.setOnClickListener(RulerActivityDua.this);
        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(RulerActivityDua.this);

        }




        return super.onOptionsItemSelected(item);




    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tvRuMeet :

                startActivity(new Intent(RulerActivityDua.this,RulerWhenActvity.class));
                view.startAnimation(myAnimation);
                break;

            case R.id.tvRuAgai :
                startActivity(new Intent(RulerActivityDua.this,RulerAgainstActivity.class));
                view.startAnimation(myAnimation);
                break;




        }



    }
}
