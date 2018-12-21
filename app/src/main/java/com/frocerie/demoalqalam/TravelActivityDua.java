package com.frocerie.demoalqalam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class TravelActivityDua extends AppCompatActivity implements View.OnClickListener {

    TextView tvTraFail,tvTraAni,tvTraRet,tvTraBeh,tvTraRes,tvTraJou,tvTraDaw,tvTraInv,tvTraSay;

    Animation myAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvTraFail = (TextView) findViewById(R.id.tvTraFail);
        tvTraFail.setOnClickListener(TravelActivityDua.this);

        tvTraAni = (TextView) findViewById(R.id.tvTraAni);
        tvTraAni.setOnClickListener(TravelActivityDua.this);

        tvTraRet = (TextView) findViewById(R.id.tvTraRet);
        tvTraRet.setOnClickListener(TravelActivityDua.this);


        tvTraBeh = (TextView) findViewById(R.id.tvTraBeh);
        tvTraBeh.setOnClickListener(TravelActivityDua.this);


        tvTraRes = (TextView) findViewById(R.id.tvTraRes);
        tvTraRes.setOnClickListener(TravelActivityDua.this);


        tvTraJou = (TextView) findViewById(R.id.tvTraJou);
        tvTraJou.setOnClickListener(TravelActivityDua.this);


        tvTraDaw = (TextView) findViewById(R.id.tvTraDaw);
        tvTraDaw.setOnClickListener(TravelActivityDua.this);


        tvTraInv = (TextView) findViewById(R.id.tvTraInv);
        tvTraInv.setOnClickListener(TravelActivityDua.this);


        tvTraSay = (TextView) findViewById(R.id.tvTraSay);
        tvTraSay.setOnClickListener(TravelActivityDua.this);
        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(TravelActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tvTraFail :
                startActivity(new Intent(TravelActivityDua.this,TravelFailActivity.class));  //D200
                tvTraFail.startAnimation(myAnimation);
                break;

            case R.id.tvTraAni :
                startActivity(new Intent(TravelActivityDua.this,TravelAniActivity.class));   //D201
                tvTraAni.startAnimation(myAnimation);
                break;


            case R.id.tvTraRet :
                startActivity(new Intent(TravelActivityDua.this,TravelRetActivity.class));  //D202 - D203
                tvTraRet.startAnimation(myAnimation);
                break;


            case R.id. tvTraBeh  :
                startActivity(new Intent(TravelActivityDua.this,TravelBehActivity.class));  //D204
                tvTraBeh.startAnimation(myAnimation);
                break;


            case R.id.tvTraRes :
                startActivity(new Intent(TravelActivityDua.this,TravelResActivity.class));  //D205 -D206
                tvTraRes.startAnimation(myAnimation);
                break;


            case R.id. tvTraJou :
                startActivity(new Intent(TravelActivityDua.this,TravelJouActivity.class));  //D207
                tvTraJou.startAnimation(myAnimation);
                break;


            case R.id.tvTraDaw  :
                startActivity(new Intent(TravelActivityDua.this,TravelDawActivity.class));   //D208
                tvTraDaw.startAnimation(myAnimation);
                break;


            case R.id.tvTraInv :
                startActivity(new Intent(TravelActivityDua.this,TravelInvActivity.class)); //D209
                tvTraInv.startAnimation(myAnimation);
                break;

            case R.id.tvTraSay :
                startActivity(new Intent(TravelActivityDua.this,TravelSayActivity.class));  //D210
                tvTraSay.startAnimation(myAnimation);
                break;



        }






    }
}
