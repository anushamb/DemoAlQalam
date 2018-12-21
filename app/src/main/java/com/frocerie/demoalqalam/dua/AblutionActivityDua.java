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

public class AblutionActivityDua extends AppCompatActivity implements View.OnClickListener {


    Button before,upon;

    Intent intent;
    Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ablution_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        before = (Button) findViewById(R.id.before);

        upon = (Button) findViewById(R.id.upon);

        before.setOnClickListener(AblutionActivityDua.this);
        upon.setOnClickListener(AblutionActivityDua.this);

        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){


            case R.id.before :

                //Toast.makeText(AblutionActivityDua.this,"Connect to another activity",Toast.LENGTH_SHORT).show();
                 intent = new Intent(AblutionActivityDua.this,BeforeAblution.class);
                startActivity(intent);
                before.startAnimation(myAnimation);

                break;

            case  R.id.upon :
                //Toast.makeText(AblutionActivityDua.this,"Connect to another activity",Toast.LENGTH_SHORT).show();

                intent = new Intent(AblutionActivityDua.this,UponAblutionActivity.class);
                startActivity(intent);
                upon.startAnimation(myAnimation);
                break;



        }

    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(AblutionActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    //Typeface typeface = Typeface(AblutionActivityDua.this.getAssets(),"fonts/arabic_letters.TTF");


}
