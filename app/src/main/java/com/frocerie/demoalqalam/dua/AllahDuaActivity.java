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

import com.frocerie.demoalqalam.ExcellenceActivity;
import com.frocerie.demoalqalam.ExcellenceRemebActivity;
import com.frocerie.demoalqalam.ProphetActivity;
import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.RemembranceActivity;
import com.frocerie.demoalqalam.SeekActivity;

public class AllahDuaActivity extends AppCompatActivity implements View.OnClickListener {

    Button tvRem,tvSeek;

    Button tvExce,tvExcelRem,tvProphet;

        Intent intent;
    Animation myAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allah_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);

        initi();

    }

    private void initi() {

        tvRem = (Button) findViewById(R.id.tvRem);
        tvRem.setOnClickListener(AllahDuaActivity.this);

        tvSeek = (Button) findViewById(R.id.tvSeek);
        tvSeek.setOnClickListener(AllahDuaActivity.this);


        tvExce = (Button) findViewById(R.id.tvExce);
        tvExce.setOnClickListener(AllahDuaActivity.this);

        tvExcelRem = (Button)findViewById(R.id.tvExcelRem);
        tvExcelRem.setOnClickListener(AllahDuaActivity.this);

        tvProphet = (Button) findViewById(R.id.tvProphet);
        tvProphet.setOnClickListener(AllahDuaActivity.this);


    }

    @Override
    public void onClick(View view) {

          switch (view.getId()){

              case R.id.tvRem :

                  intent = new Intent(AllahDuaActivity.this,RemembranceActivity.class);
                  startActivity(intent);
                  tvRem.startAnimation(myAnimation);
                  break;

              case R.id.tvSeek :
                  intent = new Intent(AllahDuaActivity.this,SeekActivity.class);
                  startActivity(intent);
                  tvSeek.startAnimation(myAnimation);
                  //Toast.makeText(AllahDuaActivity.this,"Connect to another activity",Toast.LENGTH_SHORT).show();
                 break;

              case R.id.tvExce :
                  intent = new Intent(AllahDuaActivity.this,ExcellenceActivity.class);
                  startActivity(intent);
                  tvExce.startAnimation(myAnimation);

                  //Toast.makeText(AllahDuaActivity.this,"Connect to another activity",Toast.LENGTH_SHORT).show();
                  break;

              case R.id.tvExcelRem :

                  intent = new Intent(AllahDuaActivity.this,ExcellenceRemebActivity.class);
                  startActivity(intent);
                  tvExcelRem.startAnimation(myAnimation);
                  //Toast.makeText(AllahDuaActivity.this,"Connect to another activity",Toast.LENGTH_SHORT).show();
                  break;

              case R.id.tvProphet :

                  intent = new Intent(AllahDuaActivity.this,ProphetActivity.class);
                  startActivity(intent);
                  tvProphet.startAnimation(myAnimation);
                  //Toast.makeText(AllahDuaActivity.this,"Connect to another activity",Toast.LENGTH_SHORT).show();
                  break;






          }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(AllahDuaActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }
}
