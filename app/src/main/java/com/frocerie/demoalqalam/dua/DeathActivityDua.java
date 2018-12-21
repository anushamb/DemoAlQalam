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

import com.frocerie.demoalqalam.DeaChildActivity;
import com.frocerie.demoalqalam.R;

public class DeathActivityDua extends AppCompatActivity implements View.OnClickListener {

    Button tvDeath,tvDeathSay,tvDeathStrik,tvDeathEyes,tvDeathDead,tvDeChild,tvDeBere;
    Button tvdeaGrave,tvDeaAfter,tvDeadVisit;
    Animation myAnimation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvDeath = (Button) findViewById(R.id.tvDeath);
        tvDeath.setOnClickListener(DeathActivityDua.this);

        tvDeathSay = (Button) findViewById(R.id.tvDeathSay);
        tvDeathSay.setOnClickListener(DeathActivityDua.this);

        tvDeathStrik = (Button) findViewById(R.id.tvDeathStrik);
        tvDeathStrik.setOnClickListener(DeathActivityDua.this);

        tvDeathEyes = (Button) findViewById(R.id.tvDeathEyes);
        tvDeathEyes.setOnClickListener(DeathActivityDua.this);

        tvDeathDead = (Button) findViewById(R.id.tvDeathDead);
        tvDeathDead.setOnClickListener(DeathActivityDua.this);

        tvDeChild = (Button) findViewById(R.id.tvDeChild);
        tvDeChild.setOnClickListener(DeathActivityDua.this);

        tvDeBere = (Button) findViewById(R.id.tvDeBere);
        tvDeBere.setOnClickListener(DeathActivityDua.this);

      tvdeaGrave = (Button) findViewById(R.id.tvdeaGrave);
        tvdeaGrave.setOnClickListener(DeathActivityDua.this);

        tvDeaAfter = (Button) findViewById(R.id.tvDeaAfter);
        tvDeaAfter.setOnClickListener(DeathActivityDua.this);

        tvDeadVisit = (Button) findViewById(R.id.tvDeadVisit);
        tvDeadVisit.setOnClickListener(DeathActivityDua.this);

        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(DeathActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.tvDeath :
                 startActivity(new Intent(DeathActivityDua.this,DeathInvocaActivity.class));
                tvDeath.startAnimation(myAnimation);
                break;

            case R.id.tvDeathSay:

                startActivity(new Intent(DeathActivityDua.this,DeathSayActivity.class));
                tvDeathSay.startAnimation(myAnimation);
                break;

            case R.id.tvDeathStrik:
                startActivity(new Intent(DeathActivityDua.this,DeathStrikesActivity.class));
                tvDeathStrik.startAnimation(myAnimation);
                break;

            case R.id.tvDeathEyes :
                startActivity(new Intent(DeathActivityDua.this,DeathEyesActivity.class));
                tvDeathEyes.startAnimation(myAnimation);
                break;

            case R.id.tvDeathDead :
                startActivity(new Intent(DeathActivityDua.this,DeathDeadActivity.class));
                tvDeathDead.startAnimation(myAnimation);
                break;

            case R.id.tvDeChild:
                startActivity(new Intent(DeathActivityDua.this,DeaChildActivity.class));
                tvDeChild.startAnimation(myAnimation);
                break;


            case R.id.tvDeBere:
                startActivity(new Intent(DeathActivityDua.this,DeathBereActivity.class));
                tvDeBere.startAnimation(myAnimation);
                break;


            case R.id.tvdeaGrave :
                startActivity(new Intent(DeathActivityDua.this,DeathPlaceActivity.class));
                tvdeaGrave.startAnimation(myAnimation);
                break;


            case R.id.tvDeaAfter :
                startActivity(new Intent(DeathActivityDua.this,DeathAfterActivity.class));
                tvDeaAfter.startAnimation(myAnimation);
                break;

            case R.id.tvDeadVisit :
                startActivity(new Intent(DeathActivityDua.this,DeathVisitActivity.class));
                tvDeadVisit.startAnimation(myAnimation);
                break;


        }


    }
}
