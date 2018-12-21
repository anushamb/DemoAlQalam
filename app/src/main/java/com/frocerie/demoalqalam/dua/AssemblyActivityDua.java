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

import static com.frocerie.demoalqalam.R.id.tvSitti;

public class AssemblyActivityDua extends AppCompatActivity implements View.OnClickListener {

    Button tvSit,tvExpi;

    Animation animation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assembly_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvSit = (Button) findViewById(tvSitti);
        tvSit.setOnClickListener(AssemblyActivityDua.this);

        tvExpi = (Button) findViewById(R.id.tvExpi);
        tvExpi.setOnClickListener(AssemblyActivityDua.this);

        animation = AnimationUtils.loadAnimation(this,R.anim.text_animation);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(AssemblyActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tvSitti :
                startActivity(new Intent(AssemblyActivityDua.this,SittingAcctivity.class));
                view.setAnimation(animation);
                break;

            case R.id.tvExpi :

                startActivity(new Intent(AssemblyActivityDua.this,ExpiationActivity.class));
                view.setAnimation(animation);

        }








    }
}
