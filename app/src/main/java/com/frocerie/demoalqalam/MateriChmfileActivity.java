package com.frocerie.demoalqalam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MateriChmfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_chmfile);

        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        if(id == R.id.home){

            NavUtils.navigateUpFromSameTask(MateriChmfileActivity.this);

        }

        return super.onOptionsItemSelected(item);
    }*/
}
