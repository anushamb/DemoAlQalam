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
import android.widget.TextView;

import com.frocerie.demoalqalam.R;

public class WitrActivityDua extends AppCompatActivity implements View.OnClickListener {

    Button tvWitrQun,tvWitrsay;
    Animation myAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_witr_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvWitrQun = (Button) findViewById(R.id.tvWitrQun);
        tvWitrQun.setOnClickListener(WitrActivityDua.this);

        tvWitrsay = (Button) findViewById(R.id.tvWitrsay);
        tvWitrsay.setOnClickListener(WitrActivityDua.this);

        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(WitrActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){


            case R.id.tvWitrQun:

                startActivity(new Intent(WitrActivityDua.this,WitrQunutActivityDua.class));
                tvWitrQun.startAnimation(myAnimation);
                break;

            case R.id.tvWitrsay :

                startActivity(new Intent(WitrActivityDua.this,WitrSayActivityDua.class));
                tvWitrsay.startAnimation(myAnimation);
                break;




        }
    }
}
