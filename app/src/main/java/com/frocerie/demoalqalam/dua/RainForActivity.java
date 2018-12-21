package com.frocerie.demoalqalam.dua;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.duafrag.RainDOneFragemt;
import com.frocerie.demoalqalam.duafrag.RainDSecFragment;
import com.frocerie.demoalqalam.duafrag.RainDThreFragment;

public class RainForActivity extends AppCompatActivity {


    ViewPager vpRainFo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rain_for);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        vpRainFo = (ViewPager) findViewById(R.id.vpRainFo);
        vpRainFo.setAdapter(new RainForAdapter(getSupportFragmentManager()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(RainForActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }

    public  class RainForAdapter extends FragmentPagerAdapter{


        public RainForAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0){

                return  new RainDOneFragemt();


            }else if (position == 1){

                return  new RainDSecFragment();
            }else



            return new RainDThreFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }



}
