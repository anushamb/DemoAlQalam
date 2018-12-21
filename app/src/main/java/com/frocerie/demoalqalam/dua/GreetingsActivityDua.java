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

public class GreetingsActivityDua extends AppCompatActivity implements View.OnClickListener {

    Button tvGrSpre,tvGrReply,tvGrMusli,tvGrPra;

    Animation myAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tvGrSpre = (Button) findViewById(R.id.tvGrSpre);
        tvGrSpre.setOnClickListener(GreetingsActivityDua.this);


        tvGrReply = (Button) findViewById(R.id.tvGrReply);
        tvGrReply.setOnClickListener(GreetingsActivityDua.this);

        tvGrMusli = (Button) findViewById(R.id.tvGrMusli);
        tvGrMusli.setOnClickListener(GreetingsActivityDua.this);

        tvGrPra = (Button) findViewById(R.id.tvGrPra);
        tvGrPra.setOnClickListener(GreetingsActivityDua.this);

        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(GreetingsActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){


            case R.id. tvGrSpre :

                startActivity(new Intent(GreetingsActivityDua.this,GreeSalamActivity.class));
                view.startAnimation(myAnimation);
                break;

            case R.id. tvGrReply:

                startActivity(new Intent(GreetingsActivityDua.this,GreeReplyActivity.class));
                view.startAnimation(myAnimation);
                break;

            case R.id. tvGrMusli:

                startActivity(new Intent(GreetingsActivityDua.this,GreeSayyActivity.class));
                view.startAnimation(myAnimation);
                break;

            case R.id. tvGrPra:

                startActivity(new Intent(GreetingsActivityDua.this,GreePraisedActivity.class));
                view.startAnimation(myAnimation);
                break;





        }



    }
}
