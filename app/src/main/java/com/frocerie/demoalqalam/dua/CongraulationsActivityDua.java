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

public class CongraulationsActivityDua extends AppCompatActivity implements View.OnClickListener {


    Button tvConNew,tvConReply;
    Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congraulations_dua);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tvConNew = (Button) findViewById(R.id.tvConNew);
        tvConNew.setOnClickListener(CongraulationsActivityDua.this);

        tvConReply = (Button) findViewById(R.id.tvConReply);
        tvConReply.setOnClickListener(CongraulationsActivityDua.this);

        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tvConNew :

                startActivity(new Intent(CongraulationsActivityDua.this,CongNewActivity.class));
                view.startAnimation(myAnimation);
                break;


            case R.id.tvConReply :

                startActivity(new Intent(CongraulationsActivityDua.this,CongPutActivity.class));
                view.startAnimation(myAnimation);
                break;




        }




    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(CongraulationsActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }
}
