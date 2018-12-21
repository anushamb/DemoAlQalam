package com.frocerie.demoalqalam;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class AboutEx extends AppCompatActivity {

    TextView tabout,aboutUs1,tAlh,tabt2,abt3;
    TextView tabt4,aboutUs5,tvAdd,tVasl,tvasl;
    TextView tSubsh,tsubah,callUs,callNum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_ex);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabout = (TextView) findViewById(R.id.tabout);
        aboutUs1 = (TextView) findViewById(R.id.tabt1);
        tAlh = (TextView) findViewById(R.id.tAlh);
        tabt2 = (TextView) findViewById(R.id.tabt2);
        abt3 = (TextView) findViewById(R.id.abt3);
        tabt4 = (TextView) findViewById(R.id.tabt4);
        aboutUs5 = (TextView) findViewById(R.id.tabt5);
        tvAdd = (TextView) findViewById(R.id.tvAdd);
        tVasl = (TextView) findViewById(R.id.tVasl);
        tvasl = (TextView) findViewById(R.id.tvasl);
        tSubsh = (TextView) findViewById(R.id.tSubsh);
        tsubah = (TextView) findViewById(R.id.tsubah);
        callUs = (TextView) findViewById(R.id.callUs);
        callNum = (TextView) findViewById(R.id.callNum);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(AboutEx.this);

        }




        return super.onOptionsItemSelected(item);
    }
}
