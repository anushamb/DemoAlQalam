package com.frocerie.demoalqalam.dua;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.frocerie.demoalqalam.R;

public class DevilAgaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devil_aga);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(DevilAgaActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }
}
