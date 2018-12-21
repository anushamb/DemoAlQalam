package com.frocerie.demoalqalam.batchphase;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.frocerie.demoalqalam.R;

public class FullDayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_day);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        if(id == R.id.home){

            NavUtils.navigateUpFromSameTask(FullDayActivity.this);

        }

        return super.onOptionsItemSelected(item);
    }
}
