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


public class HajjActivityDua extends AppCompatActivity implements View.OnClickListener {



    Button tvHajjText,tvHajjText1,tvHajjText2,tvHajjText3,tvHajjText4,tvHajjText5,tvHajjText6;
    Animation myAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hajj_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tvHajjText = (Button) findViewById(R.id.tvHajjText);
        tvHajjText.setOnClickListener(HajjActivityDua.this);

        tvHajjText1 = (Button) findViewById(R.id.tvHajjText1);
        tvHajjText1.setOnClickListener(HajjActivityDua.this);

        tvHajjText2 = (Button) findViewById(R.id.tvHajjText2);
        tvHajjText2.setOnClickListener(HajjActivityDua.this);

        tvHajjText3 = (Button) findViewById(R.id.tvHajjText3);
        tvHajjText3.setOnClickListener(HajjActivityDua.this);

        tvHajjText4 = (Button) findViewById(R.id.tvHajjText4);
        tvHajjText4.setOnClickListener(HajjActivityDua.this);

        tvHajjText5 = (Button) findViewById(R.id.tvHajjText5);
        tvHajjText5.setOnClickListener(HajjActivityDua.this);

        tvHajjText6 = (Button) findViewById(R.id.tvHajjText6);
        tvHajjText6.setOnClickListener(HajjActivityDua.this);

        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(HajjActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case  R.id.tvHajjText :

                startActivity(new Intent(HajjActivityDua.this,HajjPilgrimActivity.class));
                tvHajjText.startAnimation(myAnimation);
                break;

            case R.id.tvHajjText1 :
                startActivity(new Intent(HajjActivityDua.this,HajjPassingActivity.class));
                tvHajjText1.startAnimation(myAnimation);
                break;

            case  R.id.tvHajjText2 :

                startActivity(new Intent(HajjActivityDua.this,HajjCornerActivity.class));
                tvHajjText2.startAnimation(myAnimation);
                break;

            case  R.id.tvHajjText3 :

                startActivity(new Intent(HajjActivityDua.this,HajjSafaActivity.class));
                tvHajjText3.startAnimation(myAnimation);
                break;

            case  R.id.tvHajjText4 :

                startActivity(new Intent(HajjActivityDua.this,HajjArafahActivity.class));
                tvHajjText4.startAnimation(myAnimation);
                break;

            case  R.id.tvHajjText5 :

                startActivity(new Intent(HajjActivityDua.this,HajjSacredActivity.class));
                tvHajjText5.startAnimation(myAnimation);
                break;

            case  R.id.tvHajjText6 :

                startActivity(new Intent(HajjActivityDua.this,HajjMinaActivity.class));
                tvHajjText6.startAnimation(myAnimation);
                break;








        }





    }
}
