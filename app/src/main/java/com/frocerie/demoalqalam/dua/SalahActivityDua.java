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

public class SalahActivityDua extends AppCompatActivity implements View.OnClickListener {

    Button tvSalWu,tvSalTa,tvSalAd,tvSal  ,tvSalRu ,tvSalQa, tvSalSu ,tvSalBe  ,tvSalTha,tvSalAft,tvSalMy;

    Animation myAnimation;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salah_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tvSalWu = (Button) findViewById(R.id.tvSalWu);
        tvSalWu.setOnClickListener(SalahActivityDua.this);


        tvSalTa = (Button) findViewById(R.id.tvSalTa);
        tvSalTa.setOnClickListener(SalahActivityDua.this);


        tvSalAd = (Button) findViewById(R.id.tvSalAd);
        tvSalAd.setOnClickListener(SalahActivityDua.this);

        tvSal = (Button) findViewById(R.id.tvSal);
        tvSal.setOnClickListener(SalahActivityDua.this);

        tvSalRu = (Button) findViewById(R.id.tvSalRu);
        tvSalRu.setOnClickListener(SalahActivityDua.this);

        tvSalQa = (Button) findViewById(R.id.tvSalQa);
        tvSalQa.setOnClickListener(SalahActivityDua.this);

        tvSalSu = (Button) findViewById(R.id.tvSalSu);
        tvSalSu.setOnClickListener(SalahActivityDua.this);

        tvSalBe = (Button) findViewById(R.id.tvSalBe);
        tvSalBe.setOnClickListener(SalahActivityDua.this);

        tvSalTha = (Button) findViewById(R.id.tvSalTha);
        tvSalTha.setOnClickListener(SalahActivityDua.this);

        tvSalAft = (Button) findViewById(R.id.tvSalAft);
        tvSalAft.setOnClickListener(SalahActivityDua.this);

        tvSalMy = (Button) findViewById(R.id.tvSalMy);
        tvSalMy.setOnClickListener(SalahActivityDua.this);

        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(SalahActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){



            case R.id.tvSalWu :

                startActivity(new Intent(SalahActivityDua.this,SalahWuduActivity.class));
                tvSalWu.startAnimation(myAnimation);
                break;


            case R.id.tvSalTa :

                startActivity(new Intent(SalahActivityDua.this,SalahTayaActivity.class));
                tvSalTa.startAnimation(myAnimation);
                break;



            case R.id.tvSalAd :

                startActivity(new Intent(SalahActivityDua.this,SalahAdhanActivity.class));
                tvSalAd.startAnimation(myAnimation);
                break;



            case R.id. tvSal :

                startActivity(new Intent(SalahActivityDua.this,SalahSalActivity.class));
                tvSal.startAnimation(myAnimation);
                break;



            case R.id.tvSalRu :

                startActivity(new Intent(SalahActivityDua.this,SalahRukuActivity.class));
                tvSalRu.startAnimation(myAnimation);
                break;



            case R.id.tvSalQa :

                startActivity(new Intent(SalahActivityDua.this,SalahQaumActivity.class));
                tvSalQa.startAnimation(myAnimation);
                break;



            case R.id.tvSalSu :

                startActivity(new Intent(SalahActivityDua.this,SalahSujoActivity.class));
                tvSalSu.startAnimation(myAnimation);
                break;



            case R.id.tvSalBe :

                startActivity(new Intent(SalahActivityDua.this,SalahBetSujActivity.class));
                tvSalBe.startAnimation(myAnimation);
                break;



            case R.id.tvSalTha :

                startActivity(new Intent(SalahActivityDua.this,SalahThashActivity.class));
                tvSalTha.startAnimation(myAnimation);
                break;



            case R.id.tvSalAft :

                startActivity(new Intent(SalahActivityDua.this,SalahDuaAftActivity.class));
                tvSalAft.startAnimation(myAnimation);
                break;



            case R.id.tvSalMy :

                startActivity(new Intent(SalahActivityDua.this,SalahMayyatActivity.class));
                tvSalMy.startAnimation(myAnimation);
                break;





        }





    }
}
